<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 12/21/2019
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set value="1" var="count"/>
<div class="card card-outline-warning">
    <div class="card-body">
        <h5 class="card-title">In Progress</h5>
        <c:if test="${fn:length(ticketsInProgressList) > 0}">
            <jsp:include page="../search_field.jsp">
                <jsp:param name="id" value="search_in_progress"/>
            </jsp:include>
            <div class="scroll devices_tab_table">
                <table id="in_progress_table" class="table table-striped table-bordered">
                    <thead>
                    <tr class="table-bordered bg-lightGray">
                        <th>#<i class="fas float-left my-2"></i></th>
                        <th>Ticket ID<i class="fas float-left my-2"></i></th>
                        <th>Device<i class="fas float-left my-2"></i></th>
                        <th>Problem<i class="fas float-left my-2"></i></th>
                        <th>Category<i class="fas float-left my-2"></i></th>
                        <th>Sub-Category<i class="fas float-left my-2"></i></th>

                    </tr>
                    </thead>
                    <tbody id="in_progress_table_body">
                    <c:forEach items="${ticketsInProgressList}" var="ticketsInProgress">
                        <tr class="link-warning ticket_edit" ticket-id="${ticketsInProgress.ticket.id}">
                            <td>${count}</td>
                            <td>${ticketsInProgress.ticket.id}</td>
                            <td>${ticketsInProgress.ticket.device.locationDepartment.location.region.abbreviation}-${ticketsInProgress.ticket.device.locationDepartment.location.abbreviation}-${ticketsInProgress.ticket.device.locationDepartment.department.abbreviation}-${ticketsInProgress.ticket.device.deviceType.abbreviation}-<fmt:formatNumber
                                    type="number" minIntegerDigits="3" value="${ticketsInProgress.ticket.device.deviceNumCode}"/></td>
                            <td>${ticketsInProgress.ticket.problem}</td>
                            <td>${ticketsInProgress.ticket.subCategory.category.category}</td>
                            <td>${ticketsInProgress.ticket.subCategory.sub_category}</td>

                        </tr>
                        <c:set var="count" value="${count+1}"/>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>
