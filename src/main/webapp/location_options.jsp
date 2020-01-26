<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/13/2019
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty param.selected}">
    <option selected hidden disabled>Select Location</option>
</c:if>
<c:forEach items="${locationList}" var="location">
    <c:choose>
        <c:when test="${param.selected == location.id}">
            <option selected value="${location.id}">${location.location}</option>
        </c:when>
        <c:otherwise>
            <option value="${location.id}">${location.location}</option>
        </c:otherwise>
    </c:choose>

</c:forEach>

