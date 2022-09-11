package com.godoro.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import com.godoro.utils.*;

@WebServlet("/post")
public class PostServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream in = req.getInputStream();
		String input = StreamUtils.read(in);
		System.out.println("Girdi: ");
		System.out.println(input);
		
		OutputStream out = resp.getOutputStream();
		StreamUtils.write(out, "Oldu");
	}

	
}