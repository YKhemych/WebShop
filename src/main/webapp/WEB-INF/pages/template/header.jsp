<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport", content="width=device-width, initial-scale=1">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title>Title</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%--<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-route.min.js"></script>--%>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/slider.css">
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid background-white">
        <div class="row">
            <div class="col-md-10 col-md-offset-1 row max-width-">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <!-- <span class="sr-only">Навигация</span> -->
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="/" class="navbar-brand ">Свій в світі покупок</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                    <ul class="nav navbar-nav navbar-right">
                        <li class="nav-menu-li"> <a href="" >Корзина</a></li>
                        <sec:authorize access="!isAuthenticated()">
                        <li class="nav-menu-li"> <a href="" class="" data-toggle="modal" data-target="#regictration">Регістрація</a>
                            <%@include file="registration.jsp"%>
                        </li>
                        <li class="nav-menu-li"> <a href="" class="" data-toggle="modal" data-target="#login">ВВійти</a>
                            <%@include file="login.jsp"%>
                        </li>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <li class="nav-menu-li"> <a href="/user/userPage" > <sec:authentication property="principal.username" /> </a> </li>
                            <li class="nav-menu-li"><a href="/logout">Вийти</a> </li>
                        </sec:authorize>
                    </ul>
                </div>

                <div>
                    <button class="btn btn-danger dropdown-toggle" data-toggle="dropdown">Каталог товарів <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <c:forEach items="${categorys}" var="category">
                            <li><a href="#">${category.name}</a></li>
                        </c:forEach>
                    </ul>



                        <div class="input-group navbar-right col-md-6">
                            <input type="text" class="form-control border-red background-white padding-left-20px" placeholder="Пошук по крамниці...">
                            <span class="input-group-btn">
                                <button class="btn btn-danger" type="button">Go!</button>
                            </span>

                            <%--<input type="text" class="width-400px border-red background-white padding-left-20px" placeholder="Пошук по крамниці...">--%>
                            <%--<input type="submit" value="Шукати" class="border-red background-white">--%>
                        </div>
                </div>

            </div>
        </div>
    </div>
</nav>

