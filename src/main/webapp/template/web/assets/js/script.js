
$('.eye').on('click', function (event) {
    event.preventDefault();

    let idInput = $(this).closest('.product-box').find('.product_id');
    let id = parseInt(idInput.val());

    $.ajax({
        url: "api/v1/books",
        type: "GET",
        data: {
            productId: id
        },
        dataType: "json",
        success: function (response) {

            displayQuickView(response[0]);
        }
    });
});

function displayQuickView(product) {
    let htmlText = '<i class="fas fa-times remove-display"></i> ' +
        '<div class="quickview-thumnail"> ' +
        '<img src="' + product.thumbnail + '" alt=""> ' +
        '</div> ' +
        '<div class="quickview-infor"> ' +
        '<span class="name">' + product.title + '</span> ' +
        '<span>Tình trạng: </span> <span class="status">' + (product.remainQuality > 0 ? 'Còn hàng' : 'Hết hàng') + '</span> ' +
        '<span> | Loại: </span> <span class="category">' + product.category.categoryName + '</span> ' +
        '<div class="price-infor left"> ' + (product.discount != 0 ? '<span class="sale-price">' + product.discount + '<sup>đ</sup> </span><span class="price">' + product.price + '<sup>đ</sup></span>' : '<span class="sale-price">' + product.price + '<sup>đ</sup> </span> ') +
        '</div> ' +
        '<div class="amount-input"> ' +
        '<div class="decrease-div" onclick="decreaseValue()">-</div> ' +
        '<input type="number" id="Number-Product" name="num" value="1" readonly> ' +
        '<input type="hidden" id="Hidden-Product-Id" name="product_id" value="' + product.id + '">' +
        // '<h1>'+product.id+'</h1>'+
        '<div class="increase-div" onclick="increaseValue()">+ </div> ' +
        '</div> ' +
        '<a href="#" class="add-to-cart-primary" id="addToCartPrimary">Thêm vào giỏ</a>' +
        '</div>';
    $('.quickview-product').html(htmlText);
    $('.quickview-product').addClass('display-not-block');
    $('.background-cover').addClass('display-block');
}

$(document).on('click', '#addToCartPrimary', function (event) {

    event.preventDefault();
    let num = parseInt($('#Number-Product').val());
    let product_id = parseInt($('#Hidden-Product-Id').val());
    let userInput = document.getElementById('user_id');
    let userId = userInput.value.trim();
    $.ajax({
        url: 'cart',
        method: 'POST',
        data: {
            "num": num,
            "product_id": product_id
        },
        success: function(response) {
            if(userId=="") {
                addJsonToLocalStorage(response);
                let jsonFromLocal = localStorage.getItem("Json_Cart_String");
                let dataFromLocal = JSON.parse(jsonFromLocal);
                displayCart(dataFromLocal);
                displayHoverCart(dataFromLocal);
            }  else {
                getCarts();
                getCartsAndDisplayHover();
            }
        }
    });

});

$('.add-to-cart').submit(function (event) {
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
});

function addJsonToLocalStorage(data) {
    let jsonFromServer = JSON.stringify(data);
    let jsonFromLocal = localStorage.getItem("Json_Cart_String");
    let existData = JSON.parse(jsonFromLocal) || [];
    let check = false;
    let cart = JSON.parse(jsonFromServer)
    for (let i = 0; i < existData.length; i++) {
        if (cart.product.title == existData[i].product.title) {
            existData[i].num += cart.num;
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

$(document).on('click', '.remove-display', function () {

    $('.background-cover').removeClass('display-block');
    $('.hidden-cart').removeClass('display-block');
    $('.quickview-product').removeClass('display-not-block');
});
$('.background-cover').on('click', function () {
    $('.background-cover').removeClass('display-block');
    $('.hidden-cart').removeClass('display-block');
    $('.quickview-product').removeClass('display-not-block');
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

function    displayHoverCart(data) {
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
                // console.log(name +"  " +dataFromLocal[i].product.title);
                dataFromLocal.splice(i,1);
                console.log(dataFromLocal[i+1]);
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
function increaseValue() {
    let value = parseInt(document.getElementById('Number-Product').value, 10);
    value = isNaN(value) ? 0 : value;
    value++;
    document.getElementById('Number-Product').value = value;
}

function decreaseValue() {
    value = parseInt(document.getElementById('Number-Product').value, 10);
    value = isNaN(value) ? 0 : value;
    value < 1 ? value = 1 : '';
    value--;
    document.getElementById('Number-Product').value = value;
}
$('.search-submit').on("click", function (event) {
   event.preventDefault();
   // console.log('hello');
   let query = $('#query').val().trim();
   let form = $('#search-form');
   if(query == "") {
       alert('Vui lòng nhập từ khóa tìm kiếm');
   } else {
        form.submit();
   }
});