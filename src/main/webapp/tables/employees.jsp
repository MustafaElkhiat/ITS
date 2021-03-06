<%--
  Created by IntelliJ IDEA.
  User: Eng. Mustafa Elkhiat
  Date: 3/29/21
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../page_header.jsp">
    <jsp:param name="title" value="Employees"/>
</jsp:include>
<div class="card mt-3">
    <div class="card-body">
        <c:if test="${fn:length(employeeList) > 0}">
            <jsp:include page="../search_field.jsp">
                <jsp:param name="id" value="search_employee"/>
            </jsp:include>

            <div class="scroll tables_height">
                <table id="employee_table" class="table table-striped table-striped">
                    <thead>
                    <tr class="table-bordered bg-lightGray">
                        <th># <i class="fas float-left my-2"></i></th>
                        <th>Code <i class="fas float-left my-2"></i></th>
                        <th>Name <i class="fas float-left my-2"></i></th>
                        <th>Position <i class="fas float-left my-2"></i></th>
                        <th>Email <i class="fas float-left my-2"></i></th>
                        <th>Mobile <i class="fas float-left my-2"></i></th>
                        <th>Section <i class="fas float-left my-2"></i></th>
                        <th>Department <i class="fas float-left my-2"></i></th>
                        <th>Site <i class="fas float-left my-2"></i></th>
                    </tr>
                    </thead>
                    <tbody id="employee_table_body">
                    <c:forEach var="employee" items="${employeeList}" varStatus="loop">
                        <tr class="link context-menu-one" employee-code="${employee.employeeCode}">
                            <td>${loop.count}</td>
                            <td>${employee.employeeCode}</td>
                            <td>${employee.employeeName}</td>
                            <td>${employee.position}</td>
                            <td>${employee.email}</td>
                            <td>${employee.mobile}</td>
                            <td>${employee.section}</td>
                            <td>${employee.department}</td>
                            <td>${employee.site}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>