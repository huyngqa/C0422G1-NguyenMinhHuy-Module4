<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border: 1px solid black;
        }
        th {
            text-align: left;
        }
    </style>
</head>
<body>
    <h3>Mail Box</h3>
    <table>
        <tr>
            <th>Language:</th>
            <td>${email.language}</td>
        </tr>
        <tr>
            <th>Page size:</th>
            <td>${email.pageSize}</td>
        </tr>
        <tr>
            <th>Spams Filter:</th>
            <td>${email.spamsFilter}</td>
        </tr>
        <tr>
            <th>Signature:</th>
            <td>${email.signature}</td>
        </tr>
    </table>
</body>
</html>
