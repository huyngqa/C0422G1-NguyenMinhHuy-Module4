<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        table {
            border: 1px solid #000;
        }

        th, td {
            border: 1px dotted #555;
        }
    </style>
</head>
<body>
    There are ${requestScope.customers.size()} customer(s) in list.
    <table>
        <caption>Customers List</caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${requestScope.customers}">
            <tr>
                <td>
                    <c:out value="${c.id}"/>
                </td>
                <td>
                    <a href="/customer?id=${c.id}">${c.name}</a>
                </td>
                <td>
                    <c:out value="${c.email}"/>
                </td>
                <td>
                    <c:out value="${c.address}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
