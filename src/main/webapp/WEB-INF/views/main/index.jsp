<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Javac cafe</title>
</head>
<body>
	<form>
	</form>
	
	<script>
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