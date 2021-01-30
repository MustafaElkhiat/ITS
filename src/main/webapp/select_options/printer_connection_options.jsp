<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/9/2020
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty param.selected}">
    <option selected hidden disabled>Select Printer Connection</option>
</c:if>
<c:forEach items="${printerConnectionList}" var="printerConnection">
    <c:choose>
        <c:when test="${param.selected == printerConnection.id}">
            <option selected value="${printerConnection.id}">${printerConnection.connection}</option>
        </c:when>
        <c:otherwise>
            <option value="${printerConnection.id}">${printerConnection.connection}</option>
        </c:otherwise>
    </c:choose>
</c:forEach>
