<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 12/26/2019
  Time: 1:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="tab-content ${param.style}" id="myTabContent">
    <div class="tab-pane fade show active" id="${param.user}-assign-to" role="tabpanel" aria-labelledby="${param.user}-assign-to-tab">
    </div>
    <div class="tab-pane fade" id="${param.user}-in-progress" role="tabpanel" aria-labelledby="${param.user}-in-progress-tab">
    </div>
    <div class="tab-pane fade" id="${param.user}-pending" role="tabpanel" aria-labelledby="${param.user}-pending-tab"></div>
    <div class="tab-pane fade" id="${param.user}-solved" role="tabpanel" aria-labelledby="${param.user}-solved-tab"></div>
    <div class="tab-pane fade" id="${param.user}-need-to-solve" role="tabpanel" aria-labelledby="${param.user}-need-to-solve-tab"></div>
    <div class="tab-pane fade" id="${param.user}-closed" role="tabpanel" aria-labelledby="${param.user}-closed-tab"></div>
    <div class="tab-pane fade" id="${param.user}-need-to-close" role="tabpanel" aria-labelledby="${param.user}-need-to-close-tab"></div>
</div>
