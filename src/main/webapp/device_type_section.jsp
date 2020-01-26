<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/13/2019
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="select-wrap">
    <label>Device Type</label>
    <div class="input-group">
        <select class="form-control device_type_" id="device_type_" name="device_type" required autofocus>
            <jsp:include page="device_type_options.jsp">
                <jsp:param name="selected" value="${param.selected}"/>
            </jsp:include>
        </select>
        <c:if test="${P_4}">  <%-- 4 Add Device Type--%>
            <div class="input-group-append">
                <button class="btn btn-outline-primary" type="button" data-toggle="modal" data-dismiss="modal"
                        aria-label="Close"
                        data-target="#device_type_modal"><i class="fas fa-plus"></i></button>
            </div>
        </c:if>
    </div>
</div>
