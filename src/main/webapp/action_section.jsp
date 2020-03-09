<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/6/2019
  Time: 9:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<input id="status" type="hidden" name="status"/>
<div class="card mt-2">
    <div class="card-body">
        <h5 class="card-title">Actions</h5>
        <div class="row my-1">
            <div class="col">
                <button id="assign_to_btn" type="button" class="btn btn-outline-primary btn-full-width" status_value="1">Assign To</button>
            </div>
        </div>
        <div class="row my-1">
            <div class="col">
                <button id="in_progress_btn" type="button" class="btn btn-outline-warning btn-full-width" status_value="2">In Progress</button>
            </div>
        </div>
        <div class="row my-1">
            <div class="col">
                <button id="pending_btn" type="button" class="btn btn-outline-secondary btn-full-width" status_value="3">Pending</button>
            </div>
        </div>
        <div class="row my-1">
            <div class="col">
                <button id="solved_btn" type="button" class="btn btn-outline-success btn-full-width" status_value="4">Solved</button>
            </div>
        </div>
        <c:if test="${branch_manager}">
        <div class="row my-1">
            <div class="col">
                <button id="closed_btn" type="button" class="btn btn-outline-closed btn-full-width" status_value="5">Closed</button>
            </div>
        </div>
        </c:if>
    </div>
</div>
