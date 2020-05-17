<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 2/22/2020
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="card card-outline-closed">
    <div class="card-body">
        <h5 class="card-title">Closed</h5>
        <c:if test="${fn:length(ticketsClosedList) > 0}">
            <jsp:include page="search_field.jsp">
                <jsp:param name="id" value="search_closed"/>
            </jsp:include>
            <div class="scroll devices_tab_table">
                <table id="closed_table" class="table table-striped table-bordered">
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
                    <tbody id="closed_table_body">
                    <c:forEach items="${ticketsClosedList}" var="ticketsClosed" varStatus="loop">
                        <tr class="ticket link-success" ticket-id="${ticketsClosed.id}">
                            <td>${loop.count}</td>
                            <td>${ticketsClosed.id}</td>
                            <td>${ticketsClosed.device.locationDepartment.location.region.abbreviation}-${ticketsClosed.device.locationDepartment.location.abbreviation}-${ticketsClosed.device.locationDepartment.department.abbreviation}-${ticketsClosed.device.deviceType.abbreviation}-${ticketsClosed.device.device}</td>
                            <td>${ticketsClosed.problem}</td>
                            <td>${ticketsClosed.subCategory.category.category}</td>
                            <td>${ticketsClosed.subCategory.sub_category}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>
