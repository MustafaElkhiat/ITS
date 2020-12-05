<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/29/2020
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="card mt-3">
    <div class="card-body">
        <div class="row">
            <div id="ticket_chart" class="col-lg-4 col-sm-12">

            </div>
            <div class="col-lg-8 col-sm-12">
                <jsp:include page="../new_ticket/ticket_tab_header.jsp"/>
                <jsp:include page="../new_ticket/ticket_tab_content.jsp">
                    <jsp:param name="type" value="user"/>
                </jsp:include>
            </div>

        </div>

    </div>
</div>
