<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 12/5/2020
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set value="1" var="count"/>
<c:set value="" var="current_status_bg"/>
<jsp:include page="../page_header.jsp">
    <jsp:param name="title" value="Opened Ticket"/>
</jsp:include>
<div class="card">
    <div class="card-body">
        <%--<h5 class="card-title">Opened Tickets</h5>--%>
        <c:if test="${fn:length(openedTicketsList) > 0}">
            <jsp:include page="../search_field.jsp">
                <jsp:param name="id" value="search_opened"/>
            </jsp:include>
            <div class="scroll tables_height">
                <table id="opened_table" class="table table-striped table-bordered" style="width:2000px;">
                    <thead>
                    <tr class="table-bordered bg-lightGray">
                        <th>#<i class="fas float-right"></i></th>
                        <th>Current Status<i class="fas float-right"></i></th>
                        <th>Ticket ID<i class="fas float-right"></i></th>
                        <th>Device<i class="fas float-right"></i></th>
                        <th>Problem<i class="fas float-right"></i></th>
                        <th>Category<i class="fas float-right"></i></th>
                        <th>Sub-Category<i class="fas float-right"></i></th>
                        <th>TS Engineer<i class="fas float-right"></i></th>
                        <th>Region<i class="fas float-right"></i></th>
                    </tr>
                    </thead>
                    <tbody id="opened_table_body">
                    <c:forEach items="${openedTicketsList}" var="ticket">
                        <c:choose>
                            <c:when test="${ticket.currentStatus.id == 1}">
                                <c:set value="bg-primary" var="current_status_bg"/>
                            </c:when>
                            <c:when test="${ticket.currentStatus.id == 2}">
                                <c:set value="bg-warning" var="current_status_bg"/>
                            </c:when>
                            <c:when test="${ticket.currentStatus.id == 3}">
                                <c:set value="bg-secondary" var="current_status_bg"/>
                            </c:when>
                            <c:when test="${ticket.currentStatus.id == 4}">
                                <c:set value="bg-success" var="current_status_bg"/>
                            </c:when>
                            <c:when test="${ticket.currentStatus.id == 5}">
                                <c:set value="bg-closed" var="current_status_bg"/>
                            </c:when>

                        </c:choose>


                        <tr class="ticket link ticket_edit" ticket-id="${ticket.id}">
                            <td>${count}</td>
                            <td class="${current_status_bg} text-white">${ticket.currentStatus.status}</td>
                            <td>${ticket.id}</td>
                            <td>${ticket.device.locationDepartment.location.region.abbreviation}-${ticket.device.locationDepartment.location.abbreviation}-${ticket.device.locationDepartment.department.abbreviation}-${ticket.device.deviceType.abbreviation}-<fmt:formatNumber
                                    type="number" minIntegerDigits="3"
                                    value="${ticket.device.deviceNumCode}"/></td>
                            <td>${ticket.problem}</td>
                            <td>${ticket.subCategory.category.category}</td>
                            <td>${ticket.subCategory.sub_category}</td>
                            <td><c:forEach items="${openedTicketStatusList}" var="status">
                                <c:if test="${status.ticket.id == ticket.id}">
                                    ${status.TSUser.name}
                                </c:if>
                            </c:forEach></td>

                            <td>${ticket.device.locationDepartment.location.region.region}</td>
                        </tr>
                        <c:set var="count" value="${count+1}"/>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>

