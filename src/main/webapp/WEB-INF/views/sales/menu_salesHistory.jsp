<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴별 판매 내역</title>
</head>

<body>

 <header>
    <h2 class="hidden">메뉴별 판매 내역</h2>
  </header>

  <main>
    <section id="salesHistoryContent">
    <h3>메뉴별 판매 내역</h3>
    
    <form action="menuSalesHistory" method="get">
      <table>
        <tr>
          <td><label>날짜별 내역</label></td>
          <td id="historyByDate_year">
            <select>
              <option value="2010">2010</option>
              <option value="2011">2011</option>
              <option value="2012">2012</option>
              <option value="2013">2013</option>
              <option value="2014">2014</option>
              <option value="2015">2015</option>
              <option value="2016">2016</option>
              <option value="2017">2017</option>
              <option value="2018">2018</option>
              <option value="2019">2019</option>
              <option value="2020">2020</option>
              <option value="2021" selected>2021</option>
            </select>
          </td>
          
          <td id="historyByDate_month">
            <select>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              <option value="6">6</option>
              <option value="7">7</option>
              <option value="8">8</option>
              <option value="9">9</option>
              <option value="10">10</option>
              <option value="11">11</option>
              <option value="12">12</option>
            </select>
          </td>
          
          <td id="historyByDate_Date">
            <select>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              <option value="6">6</option>
              <option value="7">7</option>
              <option value="8">8</option>
              <option>9</option>
              <option>10</option>
              <option>11</option>
              <option>12</option>
              <option>13</option>
              <option>14</option>
            </select>
          </td>

          <td>
            <input type="submit" value="확인">
          </td>
        </tr>

      </table>

    </form>

    </section>
  </main>
  
</body>
</html>