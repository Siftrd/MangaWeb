
<%@page import="model.User"%>
<%@page import="javax.servlet.http.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file='toInclude/const.jsp' %>
<%@include file="toInclude/header.jsp" %>
<%@include file="toInclude/adminCheck.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' type='text/css' media='screen' href='${pageContext.request.contextPath}/css/homepage.css'>
        <link rel='stylesheet' type='text/css' media='screen' href='${pageContext.request.contextPath}/css/admin.css'>
        <title>Hentai Heaven</title>
    </head>
    <body>
        <div id = 'container'>

            <div id="them-truyen">
                <h1>Them Truyen</h1>
                <input id ="id" placeholder="ID" value="DRM1">
                <input id ="ten" placeholder="Ten Truyen" value="Doremon tap 1">
                <input id ="nxb" placeholder="Ten Nha Xuat Ban" value="Kim Dong">
                <select id="them-the-loai">
                    <option value="tt">Truyen Tranh</option>
                    <option value="tnl">Truyen Nguoi Lon</option>
                </select>
                <p class ='thong-bao' id = "thong-bao"></p>

                <div id='tai-file-truyen' class='tai-file'>
                    <h1>Tai Tep Truyen</h1>
                    <input id='file' type='file' value=''/>
                    <!--<button id="upload">upload</button>-->

                    <p class ='thong-bao' id = 'mess'></p>
                    <p class ='thong-bao' id = 'mess2'>
                        <div id='loader-file' class="loader"></div>
                    </p>
                </div>

                <div id='tai-thumb-truyen' class='tai-file'>
                    <h1>Tai Anh Thumb</h1>
                    <input id='file-thumb' type='file' value=''/>

                    <p class ='thong-bao' id = 'mess3'></p>
                    <p class ='thong-bao' id = 'mess4'>
                        <div id='loader-thumb' class="loader"></div>
                    </p>
                </div>

                <button id = 'them' class="xac-nhan">Them</button>
                
            </div>

            <div id="sua-truyen">
                <h1>Sua Truyen</h1>
                <input id ="id-sua" placeholder="ID" value="DRM1">
                <input id ="ten-sua" placeholder="Ten Truyen" value="Doremon tap 1">
                <input id ="nxb-sua" placeholder="Ten Nha Xuat Ban" value="Kim Dong">
                <select id="sua-the-loai">
                    <option value="tt">Truyen Tranh</option>
                    <option value="tnl">Truyen Nguoi Lon</option>
                </select>

                <button id = 'sua' class = 'xac-nhan'>Xac Nhan</button>
                <h2 class ='thong-bao' id = "thong-bao2"></h2>
            </div>

            <div id="xoa-truyen">
                <h1>Xoa Truyen Trong CSDL</h1>
                <input id ="id-xoa" placeholder="ID" value="DRM1">
                <button id = 'xoa' class = 'xac-nhan'>Xac Nhan</button>
                <p class ='thong-bao' id = "thong-bao3"></p>

                <h1>Xoa Tep Truyen</h1>
                <input id ="id-xoa-file" placeholder="ID" value="DRM1">
                <button id = 'xoa-file' class = 'xac-nhan'>Xac Nhan</button>
                <p class ='thong-bao'></p>

                <h1>Xoa Anh Thumb</h1>
                <input id ="id-xoa-thumb" placeholder="ID" value="DRM1">
                <button id = 'xoa-thumb' class = 'xac-nhan'>Xac Nhan</button>
                <p class ='thong-bao'></p>

            </div>
        </div>


    </body>
    <script src="${pageContext.request.contextPath}/js/admin.js"></script>
    <!--dsa-->

</html>

