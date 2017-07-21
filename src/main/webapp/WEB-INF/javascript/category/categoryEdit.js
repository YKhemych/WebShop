/**
 * Created by user on 14.07.2017.
 */

var n = 0;
var $bChange = $('<button/>', {id: "change", class: "btn btn-danger btn-sm",text: "Enter"});
var $bClose = $('<button/>', {id: "closeChange", class: "btn btn-danger btn-sm",text: "X"});
var $tdBuff;
var buffText;
var deleteCategoryArr = [];
var lenghtCategoryArr = deleteCategoryArr.length;


$('td').click(function () {
    if ( Edit == true && Delete == false ) {

        if (($(this).attr("class").includes("categoryName") && !$(this).parent().children().first().text().includes("#"))
            || ($(this).attr("class").includes("idFatherCategory") && !$(this).parent().children().first().text().includes("#"))) {
            n++;
            // console.log(n);
                if (n == 1) {
                    $('#saveCategory').attr("disabled", "true");

                    $tdBuff = $(this);
                    buffText = $(this).html();
                    // console.log(buffText);

                    $(this).parent().append($('<td/>', {id: "buffer"}));
                    $(this).parent().children().last().append($bChange);
                    $(this).parent().children().last().append($bClose);

                    $tdBuff.empty();
                    $tdBuff.append($('<input>', {id: "newNameCategory", type: "text"}));

                    $.getScript("/js/category/categoryTableEdit.js");
                    // $(this).replaceWith("<td><input type='text'></td>");

                }
            }

    }
    if ( Edit == false && Delete == true ) {
        if (!$(this).parent().children().first().text().includes("#")){
            if(!deleteCategoryArr.includes($(this).parent().children().first().text())){
                console.log(lenghtCategoryArr);
                deleteCategoryArr[lenghtCategoryArr]= $(this).parent().children().first().text();
                console.log(deleteCategoryArr);
                $(this).parent().addClass("background-delete");
                lenghtCategoryArr++;

            }else{
                $(this).parent().removeClass("background-delete");
                for (var i = 0; i < deleteCategoryArr.length; i++) {
                    if (deleteCategoryArr[i] == $(this).parent().children().first().text()){
                        console.log("delete -"+deleteCategoryArr[i]);
                        delete deleteCategoryArr[i];
                    }
                }

            }
        }
    }

});



$('#saveCategory').click(function () {
    console.log("hello111");
    var categoryName = $('#categoryName').val();
    var idFatherCategory = $('#idFatherCategory').val();
    var category = {name: categoryName, idFatherCategoryes: idFatherCategory};
    var jsonCategorySave = JSON.stringify(category);

    $.ajax({
        url: '/saveCategory',
        type: 'post',
        contentType: 'application/json',
        data : jsonCategorySave,
        success : function () {
            alert("ok");
            createCategoryTable();
        },
        error : function () {
            alert("!!!!");
        }
    });

});

function closeCategoryDiv() {
    $('#workspace').empty();
    $('#category').removeAttr("disabled");
    deleteCategoryArr = [];
    lenghtCategoryArr = 0;
    console.log("closeDiv");
}
$('#closeCategoryDiv').click(closeCategoryDiv);


var Edit= false;
var Delete= false;

$("#markToEditCategory").click(function () {
    for (var i = 0; i < deleteCategoryArr.length; i++) {
        if (deleteCategoryArr[i] != null){
            $('#' + deleteCategoryArr[i]).removeClass("background-delete");
        }
    }
    deleteCategoryArr = [];
    lenghtCategoryArr = 0;
    $('#markToEditCategory').attr("disabled", "true");
    $('#markToDeleteCategory').removeAttr("disabled");
    Edit = true;
    Delete = false;
    $('#confirmationDeleteCategory').addClass("visibility-hidden");
});
$("#markToDeleteCategory").click(function () {
    $('#markToDeleteCategory').attr("disabled", "true");
    $('#markToEditCategory').removeAttr("disabled");
    Edit = false;
    Delete = true;
    $('#confirmationDeleteCategory').removeClass("visibility-hidden");

});


$('#confirmationDeleteCategory').click(function () {
    var buff=0;
    for (var i = 0; i < deleteCategoryArr.length; i++) {
        if (deleteCategoryArr[i] != null){
            var url = "/deleteCategory-" + deleteCategoryArr[i];
            console.log(url);
            $.ajax({
                url: url,
                type: 'delete',
                success : function () {
                    closeCategoryDiv();
                    createCategoryTable();
                },
                error : function () {
                    console.log("error deleting");
                }
            });
        }
    }

});


