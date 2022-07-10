<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Admin</title>
</head>
<body>
<center>
    <h1>Sửa thông tin của Admin</h1>
    <h2>
        <a href="Admin?action=admin">Quay về danh sách Admin</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Sửa thông tin:
                </h2>
            </caption>
            <c:if test="${admin != null}">
                <input type="hidden" name="id" value="<c:out value='${admin.id}' />"/>
                <input type="hidden" name="passWord" value="<c:out value='${admin.passWord}' />"/>
            </c:if>
            <tr>
                <th>Tên Admin:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${admin.name}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>Vị trí công việc:</th>
                <td>
                    <input type="text" name="position" size="45"
                           value="<c:out value='${admin.position}' />"
                    />
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
