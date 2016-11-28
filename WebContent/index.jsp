<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Allen's Home page</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		java.util.Date d = new java.util.Date();
	%>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<!--Navigation-->
				<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#myNavbar">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Allen's Page</a>
					</div>

					<div class="collapse navbar-collapse" id="myNavbar">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">Home</a></li>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">Travel<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">Berlin</a></li>
									<li><a href="#">Zurich</a></li>
									<li><a href="#">Prague</a></li>
									<li><a href="#">Munchen</a></li>
									<li><a href="#">Dresden</a></li>
								</ul></li>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">Skill<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">C#</a></li>
									<li><a href="#">C++</a></li>
									<li><a href="#">Java</a></li>
									<li><a href="#">Javascript</a></li>
									<li><a href="#">C</a></li>
								</ul></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="/allenPage/signup.jsp"><span
									class="glyphicon glyphicon-registration-mark"></span>Sign Up</a></li>
							<li><a href="/allenPage/login.jsp"><span
									class="glyphicon glyphicon-log-in"></span>Login </a></li>
						</ul>
					</div>
				</div>
				</nav>
			</div>
		</div>
		<div class="row">
			<%
				response.setIntHeader("Refresh", 2);
			%>
			<h2>
				Today's date is
				<%=d.toString()%></h2>
			<%
				out.println("Welcome to Allen's page!");
				Integer hitsCount = (Integer) application.getAttribute("hitCounter");
				if (hitsCount == null || hitsCount == 0) {
					/* 第一次访问 */

					hitsCount = 1;
				} else {
					/* 返回访问值 */
					hitsCount += 1;
				}
				application.setAttribute("hitCounter", hitsCount);
			%>
			<p>
				Page visits statistics:
				<%=hitsCount%></p>	
		</div>
		
		<div class="row">
			<img src="src/me.jpg" width=100% height=100%/>
			
		</div>
		
		<div class="row">
			
		</div>
	</div>











</body>
</html>