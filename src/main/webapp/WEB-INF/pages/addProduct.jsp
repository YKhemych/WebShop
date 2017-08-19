<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<div class="container-fluid">
    <div class="row centered" >
        <div class="col-md-10 col-md-offset-1 border-blond-grey">
            <div class="row padding-bottom-10px">

                <p id="categoryIdToAddProduct" class="visibility-hidden">${categoryId}</p>

                <div class="page-header padding-left-20px margin-0-10">
                    <h2>Add Product</h2>
                    <div id="selectTypeProduct" class="btn-group padding-0-10px">
                        <label class="btn btn-danger">Bag</label>
                        <label class="btn btn-danger">Wallet</label>
                        <label class="btn btn-danger">Wristband</label>
                        <label class="btn btn-danger">Scarf</label>
                        <label class="btn btn-danger">Hat</label>
                        <label class="btn btn-danger">SunGlass</label>
                        <label class="btn btn-danger">Gloves</label>
                        <label class="btn btn-danger">Strap</label>
                        <label class="btn btn-danger">Clock</label>
                    </div>
                </div>

                <div class="col-md-5 col-xs-12 padding-top-10px padding-left-20px border-right-blond-grey margin-10-0" style="height: 500px">
                    <div class="col-xs-6 col-md-6 col-md-offset-3 col-xs-offset-3">
                        <a id="addPhotoToProduct" class="thumbnail btn color-red">
                            <span style="font-size: 50px" class="glyphicon glyphicon-picture"></span>
                            <p class="margin-top-10px">Додати фото</p>
                        </a>
                    </div>
                    <div class="col-md-3">
                        <p id="photoInfo">0 із 10</p>
                    </div>
                    <form id="formForSaveProductPhoto" action="" method="post"
                          enctype="multipart/form-data" accept-charset="UTF-8">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    </form>
                    <div id="productPhotoArea">

                    </div>
                </div>

                <div id="createProductArea" class="col-md-7 col-xs-12 row padding-top-10px padding-left-20px font-size-20px">
                    <div id="divProductName" class="input-group col-md-12 margin-left-20px margin-top-10px">
                        <p class="font-size-20px input-group-addon">Назва</p>
                        <input id="productName" form="formForSaveProductPhoto" type="text" name="productName" class="padding-left-20px form-control" placeholder="Name">
                    </div>
                    <div id="divProductMaker" class="input-group col-md-12 margin-left-20px margin-top-10px">
                        <p class="font-size-20px input-group-addon">Виробник</p>
                        <input id="productMaker" form="formForSaveProductPhoto" type="text" name="productMaker" class="padding-left-20px form-control" placeholder="Maker">
                    </div>
                    <div id="divProductPrice" class="input-group col-md-12 margin-left-20px margin-top-10px">
                        <p class="font-size-20px input-group-addon">Ціна</p>
                        <input id="productPrice" form="formForSaveProductPhoto" type="text" name="productPrice" class="padding-left-20px form-control" placeholder="Price">
                    </div>
                    <div id="divProductColor" class="input-group col-md-12 margin-left-20px margin-top-10px">
                        <p class="font-size-20px input-group-addon">Колір</p>
                        <input id="productColor" form="formForSaveProductPhoto" type="text" name="productColor" class="padding-left-20px form-control" placeholder="Color">
                    </div>
                    <div id="divProductSize" class="input-group col-md-12 margin-left-20px margin-top-10px">
                        <p class="font-size-20px input-group-addon">Розмір</p>
                        <input id="productSize" form="formForSaveProductPhoto" type="text" name="productSize" class="padding-left-20px form-control" placeholder="Size">
                    </div>
                    <div id="divProductMaterial" class="input-group col-md-12 margin-left-20px margin-top-10px">
                        <p class="font-size-20px input-group-addon">Матеріал</p>
                        <input id="productMaterial" form="formForSaveProductPhoto" type="text" name="productMaterial" class="padding-left-20px form-control" placeholder="Material">
                    </div>
                    <div id="divProductType" class="input-group col-md-12 margin-left-20px margin-top-10px">
                        <p class="font-size-20px input-group-addon">Тип</p>
                        <input id="productType" form="formForSaveProductPhoto" type="text" name="productType" class="padding-left-20px form-control" placeholder="Type">
                    </div>
                    <div id="divProductDescription" class="input-group col-md-12 margin-left-20px margin-top-10px">
                        <p class="font-size-20px input-group-addon">Опис</p>
                        <input id="productDescription" form="formForSaveProductPhoto" type="text" name="productDescription" class="padding-left-20px form-control" placeholder="Description">
                    </div>




                </div>

                <div class="padding-0-10px">
                    <button id="saveProduct" disabled="disabled" class="btn btn-danger float-right margin-top-50px"> Додати продукт </button>
                </div>

                <sec:authorize access="hasRole('ROLE_ADMIN')">

                </sec:authorize>




            </div>

        </div>
    </div>
</div>


<script src="/js/product/productEdit.js"></script>

<%@include file="template/footer.jsp"%>
