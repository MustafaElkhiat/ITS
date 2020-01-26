<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/6/2020
  Time: 12:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty param.selected}">
    <option selected hidden disabled>Select OS</option>
</c:if>
<c:forEach items="${osList}" var="os">
    <c:choose>
        <c:when test="${param.selected == os.id}">
            <option selected value="${os.id}">${os.OS}</option>
        </c:when>
        <c:otherwise>
            <option value="${os.id}">${os.OS}</option>
        </c:otherwise>
    </c:choose>
</c:forEach>
