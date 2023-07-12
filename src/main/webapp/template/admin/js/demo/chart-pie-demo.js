// Set new default font family and font color to mimic Bootstrap's default styling
document.addEventListener('DOMContentLoaded', function () {

    Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
    Chart.defaults.global.defaultFontColor = '#858796';

    $.ajax({
        url: "api/v1/statistics/categoryname",
        method: 'GET',
        success: function (response) {

            displayChart(response);
        }
    });
// Pie Chart Example
   function displayChart(dt) {
      let labels= [];
      let num = [];
      console.log(dt);
      for(let i = 0; i < dt.length;i++) {
          labels.push(dt[i].categoryName);
          num.push(dt[i].num);
      }
      console.log("hello");
      console.log(labels);
       let ctx = document.getElementById("myPieChart");
       let myPieChart = new Chart(ctx, {
           type: 'doughnut',
           data: {
               labels: labels,
               datasets: [{
                   data: num,
                   backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc', '#FF33FF', '#CC66FF', '#FF9900', '#FFCCFF', '#000022', '#CC0000'],
                   hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf', '#FF33CC', '#CC66CC', '#FF9966', '#FFCCCC', '#000022', '#BB0000'],
                   hoverBorderColor: "rgba(234, 236, 244, 1)",
               }],
           },
           options: {
               maintainAspectRatio: false,
               tooltips: {
                   backgroundColor: "rgb(255,255,255)",
                   bodyFontColor: "#858796",
                   borderColor: '#dddfeb',
                   borderWidth: 1,
                   xPadding: 15,
                   yPadding: 15,
                   displayColors: false,
                   caretPadding: 10,
               },
               legend: {
                   display: false
               },
               cutoutPercentage: 80,
           },
       });
   }
});