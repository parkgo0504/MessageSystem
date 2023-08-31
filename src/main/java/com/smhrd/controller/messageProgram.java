package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.Message;
import com.smhrd.model.MessageDAO;


@WebServlet("/messageProgram")
public class messageProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String sendName = request.getParameter("sendName");
		String receiveEmail = request.getParameter("receiveEmail");
		String message = request.getParameter("message");

		MessageDAO dao = new MessageDAO();
		
		Message msg = new Message();
		msg.setSendName(sendName);
		msg.setReceiveEmail(receiveEmail);
		msg.setMessage(message);

		int cnt = dao.insertMsg(msg);

		String url = "";

		if (cnt > 0) {
			url = "WEB-INF/Main.jsp";

		} else {
			url = "WEB-INF/Main.jsp";

		}

		RequestDispatcher rd = request.getRequestDispatcher(url);

		rd.forward(request, response);

	}

}
