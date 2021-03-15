<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/12/2020
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../modals.jsp"/>
<jsp:include page="../page_header.jsp">
    <jsp:param name="title" value="Edit Device"/>
</jsp:include>

<input id="device_id" type="hidden" value="${device.id}"/>
<div class="card mt-3">
    <div class="card-body">

        <form id="device_modal_form" class="needs-validation" novalidate>
            <div class="row">
                <div class="col-3">
                    <div class="form-label-group">
                        <input type="text" id="device" name="device" class="form-control"
                               placeholder="Device" value="${device.device}"
                               required=""
                               autofocus="">
                        <label for="device">Device</label>
                    </div>
                </div>
                <div class="col-3">
                    <div class="form-label-group">
                        <input type="text" id="vendor" name="vendor" class="form-control"
                               placeholder="Vendor" value="${device.vendor}"
                               required=""
                               autofocus="">
                        <label for="vendor">Vendor</label>
                    </div>
                </div>
                <div class="col-3">
                    <div class="form-label-group">
                        <input type="text" id="model" name="model" class="form-control"
                               placeholder="Model" value="${device.model}"
                               required=""
                               autofocus="">
                        <label for="model">Model</label>
                    </div>
                </div>
                <div class="col-3">
                    <div class="form-label-group">
                        <input id="purchase_date"
                               autocomplete="off"
                               type="text" value="${device.purchaseDate}"
                               data-language="en"
                               placeholder="Select Purchase Date"
                               class="datepicker-here form-control" readonly/>

                        <label for="purchase_date">Purchase Date</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-3">
                    <div class="form-label-group">
                        <input type="text" id="mac_address" name="mac_address" class="form-control"
                               placeholder="MAC Address" value="${device.mac_address}"
                               required=""
                               autofocus="">
                        <label for="mac_address">MAC Address</label>
                    </div>
                </div>
                <div class="col-3">
                    <div class="form-label-group">
                        <input type="text" id="ip_address" name="ip_address" class="form-control"
                               placeholder="IP Address" value="${device.ip_address}"
                               required=""
                               autofocus="">
                        <label for="ip_address">IP Address</label>
                    </div>
                </div>
                <div class="col-3">
                    <div class="form-label-group">
                        <input type="text" id="serial_num" name="serial_num" class="form-control"
                               placeholder="Serial Number" value="${device.serialNum}"
                               required=""
                               autofocus="">
                        <label for="serial_num">Serial Number</label>
                    </div>
                </div>
                <div class="col-3">
                    <div class="form-label-group">
                        <input type="text" id="office" name="office" class="form-control"
                               placeholder="Office" value="${device.office}"
                               required=""
                               autofocus="">
                        <label for="office">Office</label>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-3">
                    <div class="select-wrap">
                        <label>Region</label>
                        <div class="input-group">
                            <select class="form-control region_" id="region_" name="region" required autofocus>
                                <jsp:include page="../select_options/region_options.jsp">
                                    <jsp:param name="selected" value="${device.locationDepartment.location.region.id}"/>
                                </jsp:include>
                            </select>
                            <c:if test="${P_1}">  <%-- 1 Add Region--%>
                                <div class="input-group-append">
                                    <button class="btn btn-outline-primary" type="button" data-toggle="modal"
                                            data-dismiss="modal"
                                            aria-label="Close"
                                            data-target="#region_modal"><i class="fas fa-plus"></i></button>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div id="location_section" class="col-3 location_section">
                    <jsp:include page="../sections/location_section.jsp">
                        <jsp:param name="selected" value="${device.locationDepartment.location.id}"/>
                    </jsp:include>
                </div>
                <div id="department_section" class="col-3 department_section">
                    <jsp:include page="../sections/department_section.jsp">
                        <jsp:param name="selected" value="${device.locationDepartment.department.id}"/>
                    </jsp:include>
                </div>
                <div id="device_type_section" class="col-3 device_type_section">
                    <jsp:include page="../sections/device_type_section.jsp">
                        <jsp:param name="selected" value="${device.deviceType.id}"/>
                    </jsp:include>
                </div>
            </div>
            <div id="device_data">
                <c:choose>
                    <c:when test="${device.deviceType.id == 1}">
                        <jsp:include page="../devices_data/pc_data.jsp"/>
                    </c:when>
                    <c:when test="${device.deviceType.id == 2}">
                        <jsp:include page="../devices_data/printer_data.jsp"/>
                    </c:when>
                    <c:when test="${device.deviceType.id == 3 || device.deviceType.id == 7}">
                        <jsp:include page="../devices_data/video_recorder_data.jsp"/>
                    </c:when>
                    <c:when test="${device.deviceType.id == 4 || device.deviceType.id == 5 || device.deviceType.id == 6 || device.deviceType.id == 10 || device.deviceType.id == 11 || device.deviceType.id == 12  || device.deviceType.id == 14 || device.deviceType.id == 15}">
                        <jsp:include page="../devices_data/device_data.jsp"/>
                    </c:when>
                    <c:when test="${device.deviceType.id == 8}">
                        <jsp:include page="../devices_data/PBX_data.jsp"/>
                    </c:when>
                    <c:when test="${device.deviceType.id == 9}">
                        <jsp:include page="../devices_data/attendance_data.jsp"/>
                    </c:when>
                    <c:when test="${device.deviceType.id == 13}">
                        <jsp:include page="../devices_data/mobile_data.jsp"/>
                    </c:when>
                </c:choose>

            </div>
        </form>


    </div>
</div>
