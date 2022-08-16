<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <h1>Sandwich Condiments</h1>
    <form action="/choose-condiments" method="post">
        <c:forEach var="condiment" items="${condimentsList}">
            <input type="checkbox" name="condiments" value="${condiment}">${condiment}
        </c:forEach>
        <hr>
        <button>Save</button>
    </form>
</body>
</html>
