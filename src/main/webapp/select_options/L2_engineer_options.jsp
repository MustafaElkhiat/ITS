<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/13/2019
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<option selected hidden disabled>Select Techinal Support Enginner</option>
<c:forEach items="${tsUserRegionList}" var="userRegion">
    <c:if test="${userRegion.TSUser.role.id == 5 && userRegion.TSUser.id != currentUser.id}">
        <option value="${userRegion.TSUser.id}">${userRegion.TSUser.name}</option>
    </c:if>
</c:forEach>

