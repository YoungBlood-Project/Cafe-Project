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
	<h2>당일 판매 내역</h2>
	<form>
		<table>
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
	
</body>
</html>