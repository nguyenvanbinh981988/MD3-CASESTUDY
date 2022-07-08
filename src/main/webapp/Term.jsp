<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Hóa Đơn</title>
</head>
<body>
<center>
  <h1>Hóa Đơn</h1>
  <h2>
    <a href="/Admin?action=class">Chuyển sang danh sách Admin</a>
    <br>
    <br>
    <a href="/SellProduct?action=sellproduct">Chuyển sang danh sách các hàng đăng trên Web </a>
    <br>
    <br>
    <a href="/Customer?action=customer">Chuyển sang danh sách khách hàng</a>
  </h2>

</center>
<div align="center">
  <table border="1" cellpadding="5">
    <caption><c:if test="${title != null}">
      <h2><c:out value='${title}' /></h2>
    </c:if></caption>
    <tr>
      <th>Id</th>
      <th>Tên Sản phẩm</th>
      <th>Tên Khách Hàng</th>
      <th>Tên Admin quản lý</th>
      <th>Số lượng hàng nhập</th>
      <th>Giá hàng</th>
      <th>Giảm giá</th>
      <th>rankGuest</th>
      <th>Tổng tiền</th>
      <th>Sửa</th>
      <th>Xóa</th>

    </tr>
    <c:forEach var="sellList" items="${sellLists}">
      <tr>
        <td><c:out value="${sellList.id}"/></td>
        <td><c:out value="${sellList.sellProduct.name}"/></td>
        <td><c:out value="${sellList.customer.name}"/></td>
        <td><c:out value="${sellList.admin.name}"/></td>
        <td><c:out value="${sellList.exportAmount}"/></td>
        <td><c:out value="${sellList.sellProduct.price}"/></td>
        <td><c:out value="${sellList.sellProduct.discount}"/></td>
        <td><c:out value="${sellList.rankguest.discount}"/></td>
        <td><c:out value="${sellList.sellProduct.price*sellList.sellProduct.discount*sellList.rankguest.discount}"/></td>

        <td><button type="button" class="btn btn-warning"><a href="/SellProduct?id=${sellProduct.id}&action=edit">Edit</a></button></td>
        <td><button type="button" class="btn btn-danger"><a href="/SellProduct?id=${sellProduct.id}&action=delete">Delete</a></button>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>

