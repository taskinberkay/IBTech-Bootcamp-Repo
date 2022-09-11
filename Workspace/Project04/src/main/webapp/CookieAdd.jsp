<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Cookie cookie = new Cookie("Company", "godoro");
    response.addCookie(cookie);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Çerez ekle</title>
</head>
<body>
Çerez eklendi <%=cookie.getValue() %>
</body>
</html>