<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String username = request.getParameter("username");
String password = request.getParameter("password");

if (username.substring(0).trim() == "godoro" && password.substring(0).trim() == "java") {
	session.setAttribute("username", request.getParameter("username"));
	pageContext.forward("Home.jsp");
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
		username: <input type="text" name="username" value="godoro"><br><br> 
		password: <input type="text" name="password" value="java" /><br>
		<input type="submit" value="Login" name="submit" />

	</form>
</body>
</html>