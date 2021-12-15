<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당일 판매 내역</title>
</head>
<body>
<section id="today_salesHistory">
	<h2>당일 판매 내역</h2>
	<h3>총 매출: _______원  총 수량 : _______개</h3>
	<form>
		<table>
			<tr>
				<td>주문번호</td>
				<td>메뉴명</td>
				<td>수량</td>
				<td>판매가격</td>
				<td>구매일자</td>
			</tr>
			<c:if test="${not empty salesHistory_list}">
				<c:forEach var="salesHistory_list" items="${salesHistory_list}" varStatus="status">
					<tr>
						<td>${salesHistory_list.orderNum}</td>
						<td>${salesHistory_list.item.getItemName()}</td>
						<td>${salesHistory_list.numOfSales}</td>
						<td>${salesHistory_list.paidPrice}</td>
						<td>${salesHistory_list.orderDate}</td>
					</tr>
				</c:forEach>
			</c:if>
		
		</table>
	</form>
</section>
</body>
</html>