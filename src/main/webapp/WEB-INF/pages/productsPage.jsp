<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<div class="container-fluid">
    <div class="row centered" style="height: 1000px;">
        <div class="col-md-10 col-md-offset-1">
            <div class="row">

                <h1>Product Page</h1>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <div class="col-xs-6 col-md-2">
                        <a href="#" class="thumbnail btn">
                            <span class="glyphicon glyphicon-plus vectors"></span>
                            <p>Додати продукт</p>
                        </a>
                    </div>
                </sec:authorize>




            </div>

        </div>
    </div>
</div>




<%@include file="template/footer.jsp"%>
