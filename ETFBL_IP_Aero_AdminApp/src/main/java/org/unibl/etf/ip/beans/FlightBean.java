package org.unibl.etf.ip.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.unibl.etf.ip.dao.FlightDAO;
import org.unibl.etf.ip.dao.LocationDAO;

import org.unibl.etf.ip.dto.FlightDTO;
import org.unibl.etf.ip.dto.LocationDTO;

@ManagedBean(name = "flightBean")
@ViewScoped
public class FlightBean implements Serializable {

	private static final long serialVersionUID = 1048741036372003622L;
	private ArrayList<FlightDTO> flights = new ArrayList<FlightDTO>();
	private ArrayList<LocationDTO> locations = new ArrayList<LocationDTO>();
	private ArrayList<String> stringLocations = new ArrayList<String>();
	private String Status = "", Type = "",endLocation="",startLocation="";
	private int Seats_number;
	private FlightDTO flight = new FlightDTO();
	// private String endLocation="";
	//LocationDTO startLocation = new LocationDTO();
	//LocationDTO endLocation = new LocationDTO();	
	// private static Map<String, Object> favoriteCar2Value;
	//private Map<String, LocationDTO> locationsMap;

	//public Map<String, LocationDTO> getLocationsMap() {
		//return locationsMap;
	//}

	public FlightBean() {
		super();
		flights = FlightDAO.getAllFlights();
		locations = LocationDAO.getAllLocations();
		//locationsMap = new LinkedHashMap<String, LocationDTO>();
		for (LocationDTO locationDTO : locations) {
			//locationsMap.put(locationDTO.getCountry() + "," + locationDTO.getCity(), locationDTO);
			 stringLocations.add(locationDTO.getID()+". "+locationDTO.getCountry()+","+locationDTO.getCity());
		}
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> getStringLocations() {
		return stringLocations;
	}

	public void setStringLocations(ArrayList<String> stringLocations) {
		this.stringLocations = stringLocations;
	}

	public ArrayList<FlightDTO> getFlights() {
		return flights;
	}

	public void setFlights(ArrayList<FlightDTO> flights) {
		this.flights = flights;
	}

	public FlightDTO getFlight() {
		return flight;
	}

	public void setFlight(FlightDTO flight) {
		this.flight = flight;
	}

	public ArrayList<LocationDTO> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<LocationDTO> locations) {
		this.locations = locations;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public int getSeats_number() {
		return Seats_number;
	}

	public void setSeats_number(int seats_number) {
		Seats_number = seats_number;
	}

	public String addFlight() {

		var inputFlight = new FlightDTO();
		inputFlight.setSeats_Number(Seats_number);
		inputFlight.setStatus(Status);
		inputFlight.setType(Type);
		System.out.println(startLocation);
		System.out.println(endLocation);
		//var start = (LocationDTO) locationsMap.get(startLocation);
		//var end = (LocationDTO) locationsMap.get(endLocation);
		System.out.println("Start"+startLocation.split("\\.")[0]);
		System.out.println("End"+endLocation.split("\\.")[0]);
		inputFlight.setStart_Location_ID(Integer.parseInt(startLocation.split("\\.")[0]));
		inputFlight.setEnd_Location_ID(Integer.parseInt(endLocation.split("\\.")[0]));
		System.out.println(inputFlight);
		if (FlightDAO.insertFlight(inputFlight)) {
			System.out.println("Dodao");
			flights.clear();
			flights = FlightDAO.getAllFlights();
			// users.add(user);
		}

		return null;
	}
	
	public String deleteFlight() {
		Map<String, String> reqMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if (reqMap.containsKey("idFlight")) {
			int z = Integer.parseInt(reqMap.get("idFlight"));
			for (FlightDTO f : flights) {
				if (f.getID() == z) {
					flights.remove(f);
					FlightDAO.deleteFlight(z);
					break;
				}
			}
		}
		return null;
	}
}
