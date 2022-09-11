<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String username = "godoro";
session.setAttribute("username", username);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set session</title>
</head>
<body>
Oturuma koyuldu: <%=username %>
</body>
</html>