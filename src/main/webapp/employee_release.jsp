<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 5/14/2020
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="page_header.jsp">
    <jsp:param name="title" value="Release Employee"/>
</jsp:include>
<div id="section-to-print" class="mx-auto mt-3 no-margin-print printable">
    <card class="card A4" style="border:black solid 1px;">
        <div class="card-body">
            <div class="row">
                <div class="col-1 d-none d-print-none">
                    <i class="fas fa-2x fa-print"></i>
                </div>

                <div class="mr-auto ml-3">
                    <img src="photos/New%20Logo/sescotrans_logo.png" width="160" height="59" alt="">
                </div>
                <div class="ml-auto mr-3">
                    <img src="photos/TS.PNG" width="160" height="59" alt="">
                </div>
            </div>

            <div class="row my-3">

                <div class="offset-4">
                    <h1 class="display-5 text-center ">Employee Release</h1>
                </div>
            </div>
            <div class="checkbox-wrap">
                <label class="title">Employee Info.</label>
                <div class="row">
                    <div class="col">
                        <table class="table table-sm table-bordered">
                            <tr>
                                <th>Name</th>
                                <td>${employee.name}</td>
                                <th>Position</th>
                                <td>${employee.position}</td>
                                <th>Staff ID</th>
                                <td>${employee.staffID}</td>
                            </tr>
                            <tr>
                                <th>Region</th>
                                <td>${employee.locationDepartment.location.region.region}</td>
                                <th>Location</th>
                                <td>${employee.locationDepartment.location.location}</td>
                                <th>Department</th>
                                <td>${employee.locationDepartment.department.department}</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <c:if test="${fn:length(pcList) > 0}">
                <div class="checkbox-wrap">
                    <label class="title">PCs</label>
                    <div class="row">
                        <div class="col">
                            <table class="table table-sm table-bordered">
                                <tr>
                                    <th>#</th>
                                    <th>Device</th>
                                    <th>Vendor</th>
                                    <th>Model</th>
                                    <th>Serial Number</th>
                                </tr>
                                <c:forEach items="${pcList}" var="pc" varStatus="loop">
                                    <tr>
                                        <td>${loop.count}</td>
                                        <td>${pc.locationDepartment.location.region.abbreviation}-${pc.locationDepartment.location.abbreviation}-${pc.locationDepartment.department.abbreviation}-${pc.deviceType.abbreviation}-<fmt:formatNumber
                                                type="number" minIntegerDigits="3" value="${pc.deviceNumCode}"/></td>
                                        <td>${pc.vendor}</td>
                                        <td>${pc.model}</td>
                                        <td>${pc.serialNum}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${fn:length(printerList) > 0}">
                <div class="checkbox-wrap">
                    <label class="title">Printers</label>
                    <div class="row">
                        <div class="col">
                            <table class="table table-sm table-bordered">
                                <tr>
                                    <th>#</th>
                                    <th>Device</th>
                                    <th>Vendor</th>
                                    <th>Model</th>
                                    <th>Serial Number</th>
                                </tr>
                                <c:forEach items="${printerList}" var="printer" varStatus="loop">
                                    <tr>
                                        <td>${loop.count}</td>
                                        <td>${printer.locationDepartment.location.region.abbreviation}-${printer.locationDepartment.location.abbreviation}-${printer.locationDepartment.department.abbreviation}-${printer.deviceType.abbreviation}-<fmt:formatNumber
                                                type="number" minIntegerDigits="3"
                                                value="${printer.deviceNumCode}"/></td>
                                        <td>${printer.vendor}</td>
                                        <td>${printer.model}</td>
                                        <td>${printer.serialNum}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </c:if>

            <c:if test="${fn:length(IPPhoneList) > 0}">
                <div class="checkbox-wrap">
                    <label class="title">IP Phones</label>
                    <div class="row">
                        <div class="col">
                            <table class="table table-sm table-bordered">
                                <tr>
                                    <th>#</th>
                                    <th>Device</th>
                                    <th>Vendor</th>
                                    <th>Model</th>
                                    <th>Serial Number</th>
                                </tr>
                                <c:forEach items="${IPPhoneList}" var="IPPhone" varStatus="loop">
                                    <tr>
                                        <td>${loop.count}</td>
                                        <td>${IPPhone.locationDepartment.location.region.abbreviation}-${IPPhone.locationDepartment.location.abbreviation}-${IPPhone.locationDepartment.department.abbreviation}-${IPPhone.deviceType.abbreviation}-<fmt:formatNumber
                                                type="number" minIntegerDigits="3"
                                                value="${IPPhone.deviceNumCode}"/></td>
                                        <td>${IPPhone.vendor}</td>
                                        <td>${IPPhone.model}</td>
                                        <td>${IPPhone.serialNum}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${fn:length(mobileList) > 0}">
                <div class="checkbox-wrap">
                    <label class="title">Mobiles</label>
                    <div class="row">
                        <div class="col">
                            <table class="table table-sm table-bordered">
                                <tr>
                                    <th>#</th>
                                    <th>Device</th>
                                    <th>Vendor</th>
                                    <th>Model</th>
                                    <th>Serial Number</th>
                                </tr>
                                <c:forEach items="${mobileList}" var="mobile" varStatus="loop">
                                    <tr>
                                        <td>${loop.count}</td>
                                        <td>${mobile.locationDepartment.location.region.abbreviation}-${mobile.locationDepartment.location.abbreviation}-${mobile.locationDepartment.department.abbreviation}-${mobile.deviceType.abbreviation}-<fmt:formatNumber
                                                type="number" minIntegerDigits="3"
                                                value="${mobile.deviceNumCode}"/></td>
                                        <td>${mobile.vendor}</td>
                                        <td>${mobile.model}</td>
                                        <td>${mobile.serialNum}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${fn:length(employeeAccessoryList) > 0}">
                <div class="checkbox-wrap">
                    <label class="title">Accessories</label>
                    <div class="row">
                        <div class="col">
                            <table class="table table-sm table-bordered">
                                <tr>
                                    <th>#</th>
                                    <th>Accessory</th>
                                    <th>Vendor</th>
                                    <th>Phone Number</th>
                                    <th>Serial Number</th>
                                </tr>
                                <c:forEach items="${employeeAccessoryList}" var="employeeAccessory" varStatus="loop">
                                    <tr>
                                        <td>${loop.count}</td>
                                        <td>${employeeAccessory.accessory.accessory}</td>
                                        <td>${employeeAccessory.vendor}</td>
                                        <td>${employeeAccessory.phoneNumber}</td>
                                        <td>${employeeAccessory.serialNumber}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${fn:length(employeeAccountList) > 0}">
                <div class="checkbox-wrap">
                    <label class="title">Accounts</label>
                    <div class="row">
                        <div class="col">
                            <table class="table table-sm table-bordered">
                                <tr>
                                    <th>#</th>
                                    <th>Account</th>
                                    <th>Username</th>

                                </tr>
                                <c:forEach items="${employeeAccountList}" var="employeeAccount" varStatus="loop">
                                    <tr>
                                        <td>${loop.count}</td>
                                        <td>${employeeAccount.account.account}</td>
                                        <td>${employeeAccount.username}</td>

                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
        <div class="card-footer mb-5">
            Head Of Sector
        </div>
    </card>
</div>
