<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="basket" class="modal fade" tabindex="-1">
    <div id="modal-basket" class="modal-dialog modal-lg">
        <div class="modal-content background-dark-grey color-white">

            <div class="modal-header ">
                <button id="closeBasket" class="close color-white" data-dismiss="modal">X</button>
                <h4 class="modal-title">Корзина</h4>
            </div>

            <div id="basketBody" class="modal-body">
            </div>

            <div class="modal-footer ">
                <div class="col-md-3 float-left">
                    <h4 class="float-right">грн</h4>
                    <h4 id="priceToPay" class="color-red float-right padding-0-10px">0</h4>
                </div>
                <button id="orderAProduct" class="btn btn-danger col-md-3" <%--data-dismiss="modal"--%>>Замовити</button>
            </div>
        </div>
    </div>
</div>
