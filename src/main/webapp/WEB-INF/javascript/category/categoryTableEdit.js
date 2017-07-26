/**
 * Created by user on 14.07.2017.
 */
$bCategoryChange.click(function () {
    // workChange = false;
    catN=0;
    console.log("change");
    var newTextCategory = $tdCategoryBuff.children().val();

    if ($tdCategoryBuff.attr("class").includes("categoryName")){
        var id = $tdCategoryBuff.parent().children().first().html();
        var name = newTextCategory;
        var idFatherCategory = $tdCategoryBuff.parent().children().eq(2).html();
        var category = {id: id,name: name, idFatherCategoryes: idFatherCategory};
        var jsonCategoryRename = JSON.stringify(category);
        $.ajax({
            url: '/changeNameCategory',
            type: 'post',
            contentType: 'application/json',
            data : jsonCategoryRename,
            success:function () {
                alert("RENAME ok");
            },
            error:function () {
                alert("errrrrrrorrr!!!!!!!!!");
            }
        });
    }else{
        var id = $tdCategoryBuff.parent().children().first().html();
        var name = $tdCategoryBuff.parent().children().eq(1).html();
        var idFatherCategory = newTextCategory;
        var category = {id: id,name: name, idFatherCategoryes: idFatherCategory};
        console.log(category);
        var jsonCategoryChangeIDFC = JSON.stringify(category);
        $.ajax({
            url: '/changeIdFatherCategory',
            type: 'post',
            contentType: 'application/json',
            data : jsonCategoryChangeIDFC,
            success:function () {
                alert("CHANGE IDFC ok");
            },
            error:function () {
                alert("errrrrrrorrr!!!!!!!!!");
            }
        });
    };

    $('#bufferCategory').remove();
    $('#saveCategory').removeAttr("disabled");
    $tdCategoryBuff.empty();
    $tdCategoryBuff.text(newTextCategory);
});

$bCategoryClose.click(function () {
    catN=0;
    $tdCategoryBuff.empty();
    $tdCategoryBuff.text(buffTextCategory);
    $('#bufferCategory').remove();
    $('#saveCategory').removeAttr("disabled");
    console.log("close");
});