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
<c:set var="ticket_action" value="ticket"/>
<c:choose>
    <c:when test="${user.role.id == 3}">
        <c:set var="ticket_action" value="ticket_edit"/>
    </c:when>
    <c:otherwise>
        <c:set var="ticket_action" value="ticket"/>
    </c:otherwise>
</c:choose>
<div class="card card-outline-success height-200 scroll">
    <div class="card-body">
        <h5 class="card-title">Solved</h5>
        <c:if test="${fn:length(ticketsSolvedList) > 0}">
            <c:forEach items="${ticketsSolvedList}" var="ticketsSolved">
                <button type="button" class="btn btn-outline-success ${ticket_action} mt-1" ticket-id="${ticketsSolved.id}">Ticket
                    ID ${ticketsSolved.id}</button>
            </c:forEach>
        </c:if>
    </div>
</div>
