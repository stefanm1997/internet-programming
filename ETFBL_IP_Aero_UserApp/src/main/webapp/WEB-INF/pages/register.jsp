<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/x-icon" href="resources/assets/logo.ico" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/scripts.js"></script>
<link rel="stylesheet" href="resources/css/style.css">
<title>ETFBL_IP_Aero_UserApp</title>
</head>
<body onload="getCountrys()">
	<div class=" navbar navbar-inverse" style="background-color: black;">
		<jsp:include page="/WEB-INF/pages/header.jsp" />
		<jsp:include page="/WEB-INF/pages/menu.jsp" />
	</div>
	<form method="POST" action="?action=registration">
		<div class="container-fluid"
			style="display: flex; justify-content: center;">
			<div class="form-group" style="width: 30%">
				<h3 style="text-align: center;">Add user info:</h3>
				<br />
				<div class="row">
					<input type="text" class=" form-control col-xs-9"
						placeholder="Firstname" name="firstname" id="firstname">
				</div>
				<br /> <br />
				<div class="row">
					<input type="text" class=" form-control col-xs-9"
						placeholder="Lastname" name="lastname" id="lastname">
				</div>
				<br /> <br />
				<div class="row">
					<input type="text" class=" form-control col-xs-9"
						placeholder="Email" name="email" id="email">
				</div>
				<br /> <br />
				<div class="row">
					<input type="text" class=" form-control col-xs-9"
						placeholder="Username" name="username" id="username">
				</div>
				<br /> <br />
				<div class="row">
					<input type="password" class=" form-control col-xs-9"
						placeholder="Password" name="password" id="password">
				</div>
				<br /> <br />
				<div class="row">
					<input type="password" class=" form-control col-xs-9"
						placeholder="Password repeat" name="password2" id="password2">
				</div>
				<br /> <br />
				<div class="row">
					<input type="text" class=" form-control col-xs-9"
						placeholder="Address" name="address" id="address">
				</div>
				<br /> <br />
				<div class="row">
					<select name="country" id="country" class=" form-control col-xs-9">
					</select>
				</div>
				<br />
				<div class="row">
					<!-- <label for="type1">Passenger</label>
					<input type="radio" id="type1" class="  col-xs-9">
				<label for="type1">Worker</label>
					<input type="radio" id="type1" class="  col-xs-9"> -->
					<h4>Please select type of user:</h4>
					<div>
						<input type="radio" id="contactChoice1" name="type"
							value="Passenger" checked="checked"> <label
							for="contactChoice1">Passenger</label> <br /> <input
							type="radio" id="contactChoice2" name="type" value="Worker">
						<label for="contactChoice2">Worker</label>
					</div>
				</div>
				<br />
				<div class="row" style="float: left;">
					<button type="submit" class="btn btn-default">Register</button>
				</div>
				 <br /> <br />
				<h4 style="color: red; text-align: center;">
					<%=session.getAttribute("notificationRegister") != null ? session.getAttribute("notificationRegister") : ""%></h4>
				<br />
			</div>
		</div>
	</form>
		<jsp:include page="/WEB-INF/pages/footer.jsp" />
</body>
</html>