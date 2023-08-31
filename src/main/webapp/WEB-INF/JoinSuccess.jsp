﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/main.css" />
		
	</head>
	<style>
		#Update > ul.actions {
			margin-top:10%;
		}
	</style>
	<body style="text-align: center;">

		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<ul class="actions vertical">
							<li><h1>환영합니다!</h1></li>
							<li>회원가입을 축하합니다.</li>
							<!-- Q2. 회원가입 한 회원정보 중 이메일을 출력하시오. -->
							<%
							String email = (String) request.getAttribute("email");
							%>
							<li>메세지시스템의 새로운 이메일은 <strong><%=email %></strong> 입니다.</li>
							<li><button onclick='location.href="goMain"'>시작하기</button></li>
						</ul>
					</nav>			
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

