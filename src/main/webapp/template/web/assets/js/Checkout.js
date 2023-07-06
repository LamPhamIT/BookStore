// 1. what is API
// 2. How do I call API
// 3. Explain code
const host = "https://provinces.open-api.vn/api/";
var callAPI = (api) => {
    return axios.get(api)
        .then((response) => {
            renderData(response.data, "province");
        });
}
callAPI('https://provinces.open-api.vn/api/?depth=1');
var callApiDistrict = (api) => {
    return axios.get(api)
        .then((response) => {
            renderData(response.data.districts, "district");
        });
}
// var callApiWard = (api) => {
//     return axios.get(api)
//         .then((response) => {
//             renderData(response.data.wards, "ward");
//         });
// }

var renderData = (array, select) => {
    let row = ' <option disable value="">---</option>';
    array.forEach(element => {
        row += `<option value="${element.code}">${element.name}</option>`
    });
    document.querySelector("#" + select).innerHTML = row
}

$("#province").change(() => {
    callApiDistrict(host + "p/" + $("#province").val() + "?depth=2");
    // printResult();
});
// $("#district").change(() => {
//     callApiWard(host + "d/" + $("#district").val() + "?depth=2");
//     // printResult();
// });

let isExecuted= false;
$('#province').change(() => {
    let htmlText = '<h1>Vận chuyển</h1>\n' +
                '<div><h2>Phí vận chuyển 40.000₫</h2></div>';
    $('.transport').html(htmlText);
   if(!isExecuted) {

       let totalPriceText = $("#total-price").text(); // Lấy nội dung của thẻ span
       let totalPrice = totalPriceText.replace(/\D/g, ""); // Loại bỏ các ký tự không phải là số
       console.log(totalPrice); //
       let htmlText2 = parseInt(totalPrice) + 40000 +'₫';
       $('#total-price').html(htmlText2);
       let htmlText3 = ' <p>Phí vận chuyển</p>' +
                                    '<span>40000₫</span>';
       $('.shipping-fee').html(htmlText3);
   }
   isExecuted = true;

});