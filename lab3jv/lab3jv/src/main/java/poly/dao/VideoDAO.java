package poly.dao;

import java.util.List;

import poly.entity.Video;

public interface VideoDAO {
    /**
     * Truy vấn thực thể theo id
     * @param id là mã video
     * @return Video hoặc null nếu không tìm thấy
     */
    Video findById(String id);

    /**
     * Truy vấn tất cả các thực thể
     * @return List Video
     */
    List<Video> findAll();

    /**
     * Tạo mới thực thể
     * @param entity là Video
     * @return Video đã được tạo
     */
    Video create(Video entity);

    /**
     * Cập nhật thực thể
     * @param entity là Video
     */
    void update(Video entity);

    /**
     * Xóa thực thể theo id
     * @param id là mã video
     * @return Video đã bị xóa
     */
    Video deleteById(String id);
}