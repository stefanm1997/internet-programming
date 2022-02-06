package org.unibl.etf.ip.beans;

import java.io.Serializable;

import org.unibl.etf.ip.dao.MessageDAO;
import org.unibl.etf.ip.dto.MessageDTO;

public class MessageBean implements Serializable {

	private static final long serialVersionUID = -1992377316752776823L;

	public MessageBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String addMessage(MessageDTO message) {
		if (message != null && !"".equals(message.getContent()) && !"".equals(message.getStatus())
				&& !"".equals(message.getSubject())) {
			if (MessageDAO.insertMessage(message)) {
				return "Added";
			} else {
				return "Error in insert";
			}

		} else
			return "Error";

		// return null;
	}
}
