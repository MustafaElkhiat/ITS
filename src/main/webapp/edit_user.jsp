<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 1/21/2020
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="page_header.jsp">
    <jsp:param name="title" value="Edit User"/>
</jsp:include>
<input type="hidden" id="user" value="${user.id}"/>
<div class="card mt-3">
    <div class="card-body">
        <form id="create_user_form" method="post" class="needs-validation mx-3" novalidate>
            <div class="row mt-2">
                <div class="col-3 mt-2">
                    <div class="form-label-group">
                        <input type="text" id="name" name="name" class="form-control"
                               placeholder="Name" autocomplete="off"
                               required="" value="${user.name}"
                               autofocus="">
                        <label for="name">Name</label>
                    </div>
                </div>

                <div class="col-3 mt-2">
                    <div class="form-label-group">
                        <input type="text" id="username" name="username" class="form-control"
                               placeholder="UserName" autocomplete="off"
                               required="" value="${user.userName}"
                               autofocus="">
                        <label for="username">UserName</label>
                    </div>
                </div>
                <div class="col-3 mt-2">
                    <div class="form-label-group">
                        <input type="number" id="phone_num" name="phone_num" class="form-control"
                               placeholder="Phone Number" autocomplete="off"
                               required="" value="${user.phoneNum}"
                               autofocus="">
                        <label for="phone_num">Phone Number</label>
                    </div>
                </div>

                <div class="col-3 ">
                    <div class="select-wrap">
                        <label>Role</label>
                        <div class="input-group">
                            <select class="form-control" id="role" name="role"
                                    autofocus>
                                <jsp:include page="role_options.jsp">
                                    <jsp:param name="selected" value="${user.role.id}"/>
                                </jsp:include>

                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <jsp:include page="region_card.jsp"/>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <jsp:include page="privilege_card.jsp"/>
                </div>
            </div>
            <div class="row">
                <div class="offset-4 col-2">
                    <button type="reset" class="btn btn-secondary btn-full-width reset">Clear</button>
                </div>
                <div class="col-2">
                    <button type="button" id="edit_user_submit" class="btn btn-primary btn-full-width">Submit</button>
                </div>
            </div>


        </form>

    </div>
</div>