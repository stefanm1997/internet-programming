<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="icon" type="image/x-icon" href="resources/assets/logo.ico" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/style.css">
<title>ETFBL_IP_Aero_UserApp</title>
</head>
<body>
	<!-- <nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<li class="active"><a class="navbar-brand" href="#"><img
					src="resources/assets/airplane.ico" height="50px" width="80px" /></a></li>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="menuUser.xhtml" style="color: honeydew;">User</a></li>
				<li><a href="menuEmployer.xhtml" style="color: honeydew;">Employer</a></li>
				<li><a href="menuLocation.xhtml" style="color: honeydew;">Location</a></li>
			</ul>
		</div>
	</div>
	</nav> -->
	<nav class=" navbar navbar-inverse" style="background-color: black;">
	<jsp:include page="/WEB-INF/pages/header.jsp" /> 
	<jsp:include page="/WEB-INF/pages/menu.jsp" /> 
	
	
	</nav>
	<jsp:include page="/WEB-INF/pages/home.jsp" />
	<jsp:include page="/WEB-INF/pages/footer.jsp" />
</body>
</html>