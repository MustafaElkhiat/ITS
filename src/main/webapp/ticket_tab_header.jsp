<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 12/26/2019
  Time: 1:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="nav nav-tabs ${param.style}" id="myTab" role="tablist">
    <li class="nav-item">
        <a class="nav-link bg-primary red-active" id="${param.user}-assign-to-tab" data-toggle="tab" href="#${param.user}-assign-to" role="tab"
           aria-controls="home" aria-selected="true">Assigned To <span id="${param.user}-assign-to-badge" class="badge badge-light"></span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link bg-warning red-active" id="${param.user}-in-progress-tab" data-toggle="tab" href="#${param.user}-in-progress" role="tab"
           aria-controls="profile" aria-selected="false">In Progress <span id="${param.user}-in-progress-badge" class="badge badge-light"></span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link bg-secondary red-active" id="${param.user}-pending-tab" data-toggle="tab" href="#${param.user}-pending" role="tab"
           aria-controls="contact" aria-selected="false">Pending <span id="${param.user}-pending-badge" class="badge badge-light"></span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link bg-success red-active" id="${param.user}-solved-tab" data-toggle="tab" href="#${param.user}-solved" role="tab" aria-controls="contact"
           aria-selected="false">Solved <span id="${param.user}-solved-badge" class="badge badge-light"></span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link bg-danger red-active" id="${param.user}-need-to-solve-tab" data-toggle="tab" href="#${param.user}-need-to-solve" role="tab" aria-controls="contact"
           aria-selected="false">Need To Solve <span id="${param.user}-need-to-solve-badge" class="badge badge-light"></span></a>
    </li>
</ul>
