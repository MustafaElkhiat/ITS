<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/13/2019
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<option selected hidden disabled>Select Category</option>
<c:forEach items="${categoryList}" var="category">
    <option value="${category.id}">${category.category}</option>
</c:forEach>

