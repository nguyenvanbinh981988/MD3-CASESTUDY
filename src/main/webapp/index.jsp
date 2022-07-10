<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <title>Thế giới số</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <!--Made with love by Mutiullah Samim -->

    <!--Bootsrap 4 CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <!--Custom styles-->
    <style>
        .fakeimg {
            height: 200px;
            background: #aaa;
        }

        .input-group-prepend span {
            width: 50px;
            background-color: #FFC312;
            color: black;
            border: 0 !important;
        }

        div.desc {
            padding: 10px;
            text-align: left;
        }

        div.image1 {
            border: 1px solid #ccc;
        }

        div.image1:hover {
            border: 1px solid #777;
        }

        div.image1 img {
            width: 100%;
            height: auto;
        }

        div.desc {
            padding: 15px;
            text-align: center;
        }

        * {
            box-sizing: border-box;
        }

        .image {
            padding: 0 6px;
            float: left;
            width: 24.99999%;
        }

        @media only screen and (max-width: 700px) {
            .image {
                width: 49.99999%;
                margin: 6px 0;
            }
        }

        @media only screen and (max-width: 500px) {
            .image {
                width: 100%;
            }
        }

        .clearfix:after {
            content: "";
            display: table;
            clear: both;
        }

    </style>
</head>
<body>

<%-----------------------------header------------------------%>
<div class="container">
    <div class="row">
        <div class="col-4 ">
            <div class="input-group form-group">
                <div class="input-group-prepend">
                    <img src="https://ionetech.vn/Thumb/480x%20auto/2020/04/24/202004241051525246-4340f876070561c005eebe0c438037e6.jpg"
                         class="img-circle" alt="Cinque Terre" style="width: 60px" height="100%">
                </div>
                <h1>
                    <a href="/SellProduct">Thế giới số</a></h1>
            </div>
        </div>
        <div class="col-4 " class="input-group form-group">
            <form>
                <input hidden name="action" value="findA">
                <div class="input-group form-group" style="width: 200px">
                    <input type="text" style="width: 150px" class="form-control" name="find"
                           placeholder="Bạn muốn tìm sản phẩm gì?">
                    <div class="input-group-prepend">
                        <input type="submit" value="find">
                    </div>
                </div>
            </form>
        </div>
        <div class="col-4 ">
            <div class="input-group form-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"><i class="fas fa-phone"></i></span>
                </div>
                <p>HotLine: 0987654321 </p>
            </div>
        </div>
    </div>
</div>

<%-----------------------------navigation------------------------%>


<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container">
        <div class="row">
            <div class="col-2">

                <div class="input-group-prepend">
                    <span class="input-group-text"><i class="fas fa-mobile-alt"></i></span>
                </div>
                <a href="CustomerAction?action=smartPhone">Điện thoại</a>

            </div>
            <%--        --%>
            <div class="col-2">
                <div class="input-group-prepend">
                    <span class="input-group-text"><i class="fas fa-laptop"></i></span>
                </div>
                <a href="CustomerAction?action=laptop">LapTop</a>
            </div>
            <%--        --%>
            <div class="col-2">
                <div class="input-group-prepend">
                    <span class="input-group-text"><i class="fas fa-tablet-alt"></i></span>
                </div>
                <a href="CustomerAction?action=tablet">Máy tính bảng</a>
            </div>
            <%--        --%>
            <div class="col-2">
                <div class="input-group-prepend">
                    <span class="input-group-text"><i class="fas fa-desktop"></i></span>
                </div>
                <a href="CustomerAction?action=computer">Máy tính bàn</a>
            </div>
            <%--        --%>
            <div class="col-2">
                <div class="input-group-prepend">
                    <span class="input-group-text"><i class="fas fa-phone"></i></span>
                </div>
                <a href="CustomerAction?action=watch">Đồng hồ</a>
            </div>
            <%--        --%>
            <%--            <div class="col-1">--%>
            <%--                <p><i></i></p>--%>
            <%--            </div>--%>
            <%--            --%>
            <c:if test="${user == null && userAdmin == null  }">
                <div class="col-2" style="text-align: right">
                    <button><a href="/Login?action=LoginAdmin">Admin</a></button>
                    <button><a href="/Login?action=LoginCustomer">Login</a></button>
                </div>
            </c:if>


            <c:if test="${user != null}">
                <div class="input-group-prepend" class="col-2" style="position: center">

                    <button><h6><c:out value="${user.name}"/></h6></button>
                    <button type="button" class="btn btn-light"><a href="/Login?action=outCustomer">Sign out</a>
                    </button>
                    <button type="button" class="btn btn-light"><a href="/CustomerAction?action=notOrderedYet">hàng trong giỏ</a></button>
                    <button type="button" class="btn btn-light"><a href="/CustomerAction?action=transferred">hàng đã chuyển
                            khoản</a></button>
                    <button type="button" class="btn btn-light"><a href="/CustomerAction?action=delivered">lịch sử giao
                        dịch</a></button>
                </div>
                </div>


            </c:if><c:if test="${userAdmin != null}">
            <div class="input-group-prepend" class="col-2" style="position: center">
                <button><h6><c:out value="Admin:${userAdmin.name}"/></h6></button>
                <button type="button" class="btn btn-light"><a href="/Login?action=outAdmin">Sign out</a></button>
                <button><a href="/SellProduct?action=sellProduct">Sửa thông tin Web</a></button>
            </div>
        </c:if>

        </div>
    </div>
</nav>
<%-----------------------------hết nav------------------------%>

<%-----------------------------sidebar + comtent------------------------%>

<div class="container" style="margin-top:30px">
    <div class="row">

        <%-----------------------------sidebar------------------------%>

        <div class="col-sm-3">
            <form action="/CustomerAction" class="fakeimg" style="height: 300px">
                <h4>Tìm kiếm theo yêu cầu</h4>
                <input hidden name="action" value="price">

                <table>
                    <tr>
                        <th>Loại Sản Phẩm:</th>
                    </tr>
                    <tr>
                        <td>
                            <select name="productType">
                                <option value=""></option>
                                <option value="smartphone">Điện Thoại</option>
                                <option value="laptop">laptop</option>
                                <option value="tablet">Máy tính bảng</option>
                                <option value="computer">Máy tính bàn</option>
                                <option value="watch">Đồng hồ</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Nhãn hiệu:</th>
                    </tr>
                    <tr>
                        <td>
                            <select name="maker">
                                <option value=""></option>
                                <option value="apple">apple</option>
                                <option value="samsung">samsung</option>
                                <option value="dell">dell</option>
                                <option value="asus">asus</option>
                                <option value="shark">shark</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Giá tiền từ:</th>
                    </tr>
                    <tr>
                        <td>
                            <select name="minPrice">
                                <option value="0">giá nhà bạn muốn mua từ</option>
                                <option value="10000000">10 triệu VND</option>
                                <option value="20000000">20 triệu VND</option>
                                <option value="30000000">30 triệu VND</option>
                                <option value="40000000">40 triệu VND</option>
                                <option value="50000000">50 triệu VND</option>
                                <option value="60000000">60 triệu VND</option>
                                <option value="70000000">70 triệu VND</option>
                                <option value="80000000">80 triệu VND</option>
                                <option value="90000000">90 triệu VND</option>
                                <option value="100000000">100 triệu VND</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Giá tiền đến:</th>
                    </tr>
                    <tr>
                        <td>
                            <select name="maxPrice">
                                <option value="1000000000">giá nhà bạn muốn mua đến</option>
                                <option value="10000000">10 triệu VND</option>
                                <option value="20000000">20 triệu VND</option>
                                <option value="30000000">30 triệu VND</option>
                                <option value="40000000">40 triệu VND</option>
                                <option value="50000000">50 triệu VND</option>
                                <option value="60000000">60 triệu VND</option>
                                <option value="70000000">70 triệu VND</option>
                                <option value="80000000">80 triệu VND</option>
                                <option value="90000000">90 triệu VND</option>
                                <option value="100000000">100 triệu VND</option>
                            </select>

                        </td>
                    </tr>
                </table>


                <input type="submit" value="find" class="btn btn-warning">


            </form>
        </div>

        <%-----------------------------Hết Sidebar------------------------%>


        <%-----------------------------content------------------------%>

        <div class="col-9" style="height: fit-content">
            <div class="container">

                <%--------------------Điện thoại-----------------%>

                <table>
                    <tr>
                        <td>
                            <div class="container">
                                <c:if test="${smartPhones.size()>0}">
                                    <h3>Điện thoại</h3>
                                </c:if>

                                <c:forEach var="smart" items="${smartPhones}">
                                    <div class="image">
                                        <div class="image1">
                                            <a target="_blank" href="../../image/img1.jpg"></a>
                                            <img src="${smart.picture}" width="250" height="100%">
                                        </div>
                                        <div class="desc" style="height: 40px; text-align: left " s><h6><c:out
                                                value="${smart.name}"/></h6></div>
                                        <div class="desc" style="height: 20px; text-align: left">Giá:<c:out
                                                value="${smart.price}"/></div>
                                        <div class="desc" style="height: 20px; text-align: left">Giảm:<c:out
                                                value="${smart.discount}"/> %
                                        </div>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                        <c:if test="${user != null}">
                                            <button type="button" class="btn btn-warning"><a
                                                    href="/SellList?action=create&exportAmount=1&customerId=${user.id}&sellProductId=${smart.id}&adminId=1&statusCustomer=basket&statusAdmin=notOrderedYet">Mua
                                                hàng</a></button>
                                        </c:if>
                                        <c:if test="${user == null}">
                                            <button type="button" class="btn btn-warning" style="width: 150px"><a
                                                    href="/Login?action=LoginCustomer">ĐN để mua hàng</a></button>
                                        </c:if>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                    </div>
                                </c:forEach>
                            </div>
                        </td>
                    </tr>
                </table>


                <%--------------------Máy tính bảng---------------&ndash;%&gt;--%>
                <table>
                    <tr>
                        <td>
                            <div class="container">
                                <c:if test="${tablets.size()>0}">
                                    <h3>Máy tính bảng</h3>
                                </c:if>

                                <c:forEach var="tab" items="${tablets}">
                                    <div class="image">
                                        <div class="image1">
                                            <a target="_blank" href="../../image/img1.jpg"></a>
                                            <img src="${tab.picture}" width="250" height="100%">
                                        </div>
                                        <div class="desc" style="height: 40px; text-align: left " s><h6><c:out
                                                value="${tab.name}"/></h6></div>
                                        <div class="desc" style="height: 20px; text-align: left">Giá:<c:out
                                                value="${tab.price}"/></div>
                                        <div class="desc" style="height: 20px; text-align: left">Giảm:<c:out
                                                value="${tab.discount}"/>%
                                        </div>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                        <c:if test="${user != null}">
                                            <button type="button" class="btn btn-warning"><a
                                                    href="/SellList?action=create&exportAmount=1&customerId=${user.id}&sellProductId=${tab.id}&adminId=1&statusCustomer=basket&statusAdmin=notOrderedYet">Mua
                                                hàng</a></button>
                                        </c:if>
                                        <c:if test="${user == null}">
                                            <button type="button" class="btn btn-warning" style="width: 150px"><a
                                                    href="/Login?action=LoginCustomer">ĐN để mua hàng</a></button>
                                        </c:if>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                    </div>
                                </c:forEach>
                            </div>
                        </td>
                    </tr>
                </table>


                <%--------------------Laptop---------------&ndash;%&gt;--%>
                <table>
                    <tr>
                        <td>
                            <div class="container">
                                <c:if test="${laptops.size()>0}">
                                    <h3>Laptop</h3>
                                </c:if>

                                <c:forEach var="lap" items="${laptops}">
                                    <div class="image">
                                        <div class="image1">
                                            <a target="_blank" href="../../image/img1.jpg"></a>
                                            <img src="${lap.picture}" width="250" height="100%">
                                        </div>
                                        <div class="desc" style="height: 40px; text-align: left " s><h6><c:out
                                                value="${lap.name}"/></h6></div>
                                        <div class="desc" style="height: 20px; text-align: left">Giá:<c:out
                                                value="${lap.price}"/></div>
                                        <div class="desc" style="height: 20px; text-align: left">Giảm:<c:out
                                                value="${lap.discount}"/>
                                            %
                                        </div>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                        <c:if test="${user != null}">
                                            <button type="button" class="btn btn-warning"><a
                                                    href="/SellList?action=create&exportAmount=1&customerId=${user.id}&sellProductId=${lap.id}&adminId=1&statusCustomer=basket&statusAdmin=notOrderedYet">Mua
                                                hàng</a></button>
                                        </c:if>
                                        <c:if test="${user == null}">
                                            <button type="button" class="btn btn-warning" style="width: 150px"><a
                                                    href="/Login?action=LoginCustomer">ĐN để mua hàng</a></button>
                                        </c:if>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                    </div>
                                </c:forEach>
                            </div>
                        </td>
                    </tr>
                </table>


                <%--------------------Máy tính bàn---------------&ndash;%&gt;--%>
                <table>
                    <tr>
                        <td>
                            <div class="container">
                                <c:if test="${computers.size()>0}">
                                    <P>Máy tính Bàn</P>
                                </c:if>

                                <c:forEach var="comp" items="${computers}">
                                    <div class="image">
                                        <div class="image1">
                                            <a target="_blank" href="../../image/img1.jpg"></a>
                                            <img src="${comp.picture}" width="250" height="100%">
                                        </div>
                                        <div class="desc" style="height: 40px; text-align: left " s><h6><c:out
                                                value="${comp.name}"/></h6></div>
                                        <div class="desc" style="height: 20px; text-align: left">Giá:<c:out
                                                value="${comp.price}"/></div>
                                        <div class="desc" style="height: 20px; text-align: left">Giảm:<c:out
                                                value="${comp.discount}"/>
                                            %
                                        </div>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                        <c:if test="${user != null}">
                                            <button type="button" class="btn btn-warning"><a
                                                    href="/SellList?action=create&exportAmount=1&customerId=${user.id}&sellProductId=${comp.id}&adminId=1&statusCustomer=basket&statusAdmin=notOrderedYet">Mua
                                                hàng</a></button>
                                        </c:if>
                                        <c:if test="${user == null}">
                                            <button type="button" class="btn btn-warning" style="width: 150px"><a
                                                    href="/Login?action=LoginCustomer">ĐN để mua hàng</a></button>
                                        </c:if>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                    </div>
                                </c:forEach>
                            </div>
                        </td>
                    </tr>
                </table>

                <%--------------------Đồng hồ---------------&ndash;%&gt;--%>
                <table>
                    <tr>
                        <td>
                            <div class="container">
                                <c:if test="${watchs.size()>0}">
                                    <h3>Đồng hồ</h3>
                                </c:if>

                                <c:forEach var="wat" items="${watchs}">
                                    <div class="image">
                                        <div class="image1">
                                            <a target="_blank" href="../../image/img1.jpg"></a>
                                            <img src="${wat.picture}" width="250" height="100%">
                                        </div>
                                        <div class="desc" style="height: 40px; text-align: left " s><h6><c:out
                                                value="${wat.name}"/></h6></div>
                                        <div class="desc" style="height: 20px; text-align: left">Giá:<c:out
                                                value="${wat.price}"/></div>
                                        <div class="desc" style="height: 20px; text-align: left">Giảm:<c:out
                                                value="${wat.discount}"/>
                                            %
                                        </div>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                        <c:if test="${user != null}">
                                            <button type="button" class="btn btn-warning"><a
                                                    href="/SellList?action=create&exportAmount=1&customerId=${user.id}&sellProductId=${wat.id}&adminId=1&statusCustomer=basket&statusAdmin=notOrderedYet">Mua
                                                hàng</a></button>
                                        </c:if>
                                        <c:if test="${user == null}">
                                            <button type="button" class="btn btn-warning" style="width: 150px"><a
                                                    href="/Login?action=LoginCustomer">ĐN để mua hàng</a></button>
                                        </c:if>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                    </div>
                                </c:forEach>
                            </div>
                        </td>
                    </tr>
                </table>


                <%--------------------tìm kiếm---------------&ndash;%&gt;--%>
                <table>
                    <tr>
                        <td>
                            <div class="container">
                                <c:if test="${findList.size()>0}">
                                    <h3>Danh sách tìm kiếm</h3>
                                </c:if>

                                <c:forEach var="find" items="${findList}">
                                    <div class="image">
                                        <div class="image1">
                                            <a target="_blank" href="../../image/img1.jpg"></a>
                                            <img src="${find.picture}" width="250" height="100%">
                                        </div>
                                        <div class="desc" style="height: 40px; text-align: left " s><h6><c:out
                                                value="${find.name}"/></h6></div>
                                        <div class="desc" style="height: 20px; text-align: left">Giá:<c:out
                                                value="${find.price}"/></div>
                                        <div class="desc" style="height: 20px; text-align: left">Giảm:<c:out
                                                value="${find.discount}"/>%
                                        </div>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                        <c:if test="${user != null}">
                                            <button type="button" class="btn btn-warning"><a
                                                    href="//SellList?action=create">Mua
                                                hàng</a></button>
                                        </c:if>
                                        <c:if test="${user == null}">
                                            <button type="button" class="btn btn-warning" style="width: 150px"><a
                                                    href="/Login?action=LoginCustomer">ĐN để mua hàng</a></button>
                                        </c:if>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                        <div class="desc" style="height: 20px; text-align: left"></div>
                                    </div>
                                </c:forEach>
                            </div>
                        </td>
                    </tr>
                </table>


                <%----------------------------------------------------------------------%>

                <%--------------------Giỏ hàng-----------------%>

                            <div class="container">
                                <c:if test="${gioHang.size()>0}">
                                    <h3><c:out value="${status}"/></h3>
                                </c:if>

                                <table border="1" cellpadding="5" style="background-color: antiquewhite">
                                    <c:if test="${gioHang.size()>0}">
                                        <tr>
                                            <th>Sản phẩm</th>
                                            <th>Số lượng</th>
                                            <th>Giá hàng</th>
                                            <th>Giảm giá</th>
                                            <th>rankGuest discount</th>
                                            <th>Tổng tiền</th>
                                            <th>Sửa</th>
                                            <th>Xóa</th>

                                        </tr>
                                    </c:if>
                                    <c:forEach var="gio" items="${gioHang}">
                                        <tr>
                                            <td><c:out value="${gio.sellProduct.name}"/></td>
                                            <td><c:out value="${gio.exportAmount}"/></td>
                                            <td><c:out value="${gio.sellProduct.price} VND"/></td>
                                            <td><c:out value="${gio.sellProduct.discount}%"/></td>
                                            <td><c:out value="${gio.customer.rankGuest.discount}%"/></td>
                                            <td><c:out
                                                    value="${gio.sellProduct.price-((gio.sellProduct.price*(gio.sellProduct.discount/100))+(gio.sellProduct.price*(gio.customer.rankGuest.discount/100)))} VND"/></td>


                                            <td>
                                                <button type="button" class="btn btn-warning"><a
                                                        href="/CustomerAction?id=${gio.id}&action=editCustomer">Edit</a>
                                                </button>
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-danger"><a
                                                        href="/CustomerAction?id=${gio.id}&action=delete">Delete</a>
                                                </button>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>



                <%----------------------------------------------------------------------%>

            </div>
        </div>

        <%-----------------------------foot------------------------%>

        <div class="jumbotron text-center" style="margin-bottom:0">
            <div class="container">
                <div class="row">
                    <div class="col-4 " style="text-align: left">
                        <h2>CÔNG TY TNHH TIN HỌC CÔNG NGHỆ THẾ GIỚI SỐ</h2>
                        <p>Địa chỉ: Số 18, ngõ 121, Thái Hà, Đống Đa, Hà Nội</p>
                        <p>Hotline: 0987 654 321</p>
                        <p>Email: hotrolaptopaz@gmail.com</p>
                    </div>


                    <div class="col-4 " style="text-align: left">
                        <h2>THÔNG TIN CÔNG TY</h2>
                        <p>Giới thiệu công ty</p>
                        <p>Tuyển dụng</p>
                        <p>Gửi góp ý, khiếu nại</p>
                    </div>

                    <div class="col-4 " style="text-align: left">
                        <h2>CHÍNH SÁCH CÔNG TY</h2>
                        <p>Chính sách chất lượng</p>
                        <p>Chính sách bảo hành</p>
                        <p>Chính sách đổi trả</p>
                        <p>Chính sách bảo mật thông tin</p>
                        <p>Chính sách vận chuyển</p>
                        <p>Hướng dẫn mua hàng- thanh toán</p>
                    </div>

                </div>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-4 " style="text-align: left">
                        <h2>Thế Giới Số cơ sở 1</h2>
                        <p>Số 18, ngõ 121, Thái Hà, Đống Đa, Hà Nội</p>
                        <p>Tư vấn mua hàng : 0825 233 233</p>
                        <p>Hỗ trợ kĩ thuật : 0825 233 233</p>
                        <p>Chăm sóc khách hàng : 0825 233 233</p>
                        <p>Bán hàng: Từ 8h30 - 21h30</p>
                        <p>Kỹ thuật: Từ 8h30 - 12h & 13h30 - 17h30</p>
                    </div>


                    <div class="col-4 " style="text-align: left">
                        <h2>Thế Giới Số cơ sở 2</h2>
                        <p>Số 56 Trần Phú, Hà Đông, Hà Nội</p>
                        <p>Tư vấn mua hàng : 0825 233 233</p>
                        <p>Hỗ trợ kĩ thuật : 0825 233 233</p>
                        <p>Chăm sóc khách hàng : 0825 233 233</p>
                        <p>Bán hàng: Từ 8h30 - 21h30</p>
                        <p>Kỹ thuật: Từ 8h30 - 12h & 13h30 - 17h30</p>
                    </div>


                </div>
            </div>
        </div>


</body>
</html>

