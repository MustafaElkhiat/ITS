<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/15/2020
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${device.needToUpgrade}">
        <c:set var="need_to_upgrade" value='checked'/>
    </c:when>
    <c:otherwise>
        <c:set var="need_to_upgrade" value=''/>
    </c:otherwise>
</c:choose>
<div class="col-3 ${param.classs}">
    <div class="input-group">
        <div class="input-group-prepend">
            <div class="input-group-text">
                <input type="checkbox" id="need_to_upgrade" class="user_checkbox" ${need_to_upgrade}>
            </div>
        </div>
        <label class="form-control">Need To Upgrade
        </label>
    </div>
</div>