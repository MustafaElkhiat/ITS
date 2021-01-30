<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 5/10/2020
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../page_header.jsp">
    <jsp:param name="title" value="Accessories"/>
    <jsp:param name="button" value="true"/>
    <jsp:param name="button_id" value="add_accessory"/>
    <jsp:param name="button_title" value="<i class='fas fa-plus'></i> Add Accessory"/>
</jsp:include>
<div class="card mt-3">
    <div class="card-body">
        <c:if test="${fn:length(accessoryList) > 0}">
            <jsp:include page="../search_field.jsp">
                <jsp:param name="id" value="search_accessory"/>
            </jsp:include>

            <div class="scroll tables_height" >
                <table id="accessory_table" class="table table-striped table-striped">
                    <thead>
                    <tr class="table-bordered bg-lightGray">
                        <th># <i class="fas float-left my-2"></i></th>
                        <th>Accessory <i class="fas float-left my-2"></i></th>
                    </tr>
                    </thead>
                    <tbody id="accessory_table_body">
                    <c:forEach var="accessory" items="${accessoryList}" varStatus="loop">
                        <tr class="edit_accessory link" accessory-id="${accessory.id}">
                            <td>${loop.count}</td>
                            <td>${accessory.accessory}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>
