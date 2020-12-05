<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 2/9/2020
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<c:choose>
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
--%>
<div id="${param.regionAbb}_chart_div" style="height:250px;"></div>

<script>
    // Load the Visualization API and the corechart package.
    google.charts.load('current', {'packages': ['corechart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.charts.setOnLoadCallback(function () {
        var chart_${param.region} = getRegionChart("${param.regionAbb}");
        getRegionData("${param.region}", chart_${param.region}, initRegionChart().data, initRegionChart().options);
        setInterval(function () {
            getRegionData("${param.region}", chart_${param.region}, initRegionChart().data, initRegionChart().options);
        }, 20000);

    });
    <%--
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
                title: "${param.regionT}'s Ticket Ratio",
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
            var chart = new google.visualization.PieChart(document.getElementById('${param.regionAbb}_chart_div'));
            chart.draw(data, options);

        }--%>
</script>