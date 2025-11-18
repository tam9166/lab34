package poly.dao;

// ĐÃ THAY ĐỔI
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import poly.entity.Video;
import poly.util.JpaUtil;

import java.util.List;

public class VideoDAOImpl implements VideoDAO {

    @Override
    public Video findById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(Video.class, id);
    }

    @Override
    public List<Video> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Video> query = em.createQuery("SELECT v FROM Video v", Video.class);
        return query.getResultList();
    }

    @Override
    public Video create(Video entity) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Lỗi khi thêm mới Video", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Video entity) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity); // merge dùng để cập nhật
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Lỗi khi cập nhật Video", e);
        } finally {
            em.close();
        }
    }

    @Override
    public Video deleteById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Video entity = em.find(Video.class, id); // Tìm thực thể
            if (entity != null) {
                em.remove(entity); // Xóa thực thể
            }
            em.getTransaction().commit();
            return entity; // Trả về thực thể đã bị xóa
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Lỗi khi xóa Video", e);
        } finally {
            em.close();
        }
    }
}