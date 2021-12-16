<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>월간 메뉴별 판매내역</title>
</head>
<body>
<section id="m_month_salesHistory">
	<h2>월간 메뉴별 판매내역</h2>
	<p>${date.year}년 ${date.year}월 총 수량: 개 총 매출액: 원
	<table>
		<tr>
			<td>카테고리</td>
			<td>메뉴</td>
			<td>수량</td>
			<td>매출액</td>
		</tr>
		<c:if test=${not empty salesHistory_list}>
			<c:forEach var="salesHistory_list" items="${salesHistory_list}" varStatus="status">
			
			</c:forEach>
		</c:if>
	</table>
</section>
</body>
</html>