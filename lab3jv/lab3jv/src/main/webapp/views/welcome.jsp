<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Thành công</title>
    <style>
        body { 
            font-family: Arial, sans-serif; 
            background-color: #f7f7f7;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .welcome-container {
            background-color: white;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.05);
            width: 400px;
            text-align: center;
        }
        .welcome-container h1 {
            color: #2ECC71; /* Màu xanh lá */
            font-weight: 300;
        }
        .welcome-container p {
            font-size: 18px;
            color: #333;
        }
        .welcome-container a {
            color: #3498DB;
            text-decoration: none;
            margin: 0 10px;
        }
    </style>
</head>
<body>
    
    <div class="welcome-container">
        <h1>Thành công!</h1>
        
        <%-- 
          Lấy 'fullname' từ đối tượng 'currentUser' trong session.
          Chúng ta dùng JSTL để xử lý null an toàn.
        --%>
        <p>
            Chào mừng, <strong>${sessionScope.currentUser.fullname}</strong>!
        </p>
        <p>Bạn đã đăng nhập thành công.</p>
        
        <br>
        
        <div>
            <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
            <a href="#">Về trang chủ</a>
        </div>
    </div>

</body>
</html>