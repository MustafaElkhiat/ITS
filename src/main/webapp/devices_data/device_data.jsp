<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/11/2020
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <jsp:include page="../need_to_upgrade.jsp"/>
</div>

<div class="row">
    <div class="offset-4 col-2">
        <button type="reset" class="btn btn-secondary btn-full-width reset">Clear</button>
    </div>
    <div class="col-2">
        <button type="button" id="device_submit" class="btn btn-primary btn-full-width">Submit</button>
    </div>
</div>
