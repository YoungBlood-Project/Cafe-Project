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
    <link href='<c:url value="/resources/css/menu/set_items.css"/>' rel="stylesheet" type="text/css">
</head>

<body>
	<section id="set_itmes">
	    <form action="setItems" method="post">
	    
		<c:if test="${not empty ciMap}">
			<c:forEach var="ciKey" items="${ciMap.keySet()}" varStatus="status">
	    		<label><input type="radio" name="categoryName" class="radio_btn" value="${ciKey.categoryName}"/>${ciKey.categoryName}</label>
	    	</c:forEach>
		</c:if> 
        <br>
        
        <div id="setItemsWrap">
        <c:if test="${not empty ciMap}">
        	<c:forEach var="ciMap" items="${ciMap}" varStatus="status">
        		<c:choose>
        			<c:when test="${status.count eq 1}">
        				<select name="itemName" id="${ciMap.key.categoryName}" class="itemName">
							<c:forEach var="ciValue" items="${ciMap.value}" varStatus="status">
								<option value="${ciValue.itemName}">${ciValue.itemName}</option>		
							</c:forEach>
						</select>       
        			</c:when>
        			<c:otherwise>
        				<select name="hide_itemName" id="${ciMap.key.categoryName}" class="itemName" hidden="hidden">
							<c:forEach var="ciValue" items="${ciMap.value}" varStatus="status">
								<option value="${ciValue.itemName}">${ciValue.itemName}</option>		
							</c:forEach>
						</select>     
        			</c:otherwise>
        		</c:choose>   	
        	</c:forEach>
        </c:if>
        <input type="text" name="newItemName" placeholder="바꿀 메뉴명을 입력하세요">
        </div> 
        
        <input type="submit" value="수정 확인">
       </form>
	</section>


    <script>
        let category_list = $(".itemName");
        
        $(window).ready(function(){
        	$(".radio_btn:eq(0)").attr("checked",true);
        	$(".itemName").removeClass('hidden');
        })

        $(".radio_btn").on("click",function(){
            //console.log($(this).val());
            //console.log(category_list[0].className);

            for(let i = 0; i<category_list.length; i++){
                if($(this).val() == category_list[i].id){
                    console.log($(this).val())
                    $(".itemName").hide();
                    $("#"+$(this).val()).show();
                    $("#"+$(this).val()).attr("name","itemName");
                    $(".itemName").not($("#"+$(this).val())).attr("name","hide_itemName");
                    //$("."+category_list[i].className).show;
                }
            }
        })
    </script>   
</body>

</html>