<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="userBean" scope="session"
	type="org.unibl.etf.ip.beans.UserBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
			aria-expanded="false">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
	</div>
	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li class="active"><img src="resources/assets/airplane.ico"
				height="50px" width="80px" style="text-align: center;"
				onclick="document.location.href='?'" /></li>
			<li><a href="?action=arrivals">All arrivals</a></li>
			<li><a href="?action=departures">All departures</a></li>
			<%
			if (userBean.isLoggedIn()) {
			%>
			<li><a href="?action=reserve">Reservation</a></li>
			<li><a href="?action=reservations">All reservations</a></li>
			<%
			}
			%>
		</ul>

	</div>
</body>
</html>