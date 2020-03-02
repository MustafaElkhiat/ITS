<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/5/2019
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card mt-2">

    <div class="card-body">

        <div class="row">
            <div class="col-lg-4 col-sm-12">
                <div class="form-label-group mb-md-2 mb-0">
                    <input type="text" id="caller_name" name="caller_name" class="form-control"
                           placeholder="Caller Name"
                           required=""
                           autofocus="">
                    <label for="caller_name">Caller Name</label>
                </div>
            </div>
            <div class="col-lg-4 col-sm-12">
                <div class="form-label-group mb-0 mb-md-2">
                    <input type="number" id="caller_num" name="caller_num" class="form-control"
                           placeholder="Caller Number"
                           required="">
                    <label for="caller_num">Caller Number</label>
                </div>
            </div>
            <div class="col-lg-4 col-sm-12">
                <div class="form-label-group mb-0">
                    <input id="actual_date"
                           autocomplete="off"
                           type="text"
                           data-language="en" data-timepicker="true" data-time-format='hh:ii AA'
                           placeholder="Select Actual Date"
                           class="datepicker-here form-control" readonly/>

                    <label for="actual_date">Actual Date</label>
                </div>
            </div>
        </div>
        <div class="form-group row mx-0 my-2 form-label-group">

            <textarea rows="3" class="form-control" id="problem"
                      name="problem" required></textarea>
            <label for="problem">Problem</label>

        </div>
        <div class="row">
            <div class="col-lg-6 col-sm-12">
                <div class="select-wrap mb-md-2 mb-0">
                    <label>Category</label>
                    <div class="input-group">
                        <select class="form-control" id="category_" name="category" required>
                            <jsp:include page="category_options.jsp"/>

                        </select>
                        <c:if test="${P_11}">  <%-- 11 Add Catgory--%>
                            <div class="input-group-append">
                                <button class="btn btn-outline-primary" type="button" data-toggle="modal"
                                        data-target="#category_modal"><i class="fas fa-plus"></i></button>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
            <div id="sub_category_section" class="col-lg-6 col-sm-12">

            </div>
        </div>
        <div class="form-group row mx-0 my-2 form-label-group">

            <textarea rows="3" class="form-control" id="comment"
                      name="comment"></textarea>
            <label for="comment">Comment</label>

        </div>
    </div>
</div>