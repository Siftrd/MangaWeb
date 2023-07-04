<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Hentai Heaven</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href="${pageContext.request.contextPath}/css/trangDoc.css">
    <link rel='stylesheet' type='text/css' media='screen' href="${pageContext.request.contextPath}/css/homepage.css">
</head>
<body>
    <%@include file="toInclude/userCheckToRead.jsp" %>
    <%@include file="toInclude/header.jsp" %>
    <div id="khung-bao-dau">
        <div id="anh-bia">
            <img  src="${pageContext.request.contextPath}/img/Thumbnails/${truyen.id}.jpg" alt="Anh bia"/>
        </div>
        
            <div class="thong-tin" id="thong-tin" data-idtruyen="${truyen.id}">
                <div id="ten-truyen" data-ten="${truyen.ten}">Tên Truyen: ${truyen.ten}</div>
                <div id="nxb" data-nxb="${truyen.nxb}">Nha xuat ban: ${truyen.nxb}</div>
                <div>Danh gia: ${truyen.rating}</div>
                <button id="yeu-thich">
                    Thêm Vào Yêu Thích
                </button>
                <h2 id="thong-bao"></h2>
            </div>
        
        </div>
    <iframe id = "khung-doc" src="view/reader.jsp?id="${truyen.id}></iframe>
    
    <div class = 'extra'>
        
    </div>
            
    
    <script src="${pageContext.request.contextPath}/js/read.js"></script>
    
</body>
</html>