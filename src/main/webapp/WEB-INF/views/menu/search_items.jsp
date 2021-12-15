<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 조회</title>
</head>
<body>
<section id="search_items">

	<h2 class="hidden">메뉴 조회 및 메뉴 조회, 수정</h2>	
	
	<section id="searchItemsContent">
		<h3>메뉴 조회</h3>

		<section id="itemsSettingContent">
			<a href="add_items" id="addItems">메뉴 추가</a>
			<a href="set_items" id="setItems">메뉴 수정</a>
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
					<tr>
						<td>${categoryItemValue.itemId}</td>
						<td>${categoryItemMap.key.categoryName}</td>
						<td>${categoryItemValue.itemName}</td>
						<td>${categoryItemValue.itemPrice}</td>
					</tr>	
					</c:forEach>
				</c:forEach>
			</c:if>
		</table>	
	</section>
</section>	
</body>
</html>