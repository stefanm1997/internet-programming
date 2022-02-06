package org.unibl.etf.ip.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.unibl.etf.ip.dao.LocationDAO;
import org.unibl.etf.ip.dto.LocationDTO;

@ManagedBean(name = "locationBean")
@SessionScoped
public class LocationBean implements Serializable {

	private static final long serialVersionUID = -5456429580022815412L;

	private ArrayList<LocationDTO> locations = new ArrayList<LocationDTO>();
	private LocationDTO location = new LocationDTO();
	private String message = "";


	public LocationBean() {
		super();
		locations = LocationDAO.getAllLocations();
	}

	public ArrayList<LocationDTO> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<LocationDTO> locations) {
		this.locations = locations;
	}

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public boolean validateInput() {
		message = "";
		boolean flag = false;
		if (!location.getCountry().matches("^[a-zA-Z\\s]*$")) {
			message += "For country name only letters can be entered! \n";
			flag = true;
		}
		if (!location.getISO2().matches("^[a-zA-Z]+$")) {
			message += "For country ISO2 only letters can be entered! \n";
			flag = true;
		}
		if (!location.getISO3().matches("^[a-zA-Z]+$")) {
			message += "For country ISO3 only letters can be entered! \n";
			flag = true;
		}
		if (!location.getCity().matches("^[a-zA-Z\\s]*$")) { 
			message += "For city name only letters can be entered! \n";
			flag = true;
		}
		if (flag)
			return false;
		return true;
	}
	
	
	public String addLocation() {
		if (validateInput()) {
			if (LocationDAO.insertLocation(location)) {
				locations.clear();
				locations = LocationDAO.getAllLocations();
			}
		}
		return null;
	}
	
	public String deleteLocation() {
		Map<String, String> reqMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if (reqMap.containsKey("id")) {
			int z = Integer.parseInt(reqMap.get("id"));
			for (LocationDTO l : locations) {
				if (l.getID() == z) {
					locations.remove(l);
					LocationDAO.deleteLocation(z);
					break;
				}
			}
		}
		return null;
	}
	
	public String updateLocation() {
		locations.clear();
		locations = LocationDAO.getAllLocations();
		if (validateInput()) {
			for (int i = 0; i < locations.size(); i++) {
				if (locations.get(i).getID() == location.getID()) {
					if (LocationDAO.updateLocation(location, location.getID()))
						locations.set(i, location);
					break;
				}
			}
		}
		return null;
	}

}
