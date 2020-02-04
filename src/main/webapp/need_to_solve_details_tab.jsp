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
<c:set var="count" value="1"/>
<div class="card card-outline-danger scroll">
    <div class="card-body">
        <h5 class="card-title">Need To Solve</h5>
        <c:if test="${fn:length(ticketsAssignedToList) > 0}">
            <jsp:include page="search_field.jsp">
                <jsp:param name="id" value="search_need_to_solve"/>
            </jsp:include>
            <table id="need_to_solve_table" class="table table-striped table-bordered">
                <thead>
                <tr class="table-bordered bg-lightGray">
                    <th>#<i class="fas float-left my-2"></i></th>
                    <th>Ticket ID<i class="fas float-left my-2"></i></th>
                    <th>Device<i class="fas float-left my-2"></i></th>
                    <th>Problem<i class="fas float-left my-2"></i></th>
                    <th>Category<i class="fas float-left my-2"></i></th>
                    <th>Sub-Category<i class="fas float-left my-2"></i></th>
                    <th>Assigned By<i class="fas float-left my-2"></i></th>
                </tr>
                </thead>
                <tbody id="need_to_solve_table_body">
                <c:forEach items="${ticketsAssignedToList}" var="ticketsAssignedTo">
                    <tr class="ticket link" ticket-id="${ticketsAssignedTo.ticket.id}">
                        <td>${count}</td>
                        <td>${ticketsAssignedTo.ticket.id}</td>
                        <td>${ticketsAssignedTo.ticket.device.locationDepartment.location.region.abbreviation}-${ticketsAssignedTo.ticket.device.locationDepartment.location.abbreviation}-${ticketsAssignedTo.ticket.device.locationDepartment.department.abbreviation}-${ticketsAssignedTo.ticket.device.deviceType.abbreviation}-${ticketsAssignedTo.ticket.device.device}</td>
                        <td>${ticketsAssignedTo.ticket.problem}</td>
                        <td>${ticketsAssignedTo.ticket.subCategory.category.category}</td>
                        <td>${ticketsAssignedTo.ticket.subCategory.sub_category}</td>
                        <td>${ticketsAssignedTo.assignedBy.name}</td>
                    </tr>
                    <c:set var="count" value="${count+1}"/>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</div>
