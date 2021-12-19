<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문번호별 판매내역</title>
<link href='<c:url value="/resources/css/sales/orderNum_salesHistory.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
<section id="orNum_salesHistory">
	<h2>주문 번호별 판매내역</h2>
	<form action="/jvx330/sales/orderNumSalesHistory" method="post">
		주문번호: <input type="text" name="orderNum" placeholder="주문번호를 입력해주세요"/>
		<input type="submit" value="검색"/> 
	</form>
	<h3>${errorMsg}</h3>
		
	<c:if test="${not empty salesHistory_list}">
		<table>
			<tr>
				<td>총 수량: ${totalNumOfPrice}개</td>
				<td>총 판매가격: ${salesTotalPrice.totalPrice}원</td>
				<td>지불가격: ${salesTotalPrice.reducedPrice}원</td>
			</tr>
			<tr>
				<td>주문번호</td>
				<td>순번</td>
				<td>카테고리</td>
				<td>메뉴명</td>
				<td>수량</td>
				<td>판매가격</td>
				<td>구매일자</td>
			</tr>
			<c:forEach var="salesHistory_list" items="${salesHistory_list}" varStatus="status">
				<tr>
					<td>${salesHistory_list.orderNum}</td>
					<td>${status.count}</td>
					<td>${itemName_list[status.index]}</td>
					<td>${categoryName_list[status.index]}</td>
					<td>${salesHistory_list.numOfSales}</td>
					<td>${salesHistory_list.paidPrice}</td>
					<td>${salesHistory_list.orderDate}</td>
				</tr>
			</c:forEach>
		</table>
		
		<form action="/jvx330/sales/deleteOrderNumSalesHistory" method="get">
			<input type="hidden" value="${orderNum}" name="orderNum" />
			<input type="submit" value="삭제">
		</form>
	</c:if>
		<form action="/jvx330/main/index" method="get">
			<input type="submit" value="취소">
		</form>
	
</section>
</body>
</html>