var initTicketBarChart = function () {
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Engineer');
    data.addColumn('number', 'Assigned To');
    data.addColumn('number', 'In Progress');
    data.addColumn('number', 'Pending');
    data.addColumn('number', 'Solve');
    data.addColumn('number', 'Need To Solve');
    data.addColumn('number', 'Closed');
    data.addColumn('number', 'Need To Close');
    /*
        data.addRows(['Mustafa', 0, 0, 0, 0, 0, 0, 0]);
        data.setValue(0, 1, 1);
        data.setValue(0, 2, 2);
        data.setValue(0, 3, 1);
        data.setValue(0, 4, 4);
        data.setValue(0, 5, 8);
        data.setValue(0, 6, 1);
        data.setValue(0, 7, 10);
    */

    var options = {
        height: 300,
        vAxis: {
            ticks: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
            textStyle: {
                bold: true,
            }
        },
        hAxis: {
            textStyle: {
                bold: true,
            }
        },
        chartArea: {
            height: '80%',
            width: '100%'
        },
        seriesType: 'bars',
        colors: ['#007bff', '#ffc107', '#6c757d', '#28a745', '#dc3545', '#6E2571', '#17a2b8']
    };
    return {data: data, options: options}
}

var getTicketBarChart = function () {
    return new google.visualization.ComboChart(document.getElementById('bar_chart_div'));
}
var drawTicketBarChart = function (chart, data, options) {
    chart.draw(data, options);
}

var getTicketBarChartData = function (region, chart, data, options) {
    var response_result;
    //$("#" + regionAbb + "_chart_div").load('loading_spinner.jsp');
    $.ajax({
        url: "Controller",
        data: {
            n: "41",
            region: region
        },
        type: "POST",

        success: function (result, status, xhr) {
            response_result = result;
            var count = jQuery.parseJSON(result);
            $.each(count, function (index, value) {
                data.addRow([value.user_name, checkZeroValue(value.assignToCount), checkZeroValue(value.inProgressCount),
                    checkZeroValue(value.pendingCount), checkZeroValue(value.solvedCount), checkZeroValue(value.assignToUserCount),
                    checkZeroValue(value.closedCount), checkZeroValue(value.needToCloseCount)]);
                /*data.setValue(0, 1, value.assignToCount);
                data.setValue(0, 2, value.inProgressCount);
                data.setValue(0, 3, value.pendingCount);
                data.setValue(0, 4, value.solvedCount);
                data.setValue(0, 5, value.assignToUserCount);
                data.setValue(0, 6, value.closedCount);
                data.setValue(0, 7, value.needToCloseCount);*/
            });
            drawTicketBarChart(chart, data, options);

        },
        fail: function (jqXHR, textStatus) {
            alert("fail");
            //drawRegionChart(response_result);
        }
    });
}

var checkZeroValue = function (value) {
    if (value == 0) {
        return {v: 0.2, f: '0'};
    } else {
        return value;
    }
}
