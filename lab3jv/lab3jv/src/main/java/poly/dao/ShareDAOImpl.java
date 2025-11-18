package poly.dao;

// ĐÃ THAY ĐỔI
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import poly.dto.ShareReportDTO; // <-- THÊM IMPORT NÀY
import poly.entity.Share;
import poly.util.JpaUtil;

import java.util.List;

public class ShareDAOImpl implements ShareDAO {

    @Override
    public Share findById(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(Share.class, id);
    }

    @Override
    public List<Share> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Share> query = em.createQuery("SELECT s FROM Share s", Share.class);
        return query.getResultList();
    }

    @Override
    public Share create(Share entity) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Lỗi khi thêm mới Share", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Share entity) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Lỗi khi cập nhật Share", e);
        } finally {
            em.close();
        }
    }

    @Override
    public Share deleteById(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Share entity = em.find(Share.class, id);
            if (entity != null) {
                em.remove(entity);
            }
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Lỗi khi xóa Share", e);
        } finally {
            em.close();
        }
    }

    // --- THÊM PHƯƠNG THỨC MỚI DƯỚI ĐÂY ---

    @Override
    public List<ShareReportDTO> findShareReport() {
        EntityManager em = JpaUtil.getEntityManager();
        
        // Câu lệnh JPQL này sẽ nhóm các lượt chia sẻ theo tiêu đề video
        // và tạo một đối tượng ShareReportDTO mới cho mỗi kết quả
        String jpql = "SELECT new poly.dto.ShareReportDTO(" +
                      "  s.video.title, " +
                      "  COUNT(s), " +
                      "  MIN(s.shareDate), " +
                      "  MAX(s.shareDate)) " +
                      "FROM Share s " +
                      "GROUP BY s.video.title"; // Nhóm theo tiêu đề video
        
        TypedQuery<ShareReportDTO> query = em.createQuery(jpql, ShareReportDTO.class);
        
        return query.getResultList();
    }
}