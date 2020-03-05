<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 12/26/2019
  Time: 1:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="page_header.jsp">
    <jsp:param name="title" value="My Tickets"/>
</jsp:include>
<div class="card mt-3">
    <div class="card-body">
        <div class="row">
            <div class="col-12">
                <jsp:include page="ticket_tab_header.jsp"/>
                <jsp:include page="ticket_tab_content.jsp"/>
            </div>

        </div>

    </div>
</div>
<script>
    initialValues("${param.user}");
    assign_to_details_tab("${param.user}");
    in_progress_details_tab("${param.user}");
    pending_details_tab("${param.user}");
    solved_details_tab("${param.user}");
    need_to_solve_details_tab("${param.user}");
    closed_details_tab("${param.user}");
    need_to_close_details_tab("${param.user}");
</script>