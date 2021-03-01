<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.LoginBean"%>
<%
    // 問① getAttributeに適切な引数をセットして、EmployeeControllerから渡されたBeanを取得する。
    LoginBean login = (LoginBean) request.getAttribute("LoginBean");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン情報</title>
</head>
<body>
	<div align="center">
        <!-- 検索が成功した場合の表示 -->
        <%
            if (login != null) {
        %>
        <table border="1">
            <tr>
            	<th>USERNAME</th>
                <td><%=login.getuserName()%></td>
            </tr>
            <tr>
            	<th>PASSWOED</th>
                <td><%=login.getpassWord()%></td>
            </tr>
            <tr>
        </table>
        <!-- 問②  それ以外の表示（エラーの場合）-->
        <% } else { %>
           <% out.print(" IDもしくはパスワードが間違っています。");%>
        <% } %>
    </div>
</body>
</html>