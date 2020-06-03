<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 5/30/2020
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="date" value="${now}" pattern="dd-MM-yyyy" />
<div id="section-to-print" class="mx-auto mt-3 no-margin-print printable">
    <card class="card" style="border:black solid 1px;">
        <div class="card-body">
            <div class="row">
                <div class="col-1 d-none d-print-none">
                    <i class="fas fa-2x fa-print"></i>
                </div>

                <div class="mr-auto ml-3">
                    <img src="photos/sescotranspng-160.png" width="160" height="59" alt="">
                </div>
                <div class="ml-auto mr-3">
                    <img src="photos/TS.PNG" width="160" height="59" alt="">
                </div>
            </div>

            <div class="row my-3">

                <div class="col mx-auto">
                    <h1 class="display-5 text-center">Weekly Report</h1>
                </div>
            </div>
            <div class="row">
                <div class="float-left">
                    <table class="table table-sm table-borderless" style="width:200px;">
                        <tr>
                            <th>Region</th>
                            <td>${region.region}</td>
                        </tr>
                        <tr>
                            <th>Date</th>
                            <td>${date}</td>
                        </tr>
                    </table>
                </div>

            </div>
            <div class="row mt-2">
                <div class="col">
                    <table class="table table-bordered table-sm table-striped">
                        <thead>
                        <tr class="bg-lightGray">
                            <th>#</th>
                            <th>Status</th>
                            <th>User</th>
                            <th>Device</th>
                            <th>Device Type</th>
                            <th>TS Engineer</th>
                            <th>Comments / Steps / Reasons</th>
                            <th>Date</th>
                            <th>Time</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach varStatus="loop" var="ticket" items="${ticketList}">
                            <tr>
                                <td>${loop.count}</td>

                                <td>${ticket.currentStatus.status}</td>
                                <td>${ticket.reporterName}</td>
                                <td>${ticket.device.locationDepartment.location.region.abbreviation}-${ticket.device.locationDepartment.location.abbreviation}-${ticket.device.locationDepartment.department.abbreviation}-${ticket.device.deviceType.abbreviation}-<fmt:formatNumber
                                        type="number" minIntegerDigits="3" value="${ticket.device.deviceNumCode}"/></td>
                                <td>${ticket.device.deviceType.deviceType}</td>

                                <c:forEach var="ticketStatus" items="${ticketStatusList}">
                                    <c:if test="${ticketStatus.ticket.id == ticket.id}">
                                        <c:choose>
                                            <c:when test="${ticket.currentStatus.id == 5}">
                                                <td>${ticket.solvedBy.name}</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td>${ticketStatus.TSUser.name}</td>
                                            </c:otherwise>
                                        </c:choose>
                                        <td>${ticketStatus.reason}</td>
                                        <td>${ticketStatus.date}</td>
                                        <td>${ticketStatus.time}</td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </card>
</div>
