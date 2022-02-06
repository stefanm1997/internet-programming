package org.unibl.etf.ip.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.unibl.etf.ip.dao.EmployerDAO;
import org.unibl.etf.ip.dto.EmployerDTO;

@ManagedBean(name = "employerBean")
@SessionScoped
public class EmployerBean implements Serializable {

	private static final long serialVersionUID = -5589754077958626710L;
	private ArrayList<EmployerDTO> employers = new ArrayList<EmployerDTO>();
	private EmployerDTO employer = new EmployerDTO();
	private EmployerDTO empl = new EmployerDTO();
	private String message;

	public EmployerBean() {
		super();
		employers = EmployerDAO.getAllEmployers();
		for (EmployerDTO employerDTO : employers) {
			System.out.println(employerDTO);
		}

	}

	public ArrayList<EmployerDTO> getEmployers() {
		return employers;
	}

	public void setEmployers(ArrayList<EmployerDTO> employers) {
		this.employers = employers;
	}

	public EmployerDTO getEmployer() {
		return employer;
	}

	public void setEmployer(EmployerDTO employer) {
		this.employer = employer;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public EmployerDTO getEmpl() {
		return empl;
	}

	public void setEmpl(EmployerDTO empl) {
		this.empl = empl;
	}

	public boolean validateInput() {
		message = "";
		boolean flag = false;
		if (!employer.getFirstname().matches("^[a-zA-Z\\s]*$")) {
			message += "For firstname only letters can be entered! \n";
			flag = true;
		}
		if (!employer.getLastname().matches("^[a-zA-Z\\s]*$")) {
			message += "For lastname only letters can be entered! \n";
			flag = true;
		}
		if (flag)
			return false;
		return true;
	}
	
	public String addEmployer() {
		employer.setPassword(AdminBean.sha256(employer.getPassword()));
		if (validateInput()) {
			if (EmployerDAO.insertEmployer(employer)) {
				employers.clear();
				employers = EmployerDAO.getAllEmployers();
			}
		}
		return null;
	}
	
	public String deleteEmployer() {
		Map<String, String> reqMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if (reqMap.containsKey("id")) {
			int z = Integer.parseInt(reqMap.get("id"));
			for (EmployerDTO e : employers) {
				if (e.getID() == z) {
					employers.remove(e);
					EmployerDAO.deleteEmployer(z);
					break;
				}
			}
		}
		return null;
	}
	
	public String updateEmployer() {
		employers.clear();
		employers = EmployerDAO.getAllEmployers();
		if (validateInput()) {
			for (int i = 0; i < employers.size(); i++) {
				if (employers.get(i).getID() == employer.getID()) {
					employer.setPassword(AdminBean.sha256(employer.getPassword()));
					if (EmployerDAO.updateEmployer(employer, employer.getID()))
						employers.set(i, employer);
					break;
				}
			}
		}
		return null;
	}

}
