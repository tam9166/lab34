package poly.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        // Kiểm tra xem user đã đăng nhập chưa (có "currentUser" trong session không)
        if (session != null && session.getAttribute("currentUser") != null) {
            // Nếu đã đăng nhập, chuyển đến trang welcome
            request.getRequestDispatcher("/views/welcome.jsp").forward(request, response);
        } else {
            // Nếu chưa, đá về trang login
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}