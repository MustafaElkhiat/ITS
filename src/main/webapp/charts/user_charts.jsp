<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 2/5/2020
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="${param.user}_ticket_chart" >
    <jsp:include page="ticket_chart.jsp">
        <jsp:param name="user" value="${param.user}"/>
    </jsp:include>
</div>
<%--
<script>
    loadTicketChart("${param.user}");
</script>
--%>