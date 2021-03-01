<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controller.*" %>
<%@ page import="service.*" %>
<%@ page import="util.*" %>
<%@ page import="java.sql.*" %>
<%
	ShohinBean shohin = (ShohinBean) request.getAttribute("shohin");
	//ログイン時にセッションスコープに値を保持してるのでそれを利用する
	UserBean userInfo = (UserBean) session.getAttribute("userInfo");

	DetailService ds = new DetailService();
	int flag = 0;
	if(userInfo != null){
		flag = ds.showDetails(userInfo.getId(), shohin.getId());
	}

	String word = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" >
<script src="https://kit.fontawesome.com/2e4d1a80d9.js" ></script>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/common.css">
<title>ワークショップEC</title>
</head>
<body>
<%@ include file="/components/header.jsp" %>
<main>
    <div class="breadcrumbs"></div>
    <div class="main">
    <form action="?" method="post" class="detail_form">
        <div class="detail">
            <div class="detail-image">
                <img src="img/item/<%=shohin.getImageUrl()%>">
            </div>
        </div>
        <div class="other">
            <div class="other-top">
                <ul>
                    <li><%=shohin.getName()%></li><br>
                    <li>商品ID:<%=shohin.getId()%></li>
                 </ul>
            </div>
            <div class="other-under">
                <div class="price">
                    <div class="text">
                        <p class="price-title">本体価格</p>
                        <p class="price-text">￥<%=shohin.getPrice() %></p>
                    </div>
                    <div class="btn">
                        <div class="buy-btn"><a href="">購入する</a></div>
                        <% if(userInfo != null){ %>
	                        <input name="proid" type="hidden" value="<%=shohin.getId() %>">
	                   		<input name="usrid" type="hidden" value="<%=userInfo.getId() %>">
	                   		<%
	                   			if(flag != 0){
	                   				word = "お気に入り解除";
	                   			}else{
	                   				word = "お気に入り追加";
	                   			}
	                   		%>
                       	<div class="fav-btn"><button type="submit" formaction="/workshop_nov/favorite"><%= word %></button></div>
                       	<% } %>
                    </div>
                </div>
            </div>
        </div>
    </form>
    </div>
</main>
<footer>
    <div class="footer-main">
        <div class="footer-text">
            <p>©YI Group.inc</p>
        </div>
    </div>
</footer>
</body>
</html>