<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Tạo sản phẩm mới</title>

</head>
<body>
<center>
    <h1>Tạo một sản phẩm mới</h1>
    <h2>
        <a href="SellProduct?action=showList">Quay về danh sách sản phẩm</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Nhập thông tin sản phẩm mới</h2>
            </caption>
            <tr>
                <th>Tên sản phẩm:</th>
                <td>
                    <input type="text" name="name" id="nameSellProduct" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Giá bán:</th>
                <td>
                    <input type="text" name="price" id="priceSellProduct" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Giảm giá:</th>
                <td>
                    <input type="text" name="discount" id="discountSellProduct" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Số lượng hàng nhập:</th>
                <td>
                    <input type="text" name="importAmount" id="importAmountSellProduct" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Số lượng hàng đã bán:</th>
                <td>
                    <input type="text" name="exportAmount" id="exportAmountSellProduct" size="45"/>
                </td>
            </tr>
            <tr>
                <td>Ảnh sản phẩm:</td>
                <td>
                    <input type="text" name="picture" id="pictureSellProduct" size="45"/>
                </td>
            </tr>
            <tr>
                <td>Mô tả:</td>
                <td>
                    <input type="text" name="properties" id="propertiesSellProduct" size="45"/>
                </td>
            </tr>
            <tr>
                <td>Loại sản phẩm:</td>
                <td>
                    <input type="text" name="productType" id="productTypeSellProduct" size="45"/>
                </td>
            </tr><tr>
            <td>nhãn hàng:</td>
            <td>
                <input type="text" name="maker" id="makerSellProduct" size="45"/>
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
