<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<div class="container-fluid">
    <div class="row centered" >
        <div class="col-md-10 col-md-offset-1">
            <div class="row">

                <div class="col-md-3 margin-10-0 border-right-blond-grey">

                </div>

                <div class="col-md-9 margin-top-10px row">

                    <div class="margin-left-20px padding-0-10px border-bottom-blond-grey">
                        <h1> ${fatherCategory.name} </h1>
                    </div>

                    <div class="padding-top-10px">

                        <c:forEach items="${productList}" var="product">
                            <div class="col-xs-6 col-md-4 padding-0-10px">
                                <a href="/productWithId${product.id}" class="thumbnail btn padding-0">
                                    <c:forEach items="${product.photos}" var="photo" end="0">
                                            <img src="${photo.picture}" class="img-responsive width-100prc">
                                    </c:forEach>
                                    <div class="caption display-block">
                                        <h4 class="white-space-pre-wrap">${product.name}</h4>
                                        <p class="color-red">${product.price} грн</p>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>




                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <div class="col-xs-6 col-md-4 padding-0-10px">
                                <a href="/admin/addProductToCategory-${fatherCategory.id}" class="thumbnail btn color-red padding-0">
                                    <span style="font-size: 100px" class="glyphicon glyphicon-plus"></span>
                                    <p class="margin-top-10px">Додати продукт</p>
                                </a>
                            </div>
                        </sec:authorize>
                    </div>

                    <div class="btn-toolbar col-md-12" role="toolbar">
                        <div class="btn-group col-md-4 col-offset-md-4 ">
                            <button type="button" class="btn background-white color-red padding-top-10px"><span class="glyphicon glyphicon-chevron-left font-size-20px"></span></button>
                            <button type="button" class="btn background-white color-red font-size-20px"> 1 </button>
                            <button type="button" class="btn background-white color-red padding-top-10px"><span class="glyphicon glyphicon-chevron-right font-size-20px"></span></button>
                        </div>
                    </div>

                </div>



            </div>

        </div>
    </div>
</div>




<%@include file="template/footer.jsp"%>
