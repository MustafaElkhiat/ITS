<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 5/19/2020
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:include page="page_header.jsp">
    <jsp:param name="title" value="Weekly Report"/>
</jsp:include>
<div class="card mt-2">
    <div class="card-body">
        <div class="row">
            <div class="col-lg-4 col-sm-12">
                <div class="form-label-group mb-0">
                    <input id="actual_date"
                           autocomplete="off"
                           type="text" data-range="true"
                           data-multiple-dates-separator=" -- "
                           data-language="en" data-time-format='hh:ii AA'
                           placeholder="Select Weekly Report Date Range"
                           class="datepicker-here form-control" readonly/>

                    <label for="actual_date">Weekly Report Date Range</label>
                </div>
            </div>


        </div>
    </div>
</div>
<div id="preview">
</div>