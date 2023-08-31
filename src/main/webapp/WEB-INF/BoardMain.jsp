<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "com.smhrd.model.*" %>
<%@ page import = "java.util.ArrayList" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assetsBoard/css/main.css" />
		<link rel="stylesheet" href="assetsBoard/css/board.css" />
		
</head>
<body>		
			<!-- Q17. 게시글 목록 조회 기능 -->
			<!-- Q18. 게시글 목록 세부페이지 기능(제목을 클릭하면 세부페이지 BoardDetail.jsp로 이동)-->
			<div id="board">
				<%
				BoardDAO dao = new BoardDAO();
							
				ArrayList<Board> boder = new ArrayList<>();
				boder = dao.showBoard();
											
											
				// ↓ jstl 방식
				session.setAttribute("boder", boder);
				
				%>
				<table id = "list">
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>시간</td>
					</tr>
					<c:forEach var="boarder" items="${boder}" varStatus="status">
					<tr>
						<td>${status.index+1}</td> <!-- 게시글 번호 -->
						<td>${boarder.title}</td>
						<td>${boarder.writer}</td>
						<td>${boarder.b_Date}</td>
					</tr>
					</c:forEach>
				</table>
				<a href="goMain"><button id="writer">홈으로가기</button></a>
				<a href="GoBoardWrite"><button id="writer">작성하러가기</button></a>
			</div>


			<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
</body>
</html>