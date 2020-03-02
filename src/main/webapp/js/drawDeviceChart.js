var drawDeviceChart = function (countData) {
    var count = jQuery.parseJSON(countData);
    var data = google.visualization.arrayToDataTable([
        ['status', 'Slices'],
        ['PC', count.PC_count],
        ['Printer', count.Printer_count],
        ['Finger Print', count.FP_count],
        ['IP Phone', count.PBX_count],
        ['Switch', count.SW_count],
        ['Router', count.RO_count],
        ['UPS', count.UPS_count],
        ['Firewall', count.FW_count],
        ['Camera', count.CAM_count],
        ['DVR', count.DVR_count],
        ['NVR', count.NVR_count]
    ]);

    var options = {
        title: count.regionT + "'s Devices",
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
        }
    };

    var chart = new google.visualization.PieChart(document.getElementById(count.regionAbb + "_device_chart"));
    chart.draw(data, options);
}

var getDeviceData = function (region,regionAbb) {
    $("#" + regionAbb + "_device_chart").load('loading_spinner.jsp');
    $.ajax({
        url: "Controller",
        data: {
            n: "38",
            region: region
        },
        type: "POST",

        success: function (result, status, xhr) {
            drawDeviceChart(result);

        }
    });
}