var initTicketChart = function () {
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'status');
    data.addColumn('number', 'Slices');
    data.addRows([
        ['Assigned To', 0],
        ['In Progress', 0],
        ['Pending', 0],
        ['Solved', 0],
        ['Need To Solve', 0],
        ['Closed', 0],
        ['Need To Close', 0]
    ]);

    // Set chart options
    var options = {
        pieHole: 0.35,
        height: 250,
        chartArea: {
            top: 40,
            left: 10,
            height: 200,
            width: "100%"
        },
        titleTextStyle: {
            fontSize: 15,
            fontName: 'Exo'
        },
        legend: {
            textStyle: {
                fontName: 'Exo'
            }
        },
        slices: {
            0: {color: '#007bff'},
            1: {color: '#ffc107'},
            2: {color: '#6c757d'},
            3: {color: '#28a745'},
            4: {color: '#dc3545'},
            5: {color: '#6E2571'},
            6: {color: '#17a2b8'}
        }
    };
    return {data: data, options: options};
}
var getTicketChart = function (user_id) {
    return new google.visualization.PieChart(document.getElementById(user_id + "_chart_div"));
}
var drawTicketChart = function (chart, data, options) {
    chart.draw(data, options);
}
var getTicketData = function (user, chart, data, options) {
    var response_result;
    //$("#"+user+"_chart_div").load('loading_spinner.jsp');
    $.ajax({
        url: "Controller",
        data: {
            n: "37",
            user: user
        },
        type: "POST",

        success: function (result, status, xhr) {
            response_result = result;
            var count = jQuery.parseJSON(result);
            data.setValue(0, 1, count.assignToCount);
            data.setValue(1, 1, count.inProgressCount);
            data.setValue(2, 1, count.pendingCount);
            data.setValue(3, 1, count.solvedCount);
            data.setValue(4, 1, count.assignToUserCount);
            data.setValue(5, 1, count.closedCount);
            data.setValue(6, 1, count.needToCloseCount);
            options.title = count.user_name + "'s Ticket Ratio";

            drawTicketChart(chart, data, options);

        },
        fail: function (jqXHR, textStatus) {
            alert("fail");
            //drawTicketChart(response_result);
        }
    });
}