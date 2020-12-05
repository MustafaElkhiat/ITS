<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/6/2019
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="card mt-2">
    <div class="card-body">
        <h5 class="card-title">Assign To</h5>
        <div class="select-wrap">
            <label>Techinal Support Enginner</label>
            <div class="input-group">
                <select class="form-control" id="ts_engineer_" name="ts_engineer" required autofocus>
                    <jsp:include page="../select_options/L2_engineer_options.jsp"/>
                </select>
                <%--<div class="input-group-append">
                    <button class="btn btn-outline-primary" type="button" data-toggle="modal"
                            data-target="#location_modal"><i class="fas fa-plus"></i></button>
                </div>--%>
            </div>
        </div>
        <div class="row">
            <div class="offset-10 col-2">
                <button type="button" id="action_submit" class="btn btn-primary btn-full-width">Submit</button>
            </div>
        </div>
    </div>
</div>
