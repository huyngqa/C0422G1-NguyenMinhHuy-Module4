<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        th {
            text-align: left;
        }
    </style>
</head>
<body>
    <h2>Settings</h2>
    <form:form action="/settings" method="post" modelAttribute="email">
        <table>
            <tr>
                <th><form:label path="language">Languages: </form:label></th>
                <td><form:select path="language" items="${languages}"></form:select></td>
            </tr>
            <tr>
                <th><form:label path="pageSize">Page Size: </form:label></th>
                <td><form:select path="pageSize" items="${pageSizeList}"> emails per page</form:select></td>
            </tr>
            <tr>
                <th><form:label path="spamsFilter">Spams Filter</form:label></th>
                <td><form:checkbox path="spamsFilter" value="true"></form:checkbox></td>
            </tr>
            <tr>
                <th><form:label path="signature">Signature</form:label></th>
                <td><form:textarea path="signature"></form:textarea></td>
            </tr>
                <td>
                    <button type="submit">Update</button>
                    <button type="reset">Cancel</button>
                </td>
        </table>
    </form:form>
</body>
</html>
