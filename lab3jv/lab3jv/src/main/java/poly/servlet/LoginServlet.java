package poly.servlet;

import java.io.IOException;

// Import của JAKARTA
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import poly.dao.UserDAO;
import poly.dao.UserDAOImpl;
import poly.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    private UserDAO userDAO;

    public void init() {
        this.userDAO = new UserDAOImpl();
    }

    /**
     * Xử lý GET: Hiển thị trang đăng nhập
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Chỉ cần chuyển tiếp đến trang JSP
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }

    /**
     * Xử lý POST: Xử lý thông tin đăng nhập
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Lấy thông tin từ form
        String idOrEmail = request.getParameter("idOrEmail");
        String password = request.getParameter("password");
        
        try {
            // 2. Gọi DAO để tìm user
            User user = userDAO.findByIdOrEmail(idOrEmail);
            
            // 3. Kiểm tra logic
            // Nếu user tồn tại VÀ mật khẩu khớp
            if (user != null && user.getPassword().equals(password)) {
                
                // 4. Đăng nhập thành công: Lưu user vào Session
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", user); // Lưu cả đối tượng User
                
                // 5. Chuyển hướng đến trang chào mừng (hoặc trang chủ)
                // Dùng sendRedirect để đổi URL trên trình duyệt
                response.sendRedirect(request.getContextPath() + "/welcome");
                
            } else {
                // 6. Đăng nhập thất bại
                request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
                
                // 7. Forward trở lại trang login để báo lỗi
                request.getRequestDispatcher("/views/login.jsp").forward(request, response);
            }
            
        } catch (Exception e) {
            // Xử lý lỗi chung (ví dụ: lỗi kết nối CSDL)
            request.setAttribute("error", "Lỗi hệ thống: " + e.getMessage());
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        }
    }
}