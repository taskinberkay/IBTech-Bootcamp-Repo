<%@page import="org.eclipse.jdt.internal.compiler.codegen.IntegerCache"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int left = 0, right = 0, sum = 0;
if (request.getParameter("add") != null) {
	left = Integer.parseInt(request.getParameter("left"));
	right = Integer.parseInt(request.getParameter("right"));
	sum = left + right;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adder Form</title>
</head>
<body>
Toplam: <%=sum %><br>
	<form action="AdderForm.jsp" method="post">
		Sol: <input type="text" name ="left" value=<%=left%>><br> <br>
		Sağ: <input type="text" name ="right" value=<%=right%> /><br>
		<input type="submit" value="Topla" name= "add"/>
	</form>
</body>
</html>