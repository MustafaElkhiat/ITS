<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 2/15/2020
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="edit_employee" value=""/>
<c:if test="${P_16}">
    <c:set var="edit_employee" value="edit_employee"/>
</c:if>
<jsp:include page="page_header.jsp">
    <jsp:param name="title" value="Employees"/>
</jsp:include>
<div class="card mt-3">
    <div class="card-body">
        <c:if test="${fn:length(employeeList) > 0}">
            <jsp:include page="search_field.jsp">
                <jsp:param name="id" value="search_employee"/>
            </jsp:include>

            <div class="scroll" style="height:350px;">
                <table id="employee_table" class="table table-striped table-striped">
                    <thead>
                    <tr class="table-bordered bg-lightGray">
                        <th># <i class="fas float-left my-2"></i></th>
                        <th>Name <i class="fas float-left my-2"></i></th>
                        <th>Position <i class="fas float-left my-2"></i></th>
                        <th>Staff ID <i class="fas float-left my-2"></i></th>
                        <c:if test="${isRegional}">
                            <th>Region <i class="fas float-left my-2"></i></th>
                        </c:if>
                        <th>Location <i class="fas float-left my-2"></i></th>
                        <th>Department <i class="fas float-left my-2"></i></th>
                    </tr>
                    </thead>
                    <tbody id="employee_table_body">
                    <c:forEach var="employee" items="${employeeList}" varStatus="loop">
                        <tr class="${edit_employee} link" employee-id="${employee.id}">
                            <td>${loop.count}</td>
                            <td>${employee.name}</td>
                            <td>${employee.position}</td>
                            <td>${employee.staffID}</td>
                            <c:if test="${isRegional}">
                                <td>${employee.locationDepartment.location.region.region}</td>
                            </c:if>
                            <td>${employee.locationDepartment.location.location}</td>
                            <td>${employee.locationDepartment.department.department}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>