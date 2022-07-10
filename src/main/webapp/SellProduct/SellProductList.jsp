<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
<head>
    <title>SellProductList</title>
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
<center>
    <h1 style="background-color: blue">Danh sách sản phẩm đăng ký lên trang Web</h1>
    <h2>
        <button type="button" class="btn btn-warning"><a href="/SellProduct?action=sellProduct">SellProductList</a></button>
        <button type="button" class="btn btn-warning"><a href="/Customer?action=customer">CustomerList</a></button>
        <button type="button" class="btn btn-warning"><a href="/Admin?action=admin">AdminList</a></button>
        <button type="button" class="btn btn-warning"><a href="/SellList?action=sellList">SellList</a></button>
        <br>
        <br>
        <button type="button" class="btn btn-warning"><a href="/SellProduct?action=home">Back HomePage</a></button>
        <br>
        <br>
        <button type="button" class="btn btn-light"><a href="/SellProduct?action=create">AddSellProduct</a></button>
        <br>
        <br>
        <form>
            <div class="input-group form-group" style="width: fit-content">

                <input type="text" class="form-control" name="find" placeholder="tên, loại Sp, nhãn hiệu">
                <div class="input-group-prepend">
                    <input type="submit"  value="find" class="input-group-text"><i></i></input>
                </div>

            </div>
        </form>
    </h2>

</center>
<div align="center">
    <table border="1" cellpadding="5" style="background-color: antiquewhite">
        <tr>
            <th>Id</th>
            <th>Tên sản phẩm</th>
            <th>Giá bán</th>
            <th>Giảm giá</th>
            <th>Số lượng hàng nhập</th>
            <th>Số lượng hàng bán</th>
            <th>Hàng còn trong kho</th>
            <th>Ảnh sản phẩm</th>
            <th>Mô tả</th>
            <th>Loại sản phẩm</th>
            <th>nhãn hàng</th>
            <th>Sửa</th>
            <th>Xóa</th>

        </tr>
        <c:forEach var="sellProduct" items="${sellProducts}">
            <tr>
                <td><c:out value="${sellProduct.id}"/></td>
                <td><c:out value="${sellProduct.name}"/></td>
                <td><c:out value="${sellProduct.price}"/></td>
                <td><c:out value="${sellProduct.discount}"/></td>
                <td><c:out value="${sellProduct.importAmount}"/></td>
                <td><c:out value="${sellProduct.exportAmount}"/></td>
                <td><c:out value="${sellProduct.importAmount-sellProduct.exportAmount}"/></td>
                <td><img src="${sellProduct.picture}" width="200" height="100%"></td>
                <td><c:out value="${sellProduct.properties}"/></td>
                <td><c:out value="${sellProduct.productType}"/></td>
                <td><c:out value="${sellProduct.maker}"/></td>
                <td><button type="button" class="btn btn-warning"><a href="/SellProduct?id=${sellProduct.id}&action=edit">Edit</a></button></td>
                <td><button type="button" class="btn btn-danger"><a href="/SellProduct?id=${sellProduct.id}&action=delete">Delete</a></button>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

