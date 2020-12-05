<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/5/2019
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="card">
    <div class="card-body">
        <h5 class="card-title pb-1">Device Info.</h5>
        <table class="table table-bordered table-striped table my-4" width="100%">
            <tbody>
            <tr>
                <th>Device</th>
                <td>${device.locationDepartment.location.region.abbreviation}-${device.locationDepartment.location.abbreviation}-${device.locationDepartment.department.abbreviation}-${device.deviceType.abbreviation}-<fmt:formatNumber
                        type="number" minIntegerDigits="3" value="${device.deviceNumCode}"/></td>
            </tr>
            <tr>
                <th>Device Type</th>
                <td>${device.deviceType.deviceType}</td>
            </tr>
            <tr>
                <th>Vendor</th>
                <td>${device.vendor}</td>
            </tr>
            <tr>
                <th>Model</th>
                <td>${device.model}</td>
            </tr>
            <tr>
                <th>MAC Address</th>
                <td>${device.mac_address}</td>
            </tr>
            <tr>
                <th>IP Address</th>
                <td>${device.ip_address}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
