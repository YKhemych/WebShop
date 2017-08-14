<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<div class="container-fluid">
    <div class="row centered" >
        <div class="col-md-10 col-md-offset-1 border-blond-grey" style="height: 1000px;">
            <div class="row">

                <h1>Product Page</h1>

                <div class="col-md-5 col-xs-12 padding-top-10px padding-left-20px">
                    <img id="mainProductImage" src="" class="border-blond-grey" style="height: 250px; width: 320px">
                </div>

                <div class="col-md-7 col-xs-12">
                    <h1> Назва </h1>
                </div>
                <div></div>

                <sec:authorize access="hasRole('ROLE_ADMIN')">

                </sec:authorize>




            </div>

        </div>
    </div>
</div>




<%@include file="template/footer.jsp"%>