<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Javac cafe</title>
</head>
<body>
    <header>
        <h1 class="hidden">JAVAK CAFE 자박 카페</h1>
    </header>
    <section id="main">
    	<h2 class="hidden">주문내역 및 메뉴</h2>
    	        <section id="sectionLeft" class="cont">
            <h3 id="orderList_h3">주문 내역</h3>
            <form action="">
            	<table id="orderList">
            	<!-- 안에 내용 넣는 자바 스크립트 사용할 것 -->
                	<tr class="gradient">
                    	<th>순번</th>
                    	<th>제품명</th>
                    	<th>수량</th>
                    	<th>단가</th>
                    	<th>금액</th>
                	</tr>
                	<tr>
                    	<td>1</td>
                    	<td><input type="text" name="menuName" value="아메리카노" readonly="readonly"/></td>
                    	<td><button class="minus">-</button><input type="text" name="numOfNum" value="1" readonly="readonly"><button class="plus">+</button></td>
                    	<td class="orderList_right">2000</td>
                    	<td class="orderList_right"><input type="text" name="paidPrice" value="2000" readonly="readonly"/></td>
                	</tr>
                	<tr>
                    	<td>2</td>
                    	<td><input type="text" name="menuName" value="카페라떼" readonly="readonly"/></td>
                    	<td><button class="minus">-</button><input type="text" name="numOfNum" value="2" readonly="readonly"><button class="plus">+</button></td>
                    	<td class="orderList_right">2500</td>
                    	<td class="orderList_right"><input type="text" name="paidPrice" value="5000" readonly="readonly"/></td>
                	</tr>
            	</table>
            <table id="count">
            <!-- text, value에 값 넣는 자바 스크립트 사용할 것 -->
                <tr>
                    <td>총 수량</td>
                    <td><input type="text" value="6" readonly="readonly"/>6</td>
                </tr>
                <tr>
                    <td>총 금액</td>
                    <td><input type="text" value="52000" readonly="readonly"/>52000</td>
                </tr>
                <tr>
                    <td>할인 금액</td>
                    <td><input type="text" value="44000" readonly="readonly"/>44000</td>
                </tr>
                <tr>
                    <td class="important">받을 금액</td>
                    <td class="important"><input type="text" value="8000" readonly="readonly"/>8000</td>
                </tr>
            </table>
           
			<input type="submit"  value="결제하기">
			</form>    
        </section>
	<c:if test="${not empty ciMap}">
		<c:forEach var="ciMap" items="${ciMap}">
		${ciMap.key.categoryName} = 
		<c:forEach var="ciValue" items="${ciMap.value}" >
			${ciValue.itemName}
		</c:forEach>
		<br>
	</c:forEach>
	</c:if>
    </section>
	
    <footer>   
        <ul id="ownerSet">
            <li>
            	<!-- 관리자 로그인 컨트롤러 경로 -->
                <form action="" method="post">
                   	<!-- 판매내역 컨트롤러 경로 -->
                    <input type="hidden" name="transfer_link" value=""/>
                    <input type="submit"  value="판매내역">
                </form>
            </li>
            <li>
            	<!-- 관리자 로그인 컨트롤러 경로 -->
                <form action="" method="post">
                	<!-- 관리메뉴 컨트롤러 경로 -->
                    <input type="submit"  value="관리메뉴">
                </form>
            </li>
            <!-- 마일리지, 결제하기 위치 일단 이동 -->
            <!-- 인덱스 경로 구조 바꿔야...? 일단 JS 완성 되고 난 후에 이동...? -->
        </ul>
    </footer> 
	
	<script>
		//참고용으로 banking js 일단 받아왔다.
		let table = document.getElementById("table");	//테이블
   		let c_acct = document.getElementById("C-overdraft-acct");	//신용계좌 버튼
    	let s_acct = document.getElementById("S-saving-acct");		//입출금계좌 버튼
    	let intro_acct = document.getElementsByClassName("intro_acct");
    	let errorMsg = document.getElementsByClassName("errorMsg");

    	// let c_state = 0;
    	// let s_state = 0;

    	let initial_deposit_amount = document.getElementById("initial-deposit-amount-wrap");	//초기입금액
    	let limit = document.getElementById("limit-wrap");	//한도액
    	let interestRate = document.getElementById("interestRate-wrap");	//이자율
    	let submitBtn = document.querySelector("#create-account-submitButton");	//확인

	    // 마이너스 통장
    	function checked_c_acct() {
      		if (c_acct.checked == true) {
       			//이자율 숨기기
        		interestRate.setAttribute("hidden", true);
        		//한도액 나타내기
        		limit.removeAttribute("hidden");
        		intro_acct[0].setAttribute("hidden", true);
      		}
    	}

    	// 적금 통장
    	function checked_s_acct() {
      		if (s_acct.checked == true) {  
   				//한도액 숨기기
        		limit.setAttribute("hidden", true);
        		//이자율 나타내기
        		interestRate.removeAttribute("hidden");
        		intro_acct[0].setAttribute("hidden", true);
      		}
    	}

	    /* click event - function 실행. */
    	c_acct.addEventListener("click", function() {
    		if(errorMsg[0]!=null){
    			errorMsg[0].setAttribute("hidden", true);
    		}
      		checked_c_acct();
      		table.removeAttribute("hidden");
    	})

	    s_acct.addEventListener("click", function() {
    		if(errorMsg[0]!=null){
    			errorMsg[0].setAttribute("hidden", true);
    		}
      		checked_s_acct();
      		table.removeAttribute("hidden");
    	})
	</script>
</body>
</html>