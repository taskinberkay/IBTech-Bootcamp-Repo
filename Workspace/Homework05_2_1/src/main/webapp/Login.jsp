<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="user.*" %>
<%
if (request.getParameter("submit") != null) {
	String username = request.getParameter("username").trim();
	String password = request.getParameter("password").trim();
	UserManager manager = new UserManager();
	if (manager.find(username, password)!= null) {
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
	<a href="Register.jsp">Register</a>
</body>
</html>