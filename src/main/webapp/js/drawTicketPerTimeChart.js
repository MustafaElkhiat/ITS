var drawTicketPerTimeChart = function (countData) {
    var count = jQuery.parseJSON(countData);
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Time');
    data.addColumn('number', 'PC');
    data.addColumn('number', 'Printer');
    data.addColumn('number', 'Camera');

    data.addRows([
        ['8:30', count.PC_8, count.PR_8, count.CAM_8],
        ['9:30', count.PC_9, count.PR_9, count.CAM_9],
        ['10:30', count.PC_10, count.PR_10, count.CAM_10],
        ['11:30', count.PC_11, count.PR_11, count.CAM_11],
        ['12:30', count.PC_12, count.PR_11, count.CAM_11],
        ['1:30', count.PC_13, count.PR_11, count.CAM_11],
        ['2:30', count.PC_14, count.PR_11, count.CAM_11],
        ['3:30', count.PC_15, count.PR_11, count.CAM_11],
        ['4:30', count.PC_16, count.PR_11, count.CAM_11],
        ['5:30', count.PC_17, count.PR_11, count.CAM_11]
    ]);

    var options = {
        title: 'Daily Ticket Per Time',
        curveType: 'function',
        chartArea: {left: 20, top: 40, width: 330},
        vAxis: {ticks: [-1, 0, 1, 2, 3, 4, 5, 10]},
        width: 350,
        height: 250,
        titleTextStyle: {
            fontSize: 18,
            fontName: 'Exo'
        },
        legend: {
            textStyle: {
                fontName: 'Exo'
            },
            position: 'bottom'
        },

    };

    var chart = new google.visualization.LineChart(document.getElementById('ticket_category_per_time'));

    chart.draw(data, google.charts.Line.convertOptions(options));
}

var getDailyTicketPerTimeData = function (region) {
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
            drawTicketPerTimeChart(response_result);

        },
        fail: function (jqXHR, textStatus) {
            drawTicketPerTimeChart(response_result);
        }
    });
}