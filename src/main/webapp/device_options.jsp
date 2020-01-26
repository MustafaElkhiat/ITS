<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/30/2019
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<option hidden selected disabled>Select Device</option>
<c:forEach items="${deviceList}" var="device">
    <option value="${device.id}">${device.device}</option>
</c:forEach>
