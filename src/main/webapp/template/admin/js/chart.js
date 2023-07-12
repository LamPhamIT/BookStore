// document.addEventListener('DOMContentLoaded', function () {
//     Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
//     Chart.defaults.global.defaultFontColor = '#858796';
//
//     function number_format(number, decimals, dec_point, thousands_sep) {
//         // *     example: number_format(1234.56, 2, ',', ' ');
//         // *     return: '1 234,56'
//         number = (number + '').replace(',', '').replace(' ', '');
//         var n = !isFinite(+number) ? 0 : +number,
//             prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
//             sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
//             dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
//             s = '',
//             toFixedFix = function(n, prec) {
//                 var k = Math.pow(10, prec);
//                 return '' + Math.round(n * k) / k;
//             };
//         // Fix for IE parseFloat(0.55).toFixed(0) = 0;
//         s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
//         if (s[0].length > 3) {
//             s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
//         }
//         if ((s[1] || '').length < prec) {
//             s[1] = s[1] || '';
//             s[1] += new Array(prec - s[1].length + 1).join('0');
//         }
//         return s.join(dec);
//     }
//     $.ajax({
//         url: "api/v1/statistics",
//         method: 'GET',
//         success: function (response) {
//             displayChart(response);
//         }
//     });
//
//     function displayChart(data) {
//         let labels = [];
//         let money = [];
//         for (let i = 0; i < data.length; i++) {
//             labels.push(data[i].statisticDate);
//             money.push(data[i].total);
//         }
//         let dt = {
//             labels: labels,
//             datasets: [
//                 {
//                     label: "Doanh thu",
//
//                     lineTension: 0.3,
//                     backgroundColor: "rgba(78, 115, 223, 0.05)",
//                     borderColor: "rgba(78, 115, 223, 1)",
//                     pointRadius: 3,
//                     pointBackgroundColor: "rgba(78, 115, 223, 1)",
//                     pointBorderColor: "rgba(78, 115, 223, 1)",
//                     pointHoverRadius: 3,
//                     pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
//                     pointHoverBorderColor: "rgba(78, 115, 223, 1)",
//                     pointHitRadius: 10,
//                     pointBorderWidth: 2,
//                     // backgroundColor: 'transparent',
//                     // borderColor: '#4e73df',
//                     data: money,
//                     // tension: 0.4
//                 }
//             ]
//         }
//         let config   = {
//             type: 'line',
//             data: dt
//         }
//         let canvas = document.getElementById('chart');
//         let chart = new Chart(canvas, config);
//     }
//
// });