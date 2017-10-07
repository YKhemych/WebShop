
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>


<div class="container-fluid" style="min-height: 600px">
    <div class="row centered">
        <div class="col-md-10 col-md-offset-1">
            <div class="page-header padding-left-20px">
                <h2 class="">Особиста сторінка </h2>
            </div>
            <div class="row">
                <div id="mainCharacteristics" class="border-blond-grey padding-top-10px padding-left-20px padding-bottom-10px">
                    <p class="float-right"> <a id="editEmail" class="color-red margin-0-10"> Редагувати </a></p>
                    <p class="float-left margin-0-10"> Логін: </p> <p id="userLogin"><sec:authentication property="principal.username"/></p>
                    <div id="divForEmail">
                        <p class="float-left margin-0-10"> Електронна пошта: </p> <p id="userEmail" class=""> <sec:authentication property="principal.email"/></p>
                    </div>
                    <a id="substitutePassword" class="color-red margin-0-10"> Змінити пароль </a>
                </div>
                <div id="divDeliveryAddress" class="border-blond-grey margin-top-10px padding-left-20px padding-bottom-10px">
                    <h3 class="padding-bottom-10px" >Адреса доставки</h3>
                    <p class="float-left margin-0-10"> Ім'я: </p> <p id="nameOfUser"><sec:authentication property="principal.name"/></p>
                    <p class="float-left margin-0-10"> Прізвище: </p> <p id="surnameOfUser"><sec:authentication property="principal.surname"/></p>
                    <p class="float-left margin-0-10"> Країна/Місто: </p> <p id="countryAndCity"><sec:authentication property="principal.country"/>,<sec:authentication property="principal.city"/></p>
                    <p class="float-left margin-0-10"> Вулиця/Поштовий індекс: </p> <p id="streetAndZipCode"><sec:authentication property="principal.street"/>,<sec:authentication property="principal.zipCode"/></p>
                    <p class="float-left margin-0-10"> Тел: </p> <p id="phoneOfUser"><sec:authentication property="principal.phone"/></p>
                    <a id="editDeliveryAddress" class="color-red margin-0-10"> Редагувати адресу доставки </a>
                </div>


            </div>

        </div>
    </div>
</div>

<script src="/js/userPage.js"></script>
<%@include file="template/footer.jsp"%>