<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- <link href='<c:url value="/resources/css/membership/add_user.css"/>' rel="stylesheet" type="text/css"> -->
<link href='<c:url value="/resources/css/common.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
	<section id="add_user">
	<h2>회원가입</h2>
	<c:if test="${not empty errorMsg}">
		<h3>${errorMsg}</h3>
	</c:if>
		<form action="addUser" method="post">
			<span>이름:</span> <input type="text" name="name" placeholder="이름 입력"/><br>
			<span>휴대폰 번호:</span> <input type="text" name="phone" maxlength="11" placeholder="휴대폰 번호 입력"/><br>
			<input type="submit" value="가입하기"/>
		</form>
	</section>
</body>
</html>