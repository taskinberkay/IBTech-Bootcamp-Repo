<%@page import="connection.DatabaseConnection"%>
<%@page import="composition.entities.*"%>
<%@page import="composition.manager.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}
ProductManager pm = new ProductManager(DatabaseConnection.getConnection());
List<Product> products = pm.findByCategoryId((Long.parseLong(request.getParameter("categoryid"))));
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
			if (!products.isEmpty()) {
				for (Product p : products) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top"
						src="/FinalProject/image?imageName=<%=p.getImgPath()%>"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=p.getProductName()%></h5>
						<h6 class="price">
							Price: TL<%=p.getSalesPrice() %></h6>
						<h6 class="category">
							Category:
							<%=p.getCategoryId() %></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark"
								href="add-to-cart?id=<%=p.getProductId()%>">Add to Cart</a> <a
								class="btn btn-primary"
								href="order-now?quantity=1&id=<%=p.getProductId()%>">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			out.println("There are no products in the database");
			}
			%>

		</div>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>