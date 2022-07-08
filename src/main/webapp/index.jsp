<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
<head>
    <title>Lấy lại passWork</title>
    <!--Made with love by Mutiullah Samim -->

    <!--Bootsrap 4 CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <!--Custom styles-->
    <style>
        /* Made with love by Mutiullah Samim*/
        @import url('https://fonts.googleapis.com/css?family=Numans');
        html,body{
            background-image: url('http://getwallpapers.com/wallpaper/full/a/5/d/544750.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            height: 100%;
            font-family: 'Numans', sans-serif;
        }
        .container{
            height: 100%;
            align-content: center;
        }
        .card{
            height: 370px;
            margin-top: auto;
            margin-bottom: auto;
            width: 400px;
            background-color: rgba(0,0,0,0.5) !important;
        }
        .social_icon span{
            font-size: 60px;
            margin-left: 10px;
            color: #FFC312;
        }
        .social_icon span:hover{
            color: white;
            cursor: pointer;
        }
        .card-header h3{
            color: white;
        }
        .social_icon{
            position: absolute;
            right: 20px;
            top: -45px;
        }
        .input-group-prepend span{
            width: 50px;
            background-color: #FFC312;
            color: black;
            border:0 !important;
        }
        input:focus{
            /*outline: 0 0 0 0  !important;*/
            box-shadow: 0 0 0 0 !important;
        }
        .remember{
            color: white;
        }
        .remember input
        {
            width: 20px;
            height: 20px;
            margin-left: 15px;
            margin-right: 5px;
        }
        .login_btn{
            color: black;
            background-color: #FFC312;
            width: 100px;
        }
        .login_btn:hover{
            color: black;
            background-color: white;
        }
        .links a{
            margin-left: 4px;
        }
    </style>
</head>
<body>
<h2>
    <center>
        <h1>Student Management</h1>
        <h2>
            <button type="button" class="btn btn-warning"><a href="/Login?action=LoginCustomer">Login</a></button>
            <br>
            <br>
            <button type="button" class="btn btn-warning"><a href="/Login?action=LoginAdmin">Admin</a></button>
            <br>
            <br>
            <button type="button" class="btn btn-warning"><a href="/Login?action=LoginAdmin">Laptop</a></button>
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

