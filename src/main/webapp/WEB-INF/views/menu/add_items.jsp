<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�޴� �߰�</title>
</head>
<body>
	<section id="addItemsContent">
	<h2>�޴� �߰�</h2>
	<form action="/menu/add_items" method="post">
		<table>
			<tr>
				<th>ī�װ�</th>
				<th>�޴���</th>
				<th>����</th>
			</tr>

			<tr>
				<td>
					<select>
						<c:if test="${not empty category_list}">
							<c:forEach var="category_list" items="${category_list}"
								varStatus="status">
								<option>${category_list.categoryName}</option>
							</c:forEach>
						</c:if>
					</select>
				</td>
		
				<td><input type="text" name="itemName"/></td>
				<td><input type="text" name="itemPrice"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="�߰� Ȯ��"/></td>
			</tr>
		</table>
	</form>
</section>

</body>
</html>