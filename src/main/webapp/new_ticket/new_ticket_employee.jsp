<%--
  Created by IntelliJ IDEA.
  User: Eng. Mustafa Elkhiat
  Date: 3/30/21
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../page_header.jsp">
    <jsp:param name="title" value="New Ticket"/>
</jsp:include>
<form id="sub_category_form" class="needs-validation" novalidate>
    <div class="row">
        <div class="col-lg-6 col-sm-12">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Select Device</h5>
                    <div class="row">
                        <div class="col">
                            <div class="select-wrap">
                                <label>Device</label>
                                <div class="input-group">
                                    <select class="form-control device" id="device" name="device" required autofocus>
                                        <jsp:include page="../select_options/employee_device_options.jsp"/>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div id="device_info" class="my-auto">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="problem_section" class="col-lg-6 col-sm-12 sr-only">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Problem</h5>
                    <div class="row">
                        <div class="col">
                            <div class="form-group row mx-0 my-2 form-label-group">

                            <textarea rows="16" class="form-control" id="problem"
                                      name="problem" required></textarea>
                                <label for="problem">Problem</label>

                            </div>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="offset-3 col-3">
                            <button type="reset" class="btn btn-secondary btn-full-width reset">Clear</button>
                        </div>
                        <div class="col-3">
                            <button type="button" id="new_ticket_employee_submit"
                                    class="btn btn-primary btn-full-width">Submit
                            </button>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </div>
</form>