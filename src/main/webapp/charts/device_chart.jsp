<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 2/12/2020
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="${param.regionAbb}_device_chart" style="height:250px ;"></div>
<script type="text/javascript">
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(function () {

        var chart_${param.regionAbb} = getDeviceChart("${param.regionAbb}");
        getDeviceData("${param.region}", chart_${param.regionAbb}, initDeviceChart().data, initDeviceChart().options);
        setInterval(function () {
            getDeviceData("${param.region}", chart_${param.regionAbb}, initDeviceChart().data, initDeviceChart().options);
        }, 20000);
    });


</script>
