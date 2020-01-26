<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/19/2020
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="edit_user" value=""/>
<c:if test="${P_15}">
    <c:set var="edit_user" value="user"/>
</c:if>
<jsp:include page="page_header.jsp">
    <jsp:param name="title" value="Users"/>
    <jsp:param name="button" value="${P_14}"/>
    <jsp:param name="button_id" value="add_user"/>
    <jsp:param name="button_title" value="<i class='fas fa-plus'></i> Add User"/>
</jsp:include>

<div class="card mt-3">
    <div class="card-body">
        <c:if test="${fn:length(userList) > 0}">
            <jsp:include page="search_field.jsp">
                <jsp:param name="id" value="search_user"/>
            </jsp:include>

            <div class="scroll">
                <table id="user_table" class="table table-striped table-striped" style="width: 2500px;">
                    <thead>
                    <tr class="table-bordered bg-lightGray">
                        <th rowspan="2"># <i class="fas float-left my-2"></i></th>
                        <th rowspan="2">Name <i class="fas float-left my-2"></i></th>
                        <th rowspan="2">Role <i class="fas float-left my-2"></i></th>
                        <th colspan="${fn:length(privilegeList)}">Privileges <i class="fas float-left my-2"></i></th>
                    </tr>
                    <tr class="table-bordered bg-lightGray">
                        <c:forEach items="${privilegeList}" var="privilege">
                            <th>${privilege.privilege}</th>
                        </c:forEach>

                    </tr>
                    </thead>
                    <tbody id="user_table_body">
                    <c:forEach items="${userList}" var="user" varStatus="userLoop">
                        <tr class="${edit_user} link" user-id="${user.id}">
                            <td>${userLoop.count}</td>
                            <td>${user.name}</td>
                            <td>${user.role.role}</td>
                            <c:forEach items="${privilegeList}" var="privilege">
                                <td>
                                    <c:set var="not_break" value="true"/>
                                    <c:forEach items="${userPrivilegeList}" var="userPrivilege" varStatus="loop">
                                        <c:if test="${not_break}">
                                            <c:choose>
                                                <c:when test="${user.id == userPrivilege.user.id}">
                                                    <c:choose>
                                                        <c:when test="${privilege.id == userPrivilege.privilege.id}">
                                                            <i class="fas fa-2x fa-check text-success"></i>
                                                            <c:set var="not_break" value="false"/>
                                                        </c:when>
                                                        <c:when test="${privilege.id != userPrivilege.privilege.id && loop.last}">
                                                            <i class="fas fa-2x fa-times text-danger"></i>
                                                        </c:when>

                                                    </c:choose>
                                                </c:when>
                                                <c:when test="${user.id != userPrivilege.user.id && loop.last}">
                                                    <i class="fas fa-2x fa-times text-danger"></i>
                                                </c:when>
                                            </c:choose>
                                        </c:if>
                                    </c:forEach>
                                </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>

