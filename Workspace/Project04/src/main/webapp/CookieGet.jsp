<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String company = "";
    if(request.getCookies() != null){
    	for(Cookie cookie : request.getCookies()){
    		if(cookie.getName().equals("Company")){
    			company= cookie.getValue();
    		}
    	}
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Çerez al</title>
</head>
<body>
Company: <%=company %>
</body>
</html>