<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 2/15/2020
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="page_header.jsp">
    <jsp:param name="title" value="Edit Employee"/>
</jsp:include>
<jsp:include page="modals.jsp"/>
<input type="hidden" id="employee" value="${employee.id}"/>
<div class="card mt-3">
    <div class="card-body">
        <form id="edit_employee_form" method="post" class="needs-validation mx-3" novalidate>
            <div class="row mt-2">
                <div class="col mt-2">
                    <div class="form-label-group">
                        <input type="text" id="edit_name" name="name" class="form-control"
                               placeholder="Name" autocomplete="off"
                               required="" value="${employee.name}"
                               autofocus="">
                        <label for="edit_name">Name</label>
                    </div>
                </div>

                <div class="col mt-2">
                    <div class="form-label-group">
                        <input type="text" id="edit_position" name="position" class="form-control"
                               placeholder="Position" autocomplete="off"
                               required="" value="${employee.position}"
                               autofocus="">
                        <label for="edit_position">Position</label>
                    </div>
                </div>
                <div class="col mt-2">
                    <div class="form-label-group">
                        <input type="number" id="edit_staff_id" name="staff_id" class="form-control"
                               placeholder="Staff-ID" autocomplete="off"
                               required="" value="${employee.staffID}"
                               autofocus="">
                        <label for="edit_staff_id">Staff-ID</label>
                    </div>
                </div>


            </div>
            <div class="row">
                <div class="col-4">
                    <div class="select-wrap">
                        <label>Region</label>
                        <div class="input-group">
                            <select class="form-control region_" id="region_" name="region" required autofocus>
                                <jsp:include page="region_options.jsp">
                                    <jsp:param name="selected" value="${employee.locationDepartment.location.region.id}"/>
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
                <div id="location_section" class="col-4 location_section">
                    <jsp:include page="location_section.jsp">
                        <jsp:param name="selected" value="${employee.locationDepartment.location.id}"/>
                    </jsp:include>
                </div>
                <div id="department_section" class="col-4 department_section">
                    <jsp:include page="department_section.jsp">
                        <jsp:param name="selected" value="${employee.locationDepartment.department.id}"/>
                    </jsp:include>
                </div>
            </div>
            <div class="row">
                <div class="offset-4 col-2">
                    <button type="reset" class="btn btn-secondary btn-full-width reset">Clear</button>
                </div>
                <div class="col-2">
                    <button type="button" id="edit_employee_submit" class="btn btn-primary btn-full-width">Submit</button>
                </div>
            </div>
        </form>
    </div>
</div>