<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 12/22/2019
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="ticket_report.jsp"/>
<form id="edit_modal_form" class="needs-validation" novalidate>
    <div class="row">
        <div id="action_section" class="col-lg-2">
            <jsp:include page="action_section.jsp"/>
        </div>
        <div id="action_detail_section" class="col-lg-10">

        </div>
    </div>
</form>