<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 2/12/2020
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${region == 'ALL'}">
        <c:set var="regionAbb" value="All"/>
    </c:when>
    <c:otherwise>
        <c:set var="regionAbb" value="${region.abbreviation}"/>

    </c:otherwise>
</c:choose>
<c:choose>
    <c:when test="${region == 'ALL'}">
        <c:set var="regionT" value="All Regions"/>
    </c:when>
    <c:otherwise>
        <c:set var="regionT" value="${region.region}"/>

    </c:otherwise>
</c:choose>
<div id="${regionAbb}_device_chart"></div>
<script type="text/javascript">
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

        var data = google.visualization.arrayToDataTable([
            ['status', 'Slices'],
            ['PC', ${PC_count}],
            ['Printer', ${Printer_count}],
            ['Finger Print', ${FP_count}],
            ['IP Phone', ${PBX_count}],
            ['Switch', ${SW_count}],
            ['Router', ${RO_count}],
            ['UPS', ${UPS_count}],
            ['Firewall', ${FW_count}],
            ['Camera', ${CAM_count}],
            ['DVR', ${DVR_count}],
            ['NVR', ${NVR_count}]
        ]);

        var options = {
            title: "${regionT}'s Devices",
            pieHole: 0.35,
            width: 280,
            height: 250,
            chartArea: {
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

        var chart = new google.visualization.PieChart(document.getElementById('${regionAbb}_device_chart'));
        chart.draw(data, options);
    }
</script>
