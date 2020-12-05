<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/5/2019
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="select-wrap mb-0">
    <label>Sub-Category</label>
    <div class="input-group">
        <select class="form-control" id="sub_category_" name="sub_category" required autofocus>
            <jsp:include page="../select_options/sub_category_options.jsp"/>
        </select>
        <c:if test="${P_12}">  <%-- 12 Add Sub-Catgory--%>
            <div class="input-group-append">
                <button class="btn btn-outline-primary" type="button" data-toggle="modal"
                        data-target="#sub_category_modal"><i class="fas fa-plus"></i></button>
            </div>
        </c:if>
    </div>
</div>
