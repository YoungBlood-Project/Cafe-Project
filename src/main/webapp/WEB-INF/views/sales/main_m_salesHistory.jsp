<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴별 판매내역</title>
<script src='<c:url value="/resources/js/jquery-3.6.0.min.js"/>'></script>
<link href='<c:url value="/resources/css/common.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/sales/main_m_salesHistory.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
<section id="main_m_salesHistory">
	<h2>메뉴별 판매내역</h2>
	
	<c:if test="${not empty errorMsg}">
			<h3>${errorMsg}</h3>
	</c:if>
		
	<form action="mDateSalesHistory" method="get">
		날짜별 내역:
		<input type="date" name="date">
			<!--  <select name="year" class="year">
				<c:forEach var="year" items="${year_list}">
					<option value="${year}">${year}</option>
				</c:forEach>
			</select>
			
			<select name="month">
				<c:forEach var="month" items="${month_list}">
					<option value="${month}">${month}</option>
				</c:forEach>
			</select>
			
			<select name="day">
				<c:forEach var="day" items="${day_list}">
					<option value="${day}">${day}</option>
				</c:forEach>
			</select>
			-->
			<input type="submit" value="확인">
		</form>	
		
		<form action="mMonthSalesHistory" method="get">
		월별 내역:
			<select name="year" class="year">
				<c:forEach var="year" items="${year_list}">
					<option value="${year}">${year}</option>
				</c:forEach>
			</select>
			<select name="month">
				<c:forEach var="month" items="${month_list}">
					<option value="${month}">${month}</option>
				</c:forEach>
			</select>
		 	
			<input type="submit" value="확인">
		</form>	
		
		<form action="mYearSalesHistory" method="get">
		연간 내역:
			<select name="year" class="year">
				<c:forEach var="year" items="${year_list}">
					<option value="${year}">${year}</option>
				</c:forEach>
			</select>
			<input type="submit" value="확인">
		</form>	
		
		<form action="/jvx330/sales/mainSalesHistory" method="post" >
			<input type="submit" value="판매내역 메인으로 돌아가기" id="salesHistory_link">
		</form>
	</section>	
	
		<script>
    	$(window).ready(function(){
    		$(".year option").last().prop("selected", true);
    		$(".month option").last().prop("selected", true);
    	})
	</script>
</body>
</html>