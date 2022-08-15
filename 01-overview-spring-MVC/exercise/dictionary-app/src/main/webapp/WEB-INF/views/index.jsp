<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <h2>Từ điển Anh-Việt</h2>
    <form action="/trans" method="get">
        <label for="words">Nhập từ bạn muốn dịch: </label>
        <input type="text" name="words" id="words" value="${words}">
        <br>
        <button>Dịch</button>
    </form>
    <p>${result}</p>
</body>
</html>
