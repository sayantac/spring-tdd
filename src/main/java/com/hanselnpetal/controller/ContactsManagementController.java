package com.hanselnpetal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hanselnpetal.domain.ContactImportantOccasion;
import com.hanselnpetal.domain.CustomerContact;
import com.hanselnpetal.service.ContactsManagementService;

@RestController
public class ContactsManagementController {

	@Autowired
	private ContactsManagementService contactsManagementService;
	
	@GetMapping("/")
	public ResponseEntity<String> printHelloWorld() {		
		return new ResponseEntity<>("Hello World", HttpStatus.OK);
	}
	
	@PostMapping("/addContact")
	public ResponseEntity<String> processAddContactSubmit(@RequestBody CustomerContact aContact) {
		
		CustomerContact newContact = contactsManagementService.add(aContact);
		
		if (newContact != null) {
			return new ResponseEntity<>("success", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("failure", HttpStatus.BAD_REQUEST);
	}
	
	public String processAddContactOccasionSubmit(@ModelAttribute CustomerContact aContact, 
			@ModelAttribute ContactImportantOccasion anOccasion) {
		
		// implement this
		
		return "/addContactOccasionForm";
	}
}
