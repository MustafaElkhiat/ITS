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
<div class="card card-outline-warning height-200 scroll">
    <div class="card-body">
        <h5 class="card-title">In Progress</h5>
        <c:if test="${fn:length(ticketsInProgressList) > 0}">
            <c:forEach items="${ticketsInProgressList}" var="ticketsInProgress">
                <button type="button" class="btn btn-outline-warning ticket_edit mt-1"
                        ticket-id="${ticketsInProgress.ticket.id}">Ticket ID ${ticketsInProgress.ticket.id}</button>
            </c:forEach>
        </c:if>
    </div>
</div>
