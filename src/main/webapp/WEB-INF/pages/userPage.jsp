
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>


<div class="container-fluid">
    <div class="row centered">
        <div class="col-md-10 col-md-offset-1">
            <div class="page-header padding-left-20px">
                <h2>Особиста сторінка </h2>
            </div>
            <div class="row">
                <div class="border-blond-grey margin-0-10  padding-top-10px padding-left-20px padding-bottom-10px">
                    <p class="float-right"> <a href="#" class="color-red margin-0-10"> Редагувати </a></p>
                    <p class="float-left"> Логін: </p> <p id="userLogin"><sec:authentication property="principal.username"/></p>
                    <p> Електронна пошта: <sec:authentication property="principal.email"/></p>
                    <a href="#" class="color-red"> Змінити пароль </a>
                </div>
                <div id="divDeliveryAddress" class="border-blond-grey margin-0-10 padding-left-20px padding-bottom-10px">
                    <h3 class="padding-bottom-10px" >Адреса доставки</h3>
                    <p class="float-left margin-0-10"> Ім'я: </p> <p id="nameOfUser"><sec:authentication property="principal.name"/></p>
                    <p class="float-left margin-0-10"> Прізвище: </p> <p id="surnameOfUser"><sec:authentication property="principal.surname"/></p>
                    <p class="float-left margin-0-10"> Країна/Місто: </p> <p id="countryAndCity"><sec:authentication property="principal.country"/>,<sec:authentication property="principal.city"/></p>
                    <p class="float-left margin-0-10"> Вулиця/Поштовий індекс: </p> <p id="streetAndZipCode"><sec:authentication property="principal.street"/>,<sec:authentication property="principal.zipCode"/></p>
                    <p class="float-left margin-0-10"> Тел: </p> <p id="phoneOfUser"><sec:authentication property="principal.phone"/></p>
                    <a href="#" id="editDeliveryAddress" class="color-red margin-0-10"> Редагувати адресу доставки </a>
                </div>


            </div>

        </div>
    </div>
</div>

<script src="/js/userPage.js"></script>
<%@include file="template/footer.jsp"%>