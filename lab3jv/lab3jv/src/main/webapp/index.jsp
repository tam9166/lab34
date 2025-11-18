<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%-- ĐÃ THAY ĐỔI DÒNG URI NÀY --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<head>
    <title>Trang chủ - PolyOE</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    
    <div class="container" style="max-width: 600px;">
        <h1 style="color: #FF6600; text-align: center;">Bài Lab Java 4 - Poly1</h1>
        <p style="text-align: center; font-size: 1.1em;">Chọn một chức năng để xem:</p>
        
        <ul class="nav-list">
            <li>
                <a href="<c:url value='/profile'/>">
                    Bài 3-lab3: Trang Video yêu thích
                </a>
                <span>(Hiển thị video anh "Nguyễn Văn Tèo" đã thích)</span>
            </li>
            
            <li>
                <a href="<c:url value='/favorite-report'/>">
                    Bài 4-lab3: Thống kê Video
                </a>
                <span>(Hiển thị danh sách tất cả video đã được yêu thích)</span>
            </li>
            
                        <li>
                <a href="<c:url value='/share-report'/>">
                    Bài 1-lab4: Thống kê chia sẻ
                </a>
                <span>(Hiển thị tổng hợp lượt chia sẻ, ngày đầu, ngày cuối)</span>
            </li>
            
            <li>
                <a href="<c:url value='/login'/>">
                    Bài 4-lab3: Đăng nhập
                </a>
                <span>(Hiển thị danh sách tất cả video đã được yêu thích)</span>
            </li>
        </ul>
        
    </div>
</body>
</html>