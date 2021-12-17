<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<link href='<c:url value="/resources/css/common.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/manager/login_manager.css"/>' rel="stylesheet" type="text/css">

</head>
<body>
	<section id="login_manager">
	<h2>관리자 로그인</h2>
	<h3>${loginErrorMsg}</h3>
	<form action="/jvx330/manager/loginManager" method="post">
		<span>이름 :</span> <input type="text" name="managerName"><br>
		<span>패스워드 :</span> <input type="password" name="passwd"><br>
		<input type="submit" value="확인">
	</form>
	</section>
</body>
</html>