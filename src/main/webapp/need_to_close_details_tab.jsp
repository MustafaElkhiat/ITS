<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 3/4/2020
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="card card-outline-info">
    <div class="card-body">
        <h5 class="card-title">Need To Close</h5>
        <c:if test="${fn:length(ticketsSolvedList) > 0}">
            <jsp:include page="search_field.jsp">
                <jsp:param name="id" value="search_need_to_close"/>
            </jsp:include>
            <div class="scroll devices_tab_table">
                <table id="need_to_close_table" class="table table-striped table-bordered">
                    <thead>
                    <tr class="table-bordered bg-lightGray">
                        <th>#<i class="fas float-left my-2"></i></th>
                        <th>Ticket ID<i class="fas float-left my-2"></i></th>
                        <th>Device<i class="fas float-left my-2"></i></th>
                        <th>Problem<i class="fas float-left my-2"></i></th>
                        <th>Category<i class="fas float-left my-2"></i></th>
                        <th>Sub-Category<i class="fas float-left my-2"></i></th>
                        <th>Engineer<i class="fas float-left my-2"></i></th>
                    </tr>
                    </thead>
                    <tbody id="need_to_close_table_body">
                    <c:forEach items="${ticketsSolvedList}" var="ticketsSolved" varStatus="loop">
                        <tr class="ticket link ticket_edit" ticket-id="${ticketsSolved.ticket.id}">
                            <td>${loop.count}</td>
                            <td>${ticketsSolved.ticket.id}</td>
                            <td>${ticketsSolved.ticket.device.locationDepartment.location.region.abbreviation}-${ticketsSolved.ticket.device.locationDepartment.location.abbreviation}-${ticketsSolved.ticket.device.locationDepartment.department.abbreviation}-${ticketsSolved.ticket.device.deviceType.abbreviation}-<fmt:formatNumber
                                    type="number" minIntegerDigits="3" value="${ticketsSolved.ticket.device.deviceNumCode}"/></td>
                            <td>${ticketsSolved.ticket.problem}</td>
                            <td>${ticketsSolved.ticket.subCategory.category.category}</td>
                            <td>${ticketsSolved.ticket.subCategory.sub_category}</td>
                            <td>${ticketsSolved.TSUser.name}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>
