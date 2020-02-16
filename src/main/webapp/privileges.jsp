<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 2/16/2020
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="page_header.jsp">
    <jsp:param name="title" value="Privileges"/>
    <jsp:param name="button" value="true"/>
    <jsp:param name="button_id" value="add_privilege"/>
    <jsp:param name="button_title" value="<i class='fas fa-plus'></i> Add Privilege"/>
</jsp:include>
<div class="card mt-3">
    <div class="card-body">
        <c:if test="${fn:length(privilegeList) > 0}">
            <jsp:include page="search_field.jsp">
                <jsp:param name="id" value="search_privilege"/>
            </jsp:include>

            <div class="scroll" style="height:350px;">
                <table id="privilege_table" class="table table-striped table-striped">
                    <thead>
                    <tr class="table-bordered bg-lightGray">
                        <th># <i class="fas float-left my-2"></i></th>
                        <th>Privilege <i class="fas float-left my-2"></i></th>
                    </tr>
                    </thead>
                    <tbody id="privilege_table_body">
                    <c:forEach var="privilege" items="${privilegeList}" varStatus="loop">
                        <tr class="edit_privilege link" privilege-id="${privilege.id}">
                            <td>${loop.count}</td>
                            <td>${privilege.privilege}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>
