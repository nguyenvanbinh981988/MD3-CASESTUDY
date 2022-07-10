<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Update statusCustomer</title>
</head>
<body>
<center>
  <h1>Sửa thông tin Tình trạng đặt hàng</h1>
  <h2>
    <a href="/SellProduct?action=home">Quay về trang chủ</a>
  </h2>
</center>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <c:if test="${sellList != null}">
        <input type="hidden" name="id" value="<c:out value='${sellList.id}' />"/>
        <input type="hidden" name="customerId" value="<c:out value='${sellList.customer.id}' />"/>
        <input type="hidden" name="sellProductId" value="<c:out value='${sellList.sellProduct.id}' />"/>
        <input type="hidden" name="adminId" value="<c:out value='${sellList.admin.id}' />"/>
        <input type="hidden" name="statusAdmin" value="<c:out value='${sellList.statusAdmin}' />"/>
      </c:if>
      <tr>
        <th>Số lượng đặt:</th>
        <th>tình trạng xuất hàng:</th>
      <tr>
      <td>
        <input  name="exportAmount" />
      </td>
        <td>
          <select type="text" name="statusCustomer">
          <option value="delivered">Đã nhận hàng</option>
          <option value="transferred">đã chuyển khoản</option>
        </select>
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


