<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 12/1/2019
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="${param.user}_chart_div" style="width:280px; height:250px;"></div>
<script>
    // Load the Visualization API and the corechart package.
    google.charts.load('current', {'packages': ['corechart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.charts.setOnLoadCallback(function () {
        var chart_${param.user} = getTicketChart("${param.user}",initTicketChart().data,initTicketChart().options);
        getTicketData("${param.user}",chart_${param.user},initTicketChart().data,initTicketChart().options);
        setInterval(function () {
            getTicketData("${param.user}",chart_${param.user},initTicketChart().data,initTicketChart().options);
        }, 20000);
    });

    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.

</script>