<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/14/2024
  Time: 8:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        a {
            text-decoration: none;
            color: black;
        }
    </style>
    <script>
        // Confirmation for updating
        function confirmUpdate() {
            return confirm('Are you sure you want to update this ?');
        }

        // Confirmation for removing
        function confirmRemove() {
            return confirm('Are you sure you want to remove this ?');
        }
    </script>
</head>
<body>
<form action="/search" method="get">
    <input type="text" name="tim">
    <button type="submit">Search</button>
</form>
<form action="/getAll" method="post">
    <input type="text" placeholder="Nhap ma" name="ma">
    <input type="text" placeholder="Nhap tong tien" name="tongTien" required>
    <input type="text" placeholder="Nhap tien thua" name="tienThua" required>
    <input type="text" placeholder="Nhap ghi chu" name="ghiChu" required>
    <input type="text" placeholder="Nhap ma gd" name="maGD" required>
    <button type="submit" value="add" name="action">Add</button>
</form>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>MA</th>
        <th>TONG TIEN</th>
        <th>TIEN THUA</th>
        <th>GHI CHU</th>
        <th>MA GD</th>
        <th>ACTION</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="i" items="${list}" var="hd">
        <tr>
            <td><a href="/detail?ma=${hd.ma}">${i.index +1} </a></td>
            <td><a href="/detail?ma=${hd.ma}">${hd.ma} </a></td>
            <td><a href="/detail?ma=${hd.ma}">${hd.tongTien} </a></td>
            <td><a href="/detail?ma=${hd.ma}">${hd.tienThua} </a></td>
            <td><a href="/detail?ma=${hd.ma}">${hd.ghiChu} </a></td>
            <td><a href="/detail?ma=${hd.ma}">${hd.maGD} </a></td>
            <td>
                <a href="/delete?ma=${hd.ma}" onclick="return confirmRemove();">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
