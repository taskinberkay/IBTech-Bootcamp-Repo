<%@page import="org.eclipse.jdt.internal.compiler.codegen.IntegerCache"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="rectangle.utils.*"%>
<%
Rectangle rectangle = new Rectangle();
double area = 0, perimeter = 0;
if (request.getParameter("area") != null) {
	rectangle.setWidth(Integer.parseInt(request.getParameter("width")));
	rectangle.setHeight(Integer.parseInt(request.getParameter("heigth")));
	area = rectangle.getArea();
	perimeter = rectangle.getPerimeter();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rectangle Area</title>
</head>
<body>
	<form action="RectangleArea.jsp" method="post">
		width: <input type="text" name="width" value=<%=rectangle.getWidth()%>><br>
		<br> height: <input type="text" name="heigth" value=<%=rectangle.getHeight()%> /><br>
		<input type="submit" value="Hesapla" name="area" />
	</form>
	Alan:
	<%=area%><br>
	Çevre:
	<%=perimeter%><br>
</body>
</html>