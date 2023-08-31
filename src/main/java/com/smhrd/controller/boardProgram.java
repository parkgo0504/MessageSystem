package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFormat.Encoding;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.smhrd.model.Board;
import com.smhrd.model.BoardDAO;

@WebServlet("/boardProgram")
public class boardProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// ┌> 실행되는 서블릿에 대한 정보를 가져올 수 있는 메소드
		String path = request.getServletContext().getRealPath("file");
		
		// 저장하고자 하는 파일의 최대 크기 지정
		int maxSize = 1024 * 1024 * 5; // 5mb
		String encoding = "utf-8";
		
		// 파일을 업로드하기 위해 필요한 request 객체
		MultipartRequest multi = new MultipartRequest(
				request,
				path,
				maxSize,
				encoding,
				new DefaultFileRenamePolicy()
				// └> 파일 업로드 시 중복되는 이름을 방지할 수 있는 객체! 
				);
		
		// 데이터 수집
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		// ┌> 파일 데이터 수집
		String img = multi.getFilesystemName("fileName");
		
		BoardDAO dao = new BoardDAO();

		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setFileName(img);
		
		int cnt = dao.insertWirte(board);
		
		if (cnt > 0) {
			response.sendRedirect("goBoard");
		} else {
			response.sendRedirect("GoBoardWrite");
		}
	}

}
