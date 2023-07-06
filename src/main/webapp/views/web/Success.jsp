<%--
  Created by IntelliJ IDEA.
  User: shinn
  Date: 06/07/2023
  Time: 00:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Success</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  <link rel="stylesheet" href="<c:url value="/template/web/assets/css/success.css"/>">
</head>

<body>
<div class="container">
  <span class="topic">BookStore</span>
  <div class="box">
    <div class="information">
      <div class="title">
        <i class="fa-regular fa-circle-check correct-icon"></i>

        <div class="thank">
          <span class="title">Cảm ơn bạn đã đặt hàng</span>
          <div class="value">
            <span>Một email xác nhận đẫ được gửi tới phamtanlambe@gmail.com</span>
            <br>
            <span>Xin vui lòng kiểm tra email của bạn</span>
          </div>
        </div>
      </div>

      <div class="table">
        <div class="left">
          <ul class="in4-customer">
            Thông tin mua hàng
            <li>aa</li>
            <li>phamtanlambe@gmail.com</li>
            <li>0123456801</li>
          </ul>
          <ul class="payment">
            Phương thức thanh toán
            <li>Thanh toán khi giao hàng (COD)</li>
          </ul>
        </div>
        <div class="right">
          <ul class="address">
            Địa chỉ nhận hàng
            <li>aa</li>
            <li>sss</li>
            <li>Thị xã Tân Châu, An Giang</li>
            <li>0123456801</li>
          </ul>

          <ul class="transport">
            Phương thức vận chuyển
            <li>Giao hàng tận nơi</li>
          </ul>
        </div>
      </div>
      <div class="option">
        <button>Tiếp tục mua hàng</button>
        <div class="print">
          <i class="fa-solid fa-print"></i>
          <span>In</span>
        </div>
      </div>
    </div>
    <div class="cart">
      <div class="cart-box">
        <div class="id">Đơn hàng #1071 (1)</div>
        <ul class="product">
          <li>
            <div class="in4">
              <div class="pic">
                <img src="/img/tuoi tre.jpg" alt="#">
                <span class="num">1</span>
              </div>
              <span class="name">Tuổi trẻ đáng giá bap nhiêu</span>
            </div>
            <span class="price">56.000đ</span>
          </li>
        </ul>

        <div class="payment">
          <div class="value">
            <span class="name">Tạm tính</span>
            <span class="price">56.000đ</span>
          </div>

          <div class="value">
            <span class="name">Phí vận chuyển</span>
            <span class="price">40.000đ</span>
          </div>
        </div>
        <div class="sum">
          <span class="left">Tổng cộng</span>
          <span class="right">96.000đ</span>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>