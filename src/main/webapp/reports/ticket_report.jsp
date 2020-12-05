<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 12/18/2019
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../page_header.jsp">
    <jsp:param name="title" value="Ticket ID : ${ticket.id}"/>
</jsp:include>
<input type="hidden" id="device_" value="${ticket.device.id}">
<input type="hidden" id="ticket" value="${ticket.id}"/>
<div class="card mt-3">
    <div class="card-body">
        <jsp:include page="../new_ticket/ticket_timeline.jsp"/>
        <div class="row">

            <div id="device_info" class="col-lg-6 col-sm-12 my-auto">
                <jsp:include page="../new_ticket/device_info.jsp"/>
            </div>
            <div class="col-lg-6 col-sm-12 my-lg-auto mt-sm-2">
                <jsp:include page="../new_ticket/status_info.jsp"/>
                <jsp:include page="../new_ticket/caller_info.jsp"/>

            </div>
        </div>
        <div class="row">
            <div class="col">
                <jsp:include page="../new_ticket/problem_comment_info.jsp"/>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <jsp:include page="all_ticket_status.jsp"/>
            </div>
        </div>

    </div>
</div>
<script>

    google.charts.load("current", {packages: ["timeline"]});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        var container = document.getElementById('timeline');
        var chart = new google.visualization.Timeline(container);
        var dataTable = new google.visualization.DataTable();
        dataTable.addColumn({type: 'string', id: 'ticket_id'});
        dataTable.addColumn({type: 'string', id: 'status'});
        dataTable.addColumn({type: 'date', id: 'Start'});
        dataTable.addColumn({type: 'date', id: 'End'});
        <c:forEach items="${ticketStatus}" var="ticket_status" >
        <c:if test="${!ticket_status.done}">
        dataTable.addRows([['Ticket ID ' +${ticket.id}, '${ticket_status.status.status}', new Date('${ticket_status.dateString} ${ticket_status.timeString}'), new Date()]]);
        </c:if>
        <c:if test="${ticket_status.done}">
        dataTable.addRows([['Ticket ID ' +${ticket.id}, '${ticket_status.status.status}', new Date('${ticket_status.dateString} ${ticket_status.timeString}'), new Date('${ticket_status.doneDateString} ${ticket_status.doneTimeString}')]]);
        </c:if>
        </c:forEach>


        var options = {
            timeline: {groupByRowLabel: true},
            colors: [
                <c:forEach items="${ticketStatus}" var="ticket_status" >
                <c:if test="${ticket_status.status.id == 1}">
                '#007bff',
                </c:if>
                <c:if test="${ticket_status.status.id == 2}">
                '#ffc107',
                </c:if>
                <c:if test="${ticket_status.status.id == 3}">
                '#6c757d',
                </c:if>
                <c:if test="${ticket_status.status.id == 4}">
                '#28a745',
                </c:if>
                <c:if test="${ticket_status.status.id == 5}">
                '#6E2571',
                </c:if>
                </c:forEach>
            ]
        };

        chart.draw(dataTable, options);
    }


</script>