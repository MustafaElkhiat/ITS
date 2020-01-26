<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 12/23/2019
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-striped mt-3">
    <thead>
    <tr>
        <th colspan="2" class="text-left">
            <h3>${param.title}</h3>
        </th>
        <c:if test="${param.button}">
            <th class="text-right">

                <button type="button" id="${param.button_id}" class="btn btn-outline-primary">${param.button_title}
                </button>

            </th>
        </c:if>
    </tr>
    </thead>
</table>
