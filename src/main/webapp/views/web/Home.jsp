<%--
  Created by IntelliJ IDEA.
  User: shinn
  Date: 29/05/2023
  Time: 05:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>
    <link rel="stylesheet" href="<c:url value="/template/web/assets/css/base.css"/>">
    <%--    <link rel="stylesheet" href="assets/css/home.css">--%>
    <link rel="stylesheet" href="<c:url value="/template/web/assets/css/home.css"/>">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <%--    <link rel="stylesheet" type="text/css" href="bootstrap/bootstrap-5.0.2-dist/css/bootstrap.css">--%>
    <link rel="stylesheet" href="<c:url value="/template/web/bootstrap/bootstrap-5.0.2-dist/css/bootstrap.css"/>">
</head>

<body>
<div class="background-cover">

</div>
<div class="quickview-product">

</div>


<div class="hidden-cart">
    <i class="fas fa-times" id="remove-display"></i>
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
                        <a href="#">
                                <%--                            <div class="fas fa-sign-in-alt"></div>--%>
                            WELCOME ${User.firstName}
                        </a>
                        <a href="<c:url value="/dang-nhap?action=logout"/>">
                            ĐĂNG XUẤT
                        </a>
                    </c:if>
                    <a href="#">
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
                        <a href="/" class="logo-wrapper">
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
                                <a href="#" class="pay-btn">Thanh toán</a>
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
                            <li class="navbar-item navbar-item-active"><a href="/" class="navbar-link">TRANG CHỦ</a>
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
                            <li class="navbar-item"><a href="#" class="navbar-link">TIN TỨC</a></li>
                            <li class="navbar-item"><a href="#" class="navbar-link">LIÊN HỆ</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-12 col-sm-12 col-12">
                <form action="<c:url value=""/>" method="GET" class="search-form">
                    <input type="text" placeholder="Tìm kiếm" name="query">
                    <button type="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </form>
            </div>
        </div>
    </div>
</nav>
<div class="main-wrap">
    <div class="container">
        <div class="main">
            <div class="slide-block">

                <div class="row">
                    <div class="col-lg-8 col-md-12 col-sm-12 col-12">
                        <a href="#" class="slide-link">
                            <img src="https://bizweb.dktcdn.net/100/047/782/themes/877502/assets/slider_1.jpg?1676015839422%22"
                                 alt="slide1">
                        </a>
                    </div>
                    <div class="col-lg-4 col-md-0 col-sm-0 col-0 d-none d-lg-block">
                        <a href="#" class="slide-link">
                            <img
                                    src="https://bizweb.dktcdn.net/100/047/782/themes/877502/assets/slider_banner_top.jpg?1676015839422"
                                    alt="">
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="main-content">
            <div class="row">
                <div class="col-lg-3 col-md-12 col-sm-12 col-12">
                    <div class="sale-product">
                        <div class="title-box">
                <span class="category-title">
                  ĐANG GIẢM GIÁ
                </span>
                            <span class="show">
                  Xem tất cả
                  <div class="fas fa-arrow-right"></div>
                </span>
                        </div>
                        <c:forEach var="i" begin="0" end="0" items="${listSale}">
                            <div class="product-block">
                                <div class="product-box">
                                    <div class="product-thumbnail">
                                        <a href="#" class="product-link">
                                            <img
                                                    src="${i.thumbnail}"
                                                    alt="">
                                            </img>
                                        </a>
                                        <a href="#" class="cover">
                                            <div class="cover-layout">

                                            </div>
                                            <div class="eye">
                                                <div class="fas fa-eye"></div>
                                            </div>

                                        </a>

                                    </div>
                                    <div class="product-infor">
                                        <span class="product-name">${i.title}</span>
                                        <div class="price-infor">
                                            <c:if test="${i.discount > 0}">
                                                      <span class="sale-price">
                                                    ${i.discount}<sup>đ</sup>
                                                  </span>
                                                <span class="price">${i.price}<sup>đ</sup></span>
                                            </c:if>
                                            <c:if test="${i.discount <= 0}">
                                                    <span class="sale-price">
                                                    ${i.price}<sup>đ</sup>
                                                  </span>
                                            </c:if>
                                        </div>
                                        <form action="<c:url value="/cart"/>" method="POST" class="add-to-cart">
                                            <button type="submit" class="AddToCartBtn">
                                                <div class="fa fa-shopping-bag"></div>
                                                Thêm vào giỏ
                                            </button>
                                            <input type="hidden" name="product_id" value="${i.id}">
                                            <input type="hidden" name="num" value="1">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="contact-block">
                        <div class="title-box">
                <span class="category-title">
                  HỖ TRỢ TRỰC TUYẾN
                </span>
                        </div>
                        <div class="contact">
                            <div class="support">
                                <span class="hd-support">Tư vấn bán hàng 1</span>
                                <span class="support-name">
                    Mr. Lam:
                    <a href="#">0385979034</a>
                  </span>

                            </div>
                            <div class="support">
                                <span class="hd-support">Tư vấn bán hàng 2</span>
                                <span class="support-name">
                    Mr. Shinn:
                    <a href="#">6969696969</a>
                  </span>

                            </div>
                            <div class="support">
                                <span class="hd-support">Email liên hệ</span>
                                <!-- <span class="support-name"> -->
                                <a href="#">lampt.22it@vku.udn.vn</a>
                                <!-- </span> -->

                            </div>
                        </div>
                    </div>
                    <div class="feedback-block">
                        <div class="title-box">
                <span class="category-title">
                  PHẢN HỒI
                </span>

                        </div>
                        <div class="feedback">
                            <div class="sumary">
                  <span>
                    Thật tuyệt khi mua hàng tại Bookstore, tôi cảm thấy mình được phục vụ vô cùng chu đáo và tận tình.
                    Chắc chắn tôi sẽ quay lại mua hàng tại Bookstore lần nữa.
                  </span>
                            </div>
                            <div class="feedback-img">
                                <img
                                        src="https://bizweb.dktcdn.net/thumb/compact/100/047/782/themes/877502/assets/clien-say1.jpg?1676015839422"
                                        alt="">
                            </div>
                            <span class="feedback-name">- Lam Pham -</span>
                        </div>
                    </div>

                    <div class="social-block">
                        <div class="title-box">
                <span class="category-title">
                  MẠNG XÃ HỘI
                </span>
                        </div>
                        <div class="social">
                            <div class="social-content">
                                <a href="">
                                    <i class="fab fa-facebook-square"></i>
                                </a>
                            </div>
                            <div class="social-content">
                                <a href="">
                                    <i class="fab fa-twitter-square"></i>
                                </a>
                            </div>
                            <div class="social-content">
                                <a href="">
                                    <i class="fab fa-google-plus-square"></i>
                                </a>
                            </div>
                            <div class="social-content">
                                <a href="">
                                    <i class="fab fa-pinterest-square"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 col-md-12 col-sm-12 col-12 col-product">
                    <div class="new-product">
                        <div class="title-box">
                <span class="category-title">
                  SẢN PHẨM MỚI
                </span>
                            <span class="show">
                  Xem tất cả
                  <div class="fas fa-arrow-right"></div>
                </span>
                        </div>
                        <div class="row g-0">
                            <c:forEach var="i" items="${listLatest}">
                                <div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
                                    <div class="product-block col-product">
                                        <div class="product-box">
                                            <div class="product-thumbnail">
                                                <a href="#" class="product-link">
                                                    <img
                                                            src="${i.thumbnail}"
                                                            alt="">
                                                    </img>

                                                </a>
                                                <a href="#" class="cover">
                                                    <div class="cover-layout">

                                                    </div>
                                                    <div class="eye">
                                                        <div class="fas fa-eye"></div>
                                                    </div>

                                                </a>

                                            </div>
                                            <div class="product-infor">
                                                <span class="product-name">${i.title}</span>
                                                <div class="price-infor">
                                                    <c:if test="${i.discount > 0}">
                                                      <span class="sale-price">
                                                    ${i.discount}<sup>đ</sup>
                                                  </span>
                                                        <span class="price">${i.price}<sup>đ</sup></span>
                                                    </c:if>
                                                    <c:if test="${i.discount <= 0}">
                                                    <span class="sale-price">
                                                    ${i.price}<sup>đ</sup>
                                                  </span>
                                                    </c:if>
                                                </div>
                                                <form action="<c:url value="/cart"/>" method="POST" class="add-to-cart">
                                                    <button type="submit" class="AddToCartBtn">
                                                        <div class="fa fa-shopping-bag"></div>
                                                        Thêm vào giỏ
                                                    </button>
                                                    <input type="hidden" name="product_id" value="${i.id}">
                                                    <input type="hidden" name="num" value="1">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="sale-products">
                        <div class="title-box">
                        <span class="category-title">
                          SẢN PHẨM GIẢM GIÁ
                        </span>
                            <span class="show">
                  Xem tất cả
                  <div class="fas fa-arrow-right"></div>
                </span>
                        </div>
                        <div class="row g-0">
                            <c:forEach var="i" items="${listSale}">
                                <div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
                                    <div class="product-block col-product">
                                        <div class="product-box">
                                            <div class="product-thumbnail">
                                                <a href="#" class="product-link">
                                                    <img
                                                            src="${i.thumbnail}"
                                                            alt="">
                                                    </img>
                                                </a>
                                                <a href="#" class="cover">
                                                    <div class="cover-layout">

                                                    </div>
                                                    <div class="eye">
                                                        <div class="fas fa-eye"></div>
                                                    </div>

                                                </a>
                                            </div>
                                            <div class="product-infor">
                                                <span class="product-name">${i.title}</span>
                                                <div class="price-infor">
                                                    <c:if test="${i.discount > 0}">
                                                        <span class="sale-price">
                                                        ${i.discount}<sup>đ</sup>
                                                         </span>
                                                        <span class="price">${i.price}<sup>đ</sup></span>
                                                    </c:if>
                                                    <c:if test="${i.discount <= 0}">
                                                            <span class="sale-price">
                                                         ${i.price}<sup>đ</sup>
                                                         </span>

                                                    </c:if>
                                                </div>
                                                <form action="" method="POST" class="add-to-cart">
                                                    <button type="submit" class="AddToCartBtn">
                                                        <div class="fa fa-shopping-bag"></div>
                                                        Thêm vào giỏ
                                                    </button>
                                                    <input type="hidden" name="product_id" value="${i.id}">
                                                    <input type="hidden" name="num" value="1">
                                                </form>
                                            </div>
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
</div>
<footer>
    <div class="header-footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="subcribe-content">
                        <h2>ĐĂNG KÝ NHẬN TIN QUA EMAIL</h2>
                        <span>Hãy đăng ký ngay hôm nay để nhận được những tin tức cập nhật mới nhất về sản phẩm và các chương
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
                    <div class="content">
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
                            <li><span><div class="fas fa-home"></div>Thôn Trung Đàn, xã Tam Đại, huyện Phú Ninh, tỉnh Quảng Nam.</span>
                            </li>
                            <li><span><div class="fas fa-envelope"></div>lampt.22it@vku.udn.vn</span></li>

                            <li><span><div class="fas fa-phone"></div>+84385979034</span></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<script>

    $('.eye').on('click', function() {
        let idInput = $(this).closest('.product-box').find('product_id');
        let id = idInput.val();
        $.ajax({
           url: "api/v1/books",
           type: "GET",
            data: {
               productId: id
            },
           dataType: "json",
            success: function (response) {
               let products = JSON.parse(response);
               displayQuickView(products[0]);
            }
        });
    });
    function displayQuickView(product) {
        let htmlText = '<i class="fas fa-times"></i> ' +
            '<div class="quickview-thumnail"> ' +
            '<img src="https://bizweb.dktcdn.net/thumb/large/100/047/782/products/di-qua-hoa-cuc-tai-ban--1-.jpg?v=1453198485223" alt=""> ' +
            '</div> ' +
            '<div class="quickview-infor"> ' +
            '<span class="name">Đi qua hoa cúc </span> ' +
            '<span>Tình trạng: </span> <span class="status">Còn hàng</span> ' +
            '<span> | Loại: </span> <span class="category">Sách tuổi teen</span> ' +
            '<div class="price-infor left"> ' +
            '<span class="sale-price"> 63.00<sup>đ</sup> </span> ' +
            '<span class="price">50.00<sup>đ</sup></span> ' +
            '</div> ' +
            '<form class="amount-form quickview-form"> <div class="value-button decrease" onclick="decrease()" value="Decrease Value">- </div> ' +
            '<input type="number" id="number" value="0" style="color: gray"/> <div class="value-button increase" onclick="increase(this)" value="Increase Value">+ </div> ' +
            '</form> <a href="#" class="add-to-cart-primary">Thêm vào giỏ</a> ' +
            '</div>'
    }
    $('.add-to-cart', '.add-to-cart-primary').submit(function (event) {
        event.preventDefault();
        let formData = $(this).serialize();
        let url = $(this).attr("action");
        let userInput = document.getElementById('user_id');
        let userId = userInput.value.trim();
        $.ajax({
            url: 'cart',
            method: 'POST',
            data: formData,
            success: function (response) {
                if (userId == "") {
                    // localStorage.clear();
                    addJsonToLocalStorage(response);
                    let jsonFromLocal = localStorage.getItem("Json_Cart_String");
                    let dataFromLocal = JSON.parse(jsonFromLocal);
                    displayCart(dataFromLocal);
                    displayHoverCart(dataFromLocal);
                } else {
                    getCarts();
                    getCartsAndDisplayHover();
                }
            },
            error: function () {
                alert('Them vao gio hang that bai')
            }
        });

        function addJsonToLocalStorage(data) {
            let jsonFromServer = JSON.stringify(data);
            let jsonFromLocal = localStorage.getItem("Json_Cart_String");
            let existData = JSON.parse(jsonFromLocal) || [];
            let check = false;
            let cart = JSON.parse(jsonFromServer)
            for (let i = 0; i < existData.length; i++) {
                if (cart.product.title == existData[i].product.title) {
                    existData[i].num++;
                    check = true;
                    break;
                }
            }
            if (check == false) {
                existData = existData.concat(cart);
            }
            let updatedJson = JSON.stringify(existData);
            localStorage.setItem("Json_Cart_String", updatedJson);
        }

        function getCarts() {
            $.ajax({
                url: 'api/v1/carts',
                type: 'GET',
                data: {
                    user_id: userId
                },
                // dataType: 'json',
                success: function (response) {
                    displayCart(response);
                },
            });
        }

        function displayCart(data) {
            if (data != null) {
                let htmlText = "";
                let totalMoney = 0;
                for (let i = 0; i < data.length; i++) {
                    if (data[i].product.discount != 0) {
                        totalMoney += data[i].product.discount * data[i].num;
                    } else {
                        totalMoney += data[i].product.price * data[i].num;
                    }
                    if (data[i].product && data[i].product.thumbnail) {
                        htmlText += '<div class="table-row"> ' +
                            '<input type="hidden" class="idHidden" name="cart_id" value="' + data[i].id + '">' +
                            '           <div class="cart-detail"> ' +
                            '               <img src="' + data[i].product.thumbnail + '"  alt="">' +
                            '                <div class="cart-infor">' +
                            '                       <span class="cart-detail-name">' + data[i].product.title + '</span> ' +
                            '                       <a href="#"> <i class="fas fa-times"></i>Bỏ sản phẩm </a>' +
                            '                </div>' +
                            '             </div>' +
                            '           <div class="price-cart">' +
                            '               <span class="sale-price">' + '' + (data[i].product.discount != 0 ? data[i].product.discount : data[i].product.price) + '<sup>đ</sup>' +
                            ' </span> ' +
                            '</div> ' +
                            '<div class="amount-cart"> ' +
                            '<form class="amount-form cart-form"> ' +
                            '<div class="value-button decrease" value="Decrease Value">- ' +
                            '</div> ' +
                            '<input type="number" class="input-number" id="number" value="' + data[i].num + '" style="color: gray"/> ' +
                            '<div class="value-button increase" value="Increase Value">+ ' +
                            '</div> ' +
                            '</form> ' +
                            '</div> ' +
                            '<div class="total-cart"> ' +
                            '<span class="sale-price">' + parseInt(data[i].product.discount) * parseInt(data[i].num) + '<sup>đ</sup>' +
                            '</span>' +
                            '</div>' +
                            '</div>';

                        let totalMoneyHtml = '<span>Tổng tiền: </span>' +
                            '<span class="sale-price" id="hiddenTotal">' + totalMoney + '<sup>đ</sup></span>'
                        $('.table-body').html(htmlText);
                        $('.background-cover').addClass('display-block');
                        $('.hidden-cart').addClass('display-block');
                        $('.total-cart-money').html(totalMoneyHtml);

                    }
                }
            }
        }
    });
    $('#remove-display').on('click', function () {

        $('.background-cover').removeClass('display-block');
        $('.hidden-cart').removeClass('display-block');
    });
    $('.background-cover').on('click', function () {
        $('.background-cover').removeClass('display-block');
        $('.hidden-cart').removeClass('display-block');
    });


    document.addEventListener('DOMContentLoaded', function () {

        let userInput = document.getElementById('user_id');
        let userId = userInput.value.trim();
        console.log(userId);
        if (userId == "") {
            let jsonFromLocal = localStorage.getItem("Json_Cart_String");
            let dataFromLocal = JSON.parse(jsonFromLocal);
            displayHoverCart(dataFromLocal);
        } else {
            getCartsAndDisplayHover();
        }
    });

    function displayHoverCart(data) {
        if (data != null) {
            let htmlText = "";
            let count = 0;
            let totalMoney = 0;
            for (let i = 0; i < data.length; i++) {
                if (data[i].product.discount != 0) {
                    totalMoney += data[i].product.discount * data[i].num;
                } else {
                    totalMoney += data[i].product.price * data[i].num;
                }
                count += data[i].num;
                htmlText += '<div class="cart-product">' +
                    '<input type="hidden" class="idHidden" name="cart_id" value="' + data[i].id + '">' +
                    '<div class="row g-0">' +
                    '<div class="col-lg-3 col-md-3 col-3">' +
                    '<img src="' + data[i].product.thumbnail + '"alt="" class="small-thumbnail">' +
                    '</div> ' +
                    '<div class="col-lg-8 col-md-8 col-8"> ' +
                    '<span class="small-title">' + data[i].product.title + '</span>' + '<br>' +
                    '<span class="sale-price">' + (data[i].product.discount != 0 ? data[i].product.discount : data[i].product.price) + '<sup>đ</sup></span>' +
                    '<form class="amount-form">' +
                    '<div class="value-button decrease hover" value="Decrease Value">-</div>' +
                    '<input type="number" class="input-number" id="number" value="' + data[i].num + '" style="color: gray"/> ' +
                    '<div class="value-button increase hover" value="Increase Value">+</div>' +
                    '</form> ' +
                    '</div> ' +
                    '<div class="col-lg-1 col-md-1 col-1">' +
                    '<i class="fas fa-trash"></i>' +
                    '</div>' +
                    '</div>' +
                    '</div>';

            }
            // console.log(count);
            count += "";
            let totalMoneyHtml = ' <span style="color: black; font-size: 1.6rem;">Tổng cộng:</span> ' +
                '<span class="total" id="hoverTotal">' + totalMoney + '<sup>đ</sup> </span>';
            $('.cart-subtotal').html(totalMoneyHtml);
            $('.cart-list').html(htmlText);
            $('#cart-amount').text(count);
        }

    }

    function getCartsAndDisplayHover() {
        let userInput = document.getElementById('user_id');
        let userId = userInput.value.trim();
        $.ajax({
            url: 'api/v1/carts',
            type: 'GET',
            data: {
                user_id: userId
            },
            // dataType: 'json',
            success: function (response) {
                displayHoverCart(response);
            },
        });
    }


    let userInput = document.getElementById('user_id');
    let userId = userInput.value.trim();
    let decreaseTimeOut;
    let increaseTimeOut;
    const delay = 2000;
    $(document).on('click', '.decrease', function () {
        clearTimeout(decreaseTimeOut);
        clearTimeout(increaseTimeOut);
        let input = $(this).siblings('.input-number');
        let value = parseInt(input.val(), 10);
        value = isNaN(value) ? 0 : value;
        if (value == 1) {
            value = 1;
        } else {
            value--;
            let currentCartPrice;
            let price;
            let currentPriceText;
            let currentPrice, newPriceText;
            if ($(this).hasClass('hover')) {
                currentCartPrice = $(this).closest('.cart-product').find('.sale-price');
                price = parseInt(currentCartPrice.text().replace(/[^0-9]/g, ''));
                currentPriceText = $('#hoverTotal').text();
                currentPrice = parseInt(currentPriceText.replace(/[^0-9]/g, ''));
                newPriceText = currentPrice - price + '<sup>đ</sup>';
            } else {

                currentCartPrice = $(this).closest('.table-row').find('.price-cart .sale-price');

                price = parseInt(currentCartPrice.text().replace(/[^0-9]/g, ''));
                currentPriceText = $('#hiddenTotal').text();
                currentPrice = parseInt(currentPriceText.replace(/[^0-9]/g, ''));

                newPriceText = currentPrice - price + '<sup>đ</sup>';
                let totalOne = $(this).closest('.table-row').find('.total-cart .sale-price');
                let newTotalOne = price * value + '<sup>đ</sup>';
                totalOne.html(newTotalOne);
            }
            $('#hoverTotal').html(newPriceText);
            $('#hiddenTotal').html(newPriceText);
        }

        input.val(value);
        let decreaseDiv = $(this);
        decreaseTimeOut = setTimeout(function () {

            if (userId == "") {
                let nameSpan;
                let jsonFromLocal = localStorage.getItem("Json_Cart_String");
                let dataFromLocal = JSON.parse(jsonFromLocal);
                if ($(decreaseDiv).hasClass('hover')) {
                    nameSpan = $(decreaseDiv).closest('.cart-product').find('.small-title');

                } else {
                    nameSpan = $(decreaseDiv).closest('.table-row').find('.cart-detail-name');
                }

                let name = $(nameSpan).text();
                console.log(name);
                for (let i = 0; i < dataFromLocal.length; i++) {
                    if (name == dataFromLocal[i].product.title) {
                        dataFromLocal[i].num = value;
                    }
                }
                localStorage.setItem("Json_Cart_String", JSON.stringify(dataFromLocal));
            } else {
                let id;
                let idHidden;
                if ($(decreaseDiv).hasClass('hover')) {
                    idHidden = $(decreaseDiv).closest('.cart-product').find('.idHidden');
                } else {
                    idHidden = $(decreaseDiv).closest('.table-row').find('.idHidden');
                }

                id = idHidden.val();
                updateQuantity(id, value);
            }
            setTimeout(function () {
                redisplay();
            }, 1000);
        }, delay);

    });
    $(document).on('click', '.increase', function () {
        clearTimeout(decreaseTimeOut);
        clearTimeout(increaseTimeOut);
        let input = $(this).siblings('.input-number');
        let value = parseInt(input.val(), 10);
        value = isNaN(value) ? 0 : value;
        value++;
        input.val(value);


        // if(userId == "") {
        let currentCartPrice;
        let price;
        let currentPriceText;
        let currentPrice, newPriceText;
        if ($(this).hasClass('hover')) {
            currentCartPrice = $(this).closest('.cart-product').find('.sale-price');
            price = parseInt(currentCartPrice.text().replace(/[^0-9]/g, ''));
            currentPriceText = $('#hoverTotal').text();
            currentPrice = parseInt(currentPriceText.replace(/[^0-9]/g, ''));
            newPriceText = currentPrice + price + '<sup>đ</sup>';
        } else {

            currentCartPrice = $(this).closest('.table-row').find('.price-cart .sale-price');

            price = parseInt(currentCartPrice.text().replace(/[^0-9]/g, ''));
            currentPriceText = $('#hiddenTotal').text();
            currentPrice = parseInt(currentPriceText.replace(/[^0-9]/g, ''));

            newPriceText = currentPrice + price + '<sup>đ</sup>';
            let totalOne = $(this).closest('.table-row').find('.total-cart .sale-price');
            let newTotalOne = price * value + '<sup>đ</sup>';
            totalOne.html(newTotalOne);
        }
        $('#hoverTotal').html(newPriceText);
        $('#hiddenTotal').html(newPriceText);
        let increaseDiv = $(this)
        increaseTimeOut = setTimeout(function () {

            if (userId == "") {
                let nameSpan;
                let jsonFromLocal = localStorage.getItem("Json_Cart_String");
                let dataFromLocal = JSON.parse(jsonFromLocal);
                if ($(increaseDiv).hasClass('hover')) {
                    nameSpan = $(increaseDiv).closest('.cart-product').find('.small-title');

                } else {
                    nameSpan = $(increaseDiv).closest('.table-row').find('.cart-detail-name');
                }
                let name = $(nameSpan).text();
                for (let i = 0; i < dataFromLocal.length; i++) {
                    if (name == dataFromLocal[i].product.title) {
                        dataFromLocal[i].num = value;
                        break;
                    }
                }
                localStorage.setItem("Json_Cart_String", JSON.stringify(dataFromLocal));

            } else {
                let id;
                let idHidden;
                if ($(increaseDiv).hasClass('hover')) {
                    idHidden = $(increaseDiv).closest('.cart-product').find('.idHidden');
                } else {
                    idHidden = $(increaseDiv).closest('.table-row').find('.idHidden');
                }

                id = idHidden.val();
                updateQuantity(id, value);
            }
            setTimeout(function () {
                redisplay();
            }, 1000);
        }, delay);

    });

    function updateQuantity(id, newQuantity) {
        let data = {
            id: parseInt(id),
            num: newQuantity
        }
        // console.log(id);
        let jsonString = JSON.stringify(data);
        $.ajax({
            url: "api/v1/carts",
            type: "PUT",
            contentType: 'application/json',
            data: jsonString,
            dataType: 'json',
            success: function (response) {

            },
        });
    }

    $(document).on('click', '.fa-trash', function () {

        if (userId == "") {
            let jsonFromLocal = localStorage.getItem("Json_Cart_String");
            let dataFromLocal = JSON.parse(jsonFromLocal);
            let nameSpan = $(this).closest('.cart-product').find('.small-title');
            let name = $(nameSpan).text();
            for (let i = 0; i < dataFromLocal.length; i++) {
                if (name == dataFromLocal[i].product.title) {
                    dataFromLocal.splice(i);
                    break;
                }
            }
            localStorage.setItem("Json_Cart_String", JSON.stringify(dataFromLocal));
            redisplay();
        } else {
            let idHidden = $(this).closest('.cart-product').find('.idHidden');
            let id = $(idHidden).val();

            let jsonObject = {
                ids: [parseInt(id)]
            }
            let jsonString = JSON.stringify(jsonObject);
            deleteCart(jsonString);

        }

    });

    function deleteCart(data) {
        $.ajax({
            url: "api/v1/carts",
            type: "DELETE",
            contentType: 'application/json',
            data: data,
            dataType: 'json',
            success: function (response) {
                redisplay();
            }
        });
    }

    function redisplay() {
        if (userId == "") {
            let jsonFromLocal = localStorage.getItem("Json_Cart_String");
            let dataFromLocal = JSON.parse(jsonFromLocal);
            displayHoverCart(dataFromLocal);
        } else {
            getCartsAndDisplayHover();
        }
    }
</script>
<script>

</script>
<%--<script type="text/javascript" src="assets/js/jquery-3.7.0.min.js"></script>--%>
<script type="text/javascript" src="<c:url value="/template/web/assets/js/jquery-3.7.0.min.js"/>"></script>
<%--<script type="text/javascript" src="bootstrap/bootstrap-5.0.2-dist/js/bootstrap.js">--%>
<script type="text/javascript"
        src="<c:url value="/template/web/bootstrap/bootstrap-5.0.2-dist/js/bootstrap.js"/>"></script>
</script>
</body>
</html>
