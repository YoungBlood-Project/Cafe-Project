<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당일 판매 내역</title>
<link href='<c:url value="/resources/css/common.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/sales/today_salesHistory.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
<section id="today_salesHistory">
	<h2>당일 판매 내역</h2>
	<c:if test="${not empty errorMsg}">
		<h3>${errorMsg}</h3>
	</c:if>
	<form>
		<table>
			<tr>
				<td>총 판매가격: ${sumTotalPrice}원</td>
				<td>총 매출액: ${sumReducedPrice}원</td>
				<td>총 수량: ${sumNumOfsales}개</td>
			</tr>
			<tr>
				<td>주문번호</td>
				<td>카테고리명</td>
				<td>메뉴명</td>
				<td>수량</td>
				<td>판매가격</td>
				<td>구매일자</td>
			</tr>
			<c:if test="${not empty salesHistory_list}">
				<c:forEach var="salesHistory_list" items="${salesHistory_list}" varStatus="status">
					<tr>
						<td>${salesHistory_list.orderNum}</td>
						<td>${categoryName_list[status.index]}</td>
						<td>${itemName_list[status.index]}</td>
						<td>${salesHistory_list.numOfSales}</td>
						<td>${salesHistory_list.paidPrice}</td>
						<td>${salesHistory_list.orderDate}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</form>
	<form action="/jvx330/sales/mainSalesHistory" method="post">
		<input type="submit" value="판매내역 메인으로 돌아가기">
	</form>
</section>
</body>
</html>