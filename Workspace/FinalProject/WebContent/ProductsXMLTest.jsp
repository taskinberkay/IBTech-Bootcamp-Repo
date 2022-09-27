<%@page import="org.w3c.dom.Element"%>
<%@page import="connection.DatabaseConnection"%>
<%@page import="composition.entities.*"%>
<%@page import="composition.manager.*"%>
<%@page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.io.InputStream"%>
<%@page import="XML.XMLUtils"%>
<%@page import="XML.ProductXMLUtils"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="org.w3c.dom.NodeList"%>





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
Document document = XMLUtils.parse("http://localhost:8080/FinalProject/products");
NodeList productList = new ProductXMLUtils().getProductList(document);
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
			if (productList.getLength() > 0) {
				for(int i = 0; i < productList.getLength(); i++) {
					Element product = (Element)productList.item(i);
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top"
						src="/FinalProject/image?imageName=<%=product.getAttribute("imgPath")%>"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=product.getAttribute("productName")%></h5>
						<h6 class="price">
							Price: TL<%=product.getAttribute("salesPrice")%></h6>
						<h6 class="category">
							Category:
							<%=product.getAttribute("categoryId")%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark"
								href="add-to-cart?id=<%=product.getAttribute("productId")%>">Add to Cart</a> <a
								class="btn btn-primary"
								href="order-now?quantity=1&id=<%=product.getAttribute("productId")%>">Buy Now</a>
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
	<script type="text/javascript">
	var request = WebRequest.Create("http://localhost:8080/FinalProject/products") as HttpWebRequest; 
	var response = request.GetResponse();

	Stream receiveStream = response.GetResponseStream();
	StreamReader readStream = new StreamReader(receiveStream, Encoding.UTF8);
	var result =  readStream.ReadToEnd();
	</script>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>