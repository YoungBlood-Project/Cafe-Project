<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메뉴 수정</title>
    <script src="js/jquery-3.6.0.min.js"></script>

</head>

<body>
    <!-- <form>
        <select>
            <option value="1"><input type="text" value="1"/></option>
            <option value="2"><input type="text" value="2"/></option>
            <option value="3"><input type="text" value="3"/></option>
            <option value="4"><input type="text" value="4"/></option>
            <option value="5"><input type="text" value="5"/></option>
        </select>
    </form> -->

    <form>
        <label><input type="radio" name="categoryName" class="radio_btn" value="coffee"/>coffee</label>
        <label><input type="radio" name="categoryName" class="radio_btn" value="tea"/>tea</label>
        <label><input type="radio" name="categoryName" class="radio_btn" value="smoothie"/>smoothie</label>
        <br>

        <select name="itemName" id="coffee" class="itemName" hidden="hidden">
            <option selected></option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
        </select>
        <select name="itemName" id="tea" class="itemName" hidden="hidden">
            <option>차</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
        </select>

        <select name="itemName" id="smoothie" class="itemName" hidden="hidden">
            <option>딸기스무디</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
        </select>
    </form>


    <script>
        let category_list = $(".itemName");

        $(".radio_btn").on("click",function(){
            //console.log($(this).val());
            //console.log(category_list[0].className);

            for(let i = 0; i<category_list.length; i++){
                if($(this).val() == category_list[i].id){
                    console.log($(this).val())
                    $(".itemName").hide();
                    $("#"+$(this).val()).show();
                    //$("."+category_list[i].className).show;
                }
            }
        })
    </script>   
</body>

</html>