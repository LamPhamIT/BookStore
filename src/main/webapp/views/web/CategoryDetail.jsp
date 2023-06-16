<%--
  Created by IntelliJ IDEA.
  User: shinn
  Date: 09/06/2023
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${category.categoryName}</title>
    <%--  <link rel="stylesheet" href="assets//css//base.css">--%>
    <link rel="stylesheet" href="<c:url value="/template/web/assets/css/base.css"/>">
    <%--  <link rel="stylesheet" href="assets//css//products.css">--%>
    <link rel="stylesheet" href="<c:url value="/template/web/assets/css/products.css"/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <%--  <link rel="stylesheet" type="text/css" href="bootstrap/bootstrap-5.0.2-dist/css/bootstrap.css">--%>
    <link rel="stylesheet" href="<c:url value="/template/web/bootstrap/bootstrap-5.0.2-dist/css/bootstrap.css" />">
</head>

<body>
<div class="top-header">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="account-link">
                    <a href="#">
                        <div class="fas fa-lock"></div>
                        ĐĂNG NHẬP
                    </a>
                    <a href="#">
                        <div class="fas fa-sign-in-alt"></div>
                        ĐĂNG KÝ
                    </a>
                    <a href="#">
                        <div class="fas fa-check-square"></div>
                        THANH TOÁN
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<header>
    <div class="mid-header wid_100">
        <div class="container">
            <div class="row">
                <div class="col-sm-3 col-md-4 col-3 menu-bar d-lg-none">
                    <input type="checkbox" class="checkbox-input" id="checkbox-input"></input>
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
                            <span class="amount-items">0</span>
                            <span class="hidden-xs">SẢN PHẨM</span>
                            <div class="fa fa-sort-down"></div>
                        </a>
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
<nav>

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
                <form action="GET" class="search-form">
                    <input type="text" placeholder="Tìm kiếm">
                    <button type="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </form>
            </div>
        </div>
    </div>
</nav>
<div class="main">
    <div class="container">
        <div class="wrapper">

            <div class="row flex-sm-column-reverse flex-column-reverse
             flex-md-column-reverse flex-lg-row">
                <div class="col-lg-3 col-md-12 col-sm-12 col-12">
                    <section class="aside">
                        <h3>DANH MỤC</h3>
                        <ul class="nav_list" style="z-index: 2"
                        >
                            <li class="nav_link"><a href="<c:url value="/trang-chu"/>">Trang chủ</a></li>
                            <li class="nav_link"><a href="#">Giới thiệu</a></li>
                            <li class="nav_link"><a href="#">Sản phẩm</a></li>
                            <li class="nav_link"><a href="#">Tin tức</a></li>
                            <li class="nav_link"><a href="#">Liên hệ</a></li>
                        </ul>

                    </section>
                </div>
                <div class="col-lg-9 col-md-12 col-sm-12 col-12">
                    <div class="row d-flex justify-content-between">
                        <h3 class="title">${category.categoryName}</h3>
                        <!-- <div class="products"> -->

                        <c:forEach var="i" items="${listProducts}">
                            <div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12">
                                <div class="product-block">
                                    <div class="product-box">
                                        <div class="product-thumbnail">
                                            <a href="#" class="product-link">
                                                <img src="${i.thumbnail}"
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
                                            <form action="POST" class="add-to-cart">
                                                <button type="submit">
                                                    <div class="fa fa-shopping-bag"></div>
                                                    Thêm vào giỏ
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <!-- </div> -->
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
<%--<script type="text/javascript" src="assets/js/jquery-3.7.0.min.js"></script>--%>
<script src="<c:url value="/template/web/assets/js/jquery-3.7.0.min.js" />"></script>
<%--<script type="text/javascript" src="bootstrap/bootstrap-5.0.2-dist/js/bootstrap.js"></script>--%>

<script src="<c:url value="/template/web/bootstrap/bootstrap-5.0.2-dist/js/bootstrap.js"/>"></script>
</body>

</html>