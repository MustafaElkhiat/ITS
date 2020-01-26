<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 11/6/2019
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="card mt-2">
    <div class="card-body">
        <h5 class="card-title">In Progress</h5>

        <div class="form-group row mx-0 my-2 form-label-group">

            <textarea rows="3" class="form-control" id="notes"
                      name="notes" required></textarea>
            <label for="notes">Notes</label>

        </div>
        <div class="row">
            <div class="offset-10 col-2">
                <button type="button" id="action_submit" class="btn btn-primary btn-full-width">Submit</button>
            </div>
        </div>
    </div>
</div>
