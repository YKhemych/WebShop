/**
 * Created by user on 14.07.2017.
 */

var catN = 0;
var $bCategoryChange = $('<button/>', {id: "change", class: "btn btn-danger btn-sm",text: "Enter"});
var $bCategoryClose = $('<button/>', {id: "closeChange", class: "btn btn-danger btn-sm",text: "X"});
var $tdCategoryBuff;
var buffTextCategory;
var deleteCategoryArr = [];
var lenghtCategoryArr = deleteCategoryArr.length;


$('#categoryDiv td').click(function () {
    if ( EditCategory == true && DeleteCategory == false ) {

        if (($(this).attr("class").includes("categoryName") && !$(this).parent().children().first().text().includes("#"))
            || ($(this).attr("class").includes("idFatherCategory") && !$(this).parent().children().first().text().includes("#"))) {
            catN++;
            // console.log(n);
                if (catN == 1) {
                    $('#saveCategory').attr("disabled", "true");

                    $tdCategoryBuff = $(this);
                    buffTextCategory = $(this).html();
                    // console.log(buffText);

                    $(this).parent().append($('<td/>', {id: "bufferCategory"}));
                    $(this).parent().children().last().append($bCategoryChange);
                    $(this).parent().children().last().append($bCategoryClose);

                    $tdCategoryBuff.empty();
                    $tdCategoryBuff.append($('<input>', {id: "newNameCategory", type: "text"}));

                    $.getScript("/js/category/categoryTableEdit.js");
                    // $(this).replaceWith("<td><input type='text'></td>");

                }
            }

    }
    if ( EditCategory == false && DeleteCategory == true ) {
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
    $('#categoryDiv').remove();
    $('#category').removeAttr("disabled");
    deleteCategoryArr = [];
    lenghtCategoryArr = 0;
    console.log("closeDiv");
}
$('#closeCategoryDiv').click(closeCategoryDiv);


var EditCategory= false;
var DeleteCategory= false;

$("#markToEditCategory").click(function () {
    for (var i = 0; i < deleteCategoryArr.length; i++) {
        if (deleteCategoryArr[i] != null){
            $('#' + "categ" + deleteCategoryArr[i]).removeClass("background-delete");
        }
    }
    deleteCategoryArr = [];
    lenghtCategoryArr = 0;
    $('#markToEditCategory').attr("disabled", "true");
    $('#markToDeleteCategory').removeAttr("disabled");
    EditCategory = true;
    DeleteCategory = false;
    $('#confirmationDeleteCategory').addClass("visibility-hidden");
});
$("#markToDeleteCategory").click(function () {
    $('#markToDeleteCategory').attr("disabled", "true");
    $('#markToEditCategory').removeAttr("disabled");
    EditCategory = false;
    DeleteCategory = true;
    $('#confirmationDeleteCategory').removeClass("visibility-hidden");

});


$('#confirmationDeleteCategory').click(function () {
    // var buffCategory=0;
    for (var i = 0; i < deleteCategoryArr.length; i++) {
        if (deleteCategoryArr[i] != null){
            var url = "/deleteCategory-" + deleteCategoryArr[i];
            console.log(url);
            $.ajax({
                url: url,
                type: 'delete',
                success : function () {
                    // closeCategoryDiv();
                    createCategoryTable();
                },
                error : function () {
                    console.log("error deleting");
                }
            });
        }
    }

});


