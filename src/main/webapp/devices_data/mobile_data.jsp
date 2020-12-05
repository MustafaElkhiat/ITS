<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 5/13/2020
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-3">
        <div class="select-wrap">
            <label>Employee</label>
            <div class="input-group">
                <select class="form-control employee_" id="employee_" name="employee"
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
    <div class="col-3 mt-2">
        <div class="form-label-group">
            <input type="text" id="device_num" name="device_num" class="form-control"
                   placeholder="Device Number" value="${device.deviceNum}"
                   required=""
                   autofocus="">
            <label for="device_num">Device Number</label>
        </div>
    </div>
    <jsp:include page="../need_to_upgrade.jsp">
        <jsp:param name="classs" value="mt-2"/>
    </jsp:include>
</div>
<div class="row">
    <div class="offset-4 col-2">
        <button type="reset" class="btn btn-secondary btn-full-width reset">Clear</button>
    </div>
    <div class="col-2">
        <button type="button" id="mobile_submit" class="btn btn-primary btn-full-width">Submit</button>
    </div>
</div>

