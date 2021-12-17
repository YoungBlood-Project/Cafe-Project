<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 추가</title>
<link href='<c:url value="/resources/css/common.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/menu/add_items.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
	<section id="addItemsContent">
	<h2>메뉴 추가</h2>
	<h3>${errorMsgs}</h3>
	<form action="addItems" method="post">
		<table>
			<tr id="titleWrap">
				<th class="title">카테고리</th>
				<th class="title">메뉴명</th>
				<th class="title">가격</th>
			</tr>

			<tr>
				<td>
					<select name="categoryName" id="categoryName">
						<c:if test="${not empty category_list}">
							<c:forEach var="category_list" items="${category_list}"
								varStatus="status">
								<option value="${category_list.categoryName}">${category_list.categoryName}</option>
							</c:forEach>
						</c:if>
					</select>
				</td>
		
				<td><input type="text" name="itemName" class="itemInfo"/></td>
				<td><input type="text" name="itemPrice" class="itemInfo"/></td>
			</tr>
			
			<tr id="submitWrap">
				<td><input type="submit" value="추가 확인" id="submit"/></td>
			</tr>
		</table>
	</form>
</section>

</body>
</html>