<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 5/11/2019+
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html dir="ltr">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ITS</title>
    <base href="/ITS/" target="_blank">
    <link rel="shortcut icon" href="photos/favicon.ico" type="image/x-icon">
    <link rel="icon" href="photos/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/all.min.css"/>
    <link rel="stylesheet" href="css/line-awesome.min.css"/>
    <link rel="stylesheet" href="css/Exo.css"/>
    <link rel="stylesheet" href="css/datepicker.min.css"/>
    <link rel="stylesheet" href="css/customCheckbox.css"/>
    <link rel="stylesheet" href="css/toastr.css"/>
    <link rel="stylesheet" href="css/google_chart_tooltip.css"/>
    <link rel="stylesheet" href="css/google_chart_util.css"/>
    <link rel="stylesheet" href="css/floating-labels.css"/>
    <link rel="stylesheet" href="css/custom.css"/>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/loader.js"></script>
    <script src="js/update_tab_padeg.js"></script>
    <script src="js/ticket_tab_content.js"></script>
</head>
<body>
<jsp:include page="navbar.jsp"/>


<div class="container-fluid mt-4 pt-5">
    <div class="row">
        <nav class="col-2 d-none d-block bg-light sidebar sidebar-sticky no-print ">

            <div class="nav flex-column mt-4 nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                <a class="nav-link font-weight-bold mr-1 active" id="dashboard" data-toggle="pill" role="tab"
                   aria-selected="false"><i class="fas fa-home"></i> Dashboard</a>
                <c:if test="${P_10}">
                    <a class="nav-link font-weight-bold mr-1" id="new_ticket" data-toggle="pill" role="tab"
                       aria-selected="false"><i class="far fa-clipboard"></i> New Ticket</a>
                </c:if>
                <a class="nav-link font-weight-bold mr-1" id="my_ticket" data-toggle="pill" role="tab"
                   aria-selected="false"><i class="fas fa-ticket-alt"></i> My Tickets</a>
                <c:if test="${P_5}">
                    <a class="nav-link font-weight-bold mr-1" id="devices" data-toggle="pill" role="tab"
                       aria-selected="false"><i class="fas fa-desktop"></i> Devices</a>
                </c:if>
                <c:if test="${P_13}">
                    <a class="nav-link font-weight-bold mr-1" id="users" data-toggle="pill" role="tab"
                       aria-selected="false"><i class="fas fa-users"></i> Users</a>
                </c:if>
                <c:if test="${P_17}">
                    <a class="nav-link font-weight-bold mr-1" id="employees" data-toggle="pill" role="tab"
                       aria-selected="false"><i class="fas fa-users"></i> Employees</a>
                </c:if>
                <c:if test="${current_user.role.id == 6}">
                    <a class="nav-link font-weight-bold mr-1" id="Privileges" data-toggle="pill" role="tab"
                       aria-selected="false"><i class="fas fa-shield-alt"></i> <i class="fad fa-arrow-alt-right"></i> Privileges</a>
                </c:if>
                <%-- <a class="nav-link font-weight-bold" id="waiting_list" data-toggle="pill" role="tab"
                    aria-selected="false"><i class="far fa-clipboard"></i> Waiting List</a>--%>
            </div>
        </nav>
        <div class="col-10">

            <div id="content_place" class="mx-3 no-margin-print pt-2">
                <jsp:include page="dashboard_details.jsp"/>
            </div>
        </div>
    </div>
</div>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/datepicker.js"></script>
<script src="js/datepicker.en.js"></script>
<script src="js/toastr.js"></script>
<script src="js/toastr_functions.js"></script>
<script src="js/printThis.js"></script>
<script src="js/bootbox.all.min.js"></script>
<script src="js/timeout_session.js"></script>
<script src="js/filterTable.js"></script>
<script src="js/sortTable.js"></script>
<script src="js/changePassword.js"></script>
<script src="js/modals.js"></script>
<script src="js/google_chart_timeline.js"></script>
<script src="js/saveDevices.js"></script>
<script src="js/dashboard.js"></script>


</body>
</html>


