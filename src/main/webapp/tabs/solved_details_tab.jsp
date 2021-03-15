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
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set value="1" var="count"/>
<div class="card card-outline-success">
    <div class="card-body">
        <h5 class="card-title">Solved</h5>
        <c:if test="${fn:length(ticketsSolvedList) > 0}">
            <jsp:include page="../search_field.jsp">
                <jsp:param name="id" value="search_solved"/>
            </jsp:include>
            <div class="scroll devices_tab_table">
                <table id="solved_table" class="table table-striped table-bordered">
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
                    <tbody id="solved_table_body">
                    <c:forEach items="${ticketsSolvedList}" var="ticketsSolved">
                        <tr class="ticket link-success" ticket-id="${ticketsSolved.id}">
                            <td>${count}</td>
                            <td>${ticketsSolved.id}</td>
                            <td>${ticketsSolved.device.locationDepartment.location.region.abbreviation}-${ticketsSolved.device.locationDepartment.location.abbreviation}-${ticketsSolved.device.locationDepartment.department.abbreviation}-${ticketsSolved.device.deviceType.abbreviation}-<fmt:formatNumber
                                    type="number" minIntegerDigits="3" value="${ticketsSolved.device.deviceNumCode}"/></td>
                            <td>${ticketsSolved.problem}</td>
                            <td>${ticketsSolved.subCategory.category.category}</td>
                            <td>${ticketsSolved.subCategory.sub_category}</td>
                        </tr>
                        <c:set var="count" value="${count+1}"/>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>
