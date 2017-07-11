
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>


<div class="container-fluid">
    <div class="row centered">
        <div class="col-md-10 col-md-offset-1 row">
            <div class="page-header padding-left-20px">
                <h2>Admin Page</h2>
            </div>


            <div class="col-md-2">
                <ul class="text-align-center nav ">
                    <li> <button id="category" class="col-md-12 btn btn-danger margin-top-10px" >Категорії</button> </li>
                    <li class=""> <button class="col-md-12 btn btn-danger margin-top-10px" > Слайдер </button> </li>

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
                            <td class="categoryId">${category.id}</td>
                            <td class="categoryName">${category.name}</td>
                            <td class="idFatherCategory">${category.idFatherCategoryes}</td>
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




<script id="234" src="/js/category.js" ></script>
<%@include file="template/footer.jsp"%>