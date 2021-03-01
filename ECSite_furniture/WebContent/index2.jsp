<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.ShohinBean" %>
<%@ page import="bean.LoginBean" %>
<% ShohinBean ss = (ShohinBean) request.getAttribute("ShohinBean"); %>
<% LoginBean login = (LoginBean) request.getAttribute("LoginBean");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>ログイン</title>

</head>
<style>
    .container{
        position: absolute;
        top: 20%;
        left: 50%;
        transform: translate(-50%,-0%);
    }
    .navbar{
        border-bottom: thin solid rgb(229,229,229);
        width: 100%;
        z-index: 10;
    }
    .nav-item img{
        width: 25px;
    }
    .category-title , .items.img{
        text-align: center;
    }
    .ja{
        font-size: medium;
    }
    .img img{
        width: 100%;
    }
    .navbar button{
        height: 70%;
    }
    .nav{
    	position:fixed-top;
    }
</style>
<div class="nav">
    <nav class="navbar navbar-expand bg-white">
        <div class="navbar-brand ml-2"><h1>WorkShop</h1></div>
        <div class="row ml-2 my-auto">
            <ul class="navbar-nav mr-auto align-items-center">
                <li class="nav-item p-3 font-weight-bold">ITEMS</li>
                <li class="nav-item p-3 font-weight-bold">FEATURE</li>
                <li class="nav-item p-3 font-weight-bold">COORDINATE</li>
                <li class="nav-item p-3 font-weight-bold">SHOP</li>
                <li class="nav-item p-3 font-weight-bold">CONTENT</li>
                <li class="nav-item p-2 ml-3"><img src="img/icon/hart.png" alt=""></li>
                <li class="nav-item p-2">
                	<a href="index2.jsp"><img src="img/icon/man.png" alt=""></a>
                </li>
                <li class="nav-item p-2"><img src="img/icon/cart.png" alt=""></li>
            </ul>
            <form class="form-inline my-2 my-lg-0 px-2">
                <input class="form-control mr-sm-2" type="search" placeholder="Search">
                <img src="img/icon/search.png" alt="" type="submit">
            </form>
        </div>
    </nav>
</div>
<body>
	<div align="center">
	 <form action="/workShop_october/search" method="post">
      <div class="wrapper">

        <tr>
          <th class="username">
          <label for="username">USERNAME</label>
          <input type="text" name="id" value="" size="20">
          </th>
          <th class="password">
          <label for = "password">PASSWORD</label>
          <input type="password" name="pass" value="" size="20">
          </th>
       	  <br><input id="button" type="submit" name="button" value="LOGIN">
          </br>
       </tr>
    </div>
    </form>
    </div>
</body>
</html>