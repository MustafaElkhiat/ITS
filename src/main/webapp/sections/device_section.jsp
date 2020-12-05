<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/5/2019
  Time: 12:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col">
    <div class="select-wrap mb-0">
        <label>Device</label>
        <div class="input-group">
            <select class="form-control" id="device_" name="device" required autofocus>
                <jsp:include page="../select_options/device_options.jsp"/>
            </select>
            <c:if test="${P_5}">  <%-- 5 Add Device--%>
                <div class="input-group-append">
                    <button class="btn btn-outline-primary" id="add_device" type="button" data-toggle="modal"

                    ><i class="fas fa-plus"></i></button>
                </div>
            </c:if>
        </div>
    </div>
</div>
