<%@page import="connection.DatabaseConnection"%>
<%@page import="composition.entities.*"%>
<%@page import="composition.manager.*"%>
<%@page import="java.util.*"%>
<%@page import="XML.XMLUtils"%>
<%@page import="org.w3c.dom.Document"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}
Document document = XMLUtils.parse("http://localhost:8080/FinalProject/categories");
CategoryManager cm = new CategoryManager(DatabaseConnection.getConnection());
List<Category> categories = cm.list();
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>E-Commerce Cart</title>
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>

	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			if (!categories.isEmpty()) {
				for (Category c : categories) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<div class="card-body">
						<h5 class="card-title">
							<a href="categoryProducts.jsp?categoryid=<%=c.getCategoryId()%>"><%=c.getCategoryName() %></a>
						</h5>
						<h6 class="category">
							Category:
							<%=c.getCategoryId() %></h6>
						<div class="mt-3 d-flex justify-content-between"></div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			out.println("There are no categories");
			}
			%>

		</div>
	</div>
	<%@include file="/includes/footer.jsp"%>
</body>
</html>