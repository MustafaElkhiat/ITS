<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 3/3/2020
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:forEach items="${userRegions}" var="userRegion" varStatus="loop">
    <c:if test="${loop.index % 3 == 0}">
        <div class="row">
    </c:if>
    <jsp:include page="/charts/user_charts_view.jsp">
        <jsp:param name="user" value="${userRegion.TSUser.id}"/>
    </jsp:include>

    <c:if test="${loop.index % 3 == 2 || loop.last}">
        </div>
    </c:if>
</c:forEach>
