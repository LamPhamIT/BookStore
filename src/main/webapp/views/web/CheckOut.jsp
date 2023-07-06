<%--
  Created by IntelliJ IDEA.
  User: shinn
  Date: 03/07/2023
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BookStore</title>

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous"
          referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="<c:url value="/template/web/assets/css/checkout.css"/>">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<input type="hidden" id="user_id" name="user_id" value="${User.id} ">
<input type="hidden" id="email" name="email" value="${User.email} ">
<section class="container">

    <div class="container-box">
        <div class="title">
            <a href="#">Bookstore</a>
        </div>

        <form action="<c:url value="/thanh-toan"/>" method="POST" id="checkout-form">
            <div class="info">
                <div class="user-info">
                    <div class="header">
                        <h2>Thông tin nhận hàng</h2>
                        <c:if test="${empty User}">
                            <a href="<c:url value="/dang-nhap?action=login"/>" class="login">
                                <i class="fa-solid fa-circle-user"></i>
                                <p>Đăng nhập</p>
                            </a>
                        </c:if>
                        <c:if test="${not empty User}">
                            <a href="<c:url value="/dang-nhap?action=logout"/>" class="login">
                                <i class="fa-solid fa-right-from-bracket"></i>
                                <p>Đăng xuất</p>
                            </a>
                        </c:if>
                    </div>

                    <div class="email ct">
                        <input type="text" required="" name="email" class="input" id="emailInput">
                        <label class="label">Email</label>
                    </div>

                    <div class="fullname ct">
                        <input type="text" required="" name="fullname" id="fullname" class="input">
                        <label class="label">Họ và tên</label>
                    </div>

                    <div class="phone-number ct">
                        <input type="text" required="" name="phoneNumber" id="phoneNumber" class="input">
                        <label class="label">Số điện thoại</label>
                    </div>

                    <div class="address ct">
                        <input type="text" required="" name="address" id="address" class="input">
                        <label class="label">Địa chỉ</label>
                    </div>

                    <div class="city_province ct">
                        <select name="province" id="province">
                        </select>
                        <label class="label select-label">Tỉnh thành</label>
                    </div>
                    <div class="district ct">
                        <select name="district" id="district">
                        </select>
                        <label class="label select-label">Quận huyện</label>
                    </div>

                    <div class="note ct">
                        <textarea class="textarea" cols="20" rows="3" name="note" id="note"></textarea>
                        <label class="label">Ghi chú (tùy chọn)</label>
                    </div>


                </div>


                <div class="others">
                    <div class="transport">
                        <h1>Vận chuyển</h1>
                        <div><h2>Vui lòng nhập thông tin giao hàng</h2></div>
                    </div>

                    <div class="payment">
                        <h1>Thanh toán</h1>
                        <div class="checkbox-container">
                            <label class="checkbox-label">
                                <input type="checkbox" class="checkbox" checked disabled>
                                Thanh toán khi giao hàng (COD)
                                <i class="fa-regular fa-money-bill-1"></i>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <input type="hidden" name="shippingFee" id="shippingFee">
            <input type="hidden" name="price" id="price">
        </form>

    </div>

    <div class="container-box right">
        <div class="container__product">
            <div class="quantity">

            </div>
            <div class="wrap-products">


            </div>

            <div class="discount">
                <div class="discount-input ct">
                    <input type="text" class="input" required="" name="text">
                    <label class="label">Nhập mã giảm giá</label>
                </div>

                <a href="#" class="btn">Áp dụng</a>
            </div>

            <div class="calculate">
                <div class="Total-Money">

                </div>
                <div class="shipping-fee">
                    <p>Phí vận chuyển</p>
                    <span>_</span>
                </div>

                <div class="total">

                </div>
            </div>

            <div class="order">
                <a href="#" class="back">
                    <i class="fa-solid fa-chevron-left"></i>
                    <span>Quay về giỏ hàng</span>
                </a>
                <a href="#" class="btn" id="submit-form">Đặt hàng</a>
            </div>
        </div>
    </div>
</section>
<script>
    let userInput = document.getElementById('user_id');
    let userId = userInput.value.trim();

    let listOrderProduct = [];
    $('#submit-form').on('click', function (event) {
        event.preventDefault();
        let email = $('#emailInput').val();
        let phoneNumber = $('#phoneNumber').val();
        let address = $('#address').val();
        let fullname = $('#fullname').val();
        let note = $('#note').val();
        let shippingFee = $('#shippingFee').val();
        let price = $('#price').val();
        console.log(shippingFee);
        console.log(price);
        if (email == "" || phoneNumber == "" || address == "" || fullname == "") {
            alert('Vui lòng nhập đầy đủ thông tin')
            return;
        }
        if (!isValidEmail(email)) {
            alert('Sai định dạng email');
            return;
        }

        if (!isValidPhoneNumber(phoneNumber)) {
            alert('Sai định dạng số điện thoại');
            return;
        }


        let province = $('#province option:selected').text();
        let district = $('#district option:selected').text();

        address += ", " + district + ", " + province + '.';
        // $('#address').val(address);
        let data = {
            email: email,
            fullname: fullname,
            phoneNumber: phoneNumber,
            address: address,
            note: note,
            shippingFee: shippingFee,
            price: price,
            listOrderProduct: listOrderProduct
        }

        $.ajax({
            url: 'thanh-toan',
            method: 'POST',
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (response) {
                if (userId == "") {
                    let jsonFromLocal = localStorage.getItem("Json_Cart_String");
                    let existData = JSON.parse(jsonFromLocal) || [];
                    for (let i = 0; i < existData.length; i++) {
                        existData.splice(i, 1);
                    }
                    let updatedJson = JSON.stringify(existData);
                    localStorage.setItem("Json_Cart_String", updatedJson);
                }
                alert('Đặt hàng thành công, đang chờ duyệt.');
            }
        });
    });

    function isValidEmail(email) {
        let emailRegex = /^[a-zA-Z][a-zA-Z0-9_]*@[a-zA-Z]+\.[a-zA-Z]+$/;
        return emailRegex.test(email);
    };

    function isValidPhoneNumber(phoneNumber) {
        let phoneNumberRegex = /^(?:\+84|0)(?:3[2-9]|5[2689]|7[0|6-9]|8[1-9]|9[0-9])\d{7}$/;
        return phoneNumberRegex.test(phoneNumber);
    }

    document.addEventListener('DOMContentLoaded', function () {
        if (userId == "") {
            let jsonFromLocal = localStorage.getItem("Json_Cart_String");
            let dataFromLocal = JSON.parse(jsonFromLocal);
            displayOrder(dataFromLocal);
        } else {

            getCartsAjax();
            let emailInput = document.getElementById('email');
            let email = emailInput.value.trim();
            $('#emailInput').val(email);
            // $('#emailInput').attr("disable", true);
            // emailInputt.
        }
    });

    function getCartsAjax() {
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
                displayOrder(response);
            },
        });
    }

    function displayOrder(data) {
        let htmlText = "";
        let count = 0;
        let price = 0;
        for (let i = 0; i < data.length; i++) {
            count += data[i].num;
            price += data[i].product.discount != 0 ? data[i].product.discount * data[i].num : data[i].product.price * data[i].num;
            htmlText += '<div class="products"> ' +
                '<div class="info-product"> ' +
                '<div class="item"> ' +
                '<img width="100px" src="' + data[i].product.thumbnail + '" alt="">' +
                '<div class="quantity-no">' + data[i].num + '</div>' +
                '</div> ' +
                '<p style="color: black;">' + data[i].product.title + '</p>' +
                '</div> ' +
                '<div class="price" id="price"> <span>' + (data[i].product.discount != 0 ? data[i].product.discount * data[i].num : data[i].product.price * data[i].num) +
                '</span></div></div>';

            listOrderProduct.push({product: {id: data[i].product.id}, num: data[i].num});

        }
        $('.wrap-products').html(htmlText);
        let text = '<h1>Đơn hàng (<span)>' + count + '</span> sản phẩm)</h1>';
        $('.quantity').html(text);
        let text2 = '<p>Tạm tính</p> <span>' + price + '₫</span>';
        let text3 = ' <p>Tổng cộng</p> <span id="total-price">' + price + '₫</span>';
        $('.Total-Money').html(text2);
        $('.total').html(text3);
        $('#shippingFee').val('40000');
        $('#price').val(price);
    }


</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
        integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.26.1/axios.min.js"
        integrity="sha512-bPh3uwgU5qEMipS/VOmRqynnMXGGSRv+72H/N260MQeXZIK4PG48401Bsby9Nq5P5fz7hy5UGNmC/W1Z51h2GQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="<c:url value="/template/web/assets/js/Checkout.js"/>"></script>
</body>
</html>