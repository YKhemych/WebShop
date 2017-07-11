/**
 * Created by user on 03.07.2017.
 */
// console.log("hello");

$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});

$('#registerButton').click(function () {
    var username = $('#regUsername').val();
    var email = $('#regEmail').val();
    var password = $('#regPassword').val();
    var user = {username: username, email: email, password: password};
    var jsonUser = JSON.stringify(user);

    $.ajax({
        url: '/saveUser',
        type: 'post',
        contentType: 'application/json',
        data : jsonUser,
        success : function () {
            alert("ok");
        },
        error : function () {
            alert("!!!!");
        }
    });
});

$('#loginButton').click(function () {
    var $form = $('#loginform');
    $form.submit();
});

