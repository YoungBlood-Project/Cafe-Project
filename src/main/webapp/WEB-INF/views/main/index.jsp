<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Javac cafe</title>
<script src='<c:url value="/resources/js/jquery-3.6.0.min.js"/>'></script>
<script src='<c:url value="/resources/js/common.js"/>' defer></script>
<script src='<c:url value="/resources/js/index.js"/>' defer></script>
<link href='<c:url value="/resources/css/index.css"/>' rel="stylesheet" type="text/css">
</head>

<body>
    <header>
        <h1 class="hidden">JAVAK CAFE 자박 카페</h1>
    </header>
    <section id="main">
    	<h2 class="hidden">주문내역 및 메뉴</h2>
		<section id="sectionLeft" class="cont">
            <h3 id="orderList_h3">주문 내역</h3>
            <form action="${index_link}" method="post">
            	<table id="orderList">
            	<!-- 안에 내용 넣는 자바 스크립트 사용할 것 -->
					<thead>
						<tr class="gradient">
                    		<th>순번</th>
                    		<th>제품명</th>
                    		<th>수량</th>
                    		<th>단가</th>
                    		<th>금액</th>
                		</tr>
					</thead>
					<tbody>
					<c:forEach var="orderItems" items="${orderContainer.orderItemsList}" varStatus="status">
                		<tr class="orderItems">
                			<td class='orderItemsNum'>${status.count}</td>
                			<td>
                				<input type='text' name='orderItemsList[${status.count-1}].menuName' 
                					value='${orderItems.menuName}' readonly='readonly' class='menuName${status.count}'/></td>
                			<td>
                				<input type='text' name='orderItemsList[${status.count-1}].numOfNum' 
                					value='${orderItems.numOfNum}' readonly='readonly' class='numOfNum${status.count}'></td>
                			<td class='orderList_right'>
                				<input type='text' name='orderItemsList[${status.count-1}].menuPrice' value='${orderItems.menuPrice}' readonly='readonly' class='menu_price' ></td>
                			<td class='orderList_right'>
                				<input type='text' name='orderItemsList[${status.count-1}].paidPrice' value='${orderItems.paidPrice}' readonly='readonly' class='paidPrice" + i + "'></td>
                		<!-- 
							<td>${status.count}</td>
							<td>${orderItems.menuName}</td>
							<td>${orderItems.numOfNum}</td>
							<td>${orderItems.menuPrice}</td>
							<td>${orderItems.paidPrice}</td>
						-->
                		</tr>
                	</c:forEach>
					</tbody>
            	</table>
            	
            	<table id="count">
            	<!-- text, value에 값 넣는 자바 스크립트 사용할 것 -->
                	<tr>
                    	<td>총 수량</td>
                    	<td><input type="text" name="salesTotalPrice.orderNum" value="${orderContainer.salesTotalPrice.getOrderNum()}" readonly="readonly" id="total_num"/></td>
                	</tr>
                	<tr>
                    	<td>총 금액</td>
                    	<td><input type="text" name="salesTotalPrice.totalPrice" value="${orderContainer.salesTotalPrice.getTotalPrice()}" readonly="readonly" id="total_amount"/></td>
                	</tr>
                	<tr>
                    	<td>할인 금액</td>
                    	<td id="mileage">
                    		<c:choose>
                    			<c:when test="${not empty use_amount}">
                    				<input type="text" name="mileageHistory.mBalance" value="${-use_amount}" readonly="readonly"/>
                    			</c:when>
                    			<c:otherwise>
	                    			<input type="hidden" name="mileageHistory.mBalance" value="${orderContainer.mileageHistory.getMBalance()}" readonly="readonly"/>
                    				0
                    			</c:otherwise>
                    		</c:choose>                    		
                    	</td><!-- el태그로 마일리지 넣기 -->
                	</tr>
                	<tr>
                    	<td>받을 금액</td>
                    	<td><input type="text" name="salesTotalPrice.reducedPrice" value="${orderContainer.salesTotalPrice.getReducedPrice()}" readonly="readonly" id="reducedPrice" /></td>
                	</tr>
            	</table>
				<input type="submit"  value="결제하기">
			</form>    
        </section>
        
        <section id="sectionRight" class="cont">
		<c:if test="${not empty ciMap}">
			<ul id="menu">
				<c:forEach var="ciMap" items="${ciMap}" varStatus="status">
					<li class="title">${ciMap.key.categoryName}</li>
				</c:forEach>		
			</ul>
		</c:if>
		
		<c:if test="${not empty ciMap}">
			<c:forEach var="ciMap" items="${ciMap}">
				<ul class="sub ${ciMap.key.categoryName}"> 
				<c:forEach var="ciValue" items="${ciMap.value}" >
					<li>
					<img src="../resources/${ciValue.itemUrl}" alt="${ciValue.itemName}"><br>
					<span>${ciValue.itemName}</span><br>
					${ciValue.itemPrice}원
					</li>
				</c:forEach>
				</ul>
			</c:forEach>
		</c:if>
		</section>
	</section>
	
    <footer>   
        <ul id="ownerSet">
            <li>
                <form action="/jvx330/sales/mainSalesHistory" method="get">
                    <input type="submit"  value="판매내역">
                </form>
            </li>
            <li>
                <form action="/jvx330/menu/searchItems" method="get">
                    <input type="submit"  value="메뉴관리">
                </form>
            </li>
            <li>
                <form action="/jvx330/sales/orderNumSalesHistory" method="get">
                    <input type="submit"  value="주문번호로 조회">
                </form>
            </li>
            <!-- 마일리지, 결제하기 위치 일단 이동 -->
            <!-- 인덱스 경로 구조 바꿔야...? 일단 JS 완성 되고 난 후에 이동...? -->
        </ul>
    </footer> 
    
    <p>시계</p>
</body>
</html>