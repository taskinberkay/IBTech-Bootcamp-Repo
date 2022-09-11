<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("username") == null) {
	pageContext.forward("Login.jsp");
}
String username = (String) session.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>
	<h1>Welcome <%=username%></h1>
	<a href="Logout.jsp">Çık</a>
</body>
</html>