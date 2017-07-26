/**
 * Created by user on 24.07.2017.
 */
var slideN = 0;
var $bSliderChange = $('<button/>', {id: "change", class: "btn btn-danger btn-sm",text: "Enter"});
var $bSliderClose = $('<button/>', {id: "closeChange", class: "btn btn-danger btn-sm",text: "X"});
var $tdSliderBuff;
var buffTextSlider;
var deleteSliderArr = [];
var lenghtSliderArr = deleteSliderArr.length;


$('#sliderDiv td').click(function () {
    if ( EditSlider == true && DeleteSlider == false ) {

        if (($(this).attr("class").includes("slideName") && !$(this).parent().children().first().text().includes("#"))
            || ($(this).attr("class").includes("slidePicture") && !$(this).parent().children().first().text().includes("#"))) {
            slideN++;
            // console.log(n);
            if (slideN == 1) {
                $('#saveSlide').attr("disabled", "true");

                $tdSliderBuff = $(this);
                buffTextSlider = $(this).html();
                // console.log(buffText);

                $(this).parent().append($('<td/>', {id: "bufferSlide"}));
                $(this).parent().children().last().append($bSliderChange);
                $(this).parent().children().last().append($bSliderClose);

                $tdSliderBuff.empty();
                if( $tdSliderBuff.attr("class").includes("slideName") ){
                    $tdSliderBuff.append($('<input>', {id: "newNameSlide", type: "text"}));
                }else{
                    $tdSliderBuff.append($('<input>', {id: "newPictureSlide", type: "file"}));
                }


                // $.getScript("/js/category/categoryTableEdit.js");     ?????
                // $(this).replaceWith("<td><input type='text'></td>");

            }
        }

    }
    if ( EditSlider == false && DeleteSlider == true ) {
        if (!$(this).parent().children().first().text().includes("#")){
            if(!deleteSliderArr.includes($(this).parent().children().first().text())){
                console.log(lenghtSliderArr);
                deleteSliderArr[lenghtSliderArr]= $(this).parent().children().first().text();
                console.log(deleteSliderArr);
                $(this).parent().addClass("background-delete");
                lenghtSliderArr++;

            }else{
                $(this).parent().removeClass("background-delete");
                for (var i = 0; i < deleteSliderArr.length; i++) {
                    if (deleteSliderArr[i] == $(this).parent().children().first().text()){
                        console.log("delete -"+deleteSliderArr[i]);
                        delete deleteSliderArr[i];
                    }
                }

            }
        }
    }

});



$('#saveSlide').click(function () { //!!!!!!!!!!!!!!!!!
    console.log("hello111");
    var slideName = $('#slideName').val();
    var slidePicture = $('#slidePicture').ob
    // var stockSlider = {name: slideName, picture: slidePicture};
    // var jsonSlideSave = JSON.stringify(stockSlider);
    console.log(slidePicture);


    $.ajax({
        url: '/saveSlide-' + slideName,
        type: 'post',
        contentType: 'multipart/form-data',
        data : slidePicture,
        success : function () {
            alert("ok");
            createSliderTable();
        },
        error : function () {
            alert("!!!!");
        }
    });

});

function closeSliderDiv() {
    $('#sliderDiv').remove();
    $('#mainSlider').removeAttr("disabled");
    deleteSliderArr = [];
    lenghtSliderArr = 0;
    console.log("closeDiv");
}
$('#closeSliderDiv').click(closeSliderDiv);


var EditSlider = false;
var DeleteSlider = false;

$("#markToEditSlider").click(function () {
    for (var i = 0; i < deleteSliderArr.length; i++) {
        if (deleteSliderArr[i] != null){
            $('#'+ "slide" + deleteSliderArr[i]).removeClass("background-delete");
        }
    }
    deleteSliderArr = [];
    lenghtSliderArr = 0;
    $('#markToEditSlider').attr("disabled", "true");
    $('#markToDeleteSlider').removeAttr("disabled");
    EditSlider = true;
    DeleteSlider = false;
    $('#confirmationDeleteSlide').addClass("visibility-hidden");
});
$("#markToDeleteSlider").click(function () {
    $('#markToDeleteSlider').attr("disabled", "true");
    $('#markToEditSlider').removeAttr("disabled");
    EditSlider = false;
    DeleteSlider = true;
    $('#confirmationDeleteSlide').removeClass("visibility-hidden");

});


$('#confirmationDeleteSlide').click(function () {
    // var buffCategory=0;
    for (var i = 0; i < deleteSliderArr.length; i++) {
        if (deleteSliderArr[i] != null){
            var url = "/deleteSlide-" + deleteSliderArr[i];
            console.log(url);
            $.ajax({
                url: url,
                type: 'delete',
                success : function () {
                    // closeSliderDiv();
                    createSliderTable();
                },
                error : function () {
                    console.log("error deleting");
                }
            });
        }
    }

});