<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/19/2020
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="checkbox-wrap">
    <label class="title">Privilege</label>
    <c:forEach items="${privilegeList}" var="privilege">
        <c:set var="not_break" value="true"/>
        <div class="input-group inline_flex mx-2 my-1" style="width: 223px">
            <div class="input-group-prepend">
                <div class="input-group-text">
                    <input type="checkbox" class="privilege_checkbox" value="${privilege.id}"
                    <c:forEach items="${userPrivilegeList}" var="userPrivilege">
                    <c:if test="${not_break && userPrivilege.privilege.id == privilege.id}">
                        <c:set var="not_break" value="false"/>
                           checked
                    </c:if>
                    </c:forEach>
                    >
                </div>
            </div>
            <label class="form-control">${privilege.privilege}
            </label>
        </div>
    </c:forEach>
</div>
