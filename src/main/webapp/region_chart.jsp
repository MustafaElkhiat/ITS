<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 2/9/2020
  Time: 10:15 AM
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

<div id="${regionAbb}_chart_div"></div>

<script>
    // Load the Visualization API and the corechart package.
    google.charts.load('current', {'packages': ['corechart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.charts.setOnLoadCallback(drawChart);

    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.
    function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'status');
        data.addColumn('number', 'Slices');
        data.addRows([
            ['Assigned To', ${assignToRegionCount}],
            ['In Progress', ${inProgressRegionCount}],
            ['Pending', ${pendingRegionCount}],
            ['Solved', ${solvedRegionCount}]
        ]);

        // Set chart options
        var options = {
            title: "${regionT}'s Ticket Ratio",
            pieHole: 0.35,
            width: 430,
            height: 250,
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
                3: {color: '#28a745'}
            }
        };


        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('${regionAbb}_chart_div'));
        chart.draw(data, options);
    }
</script>