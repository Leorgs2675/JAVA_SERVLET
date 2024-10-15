<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/14/2024
  Time: 8:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function confirmUpdate() {
            return confirm('Are you sure you want to update this ?');
        }
    </script>

</head>
<body>
<form action="/getAll" method="post" onsubmit="return confirmUpdate();">
    <input type="text" placeholder="Nhap ma" name="ma" value="${hd.ma}" required>
    <input type="text" placeholder="Nhap tong tien" name="tongTien" value="${hd.tongTien}" required>
    <input type="text" placeholder="Nhap tien thua" name="tienThua" value="${hd.tienThua}" required>
    <input type="text" placeholder="Nhap ghi chu" name="ghiChu" value="${hd.ghiChu}" required>
    <input type="text" placeholder="Nhap ma gd" name="maGD" value="${hd.maGD}" required>
    <button type="submit" value="update" name="action">update</button>
</form>
</body>
</html>
