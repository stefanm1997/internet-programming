package org.unibl.etf.ip.beans;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.unibl.etf.ip.dao.UserDAO;
import org.unibl.etf.ip.dto.UserDTO;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = -86983812117883287L;

	private ArrayList<UserDTO> users = new ArrayList<UserDTO>();
	private UserDTO user = new UserDTO();
	private String message;
	private UserDTO userTable = new UserDTO();

	public UserBean() {
		super();
		users = UserDAO.getAllUsers();
		for (UserDTO userDTO : users) {
			System.out.println(userDTO);
		}
	}

	public ArrayList<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<UserDTO> users) {
		this.users = users;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public UserDTO getUserTable() {
		return userTable;
	}

	public void setUserTable(UserDTO userTable) {
		this.userTable = userTable;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String addUser() {
		user.setPassword(AdminBean.sha256(user.getPassword()));
		if (validateInputAdd()) {
			if (UserDAO.insertUser(user)) {
				users.clear();
				users = UserDAO.getAllUsers();
				// users.add(user);
			}
		}
		return null;
	}

	public String deleteUser() {
		Map<String, String> reqMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if (reqMap.containsKey("id")) {
			int z = Integer.parseInt(reqMap.get("id"));
			for (UserDTO u : users) {
				if (u.getID() == z) {
					users.remove(u);
					UserDAO.deleteUser(z);
					break;
				}
			}
		}
		return null;
	}

	public String updateUser() {
		users.clear();
		users = UserDAO.getAllUsers();
		if (validateInputUpdate()) {
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getID() == user.getID()) {
					user.setPassword(AdminBean.sha256(user.getPassword()));
					if (UserDAO.updateUser(user, user.getID()))
						users.set(i, user);
					break;
				}
			}
		}

		return null;
	}

	public boolean validateInputAdd() {
		message = "";
		boolean flag = false;
		var userByMail = UserDAO.getUserByEmail(user.getEmail());
		if (userByMail != null) {
			message += "Entered mail is not unique! \n";
			flag = true;
		}
		if (!user.getFirstname().matches("^[a-zA-Z\\s]*$")) {
			message += "For firstname only letters can be entered! \n";
			flag = true;
		}
		if (!user.getLastname().matches("^[a-zA-Z\\s]*$")) {
			message += "For lastname only letters can be entered! \n";
			flag = true;
		}
		if (!user.getCountry().matches("^[a-zA-Z\\s]*$")) {
			message += "For country only letters can be entered! \n";
			flag = true;
		}
		if (!user.getType().matches("^[a-zA-Z]+$")) {
			message += "For type only letters can be entered! \n";
			flag = true;
		}
		if (flag)
			return false;
		return true;
	}
	
	public boolean validateInputUpdate() {
		message = "";
		boolean flag = false;
		if (!user.getFirstname().matches("^[a-zA-Z\\s]*$")) {
			message += "For firstname only letters can be entered! \n";
			flag = true;
		}
		if (!user.getLastname().matches("^[a-zA-Z\\s]*$")) {
			message += "For lastname only letters can be entered! \n";
			flag = true;
		}
		if (!user.getCountry().matches("^[a-zA-Z\\s]*$")) {
			message += "For country only letters can be entered! \n";
			flag = true;
		}
		if (!user.getType().matches("^[a-zA-Z]+$")) {
			message += "For type only letters can be entered! \n";
			flag = true;
		}
		if (flag)
			return false;
		return true;
	}
}
