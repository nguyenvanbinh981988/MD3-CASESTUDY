<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h2>
  <center>
    <h1>Student Management</h1>
    <h2>
      <a href="/ClassSt?action=class">Show List Class</a>
      <br>
      <br>
      <a href="/Students?action=create">Add New Student</a>
      <br>
      <br>
      <a href="/Students?action=find">find Student by Name</a>
    </h2>
  </center>
  <div align="center">
    <c:forEach var="student" items="${sell}">
      <table>
        <><c:out value="${student.id}"/></>
      <td><c:out value="${student.name}"/></td>
      <td><c:out value="${student.birthDay}"/></td>
      <td><c:out value="${student.address}"/></td>
      <td><c:out value="${student.phone}"/></td>
      <td><c:out value="${student.email}"/></td>
      <td><c:out value="${student.classSt.className}"/></td>
      <td>
        <a href="/Students?action=edit&id=${student.id}">Edit</a>
        <a href="/Students?action=delete&id=${student.id}">Delete</a>
      </td>
      </table>
    </c:forEach>
    </table>
  </div>
</h2>
</body>
</html>
