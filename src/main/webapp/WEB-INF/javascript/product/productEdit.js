/**
 * Created by user on 01.08.2017.
 */

var numberOfPhoto = 0;
var $activeProduct;


$('#addPhotoToProduct').click(function () {
    if (numberOfPhoto < 10){
       numberOfPhoto += 1;
       $('#photoInfo').text(numberOfPhoto + " із 10");
       var bufElem = $('#productPhotoArea').append($('<div/>', {class: "row padding-top-10px"}));
       $('#productPhotoArea').children().last().append($('<input>',{id: "productPicture" + numberOfPhoto, form: "formForSaveProductPhoto", type: "file", accept: "image/*", name: "productPictureList", class: "col-md-10"}));
       $('#productPhotoArea').children().last().append($('<button/>',{class: "close col-md-1",text: "X", onclick: "deleteProductPicture(this)"}));
    }
});

function deleteProductPicture(obj) {
    numberOfPhoto--;
    $('#photoInfo').text(numberOfPhoto + " із 10");
    obj.parentNode.remove();
}

$('#selectTypeProduct label').click(function () {

    $('#saveProduct').removeAttr("disabled");

    $activeProduct = $(this);
    $('#selectTypeProduct').children().each(function () {
        $(this).removeAttr("disabled");
    })
    $activeProduct.attr("disabled", "true");

    $('#divProductColorLeans').remove();
    $('#divProductProtectionLevel').remove();
    $('#divProductMechanism').remove();
    $('#divProductGlass').remove();
    $('#divProductDialType').remove();
    $('#divProductWaterResistance').remove();

    if($activeProduct.text() == "Clock"){
        $('#createProductArea').append($('<div/>', {id: "divProductMechanism", class: "input-group col-md-12 margin-left-20px margin-top-10px"}));
            $('#divProductMechanism').append($('<p/>', {class: "font-size-20px input-group-addon", text: "Механізм"}));
            $('#divProductMechanism').append($('<input>',
                {id: "productMechanism", form:"formForSaveProductPhoto", type: "text", name: "productMechanism", class: "padding-left-20px form-control", placeholder: "Mechanism"}));
        $('#createProductArea').append($('<div/>', {id: "divProductGlass", class: "input-group col-md-12 margin-left-20px margin-top-10px"}));
            $('#divProductGlass').append($('<p/>', {class: "font-size-20px input-group-addon", text: "Скло"}));
            $('#divProductGlass').append($('<input>',
                {id: "productGlass", form:"formForSaveProductPhoto", type: "text", name: "productGlass", class: "padding-left-20px form-control", placeholder: "Glass"}));
        $('#createProductArea').append($('<div/>', {id: "divProductDialType", class: "input-group col-md-12 margin-left-20px margin-top-10px"}));
            $('#divProductDialType').append($('<p/>', {class: "font-size-20px input-group-addon", text: "Тип циферблату"}));
            $('#divProductDialType').append($('<input>',
                {id: "productDialType", form:"formForSaveProductPhoto", type: "text", name: "productDialType", class: "padding-left-20px form-control", placeholder: "Dial type"}));
        $('#createProductArea').append($('<div/>', {id: "divProductWaterResistance", class: "input-group col-md-12 margin-left-20px margin-top-10px"}));
            $('#divProductWaterResistance').append($('<p/>', {class: "font-size-20px input-group-addon", text: "Водостійкість"}));
            $('#divProductWaterResistance').append($('<input>',
                {id: "productWaterResistance", form:"formForSaveProductPhoto", type: "text", name: "productWaterResistance", class: "padding-left-20px form-control", placeholder: "Water resistance"}));
    }

    if ($activeProduct.text() == "SunGlass"){
        $('#createProductArea').append($('<div/>', {id: "divProductColorLeans", class: "input-group col-md-12 margin-left-20px margin-top-10px"}));
            $('#divProductColorLeans').append($('<p/>', {class: "font-size-20px input-group-addon", text: "Колір лінз"}));
            $('#divProductColorLeans').append($('<input>',
                {id: "productColorLeans", form:"formForSaveProductPhoto", type: "text", name: "productColorLeans", class: "padding-left-20px form-control", placeholder: "Color of the leans"}));
        $('#createProductArea').append($('<div/>', {id: "divProductProtectionLevel", class: "input-group col-md-12 margin-left-20px margin-top-10px"}));
            $('#divProductProtectionLevel').append($('<p/>', {class: "font-size-20px input-group-addon", text: "Клас захисту"}));
            $('#divProductProtectionLevel').append($('<input>',
                {id: "productProtectionLevel", form:"formForSaveProductPhoto", type: "text", name: "productProtectionLevel", class: "padding-left-20px form-control", placeholder: "Protection level"}));
    }


});

$('#saveProduct').click(function () {
    console.log("function Save Product");
    var categoryId = $('#categoryIdToAddProduct').text();

    $('#formForSaveProductPhoto').attr('action', "/saveProduct" + $activeProduct.text() + "ToCategory" + categoryId);

    $('#formForSaveProductPhoto').submit();

});

function sendToMainProductImage(obj) {
    console.log(obj);
    $('#mainProductImage').attr("src", obj.src);
    $('#mainProductImage').width($('#mainProductImage').parent().width());
}

$('#addOneProductToNumber').click(function () {
    if ($('#numberOfProduct').text() <= 99) {
        $('#numberOfProduct').text(+$('#numberOfProduct').text() + 1);
    }
});

$('#removeOneProductToNumber').click(function () {
    if ($('#numberOfProduct').text() >= 2){
        $('#numberOfProduct').text( +$('#numberOfProduct').text() - 1);
    }

});

$('#addProductToBasket').click(function () {

    if ($('#registeredUserName').text() == "null" || $('#registeredUserName').text() == ""){
        alert("Будь ласка зареєструйтесь або увійдіть")
    }else {
        var productId = $('#productId').text();
        var nameUserWhoOrderProduct = $('#registeredUserName').text();
        var numberOfProduct = $('#numberOfProduct').text();
        $.ajax({
            url: '/order-'+nameUserWhoOrderProduct+'Product'+productId + "-" + numberOfProduct,
            type: 'post',
            success : function () {
                alert("ok");
            },
            error : function () {
                alert("error");
            }
        });
    }


});

$(document).ready(function () {
    $('#mainProductImage').attr("src", $('#allProductPhoto').children().first().children().children().attr("src"));
    $('#mainProductImage').width($('#mainProductImage').parent().width());
})
