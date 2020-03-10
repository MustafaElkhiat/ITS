// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
var drawRegionChart = function (countData) {
    var count = jQuery.parseJSON(countData);
    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'status');
    data.addColumn('number', 'Slices');
    data.addRows([
        ['Assigned To', count.assignToRegionCount],
        ['In Progress', count.inProgressRegionCount],
        ['Pending', count.pendingRegionCount],
        ['Solved', count.solvedRegionCount],
        ['closed', count.closedRegionCount]
    ]);

    // Set chart options
    var options = {
        title: count.regionT + "'s Ticket Ratio",
        pieHole: 0.35,
        width: 280,
        height: 250,
        chartArea: {
            top: 40,
            left: 10,
            width: 250,
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
            4: {color: '#000000'}
        }
    }

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.PieChart(document.getElementById(count.regionAbb + "_chart_div"));
    chart.draw(data, options);
}
var getRegionData = function (region, regionAbb) {
    var response_result;
    //$("#" + regionAbb + "_chart_div").load('loading_spinner.jsp');
    $.ajax({
        url: "Controller",
        data: {
            n: "36",
            region: region
        },
        type: "POST",

        success: function (result, status, xhr) {
            response_result = result;
            drawRegionChart(response_result);

        },
        fail: function (jqXHR, textStatus) {
            drawRegionChart(response_result);
        }
    });
}