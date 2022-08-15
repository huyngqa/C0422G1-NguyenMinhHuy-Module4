<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08/12/22
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Ứng dụng chuyển đổi tiền tệ</h2>
    <form action="/convert" method="get">
        <label for="money">Nhập số tiền usd muốn chuyển đổi: </label>
        <input type="number" name="money" id="money" value="${money}">
        <span style="color: red">${message}</span>
        <br>
        <p>Tỉ giá: 23,000đ</p>
        <button>Chuyển đổi</button>
    </form>
    <p>${result}</p>
</body>
</html>
