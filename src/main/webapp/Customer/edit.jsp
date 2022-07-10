<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Customer</title>
</head>
<body>
<center>
    <h1>Update tình trạng xuất hàng</h1>
    <h2>
        <a href="Customer?action=customer">Quay về danh sách khách hàng</a>
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
            <c:if test="${customer != null}">
                <input type="hidden" name="id" value="<c:out value='${customer.id}' />"/>
                <input type="hidden" name="name" value="<c:out value='${customer.name}' />"/>
                <input type="hidden" name="passWord" value="<c:out value='${customer.passWord}' />"/>

            </c:if>
            <tr>
                <th>Số thẻ ngân hàng:</th>
                <td>
                    <input type="text" name="bankCard" size="45"
                           value="<c:out value='${customer.bankCard}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>Rank khách hàng:</th>
                <td>
                    <input type="text" name="rankG" size="45"
                           value="<c:out value='${customer.rankGuest.rankG}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>Địa chỉ:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${customer.address}' />"
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

