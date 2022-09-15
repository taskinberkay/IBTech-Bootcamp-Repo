package com.godoro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.godoro.transaction.Transaction;
import com.godoro.transaction.TransactionConverter;

@WebServlet("/get")
public class GetServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Transaction transaction = new Transaction(501, "Elektrik Ödemesi", 5460);
		TransactionConverter tc = new TransactionConverter();
		String output = tc.format(transaction);
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(output);
	}

}
