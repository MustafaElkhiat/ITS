<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/2/2020
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../page_header.jsp">
    <jsp:param name="title" value="Devices"/>
    <jsp:param name="button" value="${P_5}"/>
    <jsp:param name="button_id" value="add_device"/>
    <jsp:param name="button_title" value="<i class='fas fa-plus'></i> Add Device"/>
</jsp:include>
<div class="card mt-3">
    <div class="card-body">

        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item">
                <a class="nav-link bg-primary red-active" id="PC-tab" data-toggle="tab" href="#PC" role="tab"
                   aria-controls="home" aria-selected="true">PC <span class="badge badge-light">${fn:length(deviceList)}</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link bg-primary red-active" id="Printer-tab" data-toggle="tab" href="#Printer" role="tab"
                   aria-controls="profile" aria-selected="false">Printer <span class="badge badge-light">${fn:length(printerList)}</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link bg-primary red-active" id="Attendance-tab" data-toggle="tab" href="#Attendance" role="tab"
                   aria-controls="contact" aria-selected="false">Finger Print <span class="badge badge-light">${fn:length(attendanceList)}</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link bg-primary red-active" id="PBX-tab" data-toggle="tab" href="#PBX" role="tab" aria-controls="contact"
                   aria-selected="false">IP Phone <span class="badge badge-light">${fn:length(pbxList)}</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link bg-primary red-active" id="Switch-tab" data-toggle="tab" href="#Switch" role="tab" aria-controls="contact"
                   aria-selected="false">Switch <span class="badge badge-light">${fn:length(switchList)}</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link bg-primary red-active" id="Router-tab" data-toggle="tab" href="#Router" role="tab" aria-controls="contact"
                   aria-selected="false">Router <span class="badge badge-light">${fn:length(routerList)}</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link bg-primary red-active" id="UPS-tab" data-toggle="tab" href="#UPS" role="tab" aria-controls="contact"
                   aria-selected="false">UPS <span class="badge badge-light">${fn:length(UPSList)}</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link bg-primary red-active" id="Firewall-tab" data-toggle="tab" href="#Firewall" role="tab" aria-controls="contact"
                   aria-selected="false">Firewall <span class="badge badge-light">${fn:length(firewallList)}</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link bg-primary red-active" id="Camera-tab" data-toggle="tab" href="#Camera" role="tab" aria-controls="contact"
                   aria-selected="false">Camera <span class="badge badge-light">${fn:length(cameraList)}</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link bg-primary red-active" id="DVR-tab" data-toggle="tab" href="#DVR" role="tab" aria-controls="contact"
                   aria-selected="false">DVR <span class="badge badge-light">${fn:length(DVRList)}</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link bg-primary red-active" id="NVR-tab" data-toggle="tab" href="#NVR" role="tab" aria-controls="contact"
                   aria-selected="false">NVR <span class="badge badge-light">${fn:length(NVRList)}</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link bg-primary red-active" id="AP-tab" data-toggle="tab" href="#AP" role="tab" aria-controls="contact"
                   aria-selected="false">Access Point <span class="badge badge-light">${fn:length(APList)}</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link bg-primary red-active" id="mob-tab" data-toggle="tab" href="#mob" role="tab" aria-controls="contact"
                   aria-selected="false">Mobile <span class="badge badge-light">${fn:length(mobList)}</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link bg-primary red-active" id="rack-tab" data-toggle="tab" href="#rack" role="tab" aria-controls="contact"
                   aria-selected="false">Rack <span class="badge badge-light">${fn:length(rackList)}</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link bg-primary red-active" id="handheld-tab" data-toggle="tab" href="#handheld" role="handheld" aria-controls="contact"
                   aria-selected="false">Handheld <span class="badge badge-light">${fn:length(handheldList)}</span></a>
            </li>
        </ul>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade" id="PC" role="tabpanel" aria-labelledby="PC-tab">
                <jsp:include page="../tabs/PC_tab.jsp"/>
            </div>
            <div class="tab-pane fade" id="Printer" role="tabpanel" aria-labelledby="Printer-tab">
                <jsp:include page="../tabs/printer_tab.jsp"/>
            </div>
            <div class="tab-pane fade" id="Attendance" role="tabpanel" aria-labelledby="Attendance-tab">
                <jsp:include page="../tabs/attendance_tab.jsp"/>
            </div>
            <div class="tab-pane fade" id="PBX" role="tabpanel" aria-labelledby="PBX-tab">
                <jsp:include page="../tabs/PBX_tab.jsp"/>
            </div>
            <div class="tab-pane fade" id="Switch" role="tabpanel" aria-labelledby="Switch-tab">
                <jsp:include page="../tabs/switch_tab.jsp"/>
            </div>
            <div class="tab-pane fade" id="Router" role="tabpanel" aria-labelledby="Router-tab">
                <jsp:include page="../tabs/router_tab.jsp"/>
            </div>
            <div class="tab-pane fade" id="UPS" role="tabpanel" aria-labelledby="UPS-tab">
                <jsp:include page="../tabs/UPS_tab.jsp"/>
            </div>
            <div class="tab-pane fade" id="Firewall" role="tabpanel" aria-labelledby="Firewall-tab">
                <jsp:include page="../tabs/firewall_tab.jsp"/>
            </div>
            <div class="tab-pane fade" id="Camera" role="tabpanel" aria-labelledby="Camera-tab">
                <jsp:include page="../tabs/camera_tab.jsp"/>
            </div>
            <div class="tab-pane fade" id="DVR" role="tabpanel" aria-labelledby="DVR-tab">
                <jsp:include page="../tabs/DVR_tab.jsp"/>
            </div>
            <div class="tab-pane fade" id="NVR" role="tabpanel" aria-labelledby="NVR-tab">
                <jsp:include page="../tabs/NVR_tab.jsp"/>
            </div>
            <div class="tab-pane fade" id="AP" role="tabpanel" aria-labelledby="AP-tab">
                <jsp:include page="../tabs/AP_tab.jsp"/>
            </div>
            <div class="tab-pane fade" id="mob" role="tabpanel" aria-labelledby="mob-tab">
                <jsp:include page="../tabs/mobile_tab.jsp"/>
            </div>
            <div class="tab-pane fade" id="rack" role="tabpanel" aria-labelledby="rack-tab">
                <jsp:include page="../tabs/rack_tab.jsp"/>
            </div>
            <div class="tab-pane fade" id="handheld" role="tabpanel" aria-labelledby="handheld-tab">
                <jsp:include page="../tabs/handheld_tab.jsp"/>
            </div>
        </div>

    </div>
</div>