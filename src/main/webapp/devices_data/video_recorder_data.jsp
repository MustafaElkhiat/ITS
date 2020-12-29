<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/12/2020
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">

    <div class="col-3">
        <div class="form-label-group">
            <input type="number" id="port_num" name="port_num" class="form-control"
                   placeholder="Port Number" value="${device.portNum}"
                   required=""
                   autofocus="">
            <label for="port_num">Port Number</label>
        </div>
    </div>
    <jsp:include page="../need_to_upgrade.jsp"/>
</div>
<div class="row">
    <div class="offset-4 col-2">
        <button type="reset" class="btn btn-secondary btn-full-width reset">Clear</button>
    </div>
    <div class="col-2">
        <button type="button" id="vr_submit" class="btn btn-primary btn-full-width">Submit</button>
    </div>
</div>
