<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/30/2020
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="page_header.jsp">
    <jsp:param name="title" value="Dashboard"/>
</jsp:include>
<c:if test="${current_user.role.id != 1 && current_user.role.id != 2 && current_user.role.id !=3}">
    <jsp:include page="ticket_section.jsp">
        <jsp:param name="user" value="${current_user.id}"/>
    </jsp:include>
</c:if>

<c:if test="${current_user.role.id == 1 || current_user.role.id == 2 || current_user.role.id == 6}">
    <div class="card mt-3">
        <div class="card-body">
            <h5 class="card-title">Region Ticket Ratio</h5>
            <c:if test="${current_user.role.id ==  1 || current_user.role.id == 6}">
                <div class="row">
                    <jsp:include page="region_charts_view.jsp">
                        <jsp:param name="region" value="ALL"/>
                    </jsp:include>
                </div>
            </c:if>
            <c:forEach items="${userRegionList}" var="userRegion" varStatus="loop">

                <c:if test="${loop.index % 2 == 0}">
                    <div class="row">
                </c:if>
                <jsp:include page="region_charts_view.jsp">
                    <jsp:param name="region" value="${userRegion.region.id}"/>
                </jsp:include>
                <c:if test="${loop.index % 2 == 1 || loop.last}">
                    </div>
                </c:if>

            </c:forEach>
        </div>
    </div>
    <div class="card mt-3">
        <div class="card-body">
            <h5 class="card-title">L2 Engineers Ticket Ratio</h5>
            <c:forEach items="${userRegions}" var="userRegion" varStatus="loop">
                <c:if test="${loop.index % 2 == 0}">
                    <div class="row">
                </c:if>
                <jsp:include page="user_charts_view.jsp">
                    <jsp:param name="user" value="${userRegion.TSUser.id}"/>
                </jsp:include>

                <c:if test="${loop.index % 2 == 1 || loop.last}">
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
</c:if>