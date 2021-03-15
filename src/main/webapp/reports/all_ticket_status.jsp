<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 3/4/2020
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="card mt-3">
    <div class="card-body">
        <table class="table table-bordered table-striped table my-4" width="100%">
            <thead>
            <tr>
                <th>Status</th>
                <th>Comment</th>
                <th>TS Engineer</th>
                <th>Date</th>
                <th>Time</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${allTicketStatusList}" var="allTicketStatus">
                <tr>
                    <td>${allTicketStatus.status.status}</td>
                    <td>${allTicketStatus.reason}</td>
                    <td>${allTicketStatus.TSUser.name}</td>
                    <td>${allTicketStatus.date}</td>
                    <td>${allTicketStatus.time}</td>
                </tr>
            </c:forEach>


            </tbody>
        </table>
    </div>
</div>
