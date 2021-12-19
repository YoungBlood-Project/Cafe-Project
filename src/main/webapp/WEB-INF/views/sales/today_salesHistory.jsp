<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당일 판매 내역</title>
<link href='<c:url value="/resources/css/sales/today_salesHistory.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
<section id="today_salesHistory">
	<h2>당일 판매 내역</h2>
	<c:if test="${not empty errorMsg}">
		<h3>${errorMsg}</h3>
	</c:if>
	<form action="/jvx330/sales/mainSalesHistory" method="post">
		<input type="submit" value="판매내역 메인으로 돌아가기">
	</form>
	<form>
		<table id="t_salesHistoryTable">
			<tr id="t_salesHistoryTable_totalPrice">
				<td>총 판매가격: ${sumTotalPrice}원</td>
				<td>총 매출액:<strong>${sumReducedPrice}원 </strong></td>
				<td>총 수량: <strong>${sumNumOfsales}개</strong></td>
			</tr>
			<tr id="t_salesHistoryTitle">
				<th>주문번호</th>
				<th>카테고리명</th>
				<th>메뉴명</th>
				<th>수량</th>
				<th>판매가격</th>
				<th>구매일자</th>
			</tr>
			<c:if test="${not empty salesHistory_list}">
				<c:forEach var="salesHistory_list" items="${salesHistory_list}" varStatus="status">
					<tr id="t_salesHistoryWrap">
						<td class="t_salesHistoryList">${salesHistory_list.orderNum}</td>
						<td class="t_salesHistoryList">${categoryName_list[status.index]}</td>
						<td class="t_salesHistoryList">${itemName_list[status.index]}</td>
						<td class="t_salesHistoryList">${salesHistory_list.numOfSales}</td>
						<td class="t_salesHistoryList">${salesHistory_list.paidPrice}</td>
						<td class="t_salesHistoryList">${salesHistory_list.orderDate}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</form>
</section>
</body>
</html>