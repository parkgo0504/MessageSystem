package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MessageDAO;

@WebServlet("/deleteAll")
public class deleteAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MessageDAO dao = new MessageDAO();
		dao.deleteAll();
		
		RequestDispatcher rd = request.getRequestDispatcher("goMain");
		rd.forward(request, response);
	
	}

}
