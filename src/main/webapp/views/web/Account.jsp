<%--
  Created by IntelliJ IDEA.
  User: shinn
  Date: 05/07/2023
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign in</title>
    <link rel="stylesheet" href="<c:url value="/template/web/assets/css/base.css"/>">

    <link rel="stylesheet" href="<c:url value="/template/web/assets/css/blogs.css"/>">
    <link rel="stylesheet" href="<c:url value="/template/web/assets/css/account.css"/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/template/web/bootstrap/bootstrap-5.0.2-dist/css/bootstrap.css"/>">
</head>

<body>
<div class="background-cover">

</div>
<div class="quickview-product">

</div>


<div class="hidden-cart">
    <i class="fas fa-times remove-display"></i>
    <div class="message">
        <i class="fas fa-check"></i>
        <span>Bạn đã thêm </span>
        <span class="cart-name">Pipi tất dài</span>
        <span> vào giỏ hàng</span>
    </div>
    <div class="table-cart" id="table-cart">
        <div class="table-header">
            <div class="product-cart">SẢN PHẨM</div>
            <div class="price-cart">ĐƠN GIÁ</div>
            <div class="amount-cart">SỐ LƯỢNG</div>
            <div class="total-cart">THÀNH TIỀN</div>
        </div>
        <div class="table-body">

        </div>

    </div>
    <div class="total-cart-money">

    </div>
    <div class="pay-block">
        <a href="#">Tiến hành đặt hàng</a>
    </div>
</div>
<!-- <ul class="mobile-nav">
  <li><a href="#">Trang chủ</a></li>
  <li><a href="#">Giới thiệu</a></li>
  <li><a href="#">Sản phẩm</a></li>
  <li><a href="#">Tin tức</a></li>
  <li><a href="#">Liên hệ</a></li>
</ul> -->
<div class="top-header">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="account-link">
                    <c:if test="${empty User}">
                        <a href="<c:url value="/dang-nhap?action=login"/> ">
                            <div class="fas fa-lock"></div>
                            ĐĂNG NHẬP
                        </a>
                        <a href="<c:url value="/dang-ky?action=signup"/> ">
                            <div class="fas fa-sign-in-alt"></div>
                            ĐĂNG KÝ
                        </a>
                    </c:if>
                    <c:if test="${not empty User}">
                        <a href="<c:url value="/tai-khoan"/>">
                                <%--                            <div class="fas fa-sign-in-alt"></div>--%>
                            TÀI KHOẢN
                        </a>
                        <a href="<c:url value="/dang-nhap?action=logout"/>">
                            ĐĂNG XUẤT
                        </a>
                    </c:if>
                    <a href="<c:url value="/thanh-toan"/>" class="pay">
                        <div class="fas fa-check-square"></div>
                        THANH TOÁN
                    </a>
                    <input type="hidden" id="user_id" name="user_id" value="${User.id} ">
                </div>
            </div>
        </div>
    </div>
</div>
<header style="position: relative;z-index: 8 !important;">
    <div class="mid-header wid_100">
        <div class="container">
            <div class="row">
                <div class="col-sm-3 col-md-4 col-3 menu-bar d-lg-none">
                    <input type="checkbox" class="checkbox-input" id="checkbox-input">
                    <label for="nav__bars-input" class="fa fa-bars"></label>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6 col-5">
                    <div class="logo">
                        <a href="<c:url value="/trang-chu"/>" class="logo-wrapper">
                            <img src="https://bizweb.dktcdn.net/100/047/782/themes/877502/assets/logo.png?1676015839422"
                                 alt="logo">
                        </a>
                    </div>
                </div>

                <div class="col-lg-5 col-sm-6 col-xs-0 d-none d-sm-none d-lg-block d-md-none">
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-4">
                            <div class="service-header">
                                <div class="fas fa-cube">

                                </div>
                                <span>GIAO HÀNG FREE</span>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-4">
                            <div class="service-header">
                                <div class="fas fa-exchange-alt">

                                </div>
                                <span>ĐỔI TRẢ FREE</span>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-4">
                            <div class="service-header">
                                <div class="fas fa-life-ring">

                                </div>
                                <span>HỖ TRỢ 24/7</span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-3 col-md-4 col-sm-3 col-4">

                    <div class="header-right float-end d-none d-sm-none d-md-block">
                        <a href="" class="hover-cart">
                            <div class="fa fa-shopping-bag"></div>
                            <span class="amount-items" id="cart-amount"></span>
                            <span class="hidden-xs">SẢN PHẨM</span>
                            <div class="fa fa-sort-down"></div>
                        </a>
                        <div class="cart-small">
                            <div class="cart-list">

                            </div>
                            <div class="cart-subtotal">


                            </div>
                            <div class="services">
                                <a href="#" class="cart-btn">Giỏ hàng</a>
                                <a href="<c:url value="/thanh-toan"/>" class="pay-btn pay">Thanh toán</a>
                            </div>
                        </div>
                    </div>

                    <div class="header-right-mobile d-xs-block d-md-none">
                        <div class="fa fa-shopping-bag float-end"></div>
                        <span>12</span>
                    </div>

                </div>
            </div>
        </div>
    </div>
</header>
<nav style="position: relative; z-index: 1;">
    <div class="container">
        <div class="row">
            <div class="col-lg-9 col-md-0 col-sm-0 col-0 d-none d-md-none d-lg-block">
                <div class="navbar-items">
                    <div class="row g-0">
                        <ul class="navbar-list">
                            <li class="navbar-item"><a href="<c:url value="/trang-chu"/>" class="navbar-link">TRANG CHỦ</a>
                            </li>
                            <li class="navbar-item"><a href="#" class="navbar-link">GIỚI THIỆU</a></li>
                            <li class="navbar-item hover-item"><a href="#" class="navbar-link">SẢN PHẨM
                                <div
                                        class="fa fa-angle-down"></div>
                            </a>

                                <ul class="sub-menu">
                                    <c:forEach var="i" items="${listCategory}">
                                        <c:url value="/danh-muc" var="categoryURL">
                                            <c:param name="categoryCode" value="${i.categoryCode}"/>
                                        </c:url>
                                        <li><a href="${categoryURL}">${i.categoryName}</a></li>
                                    </c:forEach>
                                </ul>

                            </li>
                            <li class="navbar-item"><a href="<c:url value="/tin-tuc"/>" class="navbar-link">TIN TỨC</a></li>
                            <li class="navbar-item"><a href="#" class="navbar-link">LIÊN HỆ</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-12 col-sm-12 col-12">
                <form action="<c:url value="/tim-kiem"/>" method="GET" class="search-form" id="search-form">
                    <input type="text" placeholder="Tìm kiếm" name="query" id="query">
                    <input type="hidden" name="type" value="product">
                    <button type="submit" class="search-submit">
                        <i class="fas fa-search"></i>
                    </button>
                </form>
            </div>
        </div>
    </div>
</nav>
<div class="main" style="padding-top: 50px;">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-12 col-sm-12">
                <span class="section-title">TRANG TÀI KHOẢN</span>
                <span class="user-name">Xin chào, <span>${User.firstName}</span>!</span>
                <ul class="redirect-list">
                    <li><a href="#" class="link active" id="infor">Thông tin tài khoản</a></li>
                    <li><a href="#" class="link" id="order-infor">Đơn hàng của bạn</a></li>
                    <li><a href="#" class="link" id="blog">Bài viết của tôi</a></li>
                    <li><a href="#" class="link" id="change-password">Đổi mật khẩu</a></li>

                </ul>
            </div>
            <div class="col-lg-9 col-md-12 col-sm-12">

                <div class="infor display-block">
                    <span class="section-title">THÔNG TIN TÀI KHOẢN</span>
                    <br>
                    <span class="fullname">Họ và tên: <span>${User.lastName} ${User.firstName}</span></span><br>
                    <span class="email">Email: <span>${User.email}</span></span>
                </div>
                <div class="order-infor display-none">
                    <span class="section-title">ĐƠN HÀNG CỦA BẠN</span>
                    <br>
                    <table>
                        <thead>
                        <tr>
                            <th>Đơn hàng</th>
                            <th>Ngày</th>
                            <th>Địa chỉ</th>
                            <th>Giá trị đơn hàng</th>
                            <th>TT thanh toán</th>
                            <th>TT vận chuyển</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${listOrders}">
                            <tr>
                                <td>${i.id}</td>
                                <td><fmt:formatDate value="${i.createdDate}" pattern="dd/MM/yyyy"/></td>
                                <td>${i.address}</td>
                                <td>${i.price + i.shippingFee} vnd</td>
                                <c:choose>
                                    <c:when test="${i.orderStatus.id == 1}">
                                        <td>Chưa thanh toán</td>
                                        <td>Chờ duyệt</td>
                                    </c:when>
                                    <c:when test="${i.orderStatus.id == 2}">
                                        <td>Đang chờ xác nhận</td>
                                        <td>Đang giao hàng</td>
                                    </c:when>
                                    <c:when test="${i.orderStatus.id == 3}">
                                        <td>Đang vận chuyển</td>
                                        <td>Hoàn thành</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Hoàn thành</td>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="change-password display-none">
                    <span class="section-title">ĐỔI MẬT KHẨU</span>
                    <form action="" id="change-password-form">
                        <label for="">Mật khẩu cũ</label><br>
                        <input type="password" id="oldPassword"><br>
                        <label for="">Mật khẩu mới</label><br>
                        <input type="password" id="newPassword"><br>
                        <label for=""> Xác nhận mật khẩu mới</label><br>
                        <input type="password" id="reNewPassword">
                        <br>
                        <button type="submit" id="change-submit">Đặt lại mật khẩu</button>
                    </form>
                </div>
                <div class="blog display-none">
                    <div class="row">
                        <div class="news-blog">
                            <a href="<c:url value="/tin-tuc?action=write"/>">Viết bài viết</a>
                        </div>
                        <c:forEach var="i" items="${listBlogs}">
                            <div class="col-lg-6 col-md-12 col-sm-12 col-12">
                                <div class="summary-blog">
                                <span class="blog-name"><a href="#">${i.title}</a></span>
                                    <span class="created-date"><fmt:formatDate value="${i.createdDate}" pattern="dd/MM/yyyy"/></span>
                                    <a href="#"><img
                                            src="${i.thumbnail}"
                                            alt=""></a>

                                    <p>Tags:</p>
                                    <span class="amount-comment">${i.amountComment}</span>
                                    <span> Bình luận</span>
                                    <p>Trang thái:</p>
                                    <c:choose>
                                        <c:when test="${i.blogStatus.id == 1}">
                                            <span class="amount-comment">Chưa duyệt</span>
                                        </c:when>
                                        <c:when test="${i.blogStatus.id == 2}">
                                            <span class="amount-comment">Đã duyệt</span>
                                        </c:when>
                                    </c:choose>

                                    <div class="services">
                                        <c:url var="editURL" value="/tin-tuc">
                                            <c:param name="action" value="edit"/>
                                            <c:param name="id" value="${i.id}"/>
                                        </c:url>
                                        <a href="${editURL}" class="modify-btn">Chỉnh sửa</a>
                                        <a href="#" class="delete-btn" id="deleteBtn">Xóa bài viết</a>
                                        <input type="hidden" name="id" id="id" class="id" value="${i.id}">
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<footer>
    <div class="header-footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="subcribe-content">
                        <h2>ĐĂNG KÝ NHẬN TIN QUA EMAIL</h2>
                        <span>Hãy đăng ký ngay hôm nay để nhận được những tin tức cập nhật mới nhất về sản phẩm và
                                các chương
                                trình giảm giá, khuyến mại của chúng tôi.</span>
                        <form action="">
                            <input type="text" placeholder="Nhập email của bạn...">

                            <button type="submit">
                                <div class="fas fa-paper-plane"></div>
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="mid-footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-6 col-6">
                    <h2 class="footer-title">THÔNG TIN</h2>
                    <div class="content" id="collapse-content">
                        <ul class="list-menu">
                            <li><a href="#">Trang chủ</a></li>
                            <li><a href="#">Giới thiệu</a></li>
                            <li><a href="#">Sản phẩm</a></li>
                            <li><a href="#">Tin tức</a></li>
                            <li><a href="#">Liên hệ</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 col-6">
                    <h2 class="footer-title">THÔNG TIN</h2>
                    <div class="content" id="collapse-content">
                        <ul class="list-menu">
                            <li><a href="#">Trang chủ</a></li>
                            <li><a href="#">Giới thiệu</a></li>
                            <li><a href="#">Sản phẩm</a></li>
                            <li><a href="#">Tin tức</a></li>
                            <li><a href="#">Liên hệ</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 col-6">
                    <h2 class="footer-title">THÔNG TIN</h2>
                    <div class="content" id="collapse-content1">
                        <ul class="list-menu">
                            <li><a href="#">Trang chủ</a></li>
                            <li><a href="#">Giới thiệu</a></li>
                            <li><a href="#">Sản phẩm</a></li>
                            <li><a href="#">Tin tức</a></li>
                            <li><a href="#">Liên hệ</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-lg-3 col-md-3 col-sm-6 col-12">
                    <h2 class="footer-title">LIÊN HỆ</h2>
                    <div class="content">
                        <ul class="list-menu">
                            <li><span>
                                        <div class="fas fa-home"></div>Thôn Trung Đàn, xã Tam Đại, huyện Phú Ninh, tỉnh
                                        Quảng Nam.
                                    </span></li>
                            <li><span>
                                        <div class="fas fa-envelope"></div>lampt.22it@vku.udn.vn
                                    </span></li>

                            <li><span>
                                        <div class="fas fa-phone"></div>+84385979034
                                    </span></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>

<script type="text/javascript" src="<c:url value="/template/web/assets/js/jquery-3.7.0.min.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/template/web/bootstrap/bootstrap-5.0.2-dist/js/bootstrap.js"/>"></script>
<script>
$('#change-submit').on('click', function(event){
   event.preventDefault();
   let oldPassword = $('#oldPassword').val();
   let newPassword = $('#newPassword').val();
   let reNewPassword = $('#reNewPassword').val();
   if(newPassword !=  reNewPassword) {
       alert("Mật khẩu mới và mật khẩu xác nhận không giống nhau.");
       return;
   } else {
       let data = {
           password: oldPassword,
           newPassword: newPassword
       }
       $.ajax({
          url: 'tai-khoan',
          type: 'PUT',
          data: JSON.stringify(data),
          success: function (response) {
              alert('Đổi mật khẩu thành công');
          }

       });
   }




});
</script>
<script>
    $('#deleteBtn').on('click', function(event) {
       event.preventDefault();
        let input = $(this).siblings('.id');
        let id = parseInt(input.val());
        let data = {
            id: id
        }
        console.log(id);
        $.ajax({
           url: 'tin-tuc',
           type: 'DELETE',
           data: JSON.stringify(data),
           success: function (response) {
               alert('Xóa thành công bài viết');
           }
        });
    });
    $('#infor').on('click', function (event) {
        event.preventDefault();
        $('.infor').removeClass('display-none');
        $('.infor').addClass('display-block');
        $('.order-infor').removeClass('display-block');
        $('.order-infor').addClass('display-none');
        $('.change-password').removeClass('display-block');
        $('.change-password').addClass('display-none');
        $('.blog').removeClass('display-block');
        $('.blog').addClass('display-none');
        $('#order-infor').removeClass('active');
        $('#change-password').removeClass('active');
        $('#blog').removeClass('active');
        $(this).addClass('active');
    });
    $('#order-infor').on('click', function (event) {
        event.preventDefault();
        $('.infor').removeClass('display-block');
        $('.infor').addClass('display-none');
        $('.order-infor').removeClass('display-none');
        $('.order-infor').addClass('display-block');
        $('.change-password').removeClass('display-block');
        $('.change-password').addClass('display-none');
        $('.blog').removeClass('display-block');
        $('.blog').addClass('display-none');
        $('#infor').removeClass('active');
        $('#blog').removeClass('active');
        $('#change-password').removeClass('active');
        $(this).addClass('active');
    });
    $('#change-password').on('click', function (event) {
        event.preventDefault();
        $('.infor').removeClass('display-block');
        $('.infor').addClass('display-none');
        $('.order-infor').removeClass('display-block');
        $('.order-infor').addClass('display-none');
        $('.change-password').removeClass('display-none');
        $('.change-password').addClass('display-block');
        $('.blog').removeClass('display-block');
        $('.blog').addClass('display-none');
        $('#order-infor').removeClass('active');
        $('#infor').removeClass('active');
        $('#blog').removeClass('active');
        $(this).addClass('active');
    });
    $('#blog').on('click', function (event) {
        event.preventDefault();
        $('.infor').removeClass('display-block');
        $('.infor').addClass('display-none');
        $('.order-infor').removeClass('display-block');
        $('.order-infor').addClass('display-none');
        $('.change-password').removeClass('display-block');
        $('.change-password').addClass('display-none');
        $('.blog').removeClass('display-none');
        $('.blog').addClass('display-block');
        $('#order-infor').removeClass('active');
        $('#infor').removeClass('active');
        $('#change-password').removeClass('active');
        $(this).addClass('active');
    });
</script>
</body>

</html>