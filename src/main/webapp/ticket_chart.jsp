<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 12/1/2019
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="chart_div"></div>
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
            ['Assigned To', ${assignToCount}],
            ['In Progress', ${inProgressCount}],
            ['Pending', ${pendingCount}],
            ['Solved', ${solvedCount}],
            ['Need To Solve', ${assignToUserCount}]
        ]);

        // Set chart options
        var options = {
            title: 'Ticket Ratio',
            pieHole: 0.4,
            width: 400,
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
                3: {color: '#28a745'},
                4: {color: '#dc3545'}
            }
        };


        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
    }
</script>