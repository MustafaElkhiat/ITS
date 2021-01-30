<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 5/12/2020
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../page_header.jsp">
    <jsp:param name="title" value="Add Account"/>
</jsp:include>
<div class="card mt-3">
    <div class="card-body">
        <form id="account_form" class="needs-validation" novalidate>
            <div class="row">
                <div class="col">
                    <div class="form-label-group">
                        <input type="text" id="account" name="account" class="form-control"
                               placeholder="Account"
                               required=""
                               autofocus="">
                        <label for="account">Account</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="offset-4 col-2">
                    <button type="reset" class="btn btn-secondary btn-full-width reset">Clear</button>
                </div>
                <div class="col-2">
                    <button type="button" id="add_account_submit" class="btn btn-primary btn-full-width">Submit</button>
                </div>
            </div>
        </form>
    </div>
</div>


