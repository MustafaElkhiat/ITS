<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/12/2020
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="edit_device_privilege" value=""/>
<c:if test="${P_6}">
    <c:set var="edit_device_privilege" value="device"/>
</c:if>
<c:if test="${fn:length(switchList) > 0}">
<jsp:include page="search_field.jsp">
    <jsp:param name="id" value="search_Switch"/>
</jsp:include>
<div class="scroll">
    <table id="Switch_table" class="table table-striped table-striped" style="width: 1500px;">
        <thead>
        <tr class="table-bordered bg-lightGray">
            <th>#<i class="fas float-left my-2"></i></th>
            <th>Device<i class="fas float-left my-2"></i></th>
            <th>Vendor<i class="fas float-left my-2"></i></th>
            <th>Model<i class="fas float-left my-2"></i></th>
            <th>MAC Address<i class="fas float-left my-2"></i></th>
            <th>IP Address<i class="fas float-left my-2"></i></th>
            <th>Location<i class="fas float-left my-2"></i></th>
            <th>Department<i class="fas float-left my-2"></i></th>
            <th>Office<i class="fas float-left my-2"></i></th>
            <th>Serial Number<i class="fas float-left my-2"></i></th>
            <th>Purchase Date<i class="fas float-left my-2"></i></th>
            <th>Need To Upgrade<i class="fas float-left my-2"></i></th>
        </tr>
        </thead>
        <tbody id="Switch_table_body">
        <c:set var="count" value="1"/>
        <c:forEach items="${switchList}" var="device">

            <c:choose>
                <c:when test="${device.needToUpgrade}">
                    <c:set var="need_to_upgrade" value='<i class="fas fa-2x fa-check text-success"></i>'/>
                </c:when>
                <c:otherwise>
                    <c:set var="need_to_upgrade" value='<i class="fas fa-2x fa-times text-danger"></i>'/>
                </c:otherwise>
            </c:choose>
            <tr class="${edit_device_privilege} SW link" device-id="${device.id}">
                <td>${count}</td>
                <td>${device.department.location.region.abbreviation}-${device.department.location.abbreviation}-${device.department.abbreviation}-${device.deviceType.abbreviation}-${device.device}</td>
                <td>${device.vendor}</td>
                <td>${device.model}</td>
                <td>${device.mac_address}</td>
                <td>${device.ip_address}</td>
                <td>${device.location.location}</td>
                <td>${device.department.department}</td>
                <td>${device.office}</td>
                <td>${device.serialNum}</td>
                <td>${device.purchaseDate}</td>
                <td>${need_to_upgrade}</td>
            </tr>
            <c:set var="count" value="${count+1}"/>
        </c:forEach>
        </tbody>
    </table>
</div>
</c:if>