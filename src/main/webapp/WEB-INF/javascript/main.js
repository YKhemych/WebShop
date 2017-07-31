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
    var confPassword = $('#conPassword').val();
    if (password == confPassword){
        var user = {username: username, email: email, password: password};
        var jsonUser = JSON.stringify(user);

        $.ajax({
            url: '/saveUser',
            type: 'post',
            contentType: 'application/json',
            data : jsonUser,
            success : function () {
                alert("ok");
                document.getElementById("closeRegistration").click();
            },
            error : function () {
                alert("!!!!");
            }
        });

    }else {
        $('#divRegistrationUser').append($('<p/>', {class: "padding-left-20px", text: "Помилка в паролі"}));
    }

});

$('#loginButton').click(function () {
    var $form = $('#loginform');
    $form.submit();
});

var numbOfClicksToTheMainCategory = 0;

$('#mainCategoryButton').click(function () {
    numbOfClicksToTheMainCategory++;
    if (numbOfClicksToTheMainCategory==1) {
        $.ajax({
            url: '/allCategory',
            type: 'get',
            success: function (result) {

                $('#mainCategoryButton').parent().append($('<ul/>', {id: 'mainCategoryMenu', class: 'dropdown-menu multi-level'}));

                for (var i = 0; i < result.length; i++) {
                    if (result[i].idFatherCategoryes == 0){
                        $('#mainCategoryMenu').append($('<li/>', {id: 'id'+`${result[i].id}`}));
                        $('#mainCategoryMenu').children().last().append($('<a/>', {
                            href: "/productsWithCategory-" + `${result[i].id}`,
                            class: "linkCategory",
                            text: `${result[i].name}`,
                            // click: linkProductCategory
                        }));
                    }
                }

                $('#mainCategoryMenu').children().each(function createSubCategory() {
                    var bufUl=0;
                    for (var i = 0; i < result.length; i++) {
                        if ($(this).attr("id") == ('id'+ result[i].idFatherCategoryes)){
                            bufUl++;
                            if (bufUl == 1){
                                $(this).append($('<ul/>', {class: "dropdown-menu"}));
                                $(this).attr("class", "dropdown-submenu");
                                // $(this).children().first().attr("tabindex", "-1");
                            }
                            $(this).children().last().append($('<li/>', {id: 'id'+`${result[i].id}`}));
                            $(this).children().last().children().last().append($('<a/>', {
                                href: "/productsWithCategory-" + `${result[i].id}`,
                                text: `${result[i].name}`,
                                // click: linkProductCategory
                            }));
                        }
                    }
                    bufUl=0;
                });

                $('#mainCategoryMenu').children().each(function () { //<li>
                    $(this).children().last().children().each(function createSubCategory() {
                        var bufUl=0;
                        for (var i = 0; i < result.length; i++) {
                            if ($(this).attr("id") == ('id'+ result[i].idFatherCategoryes)){
                                bufUl++;
                                if (bufUl == 1){
                                    $(this).append($('<ul/>', {class: "dropdown-menu"}));
                                    $(this).attr("class", "dropdown-submenu");
                                    // $(this).children().first().attr("tabindex", "-1");
                                }
                                $(this).children().last().append($('<li/>', {id: 'id'+`${result[i].id}`}));
                                $(this).children().last().children().last().append($('<a/>', {
                                    href: "/productsWithCategory-" + `${result[i].id}`,
                                    text: `${result[i].name}`,
                                    // click: linkProductCategory
                                }));
                            }
                        }
                        bufUl=0;
                    });
                });

            },
            error: function () {
                alert("error");
            }
        });
    };
});

// function linkProductCategory() {
//     $.ajax({
//         url: '/product',
//         type: 'get',
//         success : function () {
//             alert("click ok");
//         },
//         error : function () {
//             alert("!!!!");
//         }
//     });
// }



