<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/30/2020
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="page_header.jsp">
    <jsp:param name="title" value="Dashboard"/>
</jsp:include>

<c:forEach items="${userRegionList}" var="userRegion">
    <jsp:include page="ticket_section.jsp">
        <jsp:param name="user" value="${userRegion.TSUser.id}"/>

    </jsp:include>
</c:forEach>
