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
       $('#productPhotoArea').children().last().append($('<input>',{id: "productPicture" + numberOfPhoto, type: "file", name: "productPicture", class: "col-md-10"}));
       $('#productPhotoArea').children().last().append($('<button/>',{class: "close col-md-1",text: "X", onclick: "deleteProductPicture(this)"}));
    }
});

function deleteProductPicture(obj) {
    numberOfPhoto--;
    $('#photoInfo').text(numberOfPhoto + " із 10");
    obj.parentNode.remove();
}

$('#selectTypeProduct label').click(function () {

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
                {id: "productMechanism", type: "text", name: "productMechanism", class: "padding-left-20px form-control", placeholder: "Mechanism"}));
        $('#createProductArea').append($('<div/>', {id: "divProductGlass", class: "input-group col-md-12 margin-left-20px margin-top-10px"}));
            $('#divProductGlass').append($('<p/>', {class: "font-size-20px input-group-addon", text: "Скло"}));
            $('#divProductGlass').append($('<input>',
                {id: "productGlass", type: "text", name: "productGlass", class: "padding-left-20px form-control", placeholder: "Glass"}));
        $('#createProductArea').append($('<div/>', {id: "divProductDialType", class: "input-group col-md-12 margin-left-20px margin-top-10px"}));
            $('#divProductDialType').append($('<p/>', {class: "font-size-20px input-group-addon", text: "Тип циферблату"}));
            $('#divProductDialType').append($('<input>',
                {id: "productDialType", type: "text", name: "productDialType", class: "padding-left-20px form-control", placeholder: "Dial type"}));
        $('#createProductArea').append($('<div/>', {id: "divProductWaterResistance", class: "input-group col-md-12 margin-left-20px margin-top-10px"}));
            $('#divProductWaterResistance').append($('<p/>', {class: "font-size-20px input-group-addon", text: "Водостійкість"}));
            $('#divProductWaterResistance').append($('<input>',
                {id: "productWaterResistance", type: "text", name: "productWaterResistance", class: "padding-left-20px form-control", placeholder: "Water resistance"}));
    }

    if ($activeProduct.text() == "SunGlass"){
        $('#createProductArea').append($('<div/>', {id: "divProductColorLeans", class: "input-group col-md-12 margin-left-20px margin-top-10px"}));
            $('#divProductColorLeans').append($('<p/>', {class: "font-size-20px input-group-addon", text: "Колір лінз"}));
            $('#divProductColorLeans').append($('<input>',
                {id: "productColorLeans", type: "text", name: "productColorLeans", class: "padding-left-20px form-control", placeholder: "Color of the leans"}));
        $('#createProductArea').append($('<div/>', {id: "divProductProtectionLevel", class: "input-group col-md-12 margin-left-20px margin-top-10px"}));
            $('#divProductProtectionLevel').append($('<p/>', {class: "font-size-20px input-group-addon", text: "Клас захисту"}));
            $('#divProductProtectionLevel').append($('<input>',
                {id: "productProtectionLevel", type: "text", name: "productProtectionLevel", class: "padding-left-20px form-control", placeholder: "Protection level"}));
    }


});