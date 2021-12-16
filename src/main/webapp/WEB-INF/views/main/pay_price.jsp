<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제하기</title>
<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/pay_price.css" rel="stylesheet" type="text/css">
</head>
<body>
	<section id="pay_price">
		<h2>결제하기</h2>
		<img src="../resources/images/coin3.gif" alt="coin"/>
		<div>
			<p>
				주문번호: ${orderNum}번<br>
				결제가 완료되었습니다.
			</p>
			<a href="index">메인으로 돌아가기</a>
		</div>
	</section>
</body>
</html>