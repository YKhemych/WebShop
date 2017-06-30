
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="login" class="modal fade" tabindex="-1">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header background-dark-grey color-white">
                <button class="close" data-dismiss="modal">х</button>
                <h4 class="modal-title">Вхід</h4>
            </div>

            <div class="modal-body background-dark-grey color-white">
                <form action="/logMe" method="post" class="row">
                    <input type="text" name="username" class="col-md-10 col-md-offset-1 padding-left-20px border-red margin-10-0 color-white background-dark-grey" placeholder="User Name">
                    <br>
                    <input type="password" name="password" class="col-md-10 col-md-offset-1 padding-left-20px border-red color-white background-dark-grey" placeholder="Password">
                    <br>
                    <input type="submit" class="col-md-10 col-md-offset-1 border-red background-dark-grey margin-10-0" value="ВВійти">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                </form>
            </div>

        </div>
    </div>
</div>
