<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <form action="/calculate" method="get">
        <label for="num1">Number1: </label>
        <input type="number" value="" id="num1" name="number1" required>
        <br>
        <label for="num2">Number2: </label>
        <input type="number" value="" id="num2" name="number2" required>
        <span style="color: red">${numberErr}</span>
        <br>
        <input type="submit" name="operator" value="+">
        <input type="submit" name="operator" value="-">
        <input type="submit" name="operator" value="*">
        <input type="submit" name="operator" value="/">
    </form>
    <hr>
    <p>${result}</p>
</body>
</html>
