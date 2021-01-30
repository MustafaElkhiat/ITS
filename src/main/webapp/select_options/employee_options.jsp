<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/6/2020
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty param.selected}">
    <option selected hidden disabled>Select Employee</option>
</c:if>
<c:forEach items="${employeeList}" var="employee">
    <c:choose>
        <c:when test="${param.selected == employee.id}">
            <option selected value="${employee.id}">${employee.name}</option>
        </c:when>
        <c:otherwise>
            <option value="${employee.id}">${employee.name}</option>
        </c:otherwise>
    </c:choose>
</c:forEach>
