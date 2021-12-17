<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매 내역</title>
<script src='<c:url value="/resources/js/jquery-3.6.0.min.js"/>'></script>
<link href='<c:url value="/resources/css/common.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/sales/main_salesHistory.css"/>' rel="stylesheet" type="text/css">
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
		
		<a href="mainMSalesHistory">메뉴별 판매내역</a>
		
		<section id="salesHistoryMain">
		<h3>총매출 확인</h3>
		<form action="/jvx330/sales/dateSalesTotalPrice" method="get">
		날짜별 내역:
			<select name="year" class="year">
				<c:forEach var="year" items="${year_list}">
					<option value="${year}">${year}</option>
				</c:forEach>
			</select>
			<select name="month" class="month">
				<c:forEach var="month" items="${month_list}">
					<option value="${month}">${month}</option>
				</c:forEach>
			</select>
			<select name="day" class="day">
				<c:forEach var="day" items="${day_list}">
					<option value="${day}">${day}</option>
				</c:forEach>
			</select>
			<input type="submit" value="확인">
		</form>	
		
		<form action="/jvx330/sales/monthSalesTotalPrice" method="get">
		월별 내역:
			<select name="year" class="year">
				<c:forEach var="year" items="${year_list}">
					<option value="${year}">${year}</option>
				</c:forEach>
			</select>
			<select name="month" class="month">
				<c:forEach var="month" items="${month_list}">
					<option value="${month}">${month}</option>
				</c:forEach>
			</select>
			<input type="submit" value="확인">
		</form>	
		
		<form action="/jvx330/sales/yearSalesTotalPrice" method="get">
		연간 내역:
			<select name="year" class="year">
				<c:forEach var="year" items="${year_list}">
					<option value="${year}">${year}</option>
				</c:forEach>
			</select>
			<input type="submit" value="확인">
		</form>	
		</section>
	</section>	
	
	<script>
    	$(window).ready(function(){
    		$(".year option").last().prop("selected", true);
    		$(".month option").last().prop("selected", true);
    	})
	</script>
</body>
</html>