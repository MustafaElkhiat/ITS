<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 12/19/2019
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="card ${status}">
    <div class="card-body">
        <div class="row">
            <div class="col">
                <h5>${ticket.currentStatus.status}
                    <c:if test="${ticket.currentStatus.id == 1}">
                        <c:forEach items="${ticketAssignedToList}" var="ticketAssignedTo">
                            ${ticketAssignedTo.assignedTo.name} By ${ticketAssignedTo.assignedBy.name}
                        </c:forEach>
                    </c:if>
                    <c:if test="${ticket.currentStatus.id != 1}">
                        <c:forEach items="${ticketStatusList}" var="ticketStatus">
                            By ${ticketStatus.TSUser.name}
                        </c:forEach>
                    </c:if>
                </h5>
            </div>
        </div>
        <c:if test="${ticket.currentStatus.id != 1}">
            <div class="row">
                <div class="col">
                    <c:forEach items="${ticketStatusList}" var="ticketStatus">
                        ${ticketStatus.reason}
                    </c:forEach>

                </div>
            </div>
        </c:if>

    </div>
</div>