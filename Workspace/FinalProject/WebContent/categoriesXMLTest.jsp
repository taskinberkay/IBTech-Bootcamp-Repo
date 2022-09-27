<%@page import="connection.DatabaseConnection"%>
<%@page import="composition.entities.*"%>
<%@page import="composition.manager.*"%>
<%@page import="java.util.*"%>
<%@page import="XML.XMLUtils"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="org.w3c.dom.NodeList"%>
<%@page import="XML.CategoryXMLUtils"%>
<%@page import="org.w3c.dom.Element"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}
Document document = XMLUtils.parse("http://localhost:8080/FinalProject/categories");
NodeList categoryList = new CategoryXMLUtils().getCategoryList(document);
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
			if (categoryList.getLength()>0) {
				for(int i = 0; i < categoryList.getLength(); i++) {
					Element category = (Element)categoryList.item(i);
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<div class="card-body">
						<h5 class="card-title">
							<a href="categoryProducts.jsp?categoryid=<%=category.getAttribute("categoryId")%>"><%=category.getAttribute("categoryName") %></a>
						</h5>
						<h6 class="category">
							Category:
							<%=category.getAttribute("categoryId") %></h6>
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