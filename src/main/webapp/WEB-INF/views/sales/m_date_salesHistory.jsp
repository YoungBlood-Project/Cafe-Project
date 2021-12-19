<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날짜별 판매 내역</title>
<link href='<c:url value="/resources/css/common.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/sales/m_date_salesHistory.css"/>' rel="stylesheet" type="text/css">

</head>
<body>
	<section id="day_salesHistory">
		<h2>날짜별 메뉴별 판매내역</h2>
			
		<form action="/jvx330/sales/mainMSalesHistory" method="get">
			<input type="submit" value="다시 선택하기">
		</form>
	
		<c:if test="${not empty errorMsg}">
			<h3>${errorMsg}</h3>
		</c:if>
	<c:if test="${not empty save_sh_list}">
		<table>
			<tr>
				<td>${date}</td>
				<td>총 수량: ${totalNumOfSales}개</td>
				<td>총 판매액: ${totalPaidPrice}원</td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td>메뉴명</td>
				<td>수량</td>
				<td>매출액</td>
			</tr>
			<c:forEach var="i" begin="0" end="${fn:length(save_sh_list)}">
				<tr>
					<td>${categoryName_list[i]}</td>
					<td>${itemName_list[i]}</td>
					<td>${save_sh_list[i].numOfSales}</td>
					<td>${save_sh_list[i].paidPrice}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>	
	
	</section>
</body>
</html>