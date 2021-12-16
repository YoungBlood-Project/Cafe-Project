<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<form>
			<table id="salesHistoryTable">
				<tr>
					<td><label>날짜별 내역</label></td>
					<td id="historyByDate_year">
					<select>
					<c:if test="${not empty historyByDate_year}">
					<c:forEach var="year" items="${historyByDate_year}" varStatus="status">
						<option>${year}</option>
					</c:forEach>
					</c:if>
					</select>
					</td>
					
					<td id="historyByDate_month">
					<select>
					<c:if test="${not empty historyByDate_month}">
					<c:forEach var="month" items="${historyByDate_month}" varStatus="status">
						<option>${month}</option>
					</c:forEach>
					</c:if>
					</select>
					</td>

					<td id="historyByDate_day">
					<select>
					<c:if test="${not empty historyByDate_day}">
					<c:forEach var="day" items="${historyByDate_day}" varStatus="status">
						<option>${day}</option>
					</c:forEach>
					</c:if>
					</select>
					</td>

					<td><input type="submit" value="확인"></td>
				</tr>

			</table>

		</form>
	</section>

		
		<form action="/jvx330/manager/logoutManager" method="get">
			<input type="submit" value="메인화면으로 돌아가기">
		</form><br>
		
		<form action="/jvx330/sales/todaySalesHistory" method="get">
			<input type="submit" value="당일 판매내역">
		</form>
		
		<form action="/jvx330/sales/menuSalesHistory" method="get">
			<input type="submit" value="메뉴별 판매내역">
		</form>	
		
		<h3>총매출 확인</h3>
		<form action="/jvx330/sales/monthSalesTotalPrice" method="get">
		월별 내역:
			<select name="year">
				<option value="2015">2015</option>
				<option value="2016">2016</option>
				<option value="2017">2017</option>
				<option value="2018">2018</option>
				<option value="2019">2019</option>
				<option value="2020">2020</option>
				<option value="2021">2021</option>
			</select>
			<select name="month">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>
			<input type="submit" value="확인">
		</form>	
</body>
</html>