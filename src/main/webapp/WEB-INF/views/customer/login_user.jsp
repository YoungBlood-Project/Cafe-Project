<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마일리지</title>

</head>
<body>
 <!-- <header></header> -->

  <main>

    <hgroup>
      <h2>마일리지</h2>
      <h3>${errorMsg}</h3>
    </hgroup>

    <form action="loginUser" method="post">
      <table>
        <tr>
          <td><label for="name">이름</label></td>
          <td><input type="text" name="name" maxlength="30"/></td>
          <!-- <td><input type="text" name="name" maxlength="30" value="${customer.name}"/></td> -->
        </tr>

        <tr>
          <td><label for="phone">번호</label></td>
          <td><input type="text" name="phone" maxlength="20" value="${customer.phone}"/></td>
          <!-- <td><input type="text" name="phone" maxlength="20" value="${customer.phone}"/></td> -->
        </tr>
      </table>
      <input type="submit" id="findButton" value="조회"/>
    </form>
    <a href="addCustomer" id="addMileageButton">회원가입</a>
  </main>

  <!-- <footer></footer> -->
</body>
</html>