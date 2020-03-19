var initDeviceChart = function () {
    var data = google.visualization.arrayToDataTable([
        ['status', 'Slices'],
        ['PC', 0],
        ['Printer', 0],
        ['Finger Print', 0],
        ['IP Phone', 0],
        ['Switch', 0],
        ['Router', 0],
        ['UPS', 0],
        ['Firewall', 0],
        ['Camera', 0],
        ['DVR', 0],
        ['NVR', 0]
    ]);

    var options = {
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
        }
    };
    return {data: data, options: options};
}


var getDeviceChart = function (regionAbb) {
    return new google.visualization.PieChart(document.getElementById(regionAbb + "_device_chart"));
}
var drawDeviceChart = function (chart, data, options) {
    chart.draw(data, options);
}
var getDeviceData = function (region, chart, data, options) {
    var response_result;
    //$("#" + regionAbb + "_device_chart").load('loading_spinner.jsp');
    $.ajax({
        url: "Controller",
        data: {
            n: "38",
            region: region
        },
        type: "POST",

        success: function (result, status, xhr) {
            response_result = result;
            var count = jQuery.parseJSON(result);
            data.setValue(0, 1, count.PC_count);
            data.setValue(1, 1, count.Printer_count);
            data.setValue(2, 1, count.FP_count);
            data.setValue(3, 1, count.PBX_count);
            data.setValue(4, 1, count.SW_count);
            data.setValue(5, 1, count.RO_count);
            data.setValue(6, 1, count.UPS_count);
            data.setValue(7, 1, count.FW_count);
            data.setValue(8, 1, count.CAM_count);
            data.setValue(9, 1, count.DVR_count);
            data.setValue(10, 1, count.NVR_count);
            options.title = count.regionT + "'s Devices";
            drawDeviceChart(chart, data, options);

        },
        fail: function (jqXHR, textStatus) {
            alert("fail");
            //drawDeviceChart(response_result);
        }
    });
}