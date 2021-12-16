<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마일리지</title>
<!-- <link href='<c:url value="/resources/css/membership/login_user.css"/>' rel="stylesheet" type="text/css"> -->
<link href='<c:url value="/resources/css/common.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
 <!-- <header></header> -->

  <section id="login_user">
    <hgroup>
      <h2>마일리지</h2>
      <h3>${errorMsg}</h3>
    </hgroup>

    <form action="loginUser" method="post">
      <table>
        <tr>
          <td><label for="name">이름</label></td>
          <td><input type="text" name="customer.name" maxlength="30"/></td>
          <!-- <td><input type="text" name="name" maxlength="30" value="${customer.name}"/></td> -->
        </tr>

        <tr>
          <td><label for="phone">번호</label></td>
          <td><input type="text" name="customer.phone" maxlength="20"/></td>
          <!-- <td><input type="text" name="phone" maxlength="20" value="${customer.phone}"/></td> -->
        </tr>
      </table>
      <input type="submit" id="findButton" value="조회"/>
    </form>
    <a href="addUser" id="addUserBtn">회원가입</a>
    <form action="/jvx330/main/payPrice" method="post">
    	<input type="submit" value="결제하기"/>
    </form>
  </section>

  <!-- <footer></footer> -->
</body>
</html>