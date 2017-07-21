/**
 * Created by user on 14.07.2017.
 */
$bChange.click(function () {
    // workChange = false;
    n=0;
    console.log("change");
    var newText = $tdBuff.children().val();

    if ($tdBuff.attr("class").includes("categoryName")){
        var id = $tdBuff.parent().children().first().html();
        var name = newText;
        var idFatherCategory = $tdBuff.parent().children().eq(2).html();
        var category = {id: id,name: name, idFatherCategoryes: idFatherCategory};
        var jsonCategoryRename = JSON.stringify(category);
        $.ajax({//!!!!
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
        var id = $tdBuff.parent().children().first().html();
        var name = $tdBuff.parent().children().eq(1).html();
        var idFatherCategory = newText;
        var category = {id: id,name: name, idFatherCategoryes: idFatherCategory};
        console.log(category);
        var jsonCategoryChangeIDFC = JSON.stringify(category);
        $.ajax({//!!!
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

    $('#buffer').remove();
    $('#saveCategory').removeAttr("disabled");
    $tdBuff.empty();
    $tdBuff.text(newText);
});

$bClose.click(function () {
    n=0;
    $tdBuff.empty();
    $tdBuff.text(buffText);
    $('#buffer').remove();
    $('#saveCategory').removeAttr("disabled");
    console.log("close");
});