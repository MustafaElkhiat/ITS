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
    <title>ITS - Dashboard</title>

    <link rel="shortcut icon" href="photos/New%20Logo/cropped-Untitled-1-1-32x32.png">
    <!--
    <link rel="shortcut icon" href="photos/favicon.ico" type="image/x-icon">
    <link rel="icon" href="photos/favicon.ico" type="image/x-icon">
    -->
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/all.min.css"/>
    <link rel="stylesheet" href="css/line-awesome.min.css"/>
    <link rel="stylesheet" href="css/Exo.css"/>
    <link rel="stylesheet" href="css/print.css"/>
    <link rel="stylesheet" href="css/datepicker.min.css"/>
    <link rel="stylesheet" href="css/customCheckbox.css"/>
    <link rel="stylesheet" href="css/toastr.css"/>
    <link rel="stylesheet" href="css/google_chart_tooltip.css"/>
    <link rel="stylesheet" href="css/google_chart_util.css"/>
    <link rel="stylesheet" href="css/floating-labels.css"/>
    <link rel="stylesheet" href="css/jquery.contextMenu.min.css"/>
    <link rel="stylesheet" href="css/paper.css"/>
    <link rel="stylesheet" href="css/preloader.css"/>
    <link rel="stylesheet" href="css/FAB.css"/>
    <link rel="stylesheet" href="css/custom.css"/>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/loader.js"></script>
    <script src="js/update_tab_padeg.js"></script>
    <script src="js/ticket_tab_content.js"></script>
</head>
<body>
<jsp:include page="navbar.jsp">
    <jsp:param name="name" value="${current_user.name}"/>
    <jsp:param name="region" value="${region}"/>
</jsp:include>


<div class="container-fluid mt-4 pt-5">
    <div class="row">
        <nav id="sidebar_menu" class="col-2 d-none d-block bg-light sidebar sidebar-sticky no-print ">

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
                       aria-selected="false"><i class="fas fa-shield-alt"></i> Privileges</a>
                    <a class="nav-link font-weight-bold mr-1" id="accessories" data-toggle="pill" role="tab"
                       aria-selected="false"><i class="fas fa-paperclip"></i> Accessories</a>
                    <a class="nav-link font-weight-bold mr-1" id="accounts" data-toggle="pill" role="tab"
                       aria-selected="false"><i class="fas fa-bullseye"></i> Accounts</a>
                    <a class="nav-link font-weight-bold mr-1" id="recoding_devices" data-toggle="pill" role="tab"
                       aria-selected="false"><i class="fas fa-laptop-code"></i> Recoding Devices</a>
                    <a class="nav-link font-weight-bold mr-1" id="employee_ticket" data-toggle="pill" role="tab"
                       aria-selected="false"><i class="fas fa-laptop-code"></i> Employee Ticket</a>
                </c:if>
                <c:if test="${current_user.role.id == 6 || current_user.role.id == 2 || current_user.role.id == 1}">
                    <a class="nav-link font-weight-bold mr-1" id="weekly" data-toggle="pill" role="tab"
                       aria-selected="false"><i class="fas fa-clipboard-list"></i> Weekly Report</a>
                    <a class="nav-link font-weight-bold mr-1" id="opened_tickets" data-toggle="pill" role="tab"
                       aria-selected="false"><i class="fas fa-clipboard-list"></i> Opened Tickets</a>
                </c:if>

                <%-- <a class="nav-link font-weight-bold" id="waiting_list" data-toggle="pill" role="tab"
                    aria-selected="false"><i class="far fa-clipboard"></i> Waiting List</a>--%>
            </div>
        </nav>
        <div class="col-10">

            <div id="content_place" class="mx-3 no-margin-print pt-2">
                <c:if test="${current_user.role.id != 9}">
                    <jsp:include page="dashboard_details.jsp"/>
                </c:if>

            </div>
        </div>
    </div>
    <div class="btn-group-fab" role="group" aria-label="FAB Menu">
        <div>
            <button id="fab_btn" type="button" class="btn btn-main btn-primary has-tooltip" data-placement="right" title="Hide Menu"><i
                    class="fa fa-bars"></i></button>

        </div>
    </div>
</div>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/datepicker.js"></script>
<script src="js/datepicker.en.js"></script>
<script src="js/toastr.js"></script>
<script src="js/toastr_functions.js"></script>
<script src="js/bootbox.all.min.js"></script>
<script src="js/print_div.js"></script>
<script src="js/print.js"></script>
<script src="js/jQuery.print.min.js"></script>
<script src="js/timeout_session.js"></script>
<script src="js/filterTable.js"></script>
<script src="js/sortTable.js"></script>
<script src="js/changePassword.js"></script>
<script src="js/modals.js"></script>
<script src="js/google_chart_timeline.js"></script>
<script src="js/saveDevices.js"></script>
<script src="js/drawRegionChart.js"></script>
<script src="js/drawTicketChart.js"></script>
<script src="js/drawDeviceChart.js"></script>
<script src="js/jquery.contextMenu.min.js"></script>
<script src="js/jquery.ui.position.min.js"></script>
<script src="js/navbarFunctions.js"></script>
<script src="js/dashboard.js"></script>


</body>
</html>


