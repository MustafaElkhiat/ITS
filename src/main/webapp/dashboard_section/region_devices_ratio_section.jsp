<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 3/3/2020
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:if test="${current_user.role.id == 1 || current_user.role.id == 3 || current_user.role.id == 6}">
    <div class="row">

        <jsp:include page="/charts/device_charts_view.jsp">
            <jsp:param name="region" value="ALL"/>
            <jsp:param name="regionAbb" value="ALL"/>
            <jsp:param name="regionT" value="All Regions"/>
        </jsp:include>

    </div>
</c:if>
<c:forEach items="${userRegionList}" var="userRegion" varStatus="loop">

    <c:if test="${loop.index % 3 == 0}">
        <div class="row">
    </c:if>
    <jsp:include page="/charts/device_charts_view.jsp">
        <jsp:param name="region" value="${userRegion.region.id}"/>
        <jsp:param name="regionAbb" value="${userRegion.region.abbreviation}"/>
        <jsp:param name="regionT" value="${userRegion.region.region}"/>
    </jsp:include>
    <c:if test="${loop.index % 3 == 2 || loop.last}">
        </div>
    </c:if>

</c:forEach>
