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

	<form action="/menu/addItems" method="post">
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
								<option>${category_list}</option>
							</c:forEach>
						</c:if>
					</select>
				</td>
				<td><input type="text" value="itemName"/></td>
				<td><input type="text" value="itemPrice"/></td>
			</tr>
		</table>
	</form>


</body>
</html>