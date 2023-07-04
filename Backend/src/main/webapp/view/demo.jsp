<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Thông tin tài khoản</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" type="text/css"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
</head>

<body>
    <section class="thong_tin_tai_khoan">
        <div class="container">
            <div class="box d-sm-flex">
                <div class="tab-content p-4 p-md-5" id="tabContent">
                    <div class="tab-pane show active" id="taikhoan">
                        <h3 class="mb-4">Chỉnh sửa tài khoản</h3>
                        <div class="row">
                            <div class="col">
                                <div class="form-group">
                                    <label>Họ và tên</label>
                                    <input type="text" class="form-control">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="text" class="form-control">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Số điện thoại </label>
                                    <input type="text" class="form-control">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label> Ngày sinh: </label>
                                    <br>
                                    <input type="date" id="birthday" name="birthday">
                                </div>
                            </div>
                            <div class="col">
                                <div class="gioi-tinh">
                                    <label> Giới tính: </label>
                                    <br>
                                    <select id="sua-the-loai">
                                        <option value="nam">Nam</option>
                                        <option value="nu">Nữ</option>
                                    </select>
                            
                                </div>
                                <div>
                                    <br>
                                    <button class="btn btn-primary">Cập nhật</button>
                                   
                                </div>
                                <br>
                                <h3 class="mb-4">Thay đổi mật khẩu</h3>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Mật khẩu cũ</label>
                                    <input type="password" class="form-control">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Mật khẩu mới</label>
                                    <input type="password" class="form-control">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Nhập lại mật khẩu mới</label>
                                    <input type="password" class="form-control">
                                </div>
                            </div>
                        </div>
                        <div>
                            <br>
                            <button class="btn btn-primary">Cập nhật</button>
                           
                        </div>
                    </div>
                </div>
    </section>


    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>