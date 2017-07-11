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

});

$('td').click(function () {//!!!!!!!!!!!!!!!
    console.log("hello222");
    var $input = $('<input/>', {type="text", });
})