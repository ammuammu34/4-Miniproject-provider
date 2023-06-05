package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.Phonebook;
import com.ashokit.service.PhonebookService;

@RestController
public class PhonebookController {
	@Autowired
	private PhonebookService service;
	@PostMapping(value = "/contact",
			consumes= {"application/json"})
	public ResponseEntity<String> createPhonebook(@RequestBody Phonebook book){
		String status = service.upsert(book);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	
	
	
	@GetMapping(value ="/contact/{id}",
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Phonebook> getBook(@PathVariable Integer id){
		Phonebook book =	service.getById(id);
		return new ResponseEntity<>(book,HttpStatus.OK);

	}
	
	
	@GetMapping(value = "/allcontact",
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Phonebook>> getAllContacts(){
		List<Phonebook> contacts = service.getAllContacts();
		return new ResponseEntity<>(contacts,HttpStatus.OK);

	}
	@PutMapping("/updatebook/{id}")
	public ResponseEntity<String> updatePhonebook(@RequestBody Phonebook book){
		String status = service.upsert(book);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	@DeleteMapping("/deletecontact/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer id){
		String status =	service.deleteById(id);
		return new ResponseEntity<>(status,HttpStatus.OK);

	}
}
