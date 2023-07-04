
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Thông tin tài khoản</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/profile.css">
    </head>

    <body>
        <%@include file="toInclude/header.jsp" %>
        <section class="thong_tin_tai_khoan">
            <div class="container">
                <div class="box d-sm-flex">
                    <div class="tab-content p-4 p-md-5" id="tabContent">
                        <div class="tab-pane show active" id="taikhoan">
                            <h3 class="mb-4">Chỉnh sửa tài khoản </h3>
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <label>Họ</label>
                                        <input type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Tên</label>
                                        <input type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input type="text" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div>
                                <br>
                                <button class="btn btn-primary">Lưu</button>
                            </div>
                            <br>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="box d-sm-flex">
                    <div class="tab-content p-4 p-md-5" id="tabContent">
                        <div class="tab-pane show active" id="taikhoan">
                            <h3 class="mb-4">Thay đổi mật khẩu </h3>
                            <form action="${pageContext.servletContext.contextPath}/doimatkhau" method="post">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Mật khẩu cũ</label>
                                        <br>
                                        <input type="password" name="oldpass" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Mật khẩu mới</label>
                                        <br>
                                        <input type="password" name="newpass1" class="form-control">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Xác nhận lại mật khẩu</label>
                                        <br>
                                        <input type="password" name="newpass2" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div>
                                <br>
                                <button class="btn btn-primary" type="submit">Lưu</button>

                            </div>
                                  <p class =${ss == 1 ?" text-success ":"text-danger"}>${messP}</p>      
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </section>

        <%@include file="toInclude/footer.jsp" %>

    </body>

</html>
