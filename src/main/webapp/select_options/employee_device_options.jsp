<%--
  Created by IntelliJ IDEA.
  User: Eng. Mustafa Elkhiat
  Date: 3/30/21
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<option hidden selected disabled>Select Device</option>
<c:forEach items="${deviceList}" var="device">
    <option value="${device.id}">${device.type} - ${device.vendor}</option>
</c:forEach>
