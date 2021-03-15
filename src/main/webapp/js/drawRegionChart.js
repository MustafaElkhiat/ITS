// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
var initRegionChart = function () {
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'status');
    data.addColumn('number', 'Slices');
    data.addRows([
        ['Assigned To', 0],
        ['In Progress', 0],
        ['Pending', 0],
        ['Solved', 0],
        ['closed', 0]
    ]);

    // Set chart options
    var options = {
        pieHole: 0.35,
        height: 250,
        chartArea: {
            top: 40,
            left: 10,
            height: 200,
            width:"100%"
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
            4: {color: '#6E2571'}
        }
    }
    return {data: data, options: options};
}
var getRegionChart = function (regionAbb) {
    return new google.visualization.PieChart(document.getElementById(regionAbb + "_chart_div"));
}
var drawRegionChart = function (chart, data, options) {
    chart.draw(data, options);
}

var getRegionData = function (region, chart, data, options) {
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
            var count = jQuery.parseJSON(result);
            data.setValue(0, 1, count.assignToRegionCount);
            data.setValue(1, 1, count.inProgressRegionCount);
            data.setValue(2, 1, count.pendingRegionCount);
            data.setValue(3, 1, count.solvedRegionCount);
            data.setValue(4, 1, count.closedRegionCount);
            options.title = count.regionT + "'s Ticket Ratio";
            drawRegionChart(chart, data, options);

        },
        fail: function (jqXHR, textStatus) {
            alert("fail");
            //drawRegionChart(response_result);
        }
    });
}