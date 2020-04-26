var initTicketPerTimeChart = function () {
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Time');
    data.addColumn('number', 'PC');
    data.addColumn('number', 'Printer');
    data.addColumn('number', 'Camera');

    data.addRows([
        ['8:30', 0, 0, 0],
        ['9:30', 0, 0, 0],
        ['10:30', 0, 0, 0],
        ['11:30', 0, 0, 0],
        ['12:30', 0, 0, 0],
        ['1:30', 0, 0, 0],
        ['2:30', 0, 0, 0],
        ['3:30', 0, 0, 0],
        ['4:30', 0, 0, 0],
        ['5:30', 0, 0, 0]
    ]);

    var options = {
        title: 'Daily Ticket Per Time',
        curveType: 'function',
        chartArea: {left: 20, top: 40 ,width:"100%"},
        vAxis: {
            ticks: [-1, 0, 1, 2, 3, 4, 5, 10],
            textStyle: {
                fontName: 'Exo',
                bold: true
            }
        },
        hAxis: {
            textStyle: {
                fontName: 'Exo',
                bold: true
            }
        },
        height: 250,
        titleTextStyle: {
            fontSize: 15,
            fontName: 'Exo'
        },
        legend: {
            textStyle: {
                fontName: 'Exo'
            },
            position: 'bottom'
        },

    };
    return {data: data, options: options};
}
var getTicketPerTimeChart = function () {
    return new google.visualization.LineChart(document.getElementById('ticket_category_per_time'));
}
var drawTicketPerTimeChart = function (chart, data, options) {
    chart.draw(data, google.charts.Line.convertOptions(options));
}


var getDailyTicketPerTimeData = function (region, chart, data, options) {
    var response_result;
    //$("#"+user+"_chart_div").load('loading_spinner.jsp');
    $.ajax({
        url: "Controller",
        data: {
            n: "40",
            region: region
        },
        type: "POST",

        success: function (result, status, xhr) {
            response_result = result;
            //drawTicketPerTimeChart(response_result);
            var count = jQuery.parseJSON(result);
            data.setValue(0, 1, count.PC_8);
            data.setValue(1, 1, count.PC_9);
            data.setValue(2, 1, count.PC_10);
            data.setValue(3, 1, count.PC_11);
            data.setValue(4, 1, count.PC_12);
            data.setValue(5, 1, count.PC_13);
            data.setValue(6, 1, count.PC_14);
            data.setValue(7, 1, count.PC_15);
            data.setValue(8, 1, count.PC_16);
            data.setValue(9, 1, count.PC_17);
            data.setValue(0, 2, count.PR_8);
            data.setValue(1, 2, count.PR_9);
            data.setValue(2, 2, count.PR_10);
            data.setValue(3, 2, count.PR_11);
            data.setValue(4, 2, count.PR_12);
            data.setValue(5, 2, count.PR_13);
            data.setValue(6, 2, count.PR_14);
            data.setValue(7, 2, count.PR_15);
            data.setValue(8, 2, count.PR_16);
            data.setValue(9, 2, count.PR_17);
            data.setValue(0, 3, count.CAM_8);
            data.setValue(1, 3, count.CAM_9);
            data.setValue(2, 3, count.CAM_10);
            data.setValue(3, 3, count.CAM_11);
            data.setValue(4, 3, count.CAM_12);
            data.setValue(5, 3, count.CAM_13);
            data.setValue(6, 3, count.CAM_14);
            data.setValue(7, 3, count.CAM_15);
            data.setValue(8, 3, count.CAM_16);
            data.setValue(9, 3, count.CAM_17);

            drawTicketPerTimeChart(chart, data, options);
        },
        fail: function (jqXHR, textStatus) {
            alert(fail);
            //drawTicketPerTimeChart(response_result);
        }
    });
}