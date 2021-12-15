<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문번호별 판매내역</title>
</head>
<body>
<section id="orNum_salesHistory">
	<h2>주문 번호별 판매내역</h2>
	<form action="/jvx330/sales/orderNumSalesHistory" method="post">
		주문번호: <input type="text" name="orderNum"/>
		<input type="submit" value="검색"/> 
	</form>
	
		
	<c:if test="${not empty salesHistory_list}">
		<p>총 수량:  ${totalNumOfPrice}
		  총 판매가격: ${salesTotalPrice.totalPrice}
		  지불가격: ${salesTotalPrice.reducedPrice} </p>	
		  
		<table>
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
	</c:if>
</section>
</body>
</html>