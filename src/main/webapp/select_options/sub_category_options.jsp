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
    <option selected hidden disabled>Select Sub-Category</option>
</c:if>
<c:forEach items="${subCategoryList}" var="sub_category">
    <c:choose>
        <c:when test="${param.selected == sub_category.id}">
            <option selected value="${sub_category.id}">${sub_category.sub_category}</option>
        </c:when>
        <c:otherwise>
            <option value="${sub_category.id}">${sub_category.sub_category}</option>
        </c:otherwise>
    </c:choose>
</c:forEach>