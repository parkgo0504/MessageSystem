package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.Member;
import com.smhrd.model.MemberDAO;

@WebServlet("/loginProgram")
public class loginProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
	
		Member member = new Member();
		member.setEmail(email);
		member.setPw(pw);
		
		MemberDAO dao = new MemberDAO();

		Member info = dao.login(member);

		HttpSession session = request.getSession();
		if (info != null) {
			session.setAttribute("info", info);
		}
		
//		RequestDispatcher rd = request.getRequestDispatcher("goMain");
//		
//		rd.forward(request, response);
		response.sendRedirect("goMain");
	}

}
