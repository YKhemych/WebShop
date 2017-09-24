
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<div id="myCarousel" class="carousel slide" data-interval="3000" data-ride="carousel">
    <ol class="carousel-indicators">
            <c:set var="n" value="0"/>
            <c:forEach items="${stockSliders}" var="stockSlider">
                <li data-target="#myCarousel" data-slide-to="${stockSlider.id}" <c:if test="${n == 0}">class="active"</c:if> >
                    <p class="visibility-hidden">${n = n+1} </p>
                </li>
            </c:forEach>
    </ol>
    <div class="carousel-inner">
        <c:set var="n" value="0"/>
        <c:forEach items="${stockSliders}" var="stockSlider">
            <div class <c:if test="${n == 0}">="item active" </c:if>
            <c:if test="${n > 0}">="item" </c:if> >
                <div class="carousel-caption" style="width: auto;">
                    <a>
                        <p class="visibility-hidden">${n = n + 1} </p>
                        <img src="${stockSlider.picture}" alt="">
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
    <a class="carousel-control left" href="#myCarousel" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left color-red"></span>
    </a>
    <a class="carousel-control right" href="#myCarousel" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right color-red"></span>
    </a>
</div>

<div class="container-fluid">
    <div class="row centered">
        <div class="col-md-10 col-md-offset-1">
            <div class="col-md-12 padding-0">
                <div class="col-md-12 padding-0">
                    <h2 class="col-md-12 text-align-left color-red padding-10px-0 border-bottom-blond-grey"> Нові товари </h2>
                    <div id="newProducts" class="col-md-12 padding-0" >
                        <c:forEach items="${newProducts}" var="newProduct">
                            <div class="col-xs-6 col-md-2 padding-0-10px">
                                <a href="/productWithId${newProduct.id}" class="thumbnail btn padding-0">
                                    <c:forEach items="${newProduct.photos}" var="photo" end="0">
                                        <img src="${photo.picture}" class="img-responsive width-100prc">
                                    </c:forEach>
                                    <div class="caption display-block">
                                        <h6 class="white-space-pre-wrap padding-bottom-10px margin-0">${newProduct.name}</h6>
                                        <p class="color-red margin-0">${newProduct.price} грн</p>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>


                <div class="col-md-12 padding-0" >
                    <h2 class="col-md-12 text-align-left color-red padding-10px-0 border-bottom-blond-grey"> Популярні товари </h2>
                    <div id="popularProducts" class="col-md-12 padding-0" >
                        <c:forEach items="${popularProducts}" var="product">
                            <div class="col-xs-6 col-md-2 padding-0-10px">
                                <a href="/productWithId${product.id}" class="thumbnail btn padding-0">
                                    <c:forEach items="${product.photos}" var="photo" end="0">
                                        <img src="${photo.picture}" class="img-responsive width-100prc">
                                    </c:forEach>
                                    <div class="caption display-block">
                                        <h6 class="white-space-pre-wrap">${product.name}</h6>
                                        <p class="color-red">${product.price} грн</p>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>

            </div>

        </div>
    </div>
</div>




<%@include file="template/footer.jsp"%>
