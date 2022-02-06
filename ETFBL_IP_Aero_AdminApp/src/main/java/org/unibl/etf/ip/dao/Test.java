package org.unibl.etf.ip.dao;

import org.unibl.etf.ip.dto.CityDTO;
import org.unibl.etf.ip.dto.CountryDTO;
import org.unibl.etf.ip.dto.EmployerDTO;
import org.unibl.etf.ip.dto.UserDTO;

public class Test {

	public static void main(String[] args) {
		
		//System.out.println(CityDAO.insertCity(new CityDTO(0, 2, "Zadar", 500000)));
		
//		var dao = UserDAO.getAllUsers();
//		  for (UserDTO city : dao) { System.out.println(city); }

		  //System.out.println(UserDAO.insertUser(new UserDTO(0, "test@gmail.com", "Marko", "Markovic","Beograd","Srbija","markom","blabla","teretni")));
		//System.out.println(CityDAO.updateCity(new CityDTO(0, 1, "Split", 50),6));
//		System.out.println(CountryDAO.deleteCountry(3));
//		var dao1 = CityDAO.getAllCitys();
//		  for (CityDTO city : dao1) { System.out.println(city); }
//		  
//		  System.out.println(CityDAO.deleteCity(6));
//		  
//		  var dao2 = CityDAO.getAllCitys();
//		  for (CityDTO city : dao2) { System.out.println(city); }
		System.out.println(EmployerDAO.insertEmployer(new EmployerDTO(0, "stankos", "nikonista", "Stanko", "Stankovic")));
		System.out.println(EmployerDAO.insertEmployer(new EmployerDTO(0, "djordje123", "mozdamoyda", "Djordje", "Djordjevic")));
		var dao = EmployerDAO.getAllEmployers();
		  for (EmployerDTO city : dao) { System.out.println(city); }
		  //System.out.println(EmployerDAO.updateCountry(new EmployerDTO(0, "djoleDjox", "novaLoza", "Djordje", "Djordjevic"),2));
		  var dao1 = EmployerDAO.getAllEmployers();
		  for (EmployerDTO city : dao1) { System.out.println(city); }
		  
		  //System.out.println(UserDAO.updateUser(new UserDTO(0, "test@hotmail.com", "Marko", "Markovic","Nis","Srbija","markom","blabla","putnicki"),2));
		  System.out.println(EmployerDAO.deleteEmployer(2));
		  var dao2 = EmployerDAO.getAllEmployers();
		  for (EmployerDTO city : dao2) { System.out.println(city); }
	}

}
