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

$('#category').click(createCategoryTable);
function createCategoryTable () {
    $('#category').attr("disabled", "true");
    var $workspace = $('#workspace');
    $workspace.empty();

    $workspace.append($('<table/>', {class: "table"}));
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
            $("#"+(result.length + 1)).append("<td>#</td>");
            $("#"+(result.length + 1)).append($('<td/>', {id: "thForCategoryName"}));
            $('#thForCategoryName').append($('<input>', {id: "categoryName", type: "text", name: "categoryName"}));
            $("#"+(result.length + 1)).append($('<td/>', {id: "thForIdFatherCategory"}));
            $('#thForIdFatherCategory').append($('<input>', {id: "idFatherCategory", type: "text", name: "idFatherCategory"}));
            $("#"+(result.length + 1)).append($('<td/>', {id:"thForButton"}));
            $('#thForButton').append($('<button>', {id: "saveCategory", class: "btn btn-danger",text: "Додати"}));

            $.getScript("/js/category.js");

        },
        error : function () {
            alert("error");
        }
    });
};



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
        },
        error : function () {
            alert("!!!!");
        }
    });
    createCategoryTable();
});

var n = 0;

$('td').click(function () {
    n++;

    if ( n == 1){
        console.log("hello222");
        $(this).replaceWith("<td><input type='text'></td>");
    }
    // var $input = $('<input>', {type: "text"});

    // $(this).css("background", "red");

    // var $table = $('<table/>');
    // $table.innerHTML("")
});
