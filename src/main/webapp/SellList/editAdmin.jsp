<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Update statusAdmin</title>
</head>
<body>
<center>
  <h1>Sửa thông tin tình trạng xuất hàng</h1>
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
        <input type="hidden" name="statusAdmin" value="<c:out value='${sellList.statusAdmin}' />"/>
      </c:if>
      <tr>
        <th>tình trạng xuất hàng:</th>
      <tr>
        <td><select type="text" name="statusCustomer">
          <option value="giao hàng nhận tiền">giao hàng nhận tiền</option>
          <option value="đã chuyển khoản">đã chuyển khoản</option>
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

