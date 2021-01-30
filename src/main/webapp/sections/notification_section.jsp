<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 12/26/2019
  Time: 1:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="notification_dropdown" class="dropdown">
    <button type="button" id="notificationLink"
            class="btn btn-outline-primary dropdown-toggle"
            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <span class="fa fa-bell"></span> Notification
        <span class="badge badge-pill badge-danger" id="notification_count"></span>
    </button>
    <div class="dropdown-menu dropdown-menu-right"
         aria-labelledby="dropdownMenu2">
        <h6 class="dropdown-header">
            Notification
        </h6>
        <div class="dropdown-divider"></div>
        <div class="pre-scrollable" id="not_container"></div>
    </div>
</div>
