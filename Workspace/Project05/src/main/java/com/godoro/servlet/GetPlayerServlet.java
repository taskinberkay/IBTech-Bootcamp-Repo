package com.godoro.servlet;
import static com.godoro.xml.XMLUtils.*;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import com.godoro.composition.entity.Category;
import com.godoro.composition.manager.PlayerManager;

@WebServlet("/player/get")
public class GetPlayerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/xml;charset=UTF-8");
		long productId = Long.parseLong(req.getParameter("productId"));
		PlayerManager manager = new PlayerManager();
		try {
			Category player = manager.find(productId);
			Document document = format(player);
			dump(document, resp.getOutputStream());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
