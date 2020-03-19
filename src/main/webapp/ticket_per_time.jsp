<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 3/16/2020
  Time: 12:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-lg-4 col-sm-12">
    <div class="card mt-3">
        <div class="card-body">
            <div id="ticket_category_per_time" style="width:280px ;height:250px;"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    google.charts.load('current', {'packages': ['line']});
    google.charts.setOnLoadCallback(function () {
        var chart = getTicketPerTimeChart();
        getDailyTicketPerTimeData('${param.region}',chart,initTicketPerTimeChart().data,initTicketPerTimeChart().options);
        setInterval(function () {
            getDailyTicketPerTimeData('${param.region}',chart,initTicketPerTimeChart().data,initTicketPerTimeChart().options);
        }, 20000);
    });


</script>
