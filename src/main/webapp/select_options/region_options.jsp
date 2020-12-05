<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/15/2020
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty param.selected}">
    <option selected hidden disabled>Select Region</option>
</c:if>
<c:forEach items="${regionList}" var="region">
    <c:choose>
        <c:when test="${param.selected == region.region.id}">
            <option selected value="${region.region.id}">${region.region.region}   (${region.region.abbreviation})</option>
        </c:when>
        <c:otherwise>
            <option value="${region.region.id}">${region.region.region}   (${region.region.abbreviation})</option>
        </c:otherwise>
    </c:choose>

</c:forEach>
