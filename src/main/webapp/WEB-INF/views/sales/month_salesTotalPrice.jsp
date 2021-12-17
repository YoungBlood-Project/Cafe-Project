<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>월별 총매출</title>
<link href='<c:url value="/resources/css/common.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
<section id="month_salesTotalPrice">
	<h2>월별 총매출</h2>
	<h3>${yyyyMM}</h3>
	
	<ul>
		<li>판매액 총합 : </li>
		<li>매출액 총합 : </li>
	</ul>
	
	<table>
		<tr>
			<td>날짜</td>
			<td>판매액</td>
			<td>매출액</td>
		</tr>
		<c:if test="${not empty stp_list}">
			<c:forEach var="stp" items="${stp_list}">
				<tr>
					<td><fmt:formatDate value="${stp.orderDate}" pattern="yyyy/MM/dd"/></td>
					<td>${stp.totalPrice}</td>
					<td>${stp.reducedPrice}</td>
				</tr>	
			</c:forEach>
		</c:if>
		
		
	</table>
	


	<form action="/jvx330/sales/mainSalesHistory" method="post">
		<input type="submit" value="판매내역 메인으로 돌아가기">
	</form>
</section>
	
</body>
</html>