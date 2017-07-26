/**
 * Created by user on 26.07.2017.
 */
var $confirmEditDeliveryAddress = $('<button/>', {id: "confirmEditDeliveryAddress", class: "btn btn-danger margin-0-10", text: "Підтвердити"});
var $cancelEditDeliveryAddress = $('<a/>', { href: "/user/userPage"});
$cancelEditDeliveryAddress.append($('<button/>',
    {id: "cancelEditDeliveryAddress", class: "btn btn-danger margin-0-10"/*, type:"submit", action: "/user/userPage"*/, text: "Відмінити"}));
var oldName, oldSurname, oldCountryAndCity, oldStreetAndZipCode, oldPhoneOfUser;

$('#editDeliveryAddress').click(function () {
    $('#editDeliveryAddress').remove();
    $('#divDeliveryAddress').append($confirmEditDeliveryAddress);
    $('#divDeliveryAddress').append($cancelEditDeliveryAddress)
    oldName = $('#nameOfUser').html();
    oldSurname = $('#surnameOfUser').html();
    oldCountryAndCity = $('#countryAndCity').html();
    oldCountryAndCity = oldCountryAndCity.split(",");
    oldStreetAndZipCode = $('#streetAndZipCode').html();
    oldStreetAndZipCode = oldStreetAndZipCode.split(",");
    oldPhoneOfUser = $('#phoneOfUser').html();
    console.log(oldName,oldSurname,oldCountryAndCity[0],oldStreetAndZipCode[1], oldPhoneOfUser );
    $('#nameOfUser').empty().append($('<input>', {type: "text", placeholder: oldName}));
    $('#surnameOfUser').empty().append($('<input>', {type: "text", placeholder: oldSurname}));
    $('#countryAndCity').empty().append($('<input>', {type: "text", placeholder: oldCountryAndCity[0]})).append($('<input>', {class: "margin-0-10", type: "text", placeholder: oldCountryAndCity[1]}));
    $('#streetAndZipCode').empty().append($('<input>', {type: "text", placeholder: oldStreetAndZipCode[0]})).append($('<input>', {class: "margin-0-10", type: "text", placeholder: oldStreetAndZipCode[1]}));
    $('#phoneOfUser').empty().append($('<input>', {type: "text", placeholder: oldPhoneOfUser}));
})

$confirmEditDeliveryAddress.click(function () {
    console.log("confirm");
    var username = $('#userLogin').html();
    var name = $('#nameOfUser').children().val();
    if (name == ""){
        name = oldName;
    }
    var surname = $('#surnameOfUser').children().val();
    if (surname == ""){
        surname = oldSurname;
    }
    var country = $('#countryAndCity').children().first().val();
    if (country == ""){
        country = oldCountryAndCity[0];
    }
    var city = $('#countryAndCity').children().last().val();
    if (city == ""){
        city = oldCountryAndCity[1];
    }
    var street = $('#streetAndZipCode').children().first().val();
    if (street == ""){
        street = oldStreetAndZipCode[0];
    }
    var zipCode = $('#streetAndZipCode').children().last().val();
    if (zipCode == ""){
        zipCode = oldStreetAndZipCode[1];
    }
    var phone = $('#phoneOfUser').children().val();
    if (phone == ""){
        phone = oldPhoneOfUser;
    }
    var user = {username: username ,name: name, surname: surname, country: country, city: city, street: street, zipCode: zipCode, phone: phone};
    var jsonUserEdit = JSON.stringify(user);
    $.ajax({
        url: '/editDeliveryAddress',
        type: 'post',
        contentType: 'application/json',
        data : jsonUserEdit,
        success : function () {
            alert("ok");
            top.location = $('#exitUser').attr('href');
        },
        error : function () {
            alert("!!!!");
        }
    });

    });