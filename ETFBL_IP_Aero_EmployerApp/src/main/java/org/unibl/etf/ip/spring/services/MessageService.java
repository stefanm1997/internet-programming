package org.unibl.etf.ip.spring.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.unibl.etf.ip.spring.entities.Message;
import org.unibl.etf.ip.spring.repositories.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	public List<Message> getAllMessages(){
		return messageRepository.findAll();
	}
	
	public Message getMessageByID(Long id) {
		return messageRepository.findById(id).get();
	}
	
	public Message addMessage(@Valid Message message) {
		return messageRepository.save(message);
	}
	
	public Message updateMessage(@Valid Message message) {
		return messageRepository.save(message);
	}
	
	public void deleteMessage(Long id) {
		messageRepository.deleteById(id);
	}
}
