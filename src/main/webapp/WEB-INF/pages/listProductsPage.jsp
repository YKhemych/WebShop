<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<div class="container-fluid">
    <div class="row centered" >
        <div class="col-md-10 col-md-offset-1" style="height: 1000px;">
            <div class="row">

                <div class="page-header margin-0-10">
                    <h1>List of Product</h1>
                </div>

                <div class="col-md-3 margin-10-0 border-right-blond-grey" style="height: 900px">

                </div>

                <div class="col-md-9 margin-top-10px row" style="height: 900px">

                    <div class="margin-left-20px padding-0-10px border-bottom-blond-grey">
                        <h1> ${category.name} </h1>
                    </div>

                    <div class="padding-top-10px">
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <div class="col-xs-6 col-md-4">
                                <a href="/admin/productPage" class="thumbnail btn color-red">
                                    <span style="font-size: 100px" class="glyphicon glyphicon-plus vectors"></span>
                                    <p class="margin-top-10px">Додати продукт</p>
                                </a>
                            </div>
                        </sec:authorize>
                    </div>

                </div>





            </div>

        </div>
    </div>
</div>




<%@include file="template/footer.jsp"%>
