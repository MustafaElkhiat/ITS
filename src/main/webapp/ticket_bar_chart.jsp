<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 3/19/2020
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-lg-12 col-sm-12">
        <div class="card mt-3">
            <div class="card-body">
                <div id="bar_chart_div"></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(function () {
        var chart = getTicketBarChart();
        getTicketBarChartData('${param.region}', chart, initTicketBarChart().data, initTicketBarChart().options);
        setInterval(function () {
            getTicketBarChartData('${param.region}', chart, initTicketBarChart().data, initTicketBarChart().options);
        }, 20000);
    });


</script>
