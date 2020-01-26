<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 12/19/2019
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="card mt-3">
    <div class="card-body">
        <table class="table table-bordered table-striped table my-4" width="100%">
            <tbody>
            <tr>
                <th>Category</th>
                <td>${ticket.subCategory.category.category}</td>
                <th>Sub-Category</th>
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
        </table>
    </div>
</div>
