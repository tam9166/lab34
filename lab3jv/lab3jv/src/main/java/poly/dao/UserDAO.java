package poly.dao;

import java.util.List;
import poly.entity.User;

public interface UserDAO {
    User findById(String id);
    List<User> findAll();
    User create(User entity);
    void update(User entity);
    User deleteById(String id);
    
    // --- THÊM PHƯƠNG THỨC MỚI DƯỚI ĐÂY ---
    
    /**
     * Tìm kiếm người dùng bằng ID (username) hoặc Email
     * @param idOrEmail là ID hoặc Email cần tìm
     * @return User hoặc null nếu không tìm thấy
     */
    User findByIdOrEmail(String idOrEmail);
}