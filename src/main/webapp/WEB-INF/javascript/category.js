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


function createCategoryTable() {
    $('#category').attr("disabled", "true");
    var $workspace = $('#workspace');
    $workspace.empty();


    $workspace.append($('<table/>', {class: "table table-striped"}));
    $('.table').append($('<thead/>', {class: "thead"}));
    $('.thead').append($('<tr/>', {class: "tr"}));
    $('.thead tr').append("<th>Id</th>");
    $('.thead tr').append("<th>Ім'я категорії</th>");
    $('.thead tr').append("<th>Id бат/кат</th>");
    $('.table').append($('<tbody/>', {class: "tbody"}));


    $.ajax({
        url: '/allCategory',
        type: 'get',
        success : function (result) {

            $(result).each(function () {
                $('.tbody').append($('<tr/>', {id: this.id}));
                $("#"+this.id).append($('<td/>', {class: "categoryId", text: `${this.id}`}));
                $("#"+this.id).append($('<td/>', {class: "categoryName", text: `${this.name}`}));
                $("#"+this.id).append($('<td/>', {class: "idFatherCategory", text: `${this.idFatherCategoryes}`}));
            });

            $('.tbody').append($('<tr/>', {id: result.length + 1}));
            $("#"+(result.length + 1)).append($('<td/>', {class: "categoryId", text: "#"}));
            $("#"+(result.length + 1)).append($('<td/>', {id: "thForCategoryName", class: "categoryName"}));
            $('#thForCategoryName').append($('<input>', {id: "categoryName", type: "text", name: "categoryName", class: ""}));
            $("#"+(result.length + 1)).append($('<td/>', {id: "thForIdFatherCategory", class: "idFatherCategory"}));
            $('#thForIdFatherCategory').append($('<input>', {id: "idFatherCategory", type: "text", name: "idFatherCategory", class: ""}));
            $("#"+(result.length + 1)).append($('<td/>', {id:"thForButton"}));
            $('#thForButton').append($('<button/>', {id: "saveCategory", class: "btn btn-danger",text: "Додати"}));

            $.getScript("/js/category.js");

        },
        error : function () {
            alert("error");
        }
    });
};
$('#category').click(createCategoryTable);


$('#saveCategory').click(function () {
    console.log("hello111");
    var categoryName = $('#categoryName').val();
    var idFatherCategory = $('#idFatherCategory').val();
    var category = {name: categoryName, idFatherCategoryes: idFatherCategory};
    var jsonCategory = JSON.stringify(category);

    $.ajax({
        url: '/saveCategory',
        type: 'post',
        contentType: 'application/json',
        data : jsonCategory,
        success : function () {
            alert("ok");
            createCategoryTable();
        },
        error : function () {
            alert("!!!!");
        }
    });

});

var n = 0;
var $bChange = $('<button/>', {id: "change", class: "btn btn-danger btn-sm",text: "Enter"});
var $bClose = $('<button/>', {id: "close", class: "btn btn-danger btn-sm",text: "X"});
var $tdBuff = $('<td/>');
var buffText;

$('td').click(function () {

    if ( ($(this).attr("class").includes("categoryName") && !$(this).parent().children().first().text().includes("#"))
        || ($(this).attr("class").includes("idFatherCategory") && !$(this).parent().children().first().text().includes("#")) ){
        n++;
        console.log(n);
        if ( n==1 ){
            $('#saveCategory').attr("disabled", "true");

            $tdBuff = $(this);
            buffText = $(this).html();
            // console.log(buffText);

            $(this).parent().append($('<td/>', {id: "buffer"}));
            $(this).parent().children().last().append($bChange);
            $(this).parent().children().last().append($bClose);

            $(this).empty();
            $(this).replaceWith($tdBuff);
            $(this).append($('<input>', {type: "text"}));
            // $(this).replaceWith("<td><input type='text'></td>");


        }
    }

});

$bChange.click(function () {
    // workChange = false;
    n=0;



    $('#saveCategory').removeAttr("disabled");
    console.log("change");

});

$bClose.click(function () {
    n=0;
    $tdBuff.empty();
    $tdBuff.text(buffText);
    $('#buffer').remove();
    $.getScript("/js/category.js")


    $('#saveCategory').removeAttr("disabled");
    console.log("close");
});

