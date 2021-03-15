<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/4/2020
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${device.internet}">
        <c:set var="internet" value='checked'/>
    </c:when>
    <c:otherwise>
        <c:set var="internet" value=''/>
    </c:otherwise>
</c:choose>
<div class="row">
    <div class="col-3">
        <div class="select-wrap">
            <label>PC Type</label>
            <div class="input-group">
                <select class="form-control pc_type" id="pc_type" name="pc_type" required
                        autofocus>
                    <jsp:include page="../select_options/pc_type_options.jsp">
                        <jsp:param name="selected" value="${device.pcType.id}"/>
                    </jsp:include>
                </select>

                <%--<div class="input-group-append">
                    <button class="btn btn-outline-primary" type="button" data-toggle="modal"
                            data-dismiss="modal"
                            aria-label="Close"
                            data-target="#location_modal"><i class="fas fa-plus"></i></button>
                </div>--%>
            </div>
        </div>
    </div>
    <div class="col-3">
        <div class="select-wrap">
            <label>Employee</label>
            <div class="input-group">
                <select class="form-control employee_" id="employee_" name="employee" required
                        autofocus>
                    <jsp:include page="../select_options/employee_options.jsp">
                        <jsp:param name="selected" value="${device.employee.id}"/>
                    </jsp:include>
                </select>

                <div class="input-group-append">
                    <button class="btn btn-outline-primary" type="button" data-toggle="modal"
                            data-dismiss="modal"
                            aria-label="Close"
                            data-target="#employee_modal"><i class="fas fa-plus"></i></button>
                </div>
            </div>
        </div>
    </div>
    <div class="col-3">
        <div class="select-wrap">
            <label>Operating System</label>
            <div class="input-group">
                <select class="form-control os_" id="os_" name="os" required
                        autofocus>
                    <jsp:include page="../select_options/os_options.jsp">
                        <jsp:param name="selected" value="${device.os.id}"/>
                    </jsp:include>
                </select>

                <div class="input-group-append">
                    <button class="btn btn-outline-primary" type="button" data-toggle="modal"
                            data-dismiss="modal"
                            aria-label="Close"
                            data-target="#os_modal"><i class="fas fa-plus"></i></button>
                </div>
            </div>
        </div>
    </div>
    <div class="col-3 mt-2">
        <div class="form-label-group">
            <input type="text" id="login_name" name="login_name" class="form-control"
                   placeholder="Login Name" value="${device.loginName}"
                   required=""
                   autofocus="">
            <label for="login_name">Login Name</label>
        </div>
    </div>
</div>
<div class="row">

    <div class="col-3">
        <div class="form-label-group">
            <input type="text" id="computer_name" name="computer_name" class="form-control"
                   placeholder="Computer Name" value="${device.computerName}"
                   required=""
                   autofocus="">
            <label for="computer_name">Computer Name</label>
        </div>
    </div>
    <div class="col-3">
        <div class="form-label-group">
            <input type="text" id="HD" name="HD" class="form-control"
                   placeholder="HardDisk" value="${device.HD}"
                   required=""
                   autofocus="">
            <label for="HD">HardDisk</label>
        </div>
    </div>
    <div class="col-3">
        <div class="form-label-group">
            <input type="text" id="ram" name="ram" class="form-control"
                   placeholder="RAM" value="${device.RAM}"
                   required=""
                   autofocus="">
            <label for="ram">RAM</label>
        </div>
    </div>
    <div class="col-3">
        <div class="form-label-group">
            <input type="text" id="cpu" name="cpu" class="form-control"
                   placeholder="CPU" value="${device.CPU}"
                   required=""
                   autofocus="">
            <label for="cpu">CPU</label>
        </div>
    </div>
</div>
<div class="row">

    <div class="col-3">
        <div class="form-label-group">
            <input type="text" id="monitor" name="monitor" class="form-control"
                   placeholder="Monitor" value="${device.monitor}"
                   required=""
                   autofocus="">
            <label for="monitor">Monitor</label>
        </div>
    </div>
    <div class="col-3">
        <div class="form-label-group">
            <input type="text" id="monitor_serial" name="monitor_serial" class="form-control"
                   placeholder="Monitor Serial Number" value="${device.monitorSerialNum}"
                   required=""
                   autofocus="">
            <label for="monitor_serial">Monitor Serial Number</label>
        </div>
    </div>

    <div class="col-3">
        <div class="input-group">
            <div class="input-group-prepend">
                <div class="input-group-text">
                    <input type="checkbox" id="internet" class="user_checkbox" ${internet}>
                </div>
            </div>
            <label class="form-control">Internet
            </label>
        </div>
    </div>
    <jsp:include page="../need_to_upgrade.jsp"/>
</div>
<div class="row">
    <div class="offset-4 col-2">
        <button type="reset" class="btn btn-secondary btn-full-width reset">Clear</button>
    </div>
    <div class="col-2">
        <button type="button" id="pc_submit" class="btn btn-primary btn-full-width">Submit</button>
    </div>
</div>
