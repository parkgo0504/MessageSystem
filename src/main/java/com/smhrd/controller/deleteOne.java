package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MessageDAO;

@WebServlet("/deleteOne")
public class deleteOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 메시지 선택시 해당 메시지를 삭제하는 controller
		// url로 넘어오는 데이터 받아주기!
		
		String num = request.getParameter("num");
		
		MessageDAO dao = new MessageDAO();
		int num_n = Integer.parseInt(num);
		dao.deleteOne(num_n);
		
		RequestDispatcher rd = request.getRequestDispatcher("goMain");
		rd.forward(request, response);
		
		
		
	}

}
