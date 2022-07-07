<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit a SellProduct</title>
</head>
<body>
<center>
    <h1>Sửa thông tin của Hàng đăng trên Web</h1>
    <h2>
        <a href="SellProduct?action=Sell">Quay về danh sách sản phẩm đăng lên Web</a>
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
            <c:if test="${sellProduct != null}">
                <input type="hidden" name="id" value="<c:out value='${sellProduct.id}' />"/>
            </c:if>
            <tr>
                <th>Tên sản phẩm:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${sellProduct.name}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>Giá bán::</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="<c:out value='${sellProduct.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Giảm giá::</th>
                <td>
                    <input type="text" name="discount" size="45"
                           value="<c:out value='${sellProduct.discount}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Số lượng hàng nhập:</th>
                <td>
                    <input type="text" name="importAmount" size="45"
                           value="<c:out value='${sellProduct.importAmount}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Số lượng hàng đã bán:</th>
                <td>
                    <input type="text" name="exportAmount" size="45"
                           value="<c:out value='${sellProduct.exportAmount}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Ảnh sản phẩm:</th>
                <td>
                    <input type="text" name="picture" size="15"
                           value="<c:out value='${sellProduct.picture}'/> "
                    />
                </td>
            </tr>
            <tr>
                <th>Mô tả:</th>
                <td>
                    <input type="text" name="properties" size="15"
                           value="<c:out value='${sellProduct.properties}'/> "
                    />
                </td>
            </tr>
            <tr>
                <th>Loại sản phẩm:</th>
                <td>
                    <input type="text" name="productType" size="15"
                           value="<c:out value='${sellProduct.productType}'/> "
                    />
                </td>
            </tr>
            <tr>
                <th>nhãn hàng:</th>
                <td>
                    <input type="text" name="maker" size="15"
                           value="<c:out value='${sellProduct.maker}'/> "
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
