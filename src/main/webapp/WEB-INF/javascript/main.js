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
        $('#errorInPassword').empty();
        $.ajax({
            url: '/saveUser',
            type: 'post',
            contentType: 'application/json',
            data : jsonUser,
            success : function (result) {
                console.log(result);
                if (result == ""){
                    $('#regUsername').val('');
                    $('#regEmail').val('');
                    $('#regPassword').val('');
                    $('#conPassword').val('');
                    document.getElementById("closeRegistration").click();
                }else{
                    if (result == "username"){
                        $('#divForErrorUserName').append($('<p/>', {class: "margin-0", text: "This userName is present"}));
                    }
                }

            },
            error : function () {
                alert("!!!!");
            }
        });

    }else {
        $('#divForErrorPassword').append($('<p/>', {id: "errorInPassword",class: "margin-0", text: "Password don`t match"}));
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
                            href: "/productsWithCategory-" + `${result[i].id}` + "-Page-0",
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
                                href: "/productsWithCategory-" + `${result[i].id}` + "-Page-0",
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
                                    href: "/productsWithCategory-" + `${result[i].id}` + "-Page-0",
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

$('#basketButton').click(function () {
    if ($('#registeredUserName').text() == "null" || $('#registeredUserName').text() == ""){
        $('#basketBody').empty();
        $('#basketBody').append($('<p/>', {class: "font-size-20px display-block padding-left-20px",text: "Будь ласка зареєструйтесь або увійдіть"}));
    } else {
        var userName = $('#registeredUserName').text();
        var priceToPay = 0;
        $('#basketBody').empty();
        $.ajax({
            url: '/allProductWithOrder' +userName,
            type: 'get',
            success : function (result) {
                if(result != ""){
                    $(result).each(function () {
                        var localPrice = this.price;
                        var productId = this.id;

                        $('#basketBody').append($('<div/>', {id: "product"+ `${this.id}` ,class: "row margin-0-20px padding-top-10px"}));
                        $('#basketBody').children().last().append($('<div/>', {class: "col-md-3 padding-0"}));
                        var url = "photoProduct" + `${this.id}`;
                        $('#basketBody').children().last().children().last().append($('<img>', {id: url, class: "img-responsive width-100prc"}));
                        $.ajax({
                            url: url,
                            type: 'get',
                            success : function(photo){
                                $('#' + url).attr("src", `${photo.picture}`);
                            },
                            error : function () {
                                alert("errror load photo");
                            }
                        });

                        $('#basketBody').children().last().append($('<div/>', {id: "product"+ productId +"Description", class: "col-md-offset-1 col-md-6 padding-0"}));
                        $('#basketBody').children().last().children().last().append($('<a/>', {href: "/productWithId"+ `${this.id}`, class: "text-primary btn font-size-25px white-space-pre-wrap", text: `${this.name}`}));
                        $('#basketBody').children().last().children().last().append($('<p/>', {class: "text-danger font-size-20px display-block padding-left-20px", text: `${this.price}` + "грн"}));
                        $('#basketBody').children().last().append($('<div/>', {class: "col-md-offset-1 col-md-1 padding-0"}));
                        var deleteButtonId = "deleteOrderWithProduct"+ `${this.id}`;
                        $('#basketBody').children().last().children().last().append($('<button>', {id: deleteButtonId , class: "close color-white", text: "x"}));

                        $.ajax({
                            url: '/orderWithProduct'+ productId + 'User' + userName,
                            type: 'get',
                            success : function(orderProduct){
                                priceToPay += localPrice * orderProduct.number;
                                $('#priceToPay').text(priceToPay);
                                $('#'+ deleteButtonId).attr("onclick", "deleteOrderWithId(" + `${orderProduct.id}` + ")");
                                $('#product' + productId).attr("id", "orderWithId"+ `${orderProduct.id}`);
                                $('#product' + productId + "Description").append($('<p/>', {class: "text-danger font-size-20px display-block padding-left-20px",text: "Кількість:" + `${orderProduct.number}`}))
                            },
                            error : function () {
                                alert("errror load Order Product");
                            }
                        });
                    });
                } else {
                    $('#basketBody').append($('<p/>', {class: "font-size-20px display-block padding-left-20px", text: "Корзина пуста, але це легков виправити)))"}));
                }
            },
            error : function () {
                alert("error");
            }
        });

    }
});

function deleteOrderWithId(id) {
    $.ajax({
        url: '/deleteOrder' + id,
        type: 'delete',
        success : function () {
            $('#orderWithId' + id).empty();
        },
        error : function () {
            console.log("error deleting");
        }
    });
}

$('#orderAProduct').click(function () {
    if ($('#registeredUserName').text() == "null" || $('#registeredUserName').text() == ""){
        $('#basketBody').empty();
        $('#basketBody').append($('<p/>', {class: "font-size-20px display-block padding-left-20px",text: "Будь ласка зареєструйтесь або увійдіть"}));
    } else {
        var userName = $('#registeredUserName').text();
        $.ajax({
            url: '/user' + userName,
            type: 'get',
            success : function(user){
                if(user.name == null || user.name == "" || user.surname  == null || user.surname == ""
                    || user.country  == null || user.country == "" || user.city == null || user.city == ""
                    || user.street == null || user.street == "" || user.zipCode == 0
                    || user.phone == null || user.phone == ""){

                    $('#basketBody').append($('<p/>', {class: "font-size-20px display-block padding-left-20px padding-top-10px", text: "Для замовлення укажіть свої особисті дані, будем дуже вдячні"}));
                } else {
                    document.getElementById("closeBasket").click();
                    $(user.orderProducts).each(function () {
                        $.ajax({
                            url: '/order' + this.id + 'ReservedTrue',
                            type: 'post',
                            success : function () {
                            },
                            error : function () {
                                console.log("error updating");
                            }
                        });
                        console.log(this);

                    });
                }
            },
            error : function () {
                alert("errror load User");
            }
        });


    }

});

$(document).ready(function () {
    var maxHeight = 0;
    $('#newProducts').children().each(function () {
        if (maxHeight < $(this).height()){
            maxHeight = $(this).height();
        }
    });
    $('#newProducts').children().each(function () {
        var difHeight = (maxHeight - $(this).height()) / 2;
        $(this).children().children().first().css("padding-top", difHeight + "px");
        $(this).children().children().first().css("padding-bottom", difHeight + "px");
        $(this).height(maxHeight);
    });

    maxHeight = 0;
    $('#popularProducts').children().each(function () {
        if (maxHeight < $(this).height()){
            maxHeight = $(this).height();
        }
    });
    $('#popularProducts').children().each(function () {
        var difHeight = (maxHeight - $(this).height()) / 2;
        $(this).children().children().first().css("padding-top", difHeight + "px");
        $(this).children().children().first().css("padding-bottom", difHeight + "px");
        $(this).height(maxHeight);
    });

    maxHeight = 0;
    $('#allProductsOnProductPage').children().each(function () {
        if (maxHeight < $(this).height()){
            maxHeight = $(this).height();
        }
    });
    $('#allProductsOnProductPage').children().each(function () {
        // var difHeight = (maxHeight - $(this).height());
        $(this).children().children().first().css("padding-top", (maxHeight - $(this).height()) / 2 + "px");
        $(this).children().children().first().css("padding-bottom", (maxHeight - $(this).height()) / 2 + "px");
        $(this).height(maxHeight);
    });
});

$(document).ready(function () {
    $('#pagination').css("padding-left", ($('#pagination').parent().width() - $('#pagination').width()) / 2);
});

$(document).ready(function selectProduct() {
    $('.js-example-basic-multiple').select2({
        placeholder: "Пошук по крамниці...",
    });

    $.ajax({
        url: '/allProduct',
        type: 'get',
        success : function(result){
            var products = [];
            var n =0;
            $(result).each(function () {
                products[n] ={id: "productWithId"+ this[0], text: this[1]};
                n++;
            });
            $('.js-example-basic-multiple').select2({
                placeholder: "Пошук по крамниці...",
                data: products
            });
        },
        error : function () {
            alert("errror load Product to Select");
        }
    });
});










