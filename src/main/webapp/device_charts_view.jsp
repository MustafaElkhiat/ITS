<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 2/12/2020
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-lg-4 col-sm-12">
    <div class="card mt-3">
        <div class="card-body">
            <div id="${param.region}_device_chart">
            </div>
        </div>
    </div>
</div>
<script>
    loadDeviceChart("${param.region}");
</script>