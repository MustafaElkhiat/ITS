<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/18/2020
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty param.selected}">
    <option selected hidden disabled>Select Role</option>
</c:if>
<c:forEach items="${roleList}" var="role">
    <c:choose>
        <c:when test="${param.selected == role.id}">
            <option selected value="${role.id}">${role.role}</option>
        </c:when>
        <c:otherwise>
            <option value="${role.id}">${role.role}</option>
        </c:otherwise>
    </c:choose>

</c:forEach>
