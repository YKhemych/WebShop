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

function createCategoryTable() {
    $('#category').attr("disabled", "true");
    var $workspace = $('#workspace');
    $workspace.empty();


    $workspace.append($('<div/>',{id:"categoryDiv", class: "row padding-top-10px border-blond-grey"}));
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
            $('#categoryDivTable').append($('<table/>',{class: "table"}));
                $('.table').append($('<thead/>',{class: "thead"}));
                    $('.thead').append($('<tr/>',{class: "tr"}));
                        $('.thead tr').append("<th>Id</th>");
                        $('.thead tr').append("<th>Ім'я категорії</th>");
                        $('.thead tr').append("<th>Id бат/кат</th>");
                $('.table').append($('<tbody/>',{class: "tbody"}));
        // $('.table').append($('<button/>', {id: "markToDelete", class: "btn btn-danger btn-sm",text: "Позначити для видалення"}));

        $.ajax({
            url: '/allCategory',
            type: 'get',
            success : function (result) {
                var lastId;
                $(result).each(function () {
                    $('.tbody').append($('<tr/>', {id: this.id}));
                        $("#"+this.id).append($('<td/>',{class: "categoryId", text: `${this.id}`}));
                        $("#"+this.id).append($('<td/>',{class: "categoryName", text: `${this.name}`}));
                        $("#"+this.id).append($('<td/>',{class: "idFatherCategory", text: `${this.idFatherCategoryes}`}));
                        lastId = this.id;
                });
                $('.tbody').append($('<tr/>',{id: lastId + 1}));
                    $("#"+(lastId +1)).append($('<td/>',{class: "categoryId", text: "#"}));
                    $("#"+(lastId + 1)).append($('<td/>',{id: "thForCategoryName", class: "categoryName"}));
                        $('#thForCategoryName').append($('<input>',{id: "categoryName", type: "text", name: "categoryName", class: ""}));
                    $("#"+(lastId + 1)).append($('<td/>',{id: "thForIdFatherCategory", class: "idFatherCategory"}));
                        $('#thForIdFatherCategory').append($('<input>',{id: "idFatherCategory", type: "text", name: "idFatherCategory", class: ""}));
                    $("#"+(lastId + 1)).append($('<td/>',{id:"thForButton",  class: ""}));
                        $('#thForButton').append($('<button/>',{id: "saveCategory", class: "btn btn-danger",text: "Додати"}));

                    // $('#categoryDiv').append($('<script>', {src: "/js/category/categoryEdit.js"}));
                    $.getScript("/js/category/categoryEdit.js");

            },
            error : function () {
                alert("error");
            }
        });
};
$('#category').click(createCategoryTable);







