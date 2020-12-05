 <%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/8/2020
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../modals.jsp"/>
<jsp:include page="../page_header.jsp">
    <jsp:param name="title" value="Add Device"/>
</jsp:include>
<div class="card mt-3">
    <div class="card-body">

        <form id="device_modal_form" class="needs-validation" novalidate>
            <div class="row">
                <div class="col-3">
                    <div class="form-label-group">
                        <input type="text" id="device" name="device" class="form-control"
                               placeholder="Device"
                               required=""
                               autofocus="">
                        <label for="device">Device</label>
                    </div>
                </div>
                <div class="col-3">
                    <div class="form-label-group">
                        <input type="text" id="vendor" name="vendor" class="form-control"
                               placeholder="Vendor"
                               required=""
                               autofocus="">
                        <label for="vendor">Vendor</label>
                    </div>
                </div>
                <div class="col-3">
                    <div class="form-label-group">
                        <input type="text" id="model" name="model" class="form-control"
                               placeholder="Model"
                               required=""
                               autofocus="">
                        <label for="model">Model</label>
                    </div>
                </div>
                <div class="col-3">
                    <div class="form-label-group">
                        <input id="purchase_date"
                               autocomplete="off"
                               type="text"
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
                               placeholder="MAC Address"
                               required=""
                               autofocus="">
                        <label for="mac_address">MAC Address</label>
                    </div>
                </div>
                <div class="col-3">
                    <div class="form-label-group">
                        <input type="text" id="ip_address" name="ip_address" class="form-control"
                               placeholder="IP Address"
                               required=""
                               autofocus="">
                        <label for="ip_address">IP Address</label>
                    </div>
                </div>
                <div class="col-3">
                    <div class="form-label-group">
                        <input type="text" id="serial_num" name="serial_num" class="form-control"
                               placeholder="Serial Number"
                               required=""
                               autofocus="">
                        <label for="serial_num">Serial Number</label>
                    </div>
                </div>
                <div class="col-3">
                    <div class="form-label-group">
                        <input type="text" id="office" name="office" class="form-control"
                               placeholder="Office"
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
                                <jsp:include page="../select_options/region_options.jsp"/>
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
                <div id="location_section" class="col-3 location_section"></div>
                <div id="department_section" class="col-3 department_section"></div>


                <div id="device_type_section" class="col-3 device_type_section"></div>
            </div>
            <div id="device_data"></div>
        </form>


    </div>
</div>