package poly.servlet;

import java.io.IOException;
import java.util.List;

// Đảm bảo import JAKARTA
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import poly.dao.ShareDAO;
import poly.dao.ShareDAOImpl;
import poly.dto.ShareReportDTO;

/**
 * Servlet này xử lý việc hiển thị báo cáo thống kê chia sẻ.
 */
@WebServlet("/share-report")
public class ShareReportServlet extends HttpServlet {
    private ShareDAO shareDAO;

    public void init() {
        // Khởi tạo DAO
        this.shareDAO = new ShareDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Gọi DAO để lấy dữ liệu thống kê
        List<ShareReportDTO> reportItems = shareDAO.findShareReport();
        
        // 2. Đặt dữ liệu vào request scope để JSP có thể truy cập
        request.setAttribute("reportItems", reportItems);
        
        // 3. Chuyển tiếp đến trang JSP để hiển thị
        request.getRequestDispatcher("/views/share-report.jsp").forward(request, response);
    }
}