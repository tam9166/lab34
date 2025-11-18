<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Import JSTL Core và Format tags --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Thống kê Chia sẻ</title>
    <%-- Giả sử bạn có file CSS chung hoặc dùng Bootstrap --%>
    <%-- <link rel="stylesheet" href="path/to/your/style.css"> --%>
    
    <%-- Thêm style đơn giản để giống hình ảnh --%>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        h1 { color: #E67E22; font-weight: 300; }
        table { 
            width: 100%; 
            border-collapse: collapse; 
            margin-top: 20px; 
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        th, td { padding: 12px 15px; text-align: left; }
        th { 
            background-color: #E67E22; 
            color: white; 
            text-transform: uppercase;
            font-size: 12px;
        }
        tr { border-bottom: 1px solid #ddd; }
        tr:nth-child(even) { background-color: #f9f9f9; }
        a {
            display: inline-block;
            margin-top: 20px;
            color: #3498DB;
            text-decoration: none;
            font-weight: bold;
        }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>

    <h1>Thống kê thông tin chia sẻ</h1>

    <table>
        <thead>
            <tr>
                <th>Tiêu đề video</th>
                <th>Số lượt chia sẻ</th>
                <th>Ngày chia sẻ đầu tiên</th>
                <th>Ngày chia sẻ cuối cùng</th>
            </tr>
        </thead>
        <tbody>
            <%-- 
              Dùng c:forEach để lặp qua danh sách 'reportItems'
              đã được gửi từ ShareReportServlet 
            --%>
            <c:forEach var="item" items="${reportItems}">
                <tr>
                    <td>${item.videoTitle}</td>
                    <td>${item.shareCount}</td>
                    <td>
                        <%-- Dùng fmt:formatDate để định dạng ngày --%>
                        <fmt:formatDate value="${item.firstShareDate}" pattern="dd/MM/yyyy" />
                    </td>
                    <td>
                        <fmt:formatDate value="${item.lastShareDate}" pattern="dd/MM/yyyy" />
                    </td>
                </tr>
            </c:forEach>

            <%-- Hiển thị thông báo nếu không có dữ liệu --%>
            <c:if test="${empty reportItems}">
                <tr>
                    <td colspan="4" style="text-align: center;">Không có dữ liệu thống kê.</td>
                </tr>
            </c:if>
        </tbody>
    </table>

    <br>
    <%-- Cập nhật link này về trang chủ của bạn --%>
    <a href="index.jsp">Quay về trang chủ</a> 

</body>
</html>