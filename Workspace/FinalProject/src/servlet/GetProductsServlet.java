package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import XML.CategoryXMLUtils;
import XML.ProductXMLUtils;
import XML.XMLUtils;
import composition.entities.Product;
import composition.manager.CategoryManager;
import composition.manager.ProductManager;
import connection.DatabaseConnection;

/**
 * Servlet implementation class GetCategoriesServlet
 */
@WebServlet("/products")
public class GetProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProductsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ProductManager pm = new ProductManager(DatabaseConnection.getConnection());
			try {
				//List<Product> productList = pm.findByCategoryId(Long.parseLong(request.getParameter("productid")));
				List<Product> productList = pm.getAllProducts();
				ProductXMLUtils cxml = new ProductXMLUtils();
				Document categoriesDocument = cxml.format(productList);
				response.setContentType("text/xml");
				XMLUtils.dump(categoriesDocument, response.getOutputStream());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
