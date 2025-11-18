package poly.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Lấy session hiện tại (không tạo mới nếu chưa có)
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            // 2. Xóa thông tin user khỏi session
            session.removeAttribute("currentUser");
            
            // 3. Hủy toàn bộ session
            session.invalidate();
        }
        
        // 4. Chuyển hướng về trang chủ (hoặc trang login)
        // Giả sử trang chủ là index.jsp
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}