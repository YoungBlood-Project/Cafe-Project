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

	<header>
		<h2 class="hidden">메뉴 조회 및 메뉴 조회, 수정</h2>	
	</header>
	
	<section id="searchItemsContent">
		<h3>메뉴 조회</h3>

		<section id="itemsSettingContent">
			<button id="addItems">메뉴 추가</button>
			<button id="setItems">메뉴 수정</button>
		</section>		
		
		<table id="ItemsTable">
			<tr>
				<th>순번</th>
				<th>카테고리</th>
				<th>메뉴명</th>
				<th>가격</th>
			</tr>
			
			
		</table>
	</section>
</body>
</html>