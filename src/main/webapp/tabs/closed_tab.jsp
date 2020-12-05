<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 2/20/2020
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="card card-outline-closed height-200 scroll">
    <div class="card-body">
        <h5 class="card-title">Closed</h5>
        <c:if test="${fn:length(ticketsClosedList) > 0}">
            <c:forEach items="${ticketsClosedList}" var="ticketsClosed">
                <button type="button" class="btn btn-outline-closed ticket mt-1"
                        ticket-id="${ticketsClosed.id}">Ticket ID ${ticketsClosed.id}</button>
            </c:forEach>
        </c:if>
    </div>
</div>
