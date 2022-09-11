<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="user.*" %>

<%

	if(request.getParameter("register") != null){
		UserManager manager = new UserManager();
		if(manager.insertUser(request.getParameter("username"), request.getParameter("password"))){
			pageContext.forward("Login.jsp");
		}
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form action="Register.jsp" method="post">
		Username : <input type="text" name="username"> 
		Password : <input type="text" name="password"> <br><br> 
		<input type="submit" value="Register"  name="register"/>
	</form>

</body>
</html>