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
<c:if test="${current_user.role.id != 1 && current_user.role.id !=3}">
    <jsp:include page="ticket_section.jsp">
        <jsp:param name="user" value="${current_user.id}"/>
    </jsp:include>
</c:if>
<div class="accordion mt-4" id="accordionExample">
<c:if test="${current_user.role.id == 1 || current_user.role.id == 2 || current_user.role.id == 6}">
    <div class="card">
        <div class="card-header" id="headingOne">
            <h2 class="mb-0">
                <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseOne"
                        aria-expanded="true" aria-controls="collapseOne" onclick="loadRegionTicketRatioSection();">
                    <h5 class="card-title">Region Ticket Ratio</h5>
                </button>
            </h2>
        </div>

        <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
            <div id="region_ticket_ratio_section" class="card-body ratio_section">
            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header" id="headingTwo">
            <h2 class="mb-0">
                <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo"
                        aria-expanded="false" aria-controls="collapseTwo" onclick="loadL2EngineersTicketRatioSection();">
                    <h5 class="card-title">L2 Engineers Ticket Ratio</h5>
                </button>
            </h2>
        </div>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
            <div id="l2_engineers_ticket_ratio_section" class="card-body ratio_section">
            </div>
        </div>
    </div>
</c:if>
<c:if test="${current_user.role.id == 1 || current_user.role.id == 2 || current_user.role.id == 3 || current_user.role.id == 6}">
    <div class="card">
        <div class="card-header" id="headingThree">
            <h2 class="mb-0">
                <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree"
                        aria-expanded="false" aria-controls="collapseThree" onclick="loadRegionDevicesRatioSection();">
                    <h5 class="card-title">Region Devices Ratio</h5>
                </button>
            </h2>
        </div>
        <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
            <div id="region_devices_ratio_section" class="card-body ratio_section">
            </div>
        </div>
    </div>
    </div>
</c:if>
<%--
<c:if test="${current_user.role.id == 1 || current_user.role.id == 2 || current_user.role.id == 6}">
    <div class="card mt-3">
        <div class="card-body">
            <h5 class="card-title">Region Ticket Ratio</h5>
            <c:if test="${current_user.role.id == 1 || current_user.role.id == 6}">
                <div class="row">
                    <jsp:include page="region_charts_view.jsp">
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
                <jsp:include page="region_charts_view.jsp">
                    <jsp:param name="region" value="${userRegion.region.id}"/>
                    <jsp:param name="regionAbb" value="${userRegion.region.abbreviation}"/>
                    <jsp:param name="regionT" value="${userRegion.region.region}"/>
                </jsp:include>
                <c:if test="${loop.index % 3 == 2 || loop.last}">
                    </div>
                </c:if>

            </c:forEach>
        </div>
    </div>
    <div class="card mt-3">
        <div class="card-body">
            <h5 class="card-title">L2 Engineers Ticket Ratio</h5>
            <c:forEach items="${userRegions}" var="userRegion" varStatus="loop">
                <c:if test="${loop.index % 3 == 0}">
                    <div class="row">
                </c:if>
                <jsp:include page="user_charts_view.jsp">
                    <jsp:param name="user" value="${userRegion.TSUser.id}"/>
                </jsp:include>

                <c:if test="${loop.index % 3 == 2 || loop.last}">
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
</c:if>
<c:if test="${current_user.role.id == 1 || current_user.role.id == 2 || current_user.role.id == 3 || current_user.role.id == 6}">
    <div class="card mt-3">
        <div class="card-body">
            <h5 class="card-title">Region Devices Ratio</h5>
            <c:if test="${current_user.role.id == 1 || current_user.role.id == 3 || current_user.role.id == 6}">
                <div class="row">

                    <jsp:include page="device_charts_view.jsp">
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
                <jsp:include page="device_charts_view.jsp">
                    <jsp:param name="region" value="${userRegion.region.id}"/>
                    <jsp:param name="regionAbb" value="${userRegion.region.abbreviation}"/>
                    <jsp:param name="regionT" value="${userRegion.region.region}"/>
                </jsp:include>
                <c:if test="${loop.index % 3 == 2 || loop.last}">
                    </div>
                </c:if>

            </c:forEach>
        </div>
    </div>
</c:if>
--%>