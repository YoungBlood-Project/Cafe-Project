<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<table>
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
</body>
</html>