<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/13/2019
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty param.selected}">
    <option hidden selected disabled>Select Device Type</option>
</c:if>
<c:forEach items="${deviceTypeList}" var="deviceType">
    <c:choose>
        <c:when test="${param.selected == deviceType.id}">
            <option selected value="${deviceType.id}">${deviceType.deviceType}   (${deviceType.abbreviation})</option>
        </c:when>
        <c:otherwise>
            <option value="${deviceType.id}">${deviceType.deviceType}   (${deviceType.abbreviation})</option>
        </c:otherwise>
    </c:choose>
</c:forEach>

