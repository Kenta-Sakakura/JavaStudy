<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.*" %>
<%
	@SuppressWarnings("unchecked")
	ArrayList<ShohinBean> shohin = (ArrayList<ShohinBean>) application.getAttribute("shohin");
	UserBean userInfo = (UserBean) session.getAttribute("userInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" >
<script src="https://kit.fontawesome.com/2e4d1a80d9.js"></script>
<link rel="stylesheet" href="css/common.css">
<title>ワークショップEC</title>
</head>
<body>
<%@ include file="/components/header.jsp" %>
<div class="container">
    <h2 class="category-title mx-auto p-3">
        <div class="en">ITEMS</div>
        <div class="ja">商品</div>
    </h2>
	<div class="row">
	<% for(ShohinBean list : shohin){ %>
		<form action="/workshop_nov/detail" class="col-md-4 mx-atuo p-5 items">
			<input type="hidden" name="id" value="<%=list.getId() %>">
			<% if(userInfo != null){ %>
				<input type="hidden" name="user" value="<%=userInfo.getId() %>">
			<% } %>
	       <button class="btn bg-white" type="submit">
	           <div class="img mx-auto"><img src="img/item/<%=list.getImageUrl() %>" alt="商品画像"></div>
	           <div class="item-info">
	               <span class="item-title"><%=list.getName() %></span><br/>
	               <span class="price">￥ <%=list.getPrice() %>(税込)</span>
	           </div>
	       </button>
       </form>
    <% }%>
    </div>
</div>
</body>
</html>