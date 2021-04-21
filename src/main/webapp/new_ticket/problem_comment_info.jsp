<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 12/19/2019
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<div id="problem_comment_info">
    <div class="card mt-3">
        <div class="card-body">
            <i class="sr-only fas fa-2x fa-edit float-right link p-2"></i>
            <i class="sr-only fas fa-2x fa-eye float-right link p-2"></i>
            <i class="sr-only fas fa-2x fa-eye-slash float-right link p-2"></i>
            <table class="table table-bordered table-striped table my-4" width="100%">
                <tbody>
                <tr>
                    <th>Category</th>
                    <td id="category" category-id="${ticket.subCategory.category.id}">${ticket.subCategory.category.category}</td>
                    <th>Sub-Category</th>
                    <td id="sub_category" sub-category-id="${ticket.subCategory.id}">${ticket.subCategory.sub_category}</td>
                </tr>
                <tr>
                    <th>Problem</th>
                    <td colspan="3" id="problem">${ticket.problem}</td>
                </tr>
                <tr>
                    <th>Comment</th>
                    <td colspan="3" id="comment">${ticket.comment}</td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>--%>
<c:set var="label"/>
<c:choose>
    <c:when test="${showFromTicket}">
        <c:set var="label" value="Edited"/>
    </c:when>
    <c:otherwise>
        <c:set var="label" value="Created"/>

    </c:otherwise>
</c:choose>
<div id="problem_comment_info">
    <div class="card mt-3">
        <div class="card-body">
            <i class="sr-only fas fa-2x fa-edit float-right link p-2"></i>
            <c:if test="${not empty editedProblemCommentModificationList || showFromTicket}">
                <i class="sr-only fas fa-2x fa-eye float-right link p-2"></i>
                <i class="sr-only fas fa-2x fa-eye-slash float-right link p-2"></i>
            </c:if>
            <table class="table table-bordered table-striped table my-4" width="100%">
                <tbody>
                <tr>
                    <th width="15%">Category</th>
                    <td width="35%" id="category"
                        category-id="${subCategory.category.id}">${subCategory.category.category}</td>
                    <th width="15%">Sub-Category</th>
                    <td id="sub_category" sub-category-id="${subCategory.id}">${subCategory.sub_category}</td>
                </tr>
                <tr>
                    <th>Problem</th>
                    <td colspan="3" id="problem">${problem}</td>
                </tr>
                <tr>
                    <th>Comment</th>
                    <td colspan="3" id="comment">${comment}</td>
                </tr>

                </tbody>
                <tfoot>
                <tr>
                    <td colspan="4" class="py-1" style="font-size:12px;text-align:right !important;">${label} By ${user}
                        - ${date} ${time}</td>
                </tr>
                </tfoot>
            </table>
            <div id="edited_problem_comment" class="sr-only">
                <c:if test="${not empty editedProblemCommentModificationList}">
                    <c:forEach items="${editedProblemCommentModificationList}" var="edited">
                        <table class="table table-bordered table-striped table my-4" width="100%" style="opacity:0.5;">
                            <tbody>
                            <tr>
                                <th width="15%">Category</th>
                                <td width="35%">${edited.subCategory.category.category}</td>
                                <th width="15%">Sub-Category</th>
                                <td>${edited.subCategory.sub_category}</td>
                            </tr>
                            <tr>
                                <th>Problem</th>
                                <td colspan="3">${edited.problem}</td>
                            </tr>
                            <tr>
                                <th>Comment</th>
                                <td colspan="3">${edited.comment}</td>
                            </tr>

                            </tbody>
                            <tfoot>
                            <tr>
                                <td colspan="4" class="py-1" style="font-size:12px;text-align:right !important;">Edited
                                    By ${edited.user.name}
                                    - ${edited.date} ${edited.time}</td>
                            </tr>
                            </tfoot>
                        </table>

                    </c:forEach>
                </c:if>
                <c:if test="${showFromTicket}">
                    <table class="table table-bordered table-striped table my-4" width="100%" style="opacity:0.5;">
                        <tbody>
                        <tr>
                            <th width="15%">Category</th>
                            <td width="35%">${ticket.subCategory.category.category}</td>
                            <th width="15%">Sub-Category</th>
                            <td>${ticket.subCategory.sub_category}</td>
                        </tr>
                        <tr>
                            <th>Problem</th>
                            <td colspan="3">${ticket.problem}</td>
                        </tr>
                        <tr>
                            <th>Comment</th>
                            <td colspan="3">${ticket.comment}</td>
                        </tr>

                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="4" class="py-1" style="font-size:12px;text-align:right !important;">Created
                                By ${ticket.l1_user.name}
                                - ${ticket.startDate} ${ticket.startTime}</td>
                        </tr>
                        </tfoot>
                    </table>
                </c:if>
            </div>
        </div>
    </div>
</div>
