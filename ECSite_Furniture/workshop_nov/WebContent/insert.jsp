<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/2e4d1a80d9.js"></script>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/insert.css">
<title>商品登録</title>
</head>
<body>
<%@ include file="/components/header.jsp"%>
<div class="wrapper container-fluid">
	<div class="container">
		<form method="post" action="/workshop_nov/insert">
			<span><p class="name">商品名</p><input name="item_name"></span>
			<span><p class="name">値段</p><input name="item_price"></span>
			<span>
				<span class="inner">
					<p class="name">商品画像</p>
					<p class="path_text" style="font-size:10px;">(※画像のリンクを添付してください)</p>
				</span>
			<input type="file" name="item_img_url">
			</span>
			<span>
				<p class="name">カテゴリ</p>
				<select name="category">
					<option value="0"></option>
					<option value="2">机</option>
					<option value="3">椅子</option>
					<option value="1">テーブル</option>
					<option value="4">その他</option>
				</select>
			</span>
			<button type="submit" class="btn btn-primary">登録する</button>
		</form>
	</div>
</div>
<%@ include file="/components/footer.jsp"%>
</body>
</html>
