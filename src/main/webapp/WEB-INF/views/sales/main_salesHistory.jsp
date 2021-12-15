<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매 내역</title>
</head>
<body>
	<section id="main_salesHistory">
		<h2>판매 내역</h2>
		
		<form action="/jvx330/manager/logoutManager" method="get">
			<input type="submit" value="메인화면으로 돌아가기">
		</form><br>
		
		<form action="/jvx330/sales/todaySalesHistory" method="get">
			<input type="submit" value="당일 판매내역">
		</form>
		
		<form action="/jvx330/sales/menu_salesHistory" method="get">
			<input type="submit" value="메뉴별 판매내역">
		</form>	
		
		<h3>총매출 확인</h3>
		<form:form action="/jvx330/sales/monthSalesTotalPrice" method="post" modelAttribute="month">
			<form:select path="month">
				<form:options items="${monthList}" itemLabel="month" itemValue="month"/>
			</form:select>
		
		</form:form> -->
		
	</section> 
</body>
</html>