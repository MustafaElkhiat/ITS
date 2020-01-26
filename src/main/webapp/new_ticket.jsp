<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/6/2019
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="modals.jsp"/>
<jsp:include page="page_header.jsp">
    <jsp:param name="title" value="New Ticket"/>
</jsp:include>

<div class="row mt-3">
    <div class="col-lg-6 col-sm-12 my-auto">
        <jsp:include page="device_selection_card.jsp"/>
    </div>
    <div id="device_info" class="col-lg-6 col-sm-12 my-auto">

    </div>
</div>
<form id="sub_category_form" class="needs-validation" novalidate>
    <div class="row">
        <div id="problem_comment_section" class="col-12"></div>
    </div>
    <div class="row">
        <div id="action_section" class="col-lg-2">

        </div>
        <div id="action_detail_section" class="col-lg-10">

        </div>
    </div>
</form>