<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <section id="search_mileage">
        <h2>포인트 조회</h2>
		<c:if test="${not empty errorMsg}">
        	<h3>${errorMsg}</h3>
		</c:if>
		<c:if test="${not empty orderContainer.mileage}">
			<p>현재 보유한 마일리지 : ${orderContainer.mileage}</p>
		</c:if>	
        <form id="radio_btn" action="searchMileage" method="post">
            <label><input type="radio" name="select_mileage" id="add_btn" value="add_mileage" checked/>적립</label>
            <label><input type="radio" name="select_mileage" id="use_btn" value="use_mileage"/>사용</label>
            <br>
            <input type="text" value="${orderContainer.mileageHistory.getMBalance()}" id="add_amount" readonly="readonly" />
            <!-- 적립할 경우 -->
            <input type="text" id="use_amount" name="use_amount" hidden="hidden"/>
            <!-- 사용할 경우 -->
            Points
            <input type="submit" id="submit_btn" value="적립"/>
        </form>
	</section>

        <script>
            let radio_btn = document.getElementById("radio_btn");
            let add_btn = document.getElementById("add_btn");
            let use_btn = document.getElementById("use_btn");
            let add_amount = document.getElementById("add_amount");
            let use_amount = document.getElementById("use_amount");
            let submit_btn = document.getElementById("submit_btn");

            radio_btn.addEventListener("click",function(){
                if(add_btn.checked == true){//적립
                    use_amount.setAttribute("hidden",true);
                    add_amount.removeAttribute("hidden");
                    submit_btn.value = "적립";
                } else{//사용
                    add_amount.setAttribute("hidden",true);
                    use_amount.removeAttribute("hidden");
                    submit_btn.value = "사용";
                }
            })
        </script>    
</body>
</html>