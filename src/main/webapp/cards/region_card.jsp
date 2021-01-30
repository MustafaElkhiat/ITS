<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/19/2020
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="checkbox-wrap">
    <label class="title">Region</label>
    <c:forEach items="${regionList}" var="region">
        <c:set var="not_break" value="true"/>
        <div class="input-group inline_flex mx-2 my-1" style="width: 223px">
            <div class="input-group-prepend">
                <div class="input-group-text">
                    <input type="checkbox" class="region_checkbox" value="${region.id}"

                    <c:forEach items="${userRegionList}" var="userRegion">
                    <c:if test="${not_break && userRegion.region.id == region.id}">
                        <c:set var="not_break" value="false"/>
                           checked
                    </c:if>
                    </c:forEach>

                    >
                </div>
            </div>
            <label class="form-control">${region.region}
            </label>
        </div>
    </c:forEach>
</div>