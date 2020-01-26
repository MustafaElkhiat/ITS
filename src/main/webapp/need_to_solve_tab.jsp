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
<div class="card card-outline-danger height-200 scroll">
    <div class="card-body">
        <h5 class="card-title">Need To Solve</h5>
        <c:if test="${fn:length(ticketsAssignedToList) > 0}">
            <c:forEach items="${ticketsAssignedToList}" var="ticketsAssignedTo">
                <button type="button" class="btn btn-outline-danger ticket_edit mt-1"
                        ticket-id="${ticketsAssignedTo.ticket.id}">Ticket ID ${ticketsAssignedTo.ticket.id}</button>
            </c:forEach>
        </c:if>
    </div>
</div>
