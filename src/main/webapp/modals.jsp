<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/19/2019
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- Add Location Modal --%>
<div class="modal" id="location_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Location</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" title="close"
                        onclick="resetForm('location_modal_form')">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="location_modal_form" class="needs-validation" novalidate>
                    <div class="form-label-group">
                        <input type="text" id="location" name="location" class="form-control" placeholder="Location"
                               required=""
                               autofocus="">
                        <label for="location">Location</label>
                    </div>
                    <div class="form-label-group">
                        <input type="text" id="location_abb" name="location_abb" class="form-control"
                               placeholder="Abbreviation"
                               required=""
                               autofocus="">
                        <label for="location_abb">Abbreviation</label>
                    </div>
                    <div class="select-wrap">
                        <label>Region</label>
                        <div class="input-group">
                            <select class="form-control" id="select_region_" name="select_region" required
                                    autofocus>
                                <jsp:include page="region_options.jsp"/>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="location_button" class="btn btn-primary" onclick="saveLocation();">Save
                </button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal"
                        onclick="resetForm('location_modal_form')">Cancel
                </button>
            </div>
        </div>
    </div>
</div>


<%-- Add Department Modal --%>
<div class="modal" id="department_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Department</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" title="close"
                        onclick="resetForm('department_modal_form')">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="department_modal_form" class="needs-validation" novalidate>
                    <div class="select-wrap">
                        <label>Department</label>
                        <div class="input-group">
                            <select class="form-control department_select" id="department_select" name="department" required autofocus>
                                <jsp:include page="department_options.jsp"/>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col">
                            <div class="select-wrap">
                                <label>Region</label>
                                <div class="input-group">
                                    <select class="form-control region_" id="region_select" name="region" required
                                            autofocus>
                                        <jsp:include page="region_options.jsp"/>
                                    </select>
                                    <c:if test="${P_1}">
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
                    </div>
                    <div class="row">
                        <div class="col location_section"></div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="department_button" class="btn btn-primary" onclick="saveDepartment();">Save
                </button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal"
                        onclick="resetForm('department_modal_form')">Cancel
                </button>
            </div>
        </div>
    </div>
</div>

<%-- Add Device Type Modal --%>
<div class="modal" id="device_type_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Device Type</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" title="close"
                        onclick="resetForm('device_type_modal_form')">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="device_type_modal_form" class="needs-validation" novalidate>
                    <div class="form-label-group">
                        <input type="text" id="device_type" name="device_type" class="form-control"
                               placeholder="Device Type"
                               required=""
                               autofocus="">
                        <label for="device_type">Device Type</label>
                    </div>
                    <div class="form-label-group">
                        <input type="text" id="device_type_abb" name="device_type_abb" class="form-control"
                               placeholder="Abbreviation"
                               required=""
                               autofocus="">
                        <label for="device_type_abb">Abbreviation</label>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="device_type_button" class="btn btn-primary" onclick="saveDeviceType();">Save
                </button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal"
                        onclick="resetForm('device_type_modal_form')">Cancel
                </button>
            </div>
        </div>
    </div>
</div>

<%-- Add Device Modal --%>
<%--<div class="modal" id="device_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Device</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" title="close"
                        onclick="resetForm('device_modal_form')">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="device_modal_form" class="needs-validation" novalidate>
                    <div class="form-label-group">
                        <input type="text" id="device" name="device" class="form-control" placeholder="Device"
                               required=""
                               autofocus="">
                        <label for="device">Device</label>
                    </div>
                    <div class="form-label-group">
                        <input type="text" id="mac_address" name="mac_address" class="form-control"
                               placeholder="MAC Address"
                               required=""
                               autofocus="">
                        <label for="mac_address">MAC Address</label>
                    </div>
                    <div class="form-label-group">
                        <input type="text" id="any_desk_id" name="any_desk_id" class="form-control"
                               placeholder="Any Desk ID"
                               required=""
                               autofocus="">
                        <label for="any_desk_id">Any Desk ID</label>
                    </div>
                    <div class="form-label-group">
                        <input type="text" id="ip_address" name="ip_address" class="form-control"
                               placeholder="IP Address"
                               required=""
                               autofocus="">
                        <label for="ip_address">IP Address</label>
                    </div>
                    <jsp:include page="device_selection_section.jsp"/>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="device_button" class="btn btn-primary" onclick="saveDevice();">Save
                </button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal"
                        onclick="resetForm('device_modal_form')">Cancel
                </button>
            </div>
        </div>
    </div>
</div>--%>
<%--
<%-- Add Device lg Modal
<div class="modal" id="device_modal" tabindex="-1" role="dialog">
    <div id="modal_lg" class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Device</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" title="close"
                        onclick="resetForm('device_modal_form')">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="device_modal_form" class="needs-validation" novalidate>
                    <div class="row">
                        <div class="col-4">
                            <div class="form-label-group">
                                <input type="text" id="device" name="device" class="form-control"
                                       placeholder="Device"
                                       required=""
                                       autofocus="">
                                <label for="device">Device</label>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="form-label-group">
                                <input type="text" id="vendor" name="vendor" class="form-control"
                                       placeholder="Vendor"
                                       required=""
                                       autofocus="">
                                <label for="vendor">Vendor</label>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="form-label-group">
                                <input type="text" id="model" name="model" class="form-control"
                                       placeholder="Model"
                                       required=""
                                       autofocus="">
                                <label for="model">Model</label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4">
                            <div class="form-label-group">
                                <input type="text" id="mac_address" name="mac_address" class="form-control"
                                       placeholder="MAC Address"
                                       required=""
                                       autofocus="">
                                <label for="mac_address">MAC Address</label>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="form-label-group">
                                <input type="text" id="ip_address" name="ip_address" class="form-control"
                                       placeholder="IP Address"
                                       required=""
                                       autofocus="">
                                <label for="ip_address">IP Address</label>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="form-label-group">
                                <input type="text" id="serial_num" name="serial_num" class="form-control"
                                       placeholder="Serial Number"
                                       required=""
                                       autofocus="">
                                <label for="serial_num">Serial Number</label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4">
                            <div class="form-label-group">
                                <input id="purchase_date"
                                       autocomplete="off"
                                       type="text"
                                       data-language="en"
                                       placeholder="Select Purchase Date"
                                       class="datepicker-here form-control"/>

                                <label for="purchase_date">Purchase Date</label>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="form-label-group">
                                <input type="text" id="office" name="office" class="form-control"
                                       placeholder="Office"
                                       required=""
                                       autofocus="">
                                <label for="office">Office</label>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <input type="checkbox" class="user_checkbox">
                                    </div>
                                </div>
                                <label class="form-control">Need To Upgrade
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="row">

                        <div class="col-4">
                            <div class="select-wrap">
                                <label>Location</label>
                                <div class="input-group">
                                    <select class="form-control location_" id="location_" name="location" required
                                            autofocus>
                                        <jsp:include page="location_options.jsp"/>
                                    </select>

                                    <div class="input-group-append">
                                        <button class="btn btn-outline-primary" type="button" data-toggle="modal"
                                                data-dismiss="modal"
                                                aria-label="Close"
                                                data-target="#location_modal"><i class="fas fa-plus"></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div id="department_section" class="col-4 department_section"></div>


                        <div id="device_type_section" class="col-4 device_type_section"></div>
                    </div>
                    <div id="device_data"></div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="device_button" class="btn btn-primary" onclick="saveDevice();">Save
                </button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal"
                        onclick="resetForm('device_modal_form')">Cancel
                </button>
            </div>
        </div>
    </div>
</div>
--%>
<%-- Add Category Modal --%>
<div class="modal" id="category_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Category</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" title="close"
                        onclick="resetForm('category_modal_form')">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="category_modal_form" class="needs-validation" novalidate>
                    <div class="form-label-group">
                        <input type="text" id="category" name="category" class="form-control" placeholder="Category"
                               required=""
                               autofocus="">
                        <label for="category">Category</label>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="category_button" class="btn btn-primary" onclick="saveCategory();">Save
                </button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal"
                        onclick="resetForm('category_modal_form')">Cancel
                </button>
            </div>
        </div>
    </div>
</div>

<%-- Add SubCategory Modal --%>
<div class="modal" id="sub_category_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Sub-Category</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" title="close"
                        onclick="resetForm('sub_category_modal_form')">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="sub_category_modal_form" class="needs-validation" novalidate>
                    <div class="form-label-group">
                        <input type="text" id="sub_category" name="sub_category" class="form-control"
                               placeholder="Sub-Category"
                               required=""
                               autofocus="">
                        <label for="sub_category">Sub-Category</label>
                    </div>
                    <div class="select-wrap">
                        <label>Category</label>
                        <div class="input-group">
                            <select class="form-control" id="select_category_" name="select_categroy_" required
                                    autofocus>
                                <jsp:include page="category_options.jsp"/>
                            </select>
                        </div>
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <button type="button" id="sub_category_button" class="btn btn-primary" onclick="saveSubCategory();">Save
                </button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal"
                        onclick="resetForm('sub_category_modal_form')">Cancel
                </button>
            </div>
        </div>
    </div>
</div>


<%-- Add Region Modal --%>
<div class="modal" id="region_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Region</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" title="close"
                        onclick="resetForm('region_modal_form')">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="region_modal_form" class="needs-validation" novalidate>
                    <div class="form-label-group">
                        <input type="text" id="region" name="region" class="form-control" placeholder="Region"
                               required=""
                               autofocus="">
                        <label for="region">Region</label>
                    </div>
                    <div class="form-label-group">
                        <input type="text" id="region_abb" name="region_abb" class="form-control"
                               placeholder="Abbreviation"
                               required=""
                               autofocus="">
                        <label for="region_abb">Abbreviation</label>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="region_button" class="btn btn-primary" onclick="saveRegion();">Save
                </button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal"
                        onclick="resetForm('region_modal_form')">Cancel
                </button>
            </div>
        </div>
    </div>
</div>

<%-- Add Employee Modal --%>
<div class="modal" id="employee_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Employee</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" title="close"
                        onclick="resetForm('employee_modal_form')">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="employee_modal_form" class="needs-validation" novalidate>
                    <div class="form-label-group">
                        <input type="text" id="name" name="name" class="form-control" placeholder="Name"
                               required="" autocomplete="off"
                               autofocus="">
                        <label for="name">Name</label>
                    </div>
                    <div class="form-label-group">
                        <input type="text" id="position" name="position" class="form-control" placeholder="Position"
                               required=""
                               autofocus="">
                        <label for="position">Position</label>
                    </div>
                    <div class="form-label-group">
                        <input type="number" id="staff_id" name="staff_id" class="form-control" placeholder="Staff ID"
                               required=""
                               autofocus="">
                        <label for="staff_id">Staff ID</label>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="select-wrap">
                                <label>Region</label>
                                <div class="input-group">
                                    <select class="form-control region_" id="region_select_employee" name="region" required
                                            autofocus>
                                        <jsp:include page="region_options.jsp"/>
                                    </select>
                                    <c:if test="${P_1}">
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
                    </div>
                    <div class="row">
                        <div id="location_section" class="col location_section"></div>
                    </div>
                    <div class="row">
                        <div id="department_section" class="col department_section"></div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="employee_button" class="btn btn-primary" onclick="saveEmployee();">Save
                </button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal"
                        onclick="resetForm('employee_modal_form')">Cancel
                </button>
            </div>
        </div>
    </div>
</div>


<%-- Add OS Modal --%>
<div class="modal" id="os_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Operating System</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" title="close"
                        onclick="resetForm('os_modal_form')">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="os_modal_form" class="needs-validation" novalidate>
                    <div class="form-label-group">
                        <input type="text" id="added_os" name="added_os" class="form-control"
                               placeholder="Operationg System"
                               required=""
                               autofocus="">
                        <label for="added_os">Operationg System</label>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="os_button" class="btn btn-primary" onclick="saveOS();">Save
                </button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal"
                        onclick="resetForm('os_modal_form')">Cancel
                </button>
            </div>
        </div>
    </div>
</div>