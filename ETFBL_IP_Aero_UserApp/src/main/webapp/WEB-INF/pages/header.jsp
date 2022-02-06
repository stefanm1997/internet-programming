<%@page import="org.unibl.etf.ip.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="userBean" type="org.unibl.etf.ip.beans.UserBean"
	scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<div style="background-color: black; height: 230px" id="divId">
		<h1 style="text-align: center; font-family: fantasy; color: white;">ETFBL_IP_Aero</h1>
		<%
		/* String notification = (String) session.getAttribute("notification");
		if (notification.equals("")) { */
		//UserBean bean=(UserBean)session.getAttribute("userBean");
		if (userBean.isLoggedIn()) {
		%>
		<form class="navbar-form navbar-right col-xs-5 col-sm-5 col-lg-5" style="margin: 0"
		action="?action=logout" method="POST">
		<label style="color: white;">You are logged in as <%=userBean.getUser().getFirstname() + " " + userBean.getUser().getLastname()%></label>
		<br /> <br />
		<button type="submit" class="btn btn-default btn-sm" style="float: right;"> <!-- onclick="clearUserBean()" --><span class="glyphicon glyphicon-log-out"></span> Logout</button>
		<script type="text/javascript">document.getElementById("divId").style="height: 140px"</script>
		</form>
		<%
		} else{
		%>
		<form class="navbar-form navbar-right col-xs-5 col-sm-5 col-lg-5"
			style="margin: 0" method="POST" action="?action=login" id="loginForm">
			<div class="form-group">
				<input type="text" class=" form-control" placeholder="Username"
					name="username" id="username"><br /> <br /> <input
					type="password" class=" form-control" placeholder="Password"
					name="password" id="password">
			</div>
			<br /> <br />
			<button type="submit" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-log-in"></span> Login</button>
			<h5 style="color: red;">
				<%=session.getAttribute("notification") != null ? session.getAttribute("notification") : ""%></h5>
			<a style="color: honeydew; justify-content: center;"  href="?action=register">If you don't
				have account, sign up!</a>
		</form>
		<% } %>
	</div>
</body>
</html>