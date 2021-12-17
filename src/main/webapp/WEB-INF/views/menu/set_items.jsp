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
    <script src='<c:url value="/resources/js/jquery-3.6.0.min.js"/>'></script>
    <link href='<c:url value="/resources/css/common.css"/>' rel="stylesheet" type="text/css">
</head>

<body>
	<section id="set_itmes">
	    <form>
		<c:if test="${not empty ciMap}">
			<c:forEach var="ciKey" items="${ciMap.key}">
	    		<label><input type="radio" name="categoryName" class="radio_btn" value="${ciKey.categoryName}"/>${ci_key.categoryName}</label>
	    	</c:forEach>
		</c:if> 
        <br>
        
        <c:if test="${not empty ciMap}">
        	<c:forEach var="ciKey" items="${ciMap.key}">
        		<select name="itemName" id="${ciKey.categoryName}" class="itemName" hidden="hidden">
					<c:forEach var="ciValue" items="${ciMap.value}">
						<option value="${ciValue.itemName}">${ciValue.itemName}</option>		
					</c:forEach>
				</select>        	
        	</c:forEach>
        </c:if>
        </form>
	</section>

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