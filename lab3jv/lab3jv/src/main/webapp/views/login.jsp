<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
    <%-- Style đơn giản cho giống hình ảnh --%>
    <style>
        body { 
            font-family: Arial, sans-serif; 
            background-color: #f7f7f7;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            background-color: white;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.05);
            width: 350px;
        }
        .login-container h1 {
            color: #E67E22;
            text-align: center;
            font-weight: 300;
        }
        .login-container label {
            font-weight: bold;
            display: block;
            margin-top: 20px;
            margin-bottom: 5px;
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            box-sizing: border-box; /* Quan trọng để padding không làm vỡ layout */
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .login-container button {
            width: 100%;
            padding: 12px;
            background-color: #E67E22;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
            margin-top: 25px;
        }
        .login-container button:hover {
            background-color: #d35400;
        }
        .login-container .links {
            text-align: center;
            margin-top: 20px;
        }
        .login-container a {
            color: #3498DB;
            text-decoration: none;
        }
        .error-message {
            color: red;
            background-color: #fdd;
            border: 1px solid red;
            padding: 10px;
            border-radius: 4px;
            margin-bottom: 15px;
            text-align: center;
        }
    </style>
</head>
<body>

    <div class="login-container">
        <h1>Đăng nhập PolyOE</h1>
        
        <%-- Hiển thị lỗi nếu có (từ LoginServlet) --%>
        <c:if test="${not empty error}">
            <div class="error-message">${error}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/login" method="POST">
            <div>
                <label for="idOrEmail">Username (ID) hoặc Email:</label>
                <input type="text" id="idOrEmail" name="idOrEmail" value="${param.idOrEmail}" required>
            </div>
            <div>
                <label for="password">Mật khẩu:</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <button type="submit">Đăng nhập</button>
        </form>

        <div class="links">
            <a href="/lab3jv/index.jsp">Quay về trang chủ</a>
        </div>
    </div>

</body>
</html>