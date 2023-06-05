package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.Phonebook;

public interface PhonebookService {
	public String upsert(Phonebook book);
	
	
	public Phonebook getById(Integer id);
	
	public List<Phonebook> getAllContacts();
	
	public String deleteById(Integer id);
	

}
