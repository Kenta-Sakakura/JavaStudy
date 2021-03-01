<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message= (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/user.css">
<title>ログイン</title>
</head>
<body>
<%@ include file="/components/header.jsp" %>
    <main>
        <article>
            <h3>Welcome!! </h3>
            <form action="/workshop_nov/login" method="POST" class="touroku">
	            <i class="fas fa-child"></i>
	            <input type="text" name="name" placeholder="Username" class="name"/>
	            <br>
	            <i class="fas fa-key"></i>
	            <input type="password" name="pass" placeholder="Password" class="pass"/><br>
	            <input type="submit" value="login" id="login" name="login" class="btn">
            </form>
        </article>
        <div class = "link">
            <a href="signUp.jsp" >会員登録がまだの方はこちら</a>
        </div>
    </main>
    <footer>
        <p>&copy;YI Group.inc</p>
    </footer>
</body>
</html>