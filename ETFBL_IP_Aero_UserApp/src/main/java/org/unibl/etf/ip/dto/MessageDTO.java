package org.unibl.etf.ip.dto;

import java.io.Serializable;

public class MessageDTO implements Serializable {

	private static final long serialVersionUID = -7130886338075380481L;

	private int ID;
	private String Subject,Content,Status;
	
	public MessageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessageDTO(int iD, String subject, String content, String status) {
		super();
		ID = iD;
		Subject = subject;
		Content = content;
		Status = status;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "MessageDTO [ID=" + ID + ", Subject=" + Subject + ", Content=" + Content + ", Status=" + Status + "]";
	}
	
}
