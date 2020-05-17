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
<c:set value="1" var="count"/>
<div class="card card-outline-primary">
    <div class="card-body">
        <h5 class="card-title">Assigned To</h5>
        <c:if test="${fn:length(ticketsAssignedByList) > 0}">
            <jsp:include page="search_field.jsp">
                <jsp:param name="id" value="search_assign_to"/>
            </jsp:include>
            <div class="scroll devices_tab_table">
                <table id="assign_to_table" class="table table-striped table-bordered" style="width:1500px;">
                    <thead>
                    <tr class="table-bordered bg-lightGray">
                        <th>#<i class="fas float-left my-2"></i></th>
                        <th>Ticket ID<i class="fas float-left my-2"></i></th>
                        <th>Device<i class="fas float-left my-2"></i></th>
                        <th>Problem<i class="fas float-left my-2"></i></th>
                        <th>Category<i class="fas float-left my-2"></i></th>
                        <th>Sub-Category<i class="fas float-left my-2"></i></th>
                        <th>Assigned To<i class="fas float-left my-2"></i></th>
                        <th>Status<i class="fas float-left my-2"></i></th>
                    </tr>
                    </thead>
                    <tbody id="assign_to_table_body">
                    <c:forEach items="${ticketsAssignedByList}" var="ticketAssignedBy">
                        <tr class="ticket link" ticket-id="${ticketAssignedBy.ticket.id}">
                            <td>${count}</td>
                            <td>${ticketAssignedBy.ticket.id}</td>
                            <td>${ticketAssignedBy.ticket.device.locationDepartment.location.region.abbreviation}-${ticketAssignedBy.ticket.device.locationDepartment.location.abbreviation}-${ticketAssignedBy.ticket.device.locationDepartment.department.abbreviation}-${ticketAssignedBy.ticket.device.deviceType.abbreviation}-${ticketAssignedBy.ticket.device.device}</td>
                            <td>${ticketAssignedBy.ticket.problem}</td>
                            <td>${ticketAssignedBy.ticket.subCategory.category.category}</td>
                            <td>${ticketAssignedBy.ticket.subCategory.sub_category}</td>
                            <td>${ticketAssignedBy.assignedTo.name}</td>
                            <td>${ticketAssignedBy.ticket.currentStatus.status}</td>
                        </tr>
                        <c:set var="count" value="${count+1}"/>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>
