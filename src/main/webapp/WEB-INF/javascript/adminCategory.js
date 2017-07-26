/**
 * Created by user on 09.07.2017.
 */
$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});

// var Edit= false;
// var Delete= false;
//
// $("#markToEditCategory").click(function () {
//     $('#markToEditCategory').attr("disabled", "true");
//     $('#markToDeleteCategory').removeAttr("disabled");
//     Edit = true;
//     Delete = false;
//     $('#confirmationDeleteCategory').addClass("visibility-hidden");
// });
// $("#markToDeleteCategory").click(function () {
//     $('#markToDeleteCategory').attr("disabled", "true");
//     $('#markToEditCategory').removeAttr("disabled");
//     Edit = false;
//     Delete = true;
//     // $("#moreFunction").append($('<button/>', {id: "confirmationDelete", class: "btn btn-danger",text: "Підтвердити видалення"}));
//     $('#confirmationDeleteCategory').removeClass("visibility-hidden");
//
// });

//                                      ---Category---

function createCategoryTable() {
    $('#category').attr("disabled", "true");
    var $workspace = $('#workspace');
    $('#categoryDiv').remove();


    $workspace.append($('<div/>',{id:"categoryDiv", class: "row margin-top-10px padding-top-10px border-blond-grey"}));
        $('#categoryDiv').append($('<div/>', {id:"categoryFunction", class: "col-md-11"}));

            $('#categoryFunction').append($('<div/>',{id:"mainCategoryFunction", class: "btn-group float-left padding-0-10px"}));
                $('#mainCategoryFunction').append($('<label/>',{class: "btn btn-danger", text: "  Редагування"}));
                    $('#mainCategoryFunction').children().last().prepend($('<input>',{type:"radio", name:"options", id:"markToEditCategory"}));
                $('#mainCategoryFunction').append($('<label/>',{class: "btn btn-danger ", text: "  Видалення"}));
                    $('#mainCategoryFunction').children().last().prepend($('<input>',{type:"radio", name:"options", id:"markToDeleteCategory"}));

            $('#categoryFunction').append($('<div/>',{id:"additionCategoryFunction", class: "btn-sm"}));
                $('#additionCategoryFunction').append($('<button/>',{id:"confirmationDeleteCategory", class:"btn btn-danger visibility-hidden", text:"Підтвердити видалення"}));

        $('#categoryDiv').append($('<div/>',{id:"categoryDivClose", class: "col-md-1"}));
            $('#categoryDivClose').append($('<button/>',{id: "closeCategoryDiv", class: "close",text: "X"}));

        $('#categoryDiv').append($('<div/>',{id:"categoryDivTable", class: "col-md-11"}));
            $('#categoryDivTable').append($('<table/>',{id: "categoryTable", class: "table"}));
                $('#categoryTable').append($('<thead/>',{id: "categoryThead"}));
                    $('#categoryThead').append($('<tr/>',{class: "tr"}));
                        $('#categoryThead tr').append("<th>Id</th>");
                        $('#categoryThead tr').append("<th>Ім'я категорії</th>");
                        $('#categoryThead tr').append("<th>Id бат/кат</th>");
                $('#categoryTable').append($('<tbody/>',{id: "categoryTbody"}));

        $.ajax({
            url: '/allCategory',
            type: 'get',
            success : function (result) {
                var lastId;
                $(result).each(function () {
                    $('#categoryTbody').append($('<tr/>', {id: "categ" + this.id}));
                        $("#"+ "categ" + this.id).append($('<td/>',{class: "categoryId", text: `${this.id}`}));
                        $("#"+ "categ" + this.id).append($('<td/>',{class: "categoryName", text: `${this.name}`}));
                        $("#"+ "categ" + this.id).append($('<td/>',{class: "idFatherCategory", text: `${this.idFatherCategoryes}`}));
                        lastId = this.id;
                });
                $('#categoryTbody').append($('<tr/>',{id:"categ" + (lastId + 1)}));
                    $("#"+ "categ" + (lastId +1)).append($('<td/>',{class: "categoryId", text: "#"}));
                    $("#"+ "categ" + (lastId + 1)).append($('<td/>',{id: "thForCategoryName", class: "categoryName"}));
                        $('#thForCategoryName').append($('<input>',{id: "categoryName", type: "text", name: "categoryName", class: ""}));
                    $("#"+ "categ" + (lastId + 1)).append($('<td/>',{id: "thForIdFatherCategory", class: "idFatherCategory"}));
                        $('#thForIdFatherCategory').append($('<input>',{id: "idFatherCategory", type: "text", name: "idFatherCategory", class: ""}));
                    $("#"+ "categ" + (lastId + 1)).append($('<td/>',{id:"thForCategoryButton",  class: ""}));
                        $('#thForCategoryButton').append($('<button/>',{id: "saveCategory", class: "btn btn-danger",text: "Додати"}));

                    // $('#categoryDiv').append($('<script>', {src: "/js/category/categoryEdit.js"}));
                    $.getScript("/js/category/categoryEdit.js");

            },
            error : function () {
                alert("error");
            }
        });
};
$('#category').click(createCategoryTable);

//                                      ---Slider---

function createSliderTable() {
    $('#mainSlider').attr("disabled", "true");
    var $workspace = $('#workspace');
    $('#sliderDiv').remove();
    // $workspace.empty();


    $workspace.append($('<div/>',{id:"sliderDiv", class: "row margin-top-10px padding-top-10px border-blond-grey"}));
        $('#sliderDiv').append($('<div/>', {id:"sliderFunction", class: "col-md-11"}));

            $('#sliderFunction').append($('<div/>',{id:"mainSliderFunction", class: "btn-group float-left padding-0-10px"}));
                $('#mainSliderFunction').append($('<label/>',{class: "btn btn-danger", text: "  Редагування"}));
                $('#mainSliderFunction').children().last().prepend($('<input>',{type:"radio", name:"options", id:"markToEditSlider"}));
                $('#mainSliderFunction').append($('<label/>',{class: "btn btn-danger ", text: "  Видалення"}));
                $('#mainSliderFunction').children().last().prepend($('<input>',{type:"radio", name:"options", id:"markToDeleteSlider"}));

            $('#sliderFunction').append($('<div/>',{id:"additionSliderFunction", class: "btn-sm"}));
                $('#additionSliderFunction').append($('<button/>',{id:"confirmationDeleteSlide", class:"btn btn-danger visibility-hidden", text:"Підтвердити видалення"}));

        $('#sliderDiv').append($('<div/>',{id:"sliderDivClose", class: "col-md-1"}));
            $('#sliderDivClose').append($('<button/>',{id: "closeSliderDiv", class: "close",text: "X"}));

        $('#sliderDiv').append($('<div/>',{id:"sliderDivTable", class: "col-md-11"}));
            $('#sliderDivTable').append($('<table/>',{id: "sliderTable", class: "table"}));
                $('#sliderTable').append($('<thead/>',{id: "sliderThead"}));
                    $('#sliderThead').append($('<tr/>',{class: "tr"}));
                    $('#sliderThead tr').append("<th>Id</th>");
                    $('#sliderThead tr').append("<th>Ім'я слайду</th>");
                    $('#sliderThead tr').append("<th>Слайд</th>");
                $('#sliderTable').append($('<tbody/>',{id: "sliderTbody"}));

        $.ajax({
            url: '/allSlide',
            type: 'get',
            success : function (result) {
                var lastId;
                $(result).each(function () {
                    $('#sliderTbody').append($('<tr/>', {id: "slide" + this.id}));
                    $("#"+ "slide" + this.id).append($('<td/>',{class: "slideId", text: `${this.id}`}));
                    $("#"+ "slide" + this.id).append($('<td/>',{class: "slideName", text: `${this.name}`}));
                    $("#"+ "slide" + this.id).append($('<td/>',{class: "slidePicture"}));
                    $("#"+ "slide" + this.id + " .slidePicture").append($('<img>', {src: `${this.picture}`, class: "height-200px width-400px"}))
                    lastId = this.id;
                });
                $('#sliderTbody').append($('<tr/>',{id:"slide" + (lastId + 1)}));
                    $("#"+ "slide" + (lastId +1)).append($('<td/>',{class: "slideId", text: "#"}));
                    $("#"+ "slide" + (lastId + 1)).append($('<td/>',{id: "thForSlideName", class: "slideName"}));
                        $('#thForSlideName').append($('<input>',{id: "slideName", type: "text", name: "slideName", class: ""}));
                    $("#"+ "slide" + (lastId + 1)).append($('<td/>',{id: "thForSlidePicture", class: "slidePicture"}));
                        $('#thForSlidePicture').append($('<input>',{id: "slidePicture", type: "file", name: "slidePicture", class: ""}));
                    $("#"+ "slide" + (lastId + 1)).append($('<td/>',{id:"thForSliderButton",  class: ""}));
                        $('#thForSliderButton').append($('<button/>',{id: "saveSlide", class: "btn btn-danger",text: "Додати"}));

                // $('#categoryDiv').append($('<script>', {src: "/js/category/categoryEdit.js"}));
                $.getScript("/js/slider/sliderEdit.js");

            },
            error : function () {
                alert("error");
            }
        });
};
$('#mainSlider').click(createSliderTable);




