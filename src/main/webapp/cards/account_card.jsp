<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 5/12/2020
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="checkbox-wrap">
    <label class="title">Account</label>
    <c:forEach items="${accountList}" var="account">
        <c:set var="not_break" value="true"/>
        <c:set var="username" value="" />
        <c:set var="username_col" value="d-none"/>

        <div class="row">
            <div class="col-4">
                <div class="input-group inline_flex mx-2 my-1">
                    <div class="input-group-prepend">
                        <div class="input-group-text">
                            <input type="checkbox" class="account_checkbox" value="${account.id}"
                            <c:forEach items="${employeeAccountList}" var="employeeAccount">
                            <c:if test="${not_break && employeeAccount.account.id == account.id}">
                                <c:set var="username" value="${employeeAccount.username}" />
                                <c:set var="username_col" value=""/>
                                <c:set var="not_break" value="false"/>
                                   checked
                            </c:if>
                            </c:forEach>
                            >
                        </div>
                    </div>
                    <label class="form-control">${account.account}
                    </label>

                </div>
            </div>
            <div class="col-4 username_col ${username_col}">
                <div class="form-label-group my-1">
                    <input type="text" id="username" name="username" class="form-control username" placeholder="Username"
                           autocomplete="off" value="${username}" autofocus="">
                    <label for="username">Username</label>
                </div>
            </div>

        </div>
    </c:forEach>
</div>
