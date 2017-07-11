
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>


<div class="container-fluid">
    <div class="row centered">
        <div class="col-md-10 col-md-offset-1 row">
            <div class="page-header padding-left-20px">
                <h2>Admin Page</h2>
            </div>


            <div class="col-md-2 border-red padding-0-10px">
                <ul class="text-align-center nav nav-pills nav-stacked">
                    <li class="border-bottom-red-1px"> <a href="">Категорії</a> </li>
                    <li class=""> <a href=""> Слайдер </a> </li>

                </ul>

            </div>

            <div id="workspace" class="col-md-9 col-md-offset-1">

                <table class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Ім'я категорії</th>
                            <th>Id бат/кат</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${categorys}" var="category">
                        <tr>
                            <td>${category.id}</td>
                            <td>${category.name}</td>
                            <td>${category.idFatherCategoryes}</td>
                        </tr>
                    </c:forEach>
                        <tr>
                            <td>#</td>
                            <td><input id="categoryName" type="text" name="categoryName"></td>
                            <td><input id="idFatherCategory" type="text" name="idFatherCategory"></td>
                            <td><button id="saveCategory">Додати</button></td>
                        </tr>
                    </tbody>
                </table>

                    <%--<input id="categoryName" type="text" name="categoryName">--%>
                    <%--<input id="idFatherCategory" type="text" name="idFatherCategory">--%>
                    <%--<button id="saveCategory">Додати</button>--%>


                <form action="/create/saveStockSlide" method="post" enctype="multipart/form-data">
                    <input type="text" name="slideName">
                    <input type="file" name="picture">
                    <input type="submit">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                </form>


            </div>

        </div>
    </div>
</div>




<script src="/js/category.js" ></script>
<%@include file="template/footer.jsp"%>