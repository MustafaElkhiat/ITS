<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 2/9/2020
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-lg-6 col-sm-12">
    <div class="card mt-3">
        <div class="card-body">
            <jsp:include page="region_charts.jsp">
                <jsp:param name="region" value="${param.region}"/>
            </jsp:include>
        </div>
    </div>
</div>
