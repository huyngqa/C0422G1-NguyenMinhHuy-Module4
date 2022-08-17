<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <a href="/">Thêm mới tờ khai</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Họ tên</th>
            <th scope="col">Năm Sinh</th>
            <th scope="col">Giới tính</th>
            <th scope="col">Quốc tịch</th>
            <th scope="col">Số chứng minh nhân dân</th>
            <th scope="col">Thông tin đi lại</th>
            <th scope="col">Ngày khởi hành</th>
            <th scope="col">Ngày kết thúc</th>
            <th scope="col">Những nơi đã đi qua</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach varStatus="status" items="${declarations}" var="declaration">
            <tr>
                <th scope="row">${status.count}</th>
                <td>${declaration.value.name}</td>
                <td>${declaration.value.yearOfBirth}</td>
                <td>${declaration.value.gender}</td>
                <td>${declaration.value.nationality}</td>
                <td>${declaration.value.idCard}</td>
                <td>${declaration.value.travelInfo}</td>
                <td>${declaration.value.startDay}/${declaration.value.startMonth}/${declaration.value.startYear}</td>
                <td>${declaration.value.endDay}/${declaration.value.endMonth}/${declaration.value.endYear}</td>
                <td>${declaration.value.note}</td>
                <td><a href="/update?id=${declaration.value.id}" class="btn btn-success">Edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p class="text-success">${msg}</p>
</body>
</html>
