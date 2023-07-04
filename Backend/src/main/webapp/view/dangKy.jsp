<%-- 
    Document   : dangNhap
    Created on : Apr 12, 2022, 11:07:18 PM
    Author     : suckm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/signup.css">
</head>
<body>
    <div id="container">
        <h1>Đăng Ký</h1>
        <div id="dangNhap">
            <form action="${pageContext.servletContext.contextPath}/signup" method="post">
                <p>
                    <input id="username" type="text" placeholder="Ho" name = "Ho">
                </p>
                <p>
                    <input id="username" type="text" placeholder="Tên" name = "Ten">
                </p>
                <p>
                    <input id="username" type="text" placeholder="Tên đăng nhập" name = "Username">
                </p>
                <p>
                    <input id="password" type="Password" placeholder="Mật khẩu" name = "password">
                </p>
                <button id="dang-ky" type="submit">Đăng ký</button>
            </form>
            <p>${mess}</p>
        </div>
    </div>
</body>
<script>

</script>
</html>
