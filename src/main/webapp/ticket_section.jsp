<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 12/21/2019
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="card mt-3">
    <div class="card-body">
        <div class="row">
            <div id="${param.user}_ticket_chart" class="col-lg-4 col-sm-12">

            </div>
            <div class="col-lg-8 col-sm-12">
                <jsp:include page="ticket_tab_header.jsp"/>
                <jsp:include page="ticket_tab_content.jsp"/>
            </div>

        </div>

    </div>
</div>

<script>
    initialValues("${param.user}");
    loadTicketChart("${param.user}");
    assign_to_tab("${param.user}");
    in_progress_tab("${param.user}");
    pending_tab("${param.user}");
    solved_tab("${param.user}");
    need_to_solve_tab("${param.user}");

</script>