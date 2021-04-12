<%@ page import="login.elements.User" %>
<%@ page import="elements.TSUserRegion" %>
<%@ page import="helpers.HibernateHelper" %>
<%@ page import="java.util.List" %><%--<%@ page import="helpers.HibernateHelper" %>
<%@ page import="elements.User" %>
<%--
  Created by IntelliJ IDEA.
  User: mustafa
  Date: 1/5/2019
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<input type="hidden" id="current_user" value="${current_user.id}"/>
<nav class="navbar navbar-expand-md fixed-top navbar-dark bg-dark">


    <img src="photos/New%20Logo/sescotrans_logo.png" width="160" height="59" alt="" class="ml-3">
    <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <c:if test="${not empty param.name}">
            <div class="form-inline ml-auto my-2 my-lg-0">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item text-white mr-2 table-style"><i class="mr-2 fas fa-2x fa-user-tie"></i> <span
                            class="my-auto table-cell-style pr-2 font-weight-bold">${param.name}</span></li>
                </ul>

            </div>
        </c:if>
        <c:if test="${not empty param.region}">
            <div class="form-inline ml-auto my-2 my-lg-0">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item text-white mr-2 table-style"><i
                            class="mr-2 fas fa-2x fa-map-marker-alt"></i><span
                            class="my-auto table-cell-style pr-2 font-weight-bold">${param.region}</span></li>
                </ul>

            </div>
        </c:if>
        <%--<div class="ml-auto mr-2">
            <jsp:include page="notification_section.jsp"/>
        </div>--%>
        <div class="dropdown my-2 ml-auto my-lg-0">
            <button
                    class="btn btn-outline-primary dropdown-toggle my-2 my-sm-0 mr-2"
                    id="dropdownSettingsButton" type="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false"><i class="fas fa-cogs"></i>
                Settings
            </button>
            <div class="dropdown-menu dropdown-menu-right"
                 aria-labelledby="dropdownSettingsButton">
                <h6 class="dropdown-header">
                    Settings
                </h6>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item link_" data-toggle="modal"
                   data-target="#change_password_modal">Change Password</a>
            </div>
        </div>
        <form id="logout_form" class="form-inline my-2 my-lg-0" target="_self" action="" method="post">
            <input type="hidden" name="n" value="2">
            <button id="logout_btn" class="btn btn-outline-primary my-2 my-sm-0" style="width:120px" type="button"><i
                    class="fas fa-sign-out-alt"></i>
                Sign Out
            </button>
        </form>
    </div>
    <%--<div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Dropdown
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>--%>
</nav>


<!-- Modal Change Password -->
<div class="modal fade" id="change_password_modal" tabindex="-1"
     role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Change Password</h5>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form id="change_password_form" class="needs-validation" novalidate>
                <div class="modal-body">
                    <div class="form-group row m-2 form-label-group">

                        <input type="password" class="form-control" id="current_password"
                               name="current_password" placeholder="Current Password" required>
                        <label for="current_password">Current Password</label>

                    </div>
                    <div class="form-group row m-2 form-label-group">


                        <input type="password" class="form-control" id="new_password"
                               name="new_password" placeholder="New Password" required>
                        <label for="new_password">New Password</label>

                    </div>
                    <div class="form-group row m-2 form-label-group">

                        <input type="password" class="form-control" id="re_new_password"
                               name="re_new_password" placeholder="Confirm Password" required>
                        <label for="re_new_password">Confirm Password</label>
                    </div>
                </div>
                <div class="modal-footer">

                    <button type="button" class="btn btn-primary"
                            id="change_password_button"
                            onclick="changePassword();">Submit
                    </button>
                    <button type="button" class="btn btn-secondary mx-2"
                            data-dismiss="modal">Cancel
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- End of Modal -->