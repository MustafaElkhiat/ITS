<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/9/2020
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">

    <div class="col-3 ">
        <div class="form-label-group">
            <input type="text" id="subnet" name="subnet" class="form-control"
                   placeholder="Subnet" value="${device.subnet}"
                   required=""
                   autofocus="">
            <label for="subnet">Subnet</label>
        </div>
    </div>
    <div class="col-3 ">
        <div class="form-label-group">
            <input type="text" id="gateway" name="gateway" class="form-control"
                   placeholder="Gateway" value="${device.gateway}"
                   required=""
                   autofocus="">
            <label for="gateway">Gateway</label>
        </div>
    </div>
    <jsp:include page="need_to_upgrade.jsp"/>

</div>
<div class="row">
    <div class="offset-4 col-2">
        <button type="reset" class="btn btn-secondary btn-full-width reset">Clear</button>
    </div>
    <div class="col-2">
        <button type="button" id="att_submit" class="btn btn-primary btn-full-width">Submit</button>
    </div>
</div>