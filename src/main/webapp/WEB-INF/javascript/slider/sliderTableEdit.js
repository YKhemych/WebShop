/**
 * Created by user on 26.07.2017.
 */
$bSliderChange.click(function () {
    // workChange = false;
    slideN=0;
    console.log("change");
    var newTextSlide = $tdSliderBuff.children().val();

    if ($tdSliderBuff.attr("class").includes("slideName")){
        var id = $tdSliderBuff.parent().children().first().html();
        var name = newTextSlide;

        $.ajax({
            url: '/changeNameSlide-' + id,
            type: 'post',
            contentType: 'text/plain',
            data : name,
            success:function () {
                alert("RENAME ok");
            },
            error:function () {
                alert("errrrrrrorrr!!!!!!!!!");
            }
        });
    }
    $('#bufferSlide').remove();
    $('#saveSlide').removeAttr("disabled");
    $tdSliderBuff.empty();
    $tdSliderBuff.text(newTextSlide);
});

$bSliderClose.click(function () {
    slideN=0;
    $tdSliderBuff.empty();
    $tdSliderBuff.text(buffTextSlider);
    $('#bufferSlide').remove();
    $('#saveSlide').removeAttr("disabled");
    console.log("close");
});