<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/5/2019
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="select-wrap">
    <label>Department</label>
    <div class="input-group">
        <select class="form-control department_" id="department_" name="department" required autofocus>
            <jsp:include page="../select_options/department_options.jsp">
                <jsp:param name="selected" value="${param.selected}"/>
            </jsp:include>
        </select>
        <c:if test="${P_3}">  <%-- 3 Add Department--%>
            <div class="input-group-append">
                <button class="btn btn-outline-primary" type="button" data-toggle="modal" data-dismiss="modal"
                        aria-label="Close"
                        data-target="#department_modal"><i class="fas fa-plus"></i></button>
            </div>
        </c:if>
    </div>
</div>

