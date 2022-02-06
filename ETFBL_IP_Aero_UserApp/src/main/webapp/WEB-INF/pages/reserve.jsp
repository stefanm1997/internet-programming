<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userBean" scope="session"
	type="org.unibl.etf.ip.beans.UserBean"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<body onload="getFlightsForReservation();">
	<div class=" navbar navbar-inverse" style="background-color: black;">
		<jsp:include page="/WEB-INF/pages/header.jsp" />
		<jsp:include page="/WEB-INF/pages/menu.jsp" />
	</div>

	<form method="POST" action="?action=reservation" enctype="multipart/form-data">
		<div class="container-fluid"
			style="display: flex; justify-content: center;">
			<div class="form-group" style="width: 30%">
				<h3 style="text-align: center;">Create reservation:</h3>

				<div class="row">
					<h5>Select flight:</h5>
					<select name="flight" id="flight" class=" form-control col-xs-9"
						onchange="fillOtherFields()">
					</select>
				</div>
				<br />
				<div class="row">
					<h5>Date of creation:</h5>
					<input class=" form-control col-xs-9" type="date" id="start"
						name="trip-start" value="" min="2021-10-01" max="2118-12-31">
					<!-- <input type="text"
						class=" form-control col-xs-9" placeholder="Date of creation"
						name="date" id="date"> -->
				</div>
				<br />
				<div class="row">
					<h5>Start location:</h5>
					<input type="text" class=" form-control col-xs-9" name="startLoc"
						id="startLoc" placeholder="Start location" readonly="true">
				</div>
				<br /> <br />
				<div class="row">
					<h5>End location:</h5>
					<input type="text" class=" form-control col-xs-9"
						placeholder="End location" name="endLoc" id="endLoc"
						readonly="true">
				</div>
				<br /> <br />
				<%
				if ("Passenger".equals(userBean.getUser().getType())) {
				%>
				<div class="row">
					<h5>Choose number of seats to reserve:</h5>
					<select class=" form-control col-xs-9" placeholder="Seats number"
						name="seat" id="seat"></select>
					<input type="hidden" name="userType" id="userType" value="Passenger">
				</div>
				<br /> <br />
				<%
				}
				if ("Worker".equals(userBean.getUser().getType())) {
				%>
				<div class="row">
					<input type="password" class=" form-control col-xs-9"
						placeholder="Cargo description" name="descritpion"
						id="description">
						<input type="hidden" name="userType" id="userType" value="Worker">
				</div>
				<br /> <br />
				<div class="row">
					<h5>Upload file specification:</h5>
					<input type="file" class="form-control" id="myfile" name="myfile">
					<!-- <input type="password"
						class=" form-control col-xs-9" placeholder="File specification"
						name="specification" id="specification"> -->
				</div>
				<br />
				<%
				}
				%>

				<div class="row" style="text-align: center">
					<input type="submit" class="btn btn-default" value="Reserve">

				</div>
				<br />
				<h4 style="text-align: center;">
					<%=session.getAttribute("notificationReserve") != null ? session.getAttribute("notificationReserve") : ""%></h4>
				<br /> <input type="hidden" name="flightID" id="flightID"> <input type="hidden" name="fileURL" id="fileURL">
			</div>

		</div>

	</form>

	<jsp:include page="/WEB-INF/pages/footer.jsp" />
</body>
</html>