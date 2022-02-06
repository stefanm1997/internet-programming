<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/style.css">
<script type="text/javascript" src="resources/js/scripts.js"></script>
<style type="text/css">
th, tr, td {
	border: 1px solid white;
	text-align: center;
}

.bg-image-airport {
	background-image: url('resources/assets/airport.jpg');
	background-size: 1600px 600px;
	background-repeat: no-repeat;
	background-position: center;
}

#map {
	height: 400px;
	/* The height is 400 pixels */
	/* width: 50%; */
	/* The width is the width of the web page */
}
</style>
</head>
<body onload="setInt()" style="background-color: black;">

	<div class="container-fluid bg-image-airport">

		<!-- 		 <img class="img-fluid "
			style="height: 500px; width: 90%; display: block; margin-left: auto; margin-right: auto;"
			src="resources/assets/airport.jpg" alt="Responsive image" />  -->

		<!-- <div style="background-image: url("resources/assets/airport.jpg")">
	</div> -->
		<div class="row">
			<br /> <br /> <br /> <br /> <br />
			<div style="padding-left: 10%; padding-right: 10%;" class="col-lg-6">
				<!-- <div style="position: absolute; left: 10%; top: 35%;"> -->
				<div class="table-responsive ">
					<table class="table" id="arrival"
						style="border: 3px solid white; color: white;">
						<thead class="table-dark" style="text-align: center;">
							<tr style="border: 1px solid black;">
								<th colspan="5" scope="col" style="text-align: center;">Arrivals</th>
							</tr>
							<tr style="border: 1px solid black;">
								<th scope="col">#</th>
								<th scope="col">Start location</th>
								<th scope="col">End location</th>
								<th scope="col">Type</th>
								<th scope="col">Status</th>
							</tr>
						</thead>
						<tbody id="bodyArrival">

						</tbody>
					</table>
				</div>
			</div>
			<!-- </div> -->
			<!-- <div style="position: absolute; right: 10%; top: 35%; "> -->
			<div style="padding-right: 10%; padding-left: 10%;" class="col-lg-6">
				<div class="table-responsive">
					<table class="table" id="departure"
						style="border: 3px solid white; color: white;">
						<thead class="table-dark" style="text-align: center;">
							<tr style="border: 1px solid black;">
								<th colspan="5" scope="col" style="text-align: center;">Departures</th>
							</tr>
							<tr style="border: 1px solid black;">
								<th scope="col">#</th>
								<th scope="col">Start location</th>
								<th scope="col">End location</th>
								<th scope="col">Type</th>
								<th scope="col">Status</th>
							</tr>
						</thead>
						<tbody id="bodyDeparture">
						</tbody>
					</table>
				</div>
			</div>
			<!-- </div> -->
		</div>
		<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
		<br />
	</div>

	<div class="container-fluid" style="padding: 0;">
		<div class="col-lg-6" style="background-color: white;" id="map">
		</div>
		<form class="col-lg-6"
			style="background-color: white; text-align: center; height: 400px;" method="POST" action="?action=message">
			
			<div style="font-size: large;">
				<span class="glyphicon glyphicon-earphone"></span><label>&nbsp;
					Phone and fax number: +38765225883</label>
			</div><br/>

			<div class="form-group" style="width: 50%; display: inline-block;">
			
				<label>Email of recipient</label> <input type="text"
					class="form-control" id="inputEmail"  name="inputEmail" placeholder="Email of user">
			</div>
			<div class="form-group" style="width: 50%; display: inline-block;">
				<label >Subject of message:</label> <input type="text"
					class="form-control" id="inputSubject" name="inputSubject" placeholder="Subject">
			</div>
			<div class="form-group">
				<label>Content of message:</label><br/>
				<textarea id="inputMessage" name="inputMessage" rows="4" cols="50">	</textarea>
			</div>
			<h4 style="color: red; text-align: center;">
					<%=session.getAttribute("notificationMessage") != null ? session.getAttribute("notificationMessage") : ""%></h4>
				
			<button type="submit" class="btn btn-primary btn-lg">Send</button>
		</form>
	</div>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBiXImJ5K4tSflfntWa6hVvdhtB3rIIPwY&callback=initMap&libraries=&v=weekly"
		async></script>
	<br />
	<br />
</body>
</html>