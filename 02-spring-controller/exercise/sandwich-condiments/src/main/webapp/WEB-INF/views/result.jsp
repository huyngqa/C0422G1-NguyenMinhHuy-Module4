<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Sandwich Condiments</h1>
    <h3>You have chosen condiments: </h3>
    <ol>
        <c:forEach items="${condiments}" var="condiment" >
                <li>${condiment}</li>
        </c:forEach>
    </ol>
    <span>${message}</span>
    <hr>
    <a href="/">Return Homepage</a>
</body>
</html>
