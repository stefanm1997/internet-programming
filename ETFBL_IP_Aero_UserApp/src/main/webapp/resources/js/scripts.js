
function getCountrys() {
	var request = new XMLHttpRequest();
	var address = "http://api.countrylayer.com/v2/region/europe?access_key=a95e2b95a0629d7fdd0ab2acdbee4339";
	request.onreadystatechange = function() {
		if ((request.readyState == 4) && (request.status == 200)) {
			var selection = document.getElementById("country");
			var json = JSON.parse(request.responseText);
			console.log(json);
			var result = "";
			for (var i = 0; i < json.length; i++) {
				result += "<option>" + json[i].name + "</option>";
			}
			selection.innerHTML = result;
		}
	};
	request.open("GET", address, true);
	request.send();
}
function setInt() {
	getFlights();
	setInterval(getFlights, 60000);
}

function setInt2() {
	onClickTodayButtonDepartures();
	setInterval(onClickTodayButtonDepartures, 60000);
}

function setInt3() {
	onClickTodayButtonArrivals()
	setInterval(onClickTodayButtonArrivals, 60000);
}

function getFlights() {
	var request = new XMLHttpRequest();
	var address = "http://localhost:8081/ETFBL_IP_Aero_UserApp/Flight?action=all";
	request.onreadystatechange = function() {
		if ((request.readyState == 4) && (request.status == 200)) {
			var tableArrival = document.getElementById("bodyArrival");
			var tableDeparture = document.getElementById("bodyDeparture");
			var json = JSON.parse(request.responseText);
			var jsonArrival = JSON.parse(request.responseText);
			console.log(json);
			//console.log(table);
			//var body = table.getElementsByTagName("tbody");
			//console.log(body);
			var resultArrival = "";
			var resultDeparture = "";
			var j = 0, k = 0;
			for (var i = jsonArrival.length - 1; i > 0; i--) {
				if (jsonArrival[i].status == 'arrival' && k < 5) {
					k = k + 1;
					resultArrival += "<tr style='text-align: center; vertical-align: middle'><td>" + (k) + "</td><td>" + jsonArrival[i].startLocation.country + "," +
						jsonArrival[i].startLocation.city + "</td><td>" + jsonArrival[i].endLocation.country + ", " + jsonArrival[i].endLocation.city + "</td ><td>"
						+ jsonArrival[i].type + "</td><td>" + jsonArrival[i].status + "</td></tr > ";
				}
				if (jsonArrival[i].status == 'departure' && j < 5) {
					j = j + 1;
					resultDeparture += "<tr style='text-align: center; vertical-align: middle'><td>" + (j) + "</td><td>" + jsonArrival[i].startLocation.country + "," +
						jsonArrival[i].startLocation.city + "</td><td>" + jsonArrival[i].endLocation.country + "," + jsonArrival[i].endLocation.city + "</td><td>"
						+ jsonArrival[i].type + "</td><td>" + jsonArrival[i].status + "</td></tr>";
				}

			}
			tableArrival.innerHTML = resultArrival;
			tableDeparture.innerHTML = resultDeparture;


			/*for (j = 0; j < json.length; j++) {			
				if(j < 5 && json[j].status == 'departure') {	
					var br = 1;	
					console.log(j);		
					
				}
			}*/

		}
	};
	request.open("GET", address, true);
	request.send();
}


function initMap() {
	// The location of Uluru 44.93377011011022, 17.303673060951493
	const uluru = { lat: 44.93377011011022, lng: 17.303673060951493 };
	// The map, centered at Uluru
	const map = new google.maps.Map(document.getElementById("map"), {
		zoom: 12,
		center: uluru,
	});
	// The marker, positioned at Uluru
	const marker = new google.maps.Marker({
		position: uluru,
		map: map,
	});
}

function getAllTodayArrivals() {
	var request = new XMLHttpRequest();
	var address = "http://localhost:8081/ETFBL_IP_Aero_UserApp/Flight?action=allToday";
	request.onreadystatechange = function() {
		if ((request.readyState == 4) && (request.status == 200)) {
			var tableArrival = document.getElementById("arrivalBody");
			var jsonArrival = JSON.parse(request.responseText);
			var resultArrival = "";
			var k = 0;
			for (var i = 0; i < jsonArrival.length; i++) {
				if (jsonArrival[i].status == 'arrival') {
					k = k + 1;
					var date = new Date().toISOString().slice(0, 10);;
					/*if (type == 'today') {
						date = new Date().toISOString().slice(0, 10);
					} *//*else if (type == 'yesterday') {
						date = formatDate(new Date().toISOString().slice(0, 10), 'yesterday');
					} else
						date = formatDate(new Date().toISOString().slice(0, 10), 'tomorrow');
					console.log("Datum" + date);*/
					var resultDateHour = "";
					for (var j = 0; j < jsonArrival[i].flightSchedules.scheduleList.length; j++) {
						if (date == jsonArrival[i].flightSchedules.scheduleList[j].date) {
							resultDateHour += jsonArrival[i].flightSchedules.scheduleList[j].date + ":" +
								jsonArrival[i].flightSchedules.scheduleList[j].hour + "h &nbsp";

						}

					}
					resultArrival += "<tr style='text-align: center; vertical-align: middle'><td>" + (k) + "</td><td>" + jsonArrival[i].startLocation.country + "," +
						jsonArrival[i].startLocation.city + "</td><td>" + jsonArrival[i].endLocation.country + ", " + jsonArrival[i].endLocation.city + "</td ><td>"
						+ resultDateHour + "</td><td>" + jsonArrival[i].type + "</td><td>" + jsonArrival[i].status + "</td></tr > ";
				}

			}
			tableArrival.innerHTML = resultArrival;
		}

	};
	request.open("GET", address, true);
	request.send();
}

function getAllYesterdayArrivals() {
	var request = new XMLHttpRequest();
	var address = "http://localhost:8081/ETFBL_IP_Aero_UserApp/Flight?action=allYesterday";
	request.onreadystatechange = function() {
		if ((request.readyState == 4) && (request.status == 200)) {
			var tableArrival = document.getElementById("arrivalBody");
			var jsonArrival = JSON.parse(request.responseText);
			var resultArrival = "";
			var k = 0;
			for (var i = 0; i < jsonArrival.length; i++) {
				if (jsonArrival[i].status == 'arrival') {
					k = k + 1;
					var date = n = formatDate(new Date().toISOString().slice(0, 10), 'yesterday');
					/*					console.log(date);
										console.log(new Date().toISOString().slice(0, 10));*/
					/*if (type == 'today') {
						date = new Date().toISOString().slice(0, 10);
					} *//*else if (type == 'yesterday') {
						date = formatDate(new Date().toISOString().slice(0, 10), 'yesterday');
					} else
						date = formatDate(new Date().toISOString().slice(0, 10), 'tomorrow');
					console.log("Datum" + date);*/
					var resultDateHour = "";
					for (var j = 0; j < jsonArrival[i].flightSchedules.scheduleList.length; j++) {
						if (date == jsonArrival[i].flightSchedules.scheduleList[j].date) {
							resultDateHour += jsonArrival[i].flightSchedules.scheduleList[j].date + ":" +
								jsonArrival[i].flightSchedules.scheduleList[j].hour + "h  &nbsp";

						}

					}
					console.log(resultDateHour);
					resultArrival += "<tr style='text-align: center; vertical-align: middle'><td>" + (k) + "</td><td>" + jsonArrival[i].startLocation.country + "," +
						jsonArrival[i].startLocation.city + "</td><td>" + jsonArrival[i].endLocation.country + ", " + jsonArrival[i].endLocation.city + "</td ><td>"
						+ resultDateHour + "</td><td>" + jsonArrival[i].type + "</td><td>" + jsonArrival[i].status + "</td></tr > ";
				}

			}
			tableArrival.innerHTML = resultArrival;
		}

	};
	request.open("GET", address, true);
	request.send();
}

function getAllTomorrowArrivals() {
	var request = new XMLHttpRequest();
	var address = "http://localhost:8081/ETFBL_IP_Aero_UserApp/Flight?action=allTomorrow";
	request.onreadystatechange = function() {
		if ((request.readyState == 4) && (request.status == 200)) {
			var tableArrival = document.getElementById("arrivalBody");
			var jsonArrival = JSON.parse(request.responseText);
			var resultArrival = "";
			var k = 0;
			for (var i = 0; i < jsonArrival.length; i++) {
				if (jsonArrival[i].status == 'arrival') {
					k = k + 1;
					var date = formatDate(new Date().toISOString().slice(0, 10), 'tomorrow');
					/*if (type == 'today') {
						date = new Date().toISOString().slice(0, 10);
					} *//*else if (type == 'yesterday') {
						date = formatDate(new Date().toISOString().slice(0, 10), 'yesterday');
					} else
						date = formatDate(new Date().toISOString().slice(0, 10), 'tomorrow');
					console.log("Datum" + date);*/
					var resultDateHour = "";
					for (var j = 0; j < jsonArrival[i].flightSchedules.scheduleList.length; j++) {
						if (date == jsonArrival[i].flightSchedules.scheduleList[j].date) {
							resultDateHour += jsonArrival[i].flightSchedules.scheduleList[j].date + ":" +
								jsonArrival[i].flightSchedules.scheduleList[j].hour + "h  &nbsp";

						}

					}
					resultArrival += "<tr style='text-align: center; vertical-align: middle'><td>" + (k) + "</td><td>" + jsonArrival[i].startLocation.country + "," +
						jsonArrival[i].startLocation.city + "</td><td>" + jsonArrival[i].endLocation.country + ", " + jsonArrival[i].endLocation.city + "</td ><td>"
						+ resultDateHour + "</td><td>" + jsonArrival[i].type + "</td><td>" + jsonArrival[i].status + "</td></tr > ";
				}

			}
			tableArrival.innerHTML = resultArrival;
		}

	};
	request.open("GET", address, true);
	request.send();
}

function getAllTodayDepartures() {
	var request = new XMLHttpRequest();
	var address = "http://localhost:8081/ETFBL_IP_Aero_UserApp/Flight?action=allToday";
	request.onreadystatechange = function() {
		if ((request.readyState == 4) && (request.status == 200)) {
			var tableArrival = document.getElementById("departureBody");
			var jsonArrival = JSON.parse(request.responseText);
			var resultArrival = "";
			var k = 0;
			for (var i = 0; i < jsonArrival.length; i++) {
				if (jsonArrival[i].status == 'departure') {
					k = k + 1;
					var date = new Date().toISOString().slice(0, 10);
					/*if (type == 'today') {
						date = new Date().toISOString().slice(0, 10);
					} *//*else if (type == 'yesterday') {
						date = formatDate(new Date().toISOString().slice(0, 10), 'yesterday');
					} else
						date = formatDate(new Date().toISOString().slice(0, 10), 'tomorrow');
					console.log("Datum" + date);*/
					var resultDateHour = "";
					for (var j = 0; j < jsonArrival[i].flightSchedules.scheduleList.length; j++) {
						if (date == jsonArrival[i].flightSchedules.scheduleList[j].date) {
							resultDateHour += jsonArrival[i].flightSchedules.scheduleList[j].date + ":" +
								jsonArrival[i].flightSchedules.scheduleList[j].hour + "h &nbsp";

						}

					}
					resultArrival += "<tr style='text-align: center; vertical-align: middle'><td>" + (k) + "</td><td>" + jsonArrival[i].startLocation.country + "," +
						jsonArrival[i].startLocation.city + "</td><td>" + jsonArrival[i].endLocation.country + ", " + jsonArrival[i].endLocation.city + "</td ><td>"
						+ resultDateHour + "</td><td>" + jsonArrival[i].type + "</td><td>" + jsonArrival[i].status + "</td></tr > ";
				}

			}
			tableArrival.innerHTML = resultArrival;
		}

	};
	request.open("GET", address, true);
	request.send();
}

function getAllYesterdayDepartures() {
	var request = new XMLHttpRequest();
	var address = "http://localhost:8081/ETFBL_IP_Aero_UserApp/Flight?action=allYesterday";
	request.onreadystatechange = function() {
		if ((request.readyState == 4) && (request.status == 200)) {
			var tableArrival = document.getElementById("departureBody");
			var jsonArrival = JSON.parse(request.responseText);
			var resultArrival = "";
			var k = 0;
			for (var i = 0; i < jsonArrival.length; i++) {
				if (jsonArrival[i].status == 'departure') {
					k = k + 1;
					var date = n = formatDate(new Date().toISOString().slice(0, 10), 'yesterday');
					/*if (type == 'today') {
						date = new Date().toISOString().slice(0, 10);
					} *//*else if (type == 'yesterday') {
						date = formatDate(new Date().toISOString().slice(0, 10), 'yesterday');
					} else
						date = formatDate(new Date().toISOString().slice(0, 10), 'tomorrow');
					console.log("Datum" + date);*/
					var resultDateHour = "";
					for (var j = 0; j < jsonArrival[i].flightSchedules.scheduleList.length; j++) {
						if (date == jsonArrival[i].flightSchedules.scheduleList[j].date) {
							resultDateHour += jsonArrival[i].flightSchedules.scheduleList[j].date + ":" +
								jsonArrival[i].flightSchedules.scheduleList[j].hour + "h  &nbsp";

						}

					}
					resultArrival += "<tr style='text-align: center; vertical-align: middle'><td>" + (k) + "</td><td>" + jsonArrival[i].startLocation.country + "," +
						jsonArrival[i].startLocation.city + "</td><td>" + jsonArrival[i].endLocation.country + ", " + jsonArrival[i].endLocation.city + "</td ><td>"
						+ resultDateHour + "</td><td>" + jsonArrival[i].type + "</td><td>" + jsonArrival[i].status + "</td></tr > ";
				}

			}
			tableArrival.innerHTML = resultArrival;
		}

	};
	request.open("GET", address, true);
	request.send();
}

function getAllTomorrowDepartures() {
	var request = new XMLHttpRequest();
	var address = "http://localhost:8081/ETFBL_IP_Aero_UserApp/Flight?action=allTomorrow";
	request.onreadystatechange = function() {
		if ((request.readyState == 4) && (request.status == 200)) {
			var tableArrival = document.getElementById("departureBody");
			var jsonArrival = JSON.parse(request.responseText);
			var resultArrival = "";
			var k = 0;
			for (var i = 0; i < jsonArrival.length; i++) {
				if (jsonArrival[i].status == 'departure') {
					k = k + 1;
					var date = formatDate(new Date().toISOString().slice(0, 10), 'tomorrow');
					/*if (type == 'today') {
						date = new Date().toISOString().slice(0, 10);
					} *//*else if (type == 'yesterday') {
						date = formatDate(new Date().toISOString().slice(0, 10), 'yesterday');
					} else
						date = formatDate(new Date().toISOString().slice(0, 10), 'tomorrow');
					console.log("Datum" + date);*/
					var resultDateHour = "";
					for (var j = 0; j < jsonArrival[i].flightSchedules.scheduleList.length; j++) {
						if (date == jsonArrival[i].flightSchedules.scheduleList[j].date) {
							resultDateHour += jsonArrival[i].flightSchedules.scheduleList[j].date + ":" +
								jsonArrival[i].flightSchedules.scheduleList[j].hour + "h  &nbsp";

						}

					}
					resultArrival += "<tr style='text-align: center; vertical-align: middle'><td>" + (k) + "</td><td>" + jsonArrival[i].startLocation.country + "," +
						jsonArrival[i].startLocation.city + "</td><td>" + jsonArrival[i].endLocation.country + ", " + jsonArrival[i].endLocation.city + "</td ><td>"
						+ resultDateHour + "</td><td>" + jsonArrival[i].type + "</td><td>" + jsonArrival[i].status + "</td></tr > ";
				}

			}
			tableArrival.innerHTML = resultArrival;
		}

	};
	request.open("GET", address, true);
	request.send();
}

function sortJsonArrayByProperty(objArray, prop, direction) {
	if (arguments.length < 2) throw new Error("sortJsonArrayByProp requires 2 arguments");
	var direct = arguments.length > 2 ? arguments[2] : 1; //Default to ascending

	if (objArray && objArray.constructor === Array) {
		var propPath = (prop.constructor === Array) ? prop : prop.split(".");
		objArray.sort(function(a, b) {
			for (var p in propPath) {
				if (a[propPath[p]] && b[propPath[p]]) {
					a = a[propPath[p]];
					b = b[propPath[p]];
				}
			}
			// convert numeric strings to integers
			a = a.match(/^\d+$/) ? +a : a;
			b = b.match(/^\d+$/) ? +b : b;
			return ((a < b) ? -1 * direct : ((a > b) ? 1 * direct : 0));
		});
	}
}

function formatDate(date, type) {
	var d = new Date(date);
	if (type == 'yesterday')
		d.setDate(d.getDate() - 1);
	else
		d.setDate(d.getDate() + 1);
	month = '' + (d.getMonth() + 1),
		day = '' + d.getDate(),
		year = d.getFullYear();


	if (month.length < 2)
		month = '0' + month;
	if (day.length < 2)
		day = '0' + day;

	return [year, month, day].join('-');
}

function onClickTodayButtonArrivals() {
	getAllTodayArrivals();
	document.getElementById("tomorrow").onclick = onClickTomorrowButtonArrivals;
	document.getElementById("yesterday").onclick = onClickYesterdayButtonArrivals;
	document.getElementById("yesterdayDiv").style.display = "block";
	document.getElementById("tomorrowDiv").style.display = "block";
	document.getElementById("yesterday").innerText = "Yesterday";
	document.getElementById("tomorrow").innerText = "Tomorrow";
}

function onClickYesterdayButtonArrivals() {
	document.getElementById("yesterdayDiv").style.display = "none";
	document.getElementById("tomorrow").innerText = "Today";
	getAllYesterdayArrivals();
	document.getElementById("tomorrow").onclick = onClickTodayButtonArrivals;

}

function onClickTomorrowButtonArrivals() {
	document.getElementById("tomorrowDiv").style.display = "none";
	document.getElementById("yesterday").innerText = "Today";
	getAllTomorrowArrivals();
	document.getElementById("yesterday").onclick = onClickTodayButtonArrivals;

}

function onClickTodayButtonDepartures() {
	getAllTodayDepartures();
	document.getElementById("tomorrowDeparture").onclick = onClickTomorrowButtonDepartures;
	document.getElementById("yesterdayDeparture").onclick = onClickYesterdayButtonDepartures;
	document.getElementById("yesterdayDepartureDiv").style.display = "block";
	document.getElementById("tomorrowDepartureDiv").style.display = "block";
	document.getElementById("yesterdayDeparture").innerText = "Yesterday";
	document.getElementById("tomorrowDeparture").innerText = "Tomorrow";
}

function onClickYesterdayButtonDepartures() {
	document.getElementById("yesterdayDepartureDiv").style.display = "none";
	document.getElementById("tomorrowDeparture").innerText = "Today";
	getAllYesterdayDepartures();
	document.getElementById("tomorrowDeparture").onclick = onClickTodayButtonDepartures;

}

function onClickTomorrowButtonDepartures() {
	document.getElementById("tomorrowDepartureDiv").style.display = "none";
	document.getElementById("yesterdayDeparture").innerText = "Today";
	getAllTomorrowDepartures();
	document.getElementById("yesterdayDeparture").onclick = onClickTodayButtonDepartures;

}

var reservationsID;

function getAllReservations() {
	var request = new XMLHttpRequest();
	var address = "http://localhost:8081/ETFBL_IP_Aero_UserApp/Reservation?action=allReservation";
	request.onreadystatechange = function() {
		if ((request.readyState == 4) && (request.status == 200)) {
			var tableReservations = document.getElementById("reservationsBody");
			if (request.responseText != "") {
				var jsonReservations = JSON.parse(request.responseText);
				var resultReservations = "";
				console.log(jsonReservations);
				var k = 0;
				for (var i = 0; i < jsonReservations.length; i++) {
					k = k + 1;
					var date = new Date().toISOString().slice(0, 10);;
					var resultDateHour = "";
					for (var j = 0; j < jsonReservations[i].flight.flightSchedules.scheduleList.length; j++) {
						//izlistaj samo datume koji su jednaki ili veci od danasnjeg, nema smisla gledati vremena letova u proslosti
						if (new Date(date) <= new Date(jsonReservations[i].flight.flightSchedules.scheduleList[j].date))
							resultDateHour += jsonReservations[i].flight.flightSchedules.scheduleList[j].date + ":" +
								jsonReservations[i].flight.flightSchedules.scheduleList[j].hour + "h  &nbsp";

					}

					resultReservations += "<tr style='text-align: center; vertical-align: middle'><td style='vertical-align: middle;'>" + (k) + "</td><td style='vertical-align: middle;display:none'>" + jsonReservations[i].ID + "</td><td style='vertical-align: middle;'>" + jsonReservations[i].flight.startLocation.country + "," +
						jsonReservations[i].flight.startLocation.city + "</td><td style='vertical-align: middle;'>" + jsonReservations[i].flight.endLocation.country + ", " + jsonReservations[i].flight.endLocation.city + "</td ><td style='vertical-align: middle;'>"
						+ jsonReservations[i].date_creation + "</td><td style='vertical-align: middle;'>" + jsonReservations[i].status + "</td><td style='vertical-align: middle;'>" + jsonReservations[i].flight.seats_Number + "</td><td style='vertical-align: middle;'>" +
						jsonReservations[i].flight.description + "</td><td style='vertical-align: middle;'>" + resultDateHour + "</td>";
					if ("New" == jsonReservations[i].status) {
						var reservationID = jsonReservations[i].ID;
						//console.log(reservationID);
						resultReservations += "<td><button type='submit' class='btn' style='background-color: red;color:white;' onclick='updateReservationStatus(" + reservationID + ")'>X</button></td></tr > ";
					} else {
						resultReservations += "<td></td></tr>";
					}
				}
				tableReservations.innerHTML = resultReservations;
			}
			//document.getElementById("notUsr").innerText="";
		}

	};
	request.open("GET", address, true);
	request.send();
}

function clearUserBean() {
	console.log("Pozvao");
	console.log(sessionStorage.getItem("userBean"));
	sessionStorage.setItem("userBean", null);
	console.log(sessionStorage.getItem("userBean"));
}

function updateReservationStatus(reservationID) {
	var request = new XMLHttpRequest();
	var address = "http://localhost:8081/ETFBL_IP_Aero_UserApp/Reservation?action=updateStatus";
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			getAllReservations();
		}
	}
	//var body=JSON.stringify("{status=Declined}");
	//console.log(body);
	//var reservationID=jsonReservations.ID;
	console.log(reservationID);
	//alert((this).closest('tr').attr('id'));
	request.open("POST", address);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send("status=Declined&id=" + reservationID);
	//request.setRequestHeader("Content-type", "application/json");
	//var body = "json_object="+JSON.stringify({status:"Declined", test:"Proba"});
	//request.send(JSON.stringify({status:"Declined", test:"Proba"})); //moze ovako, samo se mora citati kao json u servletu
}



function getFlightsForReservation() {
	var request = new XMLHttpRequest();
	var address = "http://localhost:8081/ETFBL_IP_Aero_UserApp/Reservation?action=reserve";
	request.onreadystatechange = function() {
		if ((request.readyState == 4) && (request.status == 200)) {
			var selection = document.getElementById("flight");
			//console.log(request.responseText);
			var json = JSON.parse(request.responseText);
			console.log(json);
			var result = "";
			var resultSeats = "";
			for (var i = 0; i < json.length; i++) {
				if (json[i].status == 'arrival') {
					var date = new Date().toISOString().slice(0, 10);
					var resultDateHour = "";
					for (var j = 0; j < json[i].flightSchedules.scheduleList.length; j++) {
						//izlistaj samo datume koji su jednaki ili veci od danasnjeg, nema smisla gledati vremena letova u proslosti
						if (new Date(date) <= new Date(json[i].flightSchedules.scheduleList[j].date))
							resultDateHour += json[i].flightSchedules.scheduleList[j].date + ":" +
								json[i].flightSchedules.scheduleList[j].hour + "h  &nbsp";

					}
					if (i == 0) {
						result += "<option selected value=" + json[i].D  + ">" + json[i].startLocation.country + " , " +
							json[i].startLocation.city + " --> " + json[i].endLocation.country + " , " +
							json[i].endLocation.city + " ==> seats number: " + json[i].seats_Number;
						if (resultDateHour != "") {
							result += " ==> date: " + resultDateHour + "</option>";
						} else
							result += "</option>";
					} else {
						//console.log("BROJ2"+json[i].seats_Number);
						result += "<option value=" + json[i].ID+   ">" + json[i].startLocation.country + " , " +
							json[i].startLocation.city + " --> " + json[i].endLocation.country + " , " +
							json[i].endLocation.city + " ==> seats number: " + json[i].seats_Number;
						//document.getElementById("flightID").innerText=json[i].ID;
						if (resultDateHour != "") {
							result += " ==> date: " + resultDateHour + "</option>";
						} else
							result += "</option>";
					}

				}

			}
			selection.innerHTML = result;
			//seatsNumber.innerHTML = resultSeats;
			fillOtherFields();
		}
	};
	request.open("GET", address, true);
	request.send();
}

function fillOtherFields() {
	//console.log(proba);
	var selection = document.getElementsByTagName("option");
	var selectionValue = document.getElementById("flight");
	var seatsNum = document.getElementById("seat");
	document.getElementById("flightID").value = selectionValue.options[selectionValue.selectedIndex].value;
	var value = selectionValue.options[selectionValue.selectedIndex].text;
	//console.log("VAL" + value.split("-->")[0]);
	var startLocation = value.split("-->")[0];
	var endLocation = value.split("-->")[1].split("==>")[0];
	var seatsNumber = value.split("==>")[1].split(":")[1];
	//console.log(seatsNumber);
	document.getElementById("startLoc").innerHTML = startLocation;
	document.getElementById("endLoc").innerHTML = endLocation;
	document.getElementById("startLoc").value = startLocation;
	document.getElementById("endLoc").value = endLocation;
	
	var userType = document.getElementById("userType").value;
	console.log(userType);
	if (userType == "Passenger") {
		seatsNum.innerHTML = "";
		for (var b = 1; b <= seatsNumber; b++) {
			seatsNum.innerHTML += "<option>" + b + "</option>";
		}
	} else {
		const inputElement = document.getElementById("myfile");
		inputElement.addEventListener("change", handleFiles, false);
		function handleFiles() {
			const fileList = this.files; /* now you can work with the file list */
			const objectURL = window.URL.createObjectURL(fileList[0]);
			document.getElementById("fileURL").value = objectURL;
		}
	}
}

function downloadURI(uri, name) {

	var link = document.createElement("a");
	link.download = name;
	link.href = uri;
	document.body.appendChild(link);
	link.click();
	document.body.removeChild(link);
	delete link;
}