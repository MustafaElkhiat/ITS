<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 12/26/2019
  Time: 1:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="nav nav-tabs" id="myTab" role="tablist">
    <li class="nav-item">
        <a class="nav-link bg-primary red-active" id="assign-to-tab" data-toggle="tab" href="#assign-to" role="tab"
           aria-controls="home" aria-selected="true">Assigned To <span id="assign-to-badge" class="badge badge-light"></span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link bg-warning red-active" id="in-progress-tab" data-toggle="tab" href="#in-progress" role="tab"
           aria-controls="profile" aria-selected="false">In Progress <span id="in-progress-badge" class="badge badge-light"></span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link bg-secondary red-active" id="pending-tab" data-toggle="tab" href="#pending" role="tab"
           aria-controls="contact" aria-selected="false">Pending <span id="pending-badge" class="badge badge-light"></span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link bg-success red-active" id="solved-tab" data-toggle="tab" href="#solved" role="tab" aria-controls="contact"
           aria-selected="false">Solved <span id="solved-badge" class="badge badge-light"></span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link bg-danger red-active" id="need-to-solve-tab" data-toggle="tab" href="#need-to-solve" role="tab" aria-controls="contact"
           aria-selected="false">Need To Solve <span id="need-to-solve-badge" class="badge badge-light"></span></a>
    </li>
</ul>
