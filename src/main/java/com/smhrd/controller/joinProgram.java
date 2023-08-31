package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.smhrd.model.Member;
import com.smhrd.model.MemberDAO;

@WebServlet("/joinProgram")
public class joinProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		Member member = new Member(email, pw, tel, address);

		MemberDAO dao = new MemberDAO();

		int cnt = dao.join(member);
		
		String url = "";
		
		if (cnt > 0) {
			request.setAttribute("email", email);
			url = "WEB-INF/JoinSuccess.jsp";
			
		} else {
			url = "WEB-INF/Main.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		
		rd.forward(request, response);
	}

}
