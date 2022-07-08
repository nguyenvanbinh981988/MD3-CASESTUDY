<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Tạo Admin mới</title>

</head>
<body>
<center>
    <h1>Tạo Admin mới</h1>
    <h2>
        <a href="Admin?action=admin">Quay về danh sách Admin</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Nhập thông Admin</h2>
            </caption>
            <tr>
                <th>Tên Admin:</th>
                <td>
                    <input type="text" name="name" id="nameAdmin" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Vị trí công việc:</th>
                <td>
                    <input type="text" name="position" id="priceAdmin" size="45"/>
                </td>
            </tr>
            <tr>
                <th>PassWork:</th>
                <td>
                    <input type="text" name="passWork" id="discountAdmin" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
