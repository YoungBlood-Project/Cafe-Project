<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>월간 메뉴별 판매내역</title>
</head>
<body>
<section id="m_month_salesHistory">
	<h2>월간 메뉴별 판매내역</h2>
	<c:if test="${not empty save_sh_list}">
		<table>
			<tr>
				<td>${date.year}년</td>
				<td>${date.month}월</td>
				<td>총 수량: ${totalNumOfSales}개</td>
				<td>총 매출액: ${totalPaidPrice}원</td>
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
	
	<form action="/jvx330/sales/mainMSalesHistory" method="get">
		<input type="submit" value="다시 선택하기">
	</form>
</section>
</body>
</html>