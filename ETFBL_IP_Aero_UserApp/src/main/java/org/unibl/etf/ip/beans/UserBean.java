package org.unibl.etf.ip.beans;

import java.io.Serializable;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.unibl.etf.ip.dao.UserDAO;
import org.unibl.etf.ip.dto.AccessNumberDTO;
import org.unibl.etf.ip.dto.UserDTO;

public class UserBean implements Serializable {

	private static final long serialVersionUID = -86983812117883287L;
	private UserDTO user = new UserDTO();
	private boolean isLoggedIn = false;

	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Username u konstruktoru: " + user.getUsername());
		System.out.println("Password u konstruktoru: " + user.getPassword());
	}

	public UserBean(UserDTO user, boolean isLoggedIn) {
		super();
		this.user = user;
		this.isLoggedIn = isLoggedIn;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public boolean login(String username, String password) {
		var list = UserDAO.getAllUsers();
		System.out.println("Username u loginu: " + user.getUsername());
		System.out.println("Password u loginu: " + user.getPassword());
		for (UserDTO userDTO : list) {
			System.out.println(userDTO);
			System.out.println(sha256(password));
			if (userDTO.getUsername().equals(username) && userDTO.getPassword().equals(sha256(password))) {
				user.setFirstname(userDTO.getFirstname());
				user.setLastname(userDTO.getLastname());
				user.setID(userDTO.getID());
				user.setType(userDTO.getType());
				isLoggedIn = true;
				return true;
			}
		}
		return false;
	}

	public void logout() {
		isLoggedIn = false;
	}

	public static String sha256(final String base) {
		try {
			final MessageDigest digest = MessageDigest.getInstance("SHA-256");
			final byte[] hash = digest.digest(base.getBytes("UTF-8"));
			final StringBuilder hexString = new StringBuilder();
			for (int i = 0; i < hash.length; i++) {
				final String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public String addUser(UserDTO user) {
		if (user != null && !"".equals(user.getAddress()) && !"".equals(user.getCountry())
				&& !"".equals(user.getEmail()) && !"".equals(user.getFirstname()) && !"".equals(user.getLastname())
				&& !"".equals(user.getPassword()) && !"".equals(user.getType()) && !"".equals(user.getUsername())) {		
			if (UserDAO.getUserByEmail(user.getEmail()) == null) {
				user.setPassword(sha256(user.getPassword()));
				if (UserDAO.insertUser(user)) {
					return "Added";
				} else {
					return "Error in insert";
				}
			} else
				return "Duplicate email!";
		} else
			return "Error";

		// return null;
	}
	
	public void addAccessNumber() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String myDate = sdf.format(date);
		AccessNumberDTO access=UserDAO.getAccessByDate(myDate);
		if(access!=null) {
			int number = access.getNumber();
			number++;
			UserDAO.updateAccess(number, myDate);
		}else 
			UserDAO.insertAccess(new AccessNumberDTO(0, 1, myDate));
		//UserDAO.updateAccess(0, myDate);
		
	}

}
