<%--
  Created by IntelliJ IDEA.
  User: Eng. Mustafa Elkhiat
  Date: 4/1/21
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set value="" var="current_status_bg"/>
<jsp:include page="../page_header.jsp">
    <jsp:param name="title" value="My Tickets"/>
</jsp:include>
<div class="card card-outline-primary">
    <div class="card-body">
        <c:if test="${fn:length(employeeTickets) > 0}">
            <jsp:include page="../search_field.jsp">
                <jsp:param name="id" value="search_employee_ticket"/>
            </jsp:include>
            <div class="scroll employee_ticket_table">
                <table id="assign_to_table" class="table table-striped table-bordered">
                    <thead>
                    <tr class="table-bordered bg-lightGray">
                        <th>#<i class="fas float-right"></i></th>
                        <th>Current Status<i class="fas float-right"></i></th>
                        <th>Ticket ID<i class="fas float-right"></i></th>
                        <th>Device<i class="fas float-right"></i></th>
                        <th>Problem<i class="fas float-right"></i></th>
                    </tr>
                    </thead>
                    <tbody id="employee_ticket_table_body">

                        <c:forEach items="${employeeTickets}" var="employeeTicket" varStatus="loop">
                            <c:choose>
                                <c:when test="${employeeTicket.currentStatus.id == 1}">
                                    <c:set value="bg-primary" var="current_status_bg"/>
                                </c:when>
                                <c:when test="${employeeTicket.currentStatus.id == 2}">
                                    <c:set value="bg-warning" var="current_status_bg"/>
                                </c:when>
                                <c:when test="${employeeTicket.currentStatus.id == 3}">
                                    <c:set value="bg-secondary" var="current_status_bg"/>
                                </c:when>
                                <c:when test="${employeeTicket.currentStatus.id == 4}">
                                    <c:set value="bg-success" var="current_status_bg"/>
                                </c:when>
                                <c:when test="${employeeTicket.currentStatus.id == 5}">
                                    <c:set value="bg-closed" var="current_status_bg"/>
                                </c:when>

                            </c:choose>
                            <tr class="ticket link" ticket-id="${employeeTicket.id}">
                                <td>${loop.count}</td>
                                <td class="${current_status_bg} text-white">
                                    <c:forEach items="${ticketStatusList}" var="ticketStatus">
                                        <c:if test="${ticketStatus.ticket.id == employeeTicket.id}">
                                            <c:choose>
                                                <c:when test="${ticketStatus.status.id == 1 && employeeTicket.l1_user.id == user.id}">
                                                    Opened
                                                </c:when>
                                                <c:otherwise>
                                                    ${ticketStatus.status.status}
                                                </c:otherwise>
                                            </c:choose>

                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>${employeeTicket.id}</td>
                                <td>${employeeTicket.device.locationDepartment.location.region.abbreviation}-${employeeTicket.device.locationDepartment.location.abbreviation}-${employeeTicket.device.locationDepartment.department.abbreviation}-${employeeTicket.device.deviceType.abbreviation}-<fmt:formatNumber
                                        type="number" minIntegerDigits="3"
                                        value="${employeeTicket.device.deviceNumCode}"/></td>
                                <td>${employeeTicket.problem}</td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>
<script>
    ticket_click();
    $("#search_employee_ticket").searchTable("employee_ticket_table_body");
    $("#employee_ticket_table").sortTableNow();
</script>