package poly.dao;

// Đảm bảo import 2 dòng này
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.NoResultException; // <-- THÊM IMPORT NÀY

import poly.entity.User;
import poly.util.JpaUtil;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    // ... (Giữ nguyên các hàm findById, findAll, create, update, deleteById) ...
    
    @Override
    public User findById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public User create(User entity) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Lỗi khi thêm mới User", e); 
        } finally {
            em.close();
        }
    }

	@Override
	public void update(User entity) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Lỗi khi cập nhật User", e);
        } finally {
            em.close();
        }
	}

	@Override
	public User deleteById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            User entity = em.find(User.class, id);
            if (entity != null) {
                em.remove(entity);
            }
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Lỗi khi xóa User", e);
        } finally {
            em.close();
        }
	}

    // --- THÊM PHƯƠNG THỨC MỚI DƯỚI ĐÂY ---
    
    @Override
    public User findByIdOrEmail(String idOrEmail) {
        EntityManager em = JpaUtil.getEntityManager();
        
        // Câu JPQL tìm User theo id HOẶC email
        String jpql = "SELECT u FROM User u WHERE u.id = :idOrEmail OR u.email = :idOrEmail";
        
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("idOrEmail", idOrEmail);
        
        try {
            // Lấy 1 kết quả duy nhất
            return query.getSingleResult();
        } catch (NoResultException e) {
            // Không tìm thấy thì trả về null
            return null;
        } finally {
            em.close();
        }
    }
}