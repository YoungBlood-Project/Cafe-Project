<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 조회</title>
<link href='<c:url value="/resources/css/common.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/menu/search_items.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
<section id="search_items">
	
	<section id="searchItemsContent">
		<h2>메뉴 조회</h2>
		<form action="/jvx330/manager/logoutManager" method="get">
			<input type="submit" value="메인화면으로 돌아가기">
		</form>

		<section id="itemsSettingContent">
			<a href="addItems" id="addItems">메뉴 추가</a>
			<a href="setItems" id="setItems">메뉴 수정</a>
			<a href="delItems" id="delItems">메뉴 삭제</a>
		</section>		
		
		<table id="itemsTable">
			<tr id="itemsTableTitle">
				<th>순번</th>
				<th>카테고리</th>
				<th>메뉴명</th>
				<th>가격</th>
			</tr>
			
			<c:if test="${not empty categoryItemMap}">
				<c:forEach var="categoryItemMap" items="${categoryItemMap}" varStatus="status">
					<c:forEach var="categoryItemValue" items="${categoryItemMap.value}" >
					<tr id="itemsTableWrap">
						<td class="itemsTableList">${categoryItemValue.itemId}</td>
						<td class="itemsTableList">${categoryItemMap.key.categoryName}</td>
						<td class="itemsTableList">${categoryItemValue.itemName}</td>
						<td class="itemsTableList">${categoryItemValue.itemPrice}</td>
					</tr>	
					</c:forEach>
				</c:forEach>
			</c:if>
		</table>	
	</section>
</section>	
</body>
</html>