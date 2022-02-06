package org.unibl.etf.ip.beans;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.unibl.etf.ip.dao.AdminDAO;
import org.unibl.etf.ip.dto.AdminDTO;

@ManagedBean(name = "adminBean")
@SessionScoped
public class AdminBean implements Serializable {

	private static final long serialVersionUID = -8876138787906924001L;

	private ArrayList<AdminDTO> admins = new ArrayList<AdminDTO>();
	private AdminDTO admin = new AdminDTO();
	private String message;

	public AdminBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<AdminDTO> getAdmins() {
		return admins;
	}

	public void setAdmins(ArrayList<AdminDTO> admins) {
		this.admins = admins;
	}

	public AdminDTO getAdmin() {
		return admin;
	}

	public void setAdmin(AdminDTO admin) {
		this.admin = admin;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String logoutAdmin() {
		admin.setLogged(false);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index.xhtml?faces-redirect=true";
	}

	public String loginAdmin() {
		var list = AdminDAO.getAllAdmins();
		for (AdminDTO adminDTO : list) {
			if (adminDTO.getUsername().equals(admin.getUsername())
					&& adminDTO.getPassword().equals(sha256(admin.getPassword()))) {
				admin.setLogged(true);
				return "menu.xhtml?faces-redirect=true";
			}
		}
		this.message = "Username or password is wrong!";
		if (admin.getUsername().equals("") && !admin.getPassword().equals("")) {
			this.message = "Please enter your username!";
		}else if(!admin.getUsername().equals("") && admin.getPassword().equals("")) {
			this.message = "Please enter your password!";
		}else if(admin.getUsername().equals("") && admin.getPassword().equals("")) {
			this.message = "Please enter your username and password!";		
		}
		// return "menu.xhtml?faces-redirect=true";
		return null;
		// return "failure";

//		FacesContext context = FacesContext.getCurrentInstance();
//        FacesMessage message = null;
//        boolean loggedIn = false;
//        for (AdminDTO adminDTO : list) {
//			if(adminDTO.getUsername().equals(admin.getUsername()) && adminDTO.getPassword().equals(admin.getPassword())) {
//				//return "success";
//				//return "menu.xhtml?faces-redirect=true";
//				loggedIn = true;
//	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", admin.getUsername());
//	            try {
//					context.getExternalContext().redirect("/menu.xhtml?faces-redirect=true");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//        FacesContext.getCurrentInstance().addMessage(null, message);
		// context.addMessage("loggedIn", loggedIn);
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
}
