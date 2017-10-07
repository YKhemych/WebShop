<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<div class="container-fluid">
    <div class="row centered" >
        <div class="col-md-10 col-md-offset-1">
            <div class="row">
                <div class="col-md-12 margin-top-10px row">

                    <div class="padding-0-10px border-bottom-blond-grey col-md-12 col-xs-12">
                        <h1 class="float-left font-size-25px col-md-12 col-xs-12"> ${fatherCategory.name} </h1>
                        <h1 id="activeCategoryId" class="visibility-hidden float-left margin-0" style="font-size: 0px">${fatherCategory.id}</h1>
                    </div>

                    <div id="allProductsOnProductPage" class="padding-10px-0 col-md-12">

                        <c:forEach items="${productList}" var="product">
                            <div class="col-xs-6 col-md-3 padding-0-10px">
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
                            <div class="col-xs-6 col-md-3 padding-0-10px">
                                <a href="/admin/addProductToCategory-${fatherCategory.id}" class="thumbnail btn color-red padding-0">
                                    <span style="font-size: 100px" class="glyphicon glyphicon-plus"></span>
                                    <p class="margin-top-10px">Додати продукт</p>
                                </a>
                            </div>
                        </sec:authorize>
                    </div>

                    <div class="btn-toolbar col-md-12 row" role="toolbar">
                            <ul id="pagination" class="pagination">
                                <li>
                                    <a id="aPreviousPage" <c:if test="${productPage != 0}">
                                                            href ="productsWithCategory-${fatherCategory.id}-Page-${productPage - 1}"
                                                        </c:if> class="" >&laquo;</a>
                                </li>
                                <c:if test="${productPage > 2}">
                                    <li><a href="productsWithCategory-${fatherCategory.id}-Page-0" class="text-danger"> 1 </a></li>
                                </c:if>
                                <c:if test="${productPage > 1}">
                                    <li><a href="productsWithCategory-${fatherCategory.id}-Page-${productPage - 2}" class="text-danger"> ${productPage - 1} </a></li>
                                </c:if>
                                <c:if test="${productPage > 0}">
                                    <li><a href="productsWithCategory-${fatherCategory.id}-Page-${productPage - 1}" class="text-danger"> ${productPage} </a></li>
                                </c:if>

                                <li class="active"><a id="activePage" href="" class="color-red background-red">${productPage + 1}</a></li>

                                <c:if test="${(maxPage - productPage) > 2}">
                                    <li><a href="productsWithCategory-${fatherCategory.id}-Page-${productPage + 1}" class="text-danger"> ${productPage + 2} </a></li>
                                </c:if>
                                <c:if test="${(maxPage - productPage) > 3}">
                                    <li><a href="productsWithCategory-${fatherCategory.id}-Page-${productPage + 2}" class="text-danger"> ${productPage + 3} </a></li>
                                </c:if>
                                <c:if test="${productPage + 1 != maxPage}">
                                    <li><a id="maxPage" href="productsWithCategory-${fatherCategory.id}-Page-${maxPage - 1}" class="text-danger"> ${maxPage} </a></li>
                                </c:if>
                                <li>
                                    <a id="aNextPage" <c:if test="${productPage + 1 != maxPage}">
                                                        href="productsWithCategory-${fatherCategory.id}-Page-${productPage + 1}"
                                                    </c:if> class="">&raquo;</a>
                                </li>

                            </ul>

                    </div>

                </div>



            </div>

        </div>
    </div>
</div>




<%@include file="template/footer.jsp"%>
