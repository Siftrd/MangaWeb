<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>Hentai Heaven</title>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link rel='stylesheet' type='text/css' media='screen' href='css/homepage.css'>
    </head>
    <body>
        <%@include file="view/toInclude/header.jsp" %>
        <div id="nd-chinh" >

            <div id = 'danh-muc-truyen'>
                <c:forEach items= "${sessionScope.dsTruyen}" var='t'>
                    <a class='truyen' href="read?truyenID=${t.id}">
                        <div style="width: 85%; height: 80%; justify-content: center">
                            <img style="width: calc(100%*3/4); height: 100%; border-radius: 5px " src="img/Thumbnails/${t.id}.jpg" alt="${t.id}"/>
                            <!--<img style="width: calc(100%*3/4); height: 100%; border-radius: 5px " src="img/Thumbnails/DRM1.jpg" alt="${t.id}"/>-->
                        </div>
                        <p style="color: white;font-size: 30px;text-decoration: none;display: flex;width: 100%; height:15%;justify-content: center">
                            ${t.ten}
                        </p>
                    </a>
                </c:forEach>
                <!--<div class = 'truyen' onclick="themTruyen()"></div>-->
            </div>

        </div>

        <nav id="chuyen-trang">
            <ul>
                <c:forEach begin="1" end="${amount + 1}" var="i">
                    <li class = 'doi-so-trang'>
                        <a href="home?page=${i}" class="link trang">${i}</a>
                    </li>
                </c:forEach>
            </ul>
        </nav>

        <%@include file="view/toInclude/footer.jsp" %>

        <script src='js/main.js'></script>
    </body>
</html>



