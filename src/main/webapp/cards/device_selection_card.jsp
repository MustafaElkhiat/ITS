<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/4/2019
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="card">
    <div class="card-body">
        <h5 class="card-title">Select Device</h5>
        <div class="row">
            <div class="col">
                <div class="select-wrap">
                    <label>Region</label>
                    <div class="input-group">
                        <select class="form-control region_" id="region_" name="region" required autofocus>
                            <jsp:include page="../select_options/region_options.jsp"/>
                        </select>
                        <c:if test="${P_1}">  <%-- 1 Add Region--%>
                            <div class="input-group-append">
                                <button class="btn btn-outline-primary" type="button" data-toggle="modal"
                                        data-dismiss="modal"
                                        aria-label="Close"
                                        data-target="#region_modal"><i class="fas fa-plus"></i></button>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../sections/device_selection_section.jsp">
            <jsp:param name="canAdd" value="true"/>
        </jsp:include>
        <div id="device_section" class="row"></div>
    </div>
</div>
