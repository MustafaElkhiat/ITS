<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 5/9/2020
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="checkbox-wrap">
    <label class="title">Accessory</label>
    <c:forEach items="${accessoryList}" var="accessory">
        <c:set var="not_break" value="true"/>
        <c:set var="vendor" value=""/>
        <c:set var="vendor_col" value="d-none"/>
        <c:set var="phone_num" value=""/>
        <c:set var="phone_col" value="d-none"/>
        <c:set var="serial_num" value=""/>
        <c:set var="serial_col" value="d-none"/>
        <div class="row">
            <div class="col-4">
                <div class="input-group inline_flex mx-2 my-1">
                    <div class="input-group-prepend">
                        <div class="input-group-text">
                            <input type="checkbox" class="accessory_checkbox" value="${accessory.id}"
                            <c:forEach items="${employeeAccessoryList}" var="employeeAccessory">
                            <c:if test="${not_break && employeeAccessory.accessory.id == accessory.id}">
                                <c:set var="vendor" value="${employeeAccessory.vendor}"/>
                                <c:set var="vendor_col" value=""/>
                            <c:if test="${accessory.id == 1 || accessory.id == 2}">
                                <c:set var="phone_num" value="${employeeAccessory.phoneNumber}"/>
                                <c:set var="phone_col" value=""/>
                            </c:if>
                            <c:if test="${accessory.id == 3 || accessory.id == 4}">
                                <c:set var="serial_num" value="${employeeAccessory.serialNumber}"/>
                                <c:set var="serial_col" value=""/>
                            </c:if>

                                <c:set var="not_break" value="false"/>
                                   checked
                            </c:if>
                            </c:forEach>
                            >
                        </div>
                    </div>
                    <label class="form-control">${accessory.accessory}
                    </label>

                </div>
            </div>
            <div class="col-4 vendor_col ${vendor_col}">
                <div class="form-label-group my-1">
                    <input type="text" id="vendor" name="vendor" class="form-control vendor" placeholder="Vendor"
                           autocomplete="off" value="${vendor}" autofocus="">
                    <label for="vendor">Vendor</label>
                </div>
            </div>
            <div class="col-4 serial_col ${serial_col}">
                <div class="form-label-group my-1">
                    <input type="text" id="serial_num" name="serial_num" class="form-control serial_num"
                           placeholder="Serial Number" autocomplete="off" value="${serial_num}"
                           autofocus="">
                    <label for="serial_num">Serial Number</label>
                </div>
            </div>
            <div class="col-4 phone_col ${phone_col}">
                <div class="form-label-group my-1">
                    <input type="text" id="phone_num" name="phone_num" class="form-control phone_num"
                           placeholder="Phone Number"
                           autocomplete="off" value="${phone_num}" autofocus="">
                    <label for="phone_num">Phone Number</label>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
