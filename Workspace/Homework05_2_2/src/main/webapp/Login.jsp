<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (request.getParameter("submit") != null) {
	String username = request.getParameter("username").trim();
	String password = request.getParameter("password").trim();
	if (username.equals("godoro") && password.equals("java")) {
		session.setAttribute("username", request.getParameter("username"));
		pageContext.forward("Home.jsp");
	}
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form action="Login.jsp" method="post">
		username: <input type="text" name="username" value=><br>
		<br> password: <input type="text" name="password"><br>
		<input type="submit" value="Login" name="submit" />

	</form>
</body>
</html>