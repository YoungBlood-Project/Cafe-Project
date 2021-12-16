<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 추가</title>
</head>
<body>
	<section id="addItemsContent">
	<h2>메뉴 추가</h2>
	<form action="addItems" method="post">
		<table>
			<tr>
				<th>카테고리</th>
				<th>메뉴명</th>
				<th>가격</th>
			</tr>

			<tr>
				<td>
					<select name="categoryName">
						<c:if test="${not empty category_list}">
							<c:forEach var="category_list" items="${category_list}"
								varStatus="status">
								<option value="${category_list.categoryName}">${category_list.categoryName}</option>
							</c:forEach>
						</c:if>
					</select>
				</td>
		
				<td><input type="text" name="itemName"/></td>
				<td><input type="text" name="itemPrice"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="추가 확인"/></td>
			</tr>
		</table>
	</form>
</section>

</body>
</html>