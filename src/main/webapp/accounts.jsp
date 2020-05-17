<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 5/12/2020
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="page_header.jsp">
    <jsp:param name="title" value="Accounts"/>
    <jsp:param name="button" value="true"/>
    <jsp:param name="button_id" value="add_account"/>
    <jsp:param name="button_title" value="<i class='fas fa-plus'></i> Add Account"/>
</jsp:include>
<div class="card mt-3">
    <div class="card-body">
        <c:if test="${fn:length(accountList) > 0}">
            <jsp:include page="search_field.jsp">
                <jsp:param name="id" value="search_account"/>
            </jsp:include>

            <div class="scroll tables_height">
                <table id="account_table" class="table table-striped table-striped">
                    <thead>
                    <tr class="table-bordered bg-lightGray">
                        <th># <i class="fas float-left my-2"></i></th>
                        <th>account <i class="fas float-left my-2"></i></th>
                    </tr>
                    </thead>
                    <tbody id="account_table_body">
                    <c:forEach var="account" items="${accountList}" varStatus="loop">
                        <tr class="edit_account link" account-id="${account.id}">
                            <td>${loop.count}</td>
                            <td>${account.account}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>
