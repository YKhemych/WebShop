
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>


<div class="container-fluid">
    <div class="row centered">
        <div class="col-md-10 col-md-offset-1 row">
            <div class="page-header padding-left-20px">
                <h2>Admin Page</h2>
            </div>


            <div class="col-md-2 padding-bottom-10px">
                <ul class="text-align-center nav ">
                    <li> <button id="category" class="col-md-12 btn btn-danger margin-top-10px" >Категорії</button> </li>
                    <li> <button id="mainSlider" class="col-md-12 btn btn-danger margin-top-10px" > Слайдер </button> </li>

                </ul>

            </div>
            <div id="workspace" class="col-md-10 padding-bottom-10px">


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




<script src="/js/adminCategory.js" ></script>
<%@include file="template/footer.jsp"%>