<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/15/2020
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="select-wrap">
    <label>Location</label>
    <div class="input-group">
        <select class="form-control location_" id="location_" name="location" required autofocus>
            <jsp:include page="../select_options/location_options.jsp"/>
        </select>

        <c:if test="${P_2}">  <%-- 2 Add Location--%>
            <div class="input-group-append">
                <button class="btn btn-outline-primary" type="button" data-toggle="modal" data-dismiss="modal"
                        aria-label="Close"
                        data-target="#location_modal"><i class="fas fa-plus"></i></button>
            </div>
        </c:if>
    </div>
</div>
