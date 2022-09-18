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

import composition.entities.Category;
import composition.manager.CategoryManager;
import connection.DatabaseConnection;
import XML.CategoryXMLUtils;
import XML.XMLUtils;

/**
 * Servlet implementation class GetCategoriesServlet
 */
@WebServlet("/categories")
public class GetCategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCategoriesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CategoryManager cm = new CategoryManager(DatabaseConnection.getConnection());
			try {
				List<Category> categoryList = cm.list();
				CategoryXMLUtils cxml = new CategoryXMLUtils();
				Document categoriesDocument = cxml.format(categoryList);
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
