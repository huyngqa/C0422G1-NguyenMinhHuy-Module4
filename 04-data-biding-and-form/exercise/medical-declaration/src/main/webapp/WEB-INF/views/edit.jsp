<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <h3>TỜ KHAI Y TẾ</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-center">
                <h4>
                    ĐÂY LÀ TÀI LIỆU QUAN , THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN LIÊN LẠC KHI CẦN THIẾT
                    ĐỂ ĐỀ PHÒNG DỊCH BỆNH TRUYỀN NHIỄM
                </h4>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-center text-danger">
                <p>Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>
            </div>
        </div>
        <form:form action="/update" method="post" modelAttribute="declaration">
            <form:hidden path="id"></form:hidden>
            <div class="row">
                <div class="col-lg-12">
                    <div class="mb-3">
                        <label for="name" class="form-label">Họ Tên (ghi chữ IN HOA)</label>
                        <form:input class="form-control" path="name"/>
                    </div>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-lg-4">
                    <label for="yearOfBirth" class="form-label">Năm sinh</label>
                    <form:select class="form-control" path="yearOfBirth" items="${years}"/>
                </div>

                <div class="col-lg-4">
                    <label for="gender" class="form-label">Giới tính</label>
                    <form:select class="form-control" path="gender" items="${genders}"/>
                </div>

                <div class="col-lg-4">
                    <label for="nationality" class="form-label">Quốc tịch</label>
                    <form:select class="form-control" path="nationality" items="${nations}"/>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="mb-3">
                        <label for="idCard" class="form-label">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp
                            khác</label>
                        <form:input class="form-control" path="idCard"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="mb-3">
                        <label for="travelInfo" class="form-label">Thông tin đi lại: </label>
                        <form:radiobuttons class="form-control form-check-input form-check form-check-inline"
                                           path="travelInfo" items="${travels}"/>
                    </div>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-lg-6">
                    <label for="vehicleNumber" class="form-label">Số hiệu phương tiện</label>
                    <form:input class="form-control" path="vehicleNumber"/>
                </div>

                <div class="col-lg-6">
                    <label for="seats" class="form-label">Số ghế</label>
                    <form:input class="form-control" path="seats"/>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="mb-3">
                        <label for="startDay" class="form-label">Ngày khởi hành</label>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="mb-3">
                        <label for="seats" class="form-label">Ngày kết thúc</label>
                    </div>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-lg-2">
                    <form:select class="form-control" path="startDay" items="${days}"/>
                </div>
                <div class="col-lg-2">
                    <form:select class="form-control" path="startMonth" items="${months}"/>
                </div>
                <div class="col-lg-2">
                    <form:select class="form-control" path="startYear" items="${years}"/>
                </div>
                <div class="col-lg-2">
                    <form:select class="form-control" path="endDay" items="${days}"/>
                </div>
                <div class="col-lg-2">
                    <form:select class="form-control" path="endMonth" items="${months}"/>
                </div>
                <div class="col-lg-2">
                    <form:select class="form-control" path="endYear" items="${years}"/>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="mb-3">
                        <label for="note" class="form-label">
                            Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?(*)
                        </label>
                        <form:textarea class="form-control" path="note"/>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
        <div class="row">
            <div class="col-lg-12">
                <a href="/list">Danh sách tờ khai</a>
            </div>
        </div>
    </div>
</body>
</html>
