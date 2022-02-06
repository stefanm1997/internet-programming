
function populateUsers() {

	var div = document.getElementById("userTable");
	var table = div.getElementsByTagName("table")[0];
	var body = table.getElementsByTagName("tbody")[0];

	//console.log(body);
	body.onclick = function(e) {
		var e = e || window.event;
		var td = e.target || e.srcElement
		//console.log(td);
		var row = td.parentNode;
		//value = row.getElementsByTagName("span")[0].innerHTML;
		//row.cells[0].innerText = value;
		//document.getElementById('addForm:emailDiv').value = row.cells[0].innerHTML;
		console.log(row);
		populateFields(row);
	}

	function populateFields(row) {
		document.getElementById('addForm:idDiv').value = row.getElementsByTagName("span")[0].innerHTML;
		document.getElementById('addForm:emailDiv').value = row.cells[1].innerHTML;
		document.getElementById('addForm:firstNameDiv').value = row.cells[2].innerHTML;
		document.getElementById('addForm:lastNameDiv').value = row.cells[3].innerHTML;
		document.getElementById('addForm:addressDiv').value = row.cells[4].innerHTML;
		document.getElementById('addForm:countryDiv').value = row.cells[5].innerHTML;
		document.getElementById('addForm:userNameDiv').value = row.cells[6].innerHTML;
		document.getElementById('addForm:passwordDiv').value = "";
		document.getElementById('addForm:typeDiv').value = row.cells[7].innerHTML;
	}
}

function clearInputUser() {
	document.getElementById('addForm:emailDiv').value = "";
	document.getElementById('addForm:firstNameDiv').value = "";
	document.getElementById('addForm:lastNameDiv').value = "";
	document.getElementById('addForm:addressDiv').value = "";
	document.getElementById('addForm:countryDiv').value = "";
	document.getElementById('addForm:userNameDiv').value = "";
	document.getElementById('addForm:passwordDiv').value = "";
	document.getElementById('addForm:typeDiv').value = "";
}


function scriptAlert(text) {
	alert(text);
}

function populateEmployers() {

	var div = document.getElementById("employerTable");
	var table = div.getElementsByTagName("table")[0];
	var body = table.getElementsByTagName("tbody")[0];

	//console.log(body);
	body.onclick = function(e) {
		var e = e || window.event;
		var td = e.target || e.srcElement
		//console.log(td);
		var row = td.parentNode;
		//value = row.getElementsByTagName("span")[0].innerHTML;
		//row.cells[0].innerText = value;
		//document.getElementById('addForm:emailDiv').value = row.cells[0].innerHTML;
		console.log(row);
		populateFields(row);
	}

	function populateFields(row) {
		document.getElementById('employerForm:idDiv').value = row.getElementsByTagName("span")[0].innerHTML;
		document.getElementById('employerForm:firstNameDiv').value = row.cells[1].innerHTML;
		document.getElementById('employerForm:lastNameDiv').value = row.cells[2].innerHTML;
		document.getElementById('employerForm:userNameDiv').value = row.cells[3].innerHTML;
		document.getElementById('employerForm:passwordDiv').value = "";

	}
}

function clearInputEmployer() {
		document.getElementById('employerForm:idDiv').value = "";
		document.getElementById('employerForm:firstNameDiv').value = "";
		document.getElementById('employerForm:lastNameDiv').value = "";
		document.getElementById('employerForm:userNameDiv').value = "";
		document.getElementById('employerForm:passwordDiv').value = "";
	}
	
	
function populateLocations() {

	var div = document.getElementById("locationTable");
	var table = div.getElementsByTagName("table")[0];
	var body = table.getElementsByTagName("tbody")[0];

	//console.log(body);
	body.onclick = function(e) {
		var e = e || window.event;
		var td = e.target || e.srcElement
		//console.log(td);
		var row = td.parentNode;
		//value = row.getElementsByTagName("span")[0].innerHTML;
		//row.cells[0].innerText = value;
		//document.getElementById('addForm:emailDiv').value = row.cells[0].innerHTML;
		console.log(row);
		populateFields(row);
	}

	function populateFields(row) {
		document.getElementById('locationForm:idDiv').value = row.getElementsByTagName("span")[0].innerHTML;
		document.getElementById('locationForm:countryDiv').value = row.cells[1].innerHTML;
		document.getElementById('locationForm:iso2Div').value = row.cells[2].innerHTML;
		document.getElementById('locationForm:iso3Div').value = row.cells[3].innerHTML;
		document.getElementById('locationForm:cityDiv').value = row.cells[4].innerHTML;

	}
}

function clearInputLocation() {
		document.getElementById('locationForm:idDiv').value = "";
		document.getElementById('locationForm:countryDiv').value = "";
		document.getElementById('locationForm:iso2Div').value = "";
		document.getElementById('locationForm:iso3Div').value = "";
		document.getElementById('locationForm:cityDiv').value = "";
	}

