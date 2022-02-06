<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<style type="text/css">
th {
	text-align: center;
}
</style>
</head>
<body onload="getAllReservations();">
	<div class=" navbar navbar-inverse" style="background-color: black;">
		<jsp:include page="/WEB-INF/pages/header.jsp" />
		<jsp:include page="/WEB-INF/pages/menu.jsp" />
	</div>
	
				
	<div class="container-fluid">
		<div class="row">
			<!-- <div style="position: absolute; left: 10%; top: 35%;"> -->
			<div class="table-responsive col-lg-12">
				<table class="table table-bordered border-primary" id="reservations"
					style="border: 3px solid black;">
					<thead class="thead-dark" style="text-align: center;">
						<tr style="">
							<th colspan="10" scope="col">Reservations</th>
						</tr>
						<tr>
							<th scope="col">#</th>
							<th style="display: none;" scope="col">ID</th>
							<th scope="col">Start location</th>
							<th scope="col">End location</th>
							<th scope="col">Date creation</th>
							<th scope="col">Status</th>
							<th scope="col">Seats number</th>
							<th scope="col">Cargo description</th>
							<th scope="col">Flight date</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody id="reservationsBody">

					</tbody>
				</table>
			</div>
 
		</div>
		
		</div>
		<h1 id="notUsr" style= "text-align: center;">
					<%=session.getAttribute("notificationUser")%></h1>
	
	<jsp:include page="/WEB-INF/pages/footer.jsp" />
</body>
</html>