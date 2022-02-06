package org.unibl.etf.ip.spring.contorllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.spring.entities.Message;
import org.unibl.etf.ip.spring.services.MessageService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/message")
public class MessageController {

	@Autowired
	private MessageService service;

	@GetMapping
	public ResponseEntity<List<Message>> getAllMessages() {
		List<Message> messages = service.getAllMessages();
		if(!messages.isEmpty())
			return ResponseEntity.ok(messages);
		else
			return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getMessageById(@PathVariable Long id) {

//		Message message = service.getMessageByID(id);
//		if(message != null) {
//			return new ResponseEntity<Message>(message,HttpStatus.OK);
//		}
//		return ResponseEntity.notFound().build();
		// return ResponseEntity.notFound().build();
		// throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find
		// resource");
		try {
			Message message = service.getMessageByID(id);
			return new ResponseEntity<Message>(message, HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body("Unable to find message with id: "+id);
			//return new ResponseEntity<Message>("Unable to find message with id: ",HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> addMessage(@RequestBody Message message) {	
		try {
			if(message == null || message.getContent()==null || message.getStatus()==null || message.getSubject()==null) {
				return ResponseEntity.badRequest().body("Unable to create message!");
			}
			Message mess = service.addMessage(message);
			return new ResponseEntity<Message>(mess, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Unable to find message in body request!");
			//return new ResponseEntity<Message>(HttpStatus.BAD_REQUEST);
		}
//		if (mess != null) {
//			return new ResponseEntity<Message>(mess, HttpStatus.CREATED);
//		}
//		// return ResponseEntity.status(400).build();
//		return new ResponseEntity<Message>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateMessage(@RequestBody Message message, @PathVariable Long id) {
		try {
			if(message == null || message.getContent()==null || message.getStatus()==null || message.getSubject()==null) {
				return ResponseEntity.badRequest().body("Unable to update message!");
			}
			service.getMessageByID(id);
			message.setID(id);
			service.updateMessage(message);
			return new ResponseEntity<Message>(message, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body("Unable to find message with id: "+id);
			//return new ResponseEntity<Message>(HttpStatus.BAD_REQUEST);
		}
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMessage(@PathVariable Long id){
		try {
			service.deleteMessage(id);
			return new ResponseEntity<Message>(HttpStatus.OK);
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.badRequest().body("Unable to delete message with id: "+id);
			//return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
		}
	}
}
