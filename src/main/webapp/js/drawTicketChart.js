var drawTicketChart = function (countData) {
    var count = jQuery.parseJSON(countData);
    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'status');
    data.addColumn('number', 'Slices');
    data.addRows([
        ['Assigned To', count.assignToCount],
        ['In Progress', count.inProgressCount],
        ['Pending', count.pendingCount],
        ['Solved', count.solvedCount],
        ['Need To Solve', count.assignToUserCount],
        ['Closed', count.closedCount],
        ['Need To Close', count.needToCloseCount]
    ]);

    // Set chart options
    var options = {
        title: count.user_name + "'s Ticket Ratio",
        pieHole: 0.35,
        width: 280,
        height: 250,
        chartArea: {
            top: 40,
            left: 10,
            width: 260,
            height: 200
        },
        titleTextStyle: {
            fontSize: 18,
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


    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.PieChart(document.getElementById(count.user_id + "_chart_div"));
    chart.draw(data, options);
}
var getTicketData = function (user) {
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
            drawTicketChart(response_result);

        },
        fail: function (jqXHR, textStatus) {
            drawTicketChart(response_result);
        }
    });
}