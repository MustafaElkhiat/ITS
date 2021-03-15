<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/5/2019
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="card mt-2">
    <div class="card-body">
        <h5 class="card-title pb-1">Caller Info.</h5>
        <table class="table table-bordered table-striped table my-4" width="100%">
            <tbody>
            <tr>
                <th>Caller Name</th>
                <td>${ticket.reporterName}</td>
            </tr>
            <tr>
                <th>Caller Number</th>
                <td>${ticket.reporterNum}</td>
            </tr>

            </tbody>
        </table>
    </div>
</div>
