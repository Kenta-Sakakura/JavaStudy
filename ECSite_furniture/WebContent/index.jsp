<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.ShohinBean" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<ShohinBean> shohin = (ArrayList<ShohinBean>) request.getAttribute("shohin");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>ワークショップEC</title>
</head>
<style>
    .container{
        position: absolute;
        top: 20%;
        left: 50%;
        transform: translate(-50%,-0%);
    }
    .navbar{
        position: fixed;
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
</style>
<body>
<header>
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
</header>
<div class="container">
    <h2 class="category-title mx-auto p-3">
        <div class="en_">ITEMS</div>
        <div class="ja">商品</div>
    </h2>
	<div class="row">
	<% for(ShohinBean list : shohin){ %>
       <div name="<%=list.getId() %>" class="col-md-4 mx-atuo p-5 items">
           <div class="img mx-auto"><img src="<%=list.getImageUrl() %>" alt="商品画像"></div>
           <div class="item-info">
               <span class="item-title"><%=list.getName()  %></span><br/>
               <span class="price">￥ <%=list.getPrice() %>(税込)</span>
           </div>
       </div>
    <% }%>
    </div>
</div>
</body>
</html>