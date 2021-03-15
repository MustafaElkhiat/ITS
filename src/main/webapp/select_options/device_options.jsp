<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/30/2019
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<option hidden selected disabled>Select Device</option>
<c:forEach items="${deviceList}" var="device">
    <option value="${device.id}"><fmt:formatNumber
            type="number" minIntegerDigits="3" value="${device.deviceNumCode}"/></option>
</c:forEach>
