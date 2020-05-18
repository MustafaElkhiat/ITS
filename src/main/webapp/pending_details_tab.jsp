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
<div class="card card-outline-secondary">
    <div class="card-body">
        <h5 class="card-title">Pending</h5>
        <c:if test="${fn:length(ticketsPendingList) > 0}">
            <jsp:include page="search_field.jsp">
                <jsp:param name="id" value="search_pending"/>
            </jsp:include>
            <div class="scroll devices_tab_table">
                <table id="pending_table" class="table table-striped table-bordered">
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
                    <tbody id="pending_table_body">
                    <c:forEach items="${ticketsPendingList}" var="ticketsPending">
                        <tr class="link-secondary ticket_edit" ticket-id="${ticketsPending.ticket.id}">
                            <td>${count}</td>
                            <td>${ticketsPending.ticket.id}</td>
                            <td>${ticketsPending.ticket.device.locationDepartment.location.region.abbreviation}-${ticketsPending.ticket.device.locationDepartment.location.abbreviation}-${ticketsPending.ticket.device.locationDepartment.department.abbreviation}-${ticketsPending.ticket.device.deviceType.abbreviation}-<fmt:formatNumber
                                    type="number" minIntegerDigits="3" value="${ticketsClosed.device.deviceNumCode}"/></td>
                            <td>${ticketsPending.ticket.problem}</td>
                            <td>${ticketsPending.ticket.subCategory.category.category}</td>
                            <td>${ticketsPending.ticket.subCategory.sub_category}</td>

                        </tr>
                        <c:set var="count" value="${count+1}"/>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>
