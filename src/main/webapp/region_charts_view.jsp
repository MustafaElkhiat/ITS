<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 2/9/2020
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-lg-4 col-sm-12">
    <div class="card mt-3">
        <div class="card-body">
            <div id="${param.region}_region_chart">
            </div>
        </div>
    </div>
</div>
<script>
    loadRegionChart("${param.region}");
</script>