<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/9/2020
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="edit_device_privilege" value=""/>
<c:if test="${P_6}">
    <c:set var="edit_device_privilege" value="device"/>
</c:if>
<div class="card card-outline-primary">
    <div class="card-body">

        <c:if test="${fn:length(attendanceList) > 0}">
            <h5 class="card-title">Finger Print <i class="fas fa-print"></i></h5>
            <jsp:include page="../search_field.jsp">
                <jsp:param name="id" value="search_Att"/>
            </jsp:include>

            <div class="scroll devices_tab_table" >
                <table id="Att_table" class="table table-striped table-bordered" style="width: 2500px;">
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
                        <th>Subnet<i class="fas float-left my-2"></i></th>
                        <th>Gateway<i class="fas float-left my-2"></i></th>
                        <th>Purchase Date<i class="fas float-left my-2"></i></th>
                        <th>Need To Upgrade<i class="fas float-left my-2"></i></th>
                    </tr>
                    </thead>
                    <tbody id="Att_table_body">
                    <c:set var="count" value="1"/>
                    <c:forEach items="${attendanceList}" var="device">
                        <c:choose>
                            <c:when test="${device.needToUpgrade}">
                                <c:set var="need_to_upgrade" value='<i class="fas fa-2x fa-check text-success"></i>'/>
                            </c:when>
                            <c:otherwise>
                                <c:set var="need_to_upgrade" value='<i class="fas fa-2x fa-times text-danger"></i>'/>
                            </c:otherwise>
                        </c:choose>
                        <tr class="${edit_device_privilege} FP link" device-id="${device.id}">
                            <td>${count}</td>
                            <td>${device.locationDepartment.location.region.abbreviation}-${device.locationDepartment.location.abbreviation}-${device.locationDepartment.department.abbreviation}-${device.deviceType.abbreviation}-<fmt:formatNumber
                                    type="number" minIntegerDigits="3" value="${device.deviceNumCode}"/></td>
                            <td>${device.vendor}</td>
                            <td>${device.model}</td>
                            <td>${device.mac_address}</td>
                            <td>${device.ip_address}</td>
                            <td>${device.locationDepartment.location.location}</td>
                            <td>${device.locationDepartment.department.department}</td>
                            <td>${device.office}</td>
                            <td>${device.serialNum}</td>
                            <td>${device.subnet}</td>
                            <td>${device.gateway}</td>
                            <td>${device.purchaseDate}</td>
                            <td>${need_to_upgrade}</td>
                        </tr>
                        <c:set var="count" value="${count+1}"/>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>