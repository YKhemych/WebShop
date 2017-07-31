<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<div class="container-fluid">
    <div class="row centered" >
        <div class="col-md-10 col-md-offset-1 border-blond-grey" style="height: 1000px;">
            <div class="row">

                <h1>Product Page</h1>

                <div class="col-md-4 col-xs-12">
                    <img id="mainProductImage" src="">
                </div>

                <div class="col-md-8 col-xs-12">

                </div>

                <sec:authorize access="hasRole('ROLE_ADMIN')">

                </sec:authorize>




            </div>

        </div>
    </div>
</div>




<%@include file="template/footer.jsp"%>