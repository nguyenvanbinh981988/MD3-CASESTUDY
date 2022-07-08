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
    <a href="/CustomerAction?action=trangchu">Quay về trang chủ</a>
  </h2>
</center>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <c:if test="${sellList != null}">
        <input type="hidden" name="id" value="<c:out value='${sellList.id}' />"/>
        <input type="hidden" name="exportAmount" value="<c:out value='${sellList.exportAmount}' />"/>
        <input type="hidden" name="customerId" value="<c:out value='${sellList.customer.customerId}' />"/>
        <input type="hidden" name="sellProductId" value="<c:out value='${sellList.sellProduct.sellProductId}' />"/>
        <input type="hidden" name="adminId" value="<c:out value='${sellList.admin.adminId}' />"/>
        <input type="hidden" name="statusCustomer" value="<c:out value='${sellList.statusCustomer}' />"/>
      </c:if>
      <tr>
        <th>tình trạng xuất hàng:</th>
      <tr>
        <td><select type="text" name="statusAdmin">
          <option value="đã nhận chuyển khoản">đã nhận chuyển khoản</option>
          <option value="đã giao hàng xong">đã giao hàng xong</option>
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


