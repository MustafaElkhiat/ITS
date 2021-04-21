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
    <option selected hidden disabled>Select Category</option>
</c:if>
<c:forEach items="${categoryList}" var="category">
    <c:choose>
        <c:when test="${param.selected == category.id}">
            <option selected value="${category.id}">${category.category}</option>
        </c:when>
        <c:otherwise>
            <option value="${category.id}">${category.category}</option>
        </c:otherwise>
    </c:choose>
</c:forEach>

