<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
</head>
<body>
	<h2>관리자 로그인</h2>
	<h3>${loginErrorMsg}</h3>
	<form action="/jvx330/manager/loginManager" method="post">
		이름 : <input type="text" name="managerName"><br>
		패스워드 : <input type="password" name="passwd"><br>
		<input type="submit" value="확인">
	</form>
</body>
</html>