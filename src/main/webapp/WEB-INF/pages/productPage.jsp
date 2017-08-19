<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<div class="container-fluid">
    <div class="row centered" >
        <div class="col-md-10 col-md-offset-1 border-blond-grey">
            <div class="row">

                <div class="col-md-5 col-xs-12 padding-top-10px border-right-blond-grey margin-10-0" style="height: 500px">
                    <div class="col-xs-10 col-md-10 col-md-offset-1 col-xs-offset-1 margin-bottom-50px">
                        <img id="mainProductImage" src="" class="border-blond-grey img-responsive">
                    </div>
                    <div id="allProductPhoto">
                        <c:forEach items="${pictures}" var="photo">
                            <div class="col-xs-6 col-md-3">
                                <a href="#" class="thumbnail listPhotoProduct">
                                    <img src="${photo.picture}" class="img-responsive" onclick="sendToMainProductImage(this)">
                                </a>
                            </div>
                        </c:forEach>
                    </div>

                </div>

                <div id="createProductArea" class="col-md-7 col-xs-12 row padding-top-10px padding-left-20px font-size-20px">
                    <sec:authorize access="hasRole('ROLE_ADMIN')"><h1 class="padding-left-20px">Id: ${product.id}</h1></sec:authorize>
                    <h1 class="padding-left-20px">${product.name}</h1>
                    <h5 class="padding-left-20px padding-bottom-10px border-bottom-blond-grey "> Виробник: ${product.maker}</h5>
                    <div class="col-md-12">
                        <h3 class="color-red padding-left-20px float-left col-md-4 margin-top-10px">${product.price} грн </h3>
                        <div class="col-md-3 padding-top-10px ">
                            <a id="addOneProductToNumber" class="float-right"><span class="glyphicon glyphicon-chevron-right font-size-20px color-red"></span></a>
                            <h4 id="numberOfProduct" class="float-right margin-0 font-size-25px">1</h4>
                            <a id="removeOneProductToNumber" class="float-right"><span class="glyphicon glyphicon-chevron-left font-size-20px color-red"></span></a>
                        </div>

                        <button id="addProductToBasket" class="btn btn-danger col-md-5 margin-top-5px">
                            <span class="glyphicon glyphicon-shopping-cart col-md-3 padding-0"> </span>
                            Додати в корзину
                        </button>
                    </div>
                    <h3 class="col-md-11 col-md-offset-1 padding-top-10px padding-left-20px">
                        <span class="glyphicon glyphicon-gift font-size-20px padding-0-10px"></span>Безкоштовна доставка
                    </h3>
                    <div class="padding-left-20px col-md-12">
                        <h3 class=" border-bottom-blond-grey padding-bottom-10px padding-left-20px"> Деталі </h3>

                        <p> Матеріал: ${product.material}</p>
                        <p> Колір: ${product.color}</p>
                        <p> Розмір: ${product.size}</p>
                        <p> Тип: ${product.type}</p>
                        <c:if test="${DTYPE == 'class jv.entity.listProducts.SunGlass'}">
                            <p> Колір лінз: ${product.colorLeans}</p>
                            <p> Рівень захисту: ${product.protectionLevel}</p>
                        </c:if>
                        <c:if test="${DTYPE == 'class jv.entity.listProducts.Clock'}">
                            <p> Механізм: ${product.mechanism}</p>
                            <p> Скло: ${product.glass}</p>
                            <p> Тип циферблату: ${product.dialType}</p>
                            <p> Водонепроникність: ${product.waterResistance}</p>
                        </c:if>
                        <p> Опис: ${product.description}</p>

                    </div>

                    <div class="padding-left-20px col-md-12">
                        <h3 class=" border-bottom-blond-grey padding-bottom-10px padding-left-20px"> Повернення </h3>
                        <p class="padding-bottom-10px"> У разі якщо доставлений клієнту товар виявився невідповідного розміру або неналежної якості внаслідок виробничого браку, покупець має право повернути його, або обміняти на аналогічний товар належної якості, за умови наявності його на складі. </p>
                        <h5> Вимога про заміну товару задовольняється протягом 14 днів з моменту отримання. </h5>

                    </div>
                    <div class="padding-left-20px col-md-12">
                        <h3 class=" border-bottom-blond-grey padding-bottom-10px padding-left-20px"> Оплата і доставка </h3>

                        <h5> Доставка по Україні: </h5>
                        <p> Доставка по Україні здійснюється Новою Поштою. Доставка безкоштовна.
                            Терміни доставки 2-7 робочих днів.</p>
                        <h5> Оплата при отриманні: </h5>
                        <p> Оплата при отриманні Новою Поштою можлива за умови замовлення послуги "Накладний платіж" під час оформлення замовлення. Також Ви можете оплатити товар готівкою при отриманні у фізичному магазині."</p>

                    </div>
                    <div class="padding-left-20px col-md-12">
                        <h3 class=" border-bottom-blond-grey padding-bottom-10px padding-left-20px"> Коментарі </h3>

                    </div>

                    <p id="productId" class="padding-left-20px visibility-hidden">${product.id}</p>

                </div>


                <sec:authorize access="hasRole('ROLE_ADMIN')">

                </sec:authorize>




            </div>

        </div>
    </div>
</div>



<script src="/js/product/productEdit.js"></script>

<%@include file="template/footer.jsp"%>