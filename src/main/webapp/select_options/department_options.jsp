<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/13/2019
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty param.selected}">
    <option selected hidden disabled>Select Department</option>
</c:if>
<c:forEach items="${departmentList}" var="department">
    <c:choose>
        <c:when test="${param.selected == department.id}">
            <option selected value="${department.id}">${department.department}   (${department.abbreviation})</option>
        </c:when>
        <c:otherwise>
            <option value="${department.id}">${department.department}   (${department.abbreviation})</option>
        </c:otherwise>
    </c:choose>
</c:forEach>
