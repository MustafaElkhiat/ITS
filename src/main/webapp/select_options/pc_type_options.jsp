<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/6/2020
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty param.selected}">
    <option selected hidden disabled>Select PC Type</option>
</c:if>
<c:forEach items="${pcTypeList}" var="pcType">
    <c:choose>
        <c:when test="${param.selected == pcType.id}">
            <option selected value="${pcType.id}">${pcType.pcType}</option>
        </c:when>
        <c:otherwise>
            <option value="${pcType.id}">${pcType.pcType}</option>
        </c:otherwise>
    </c:choose>
</c:forEach>