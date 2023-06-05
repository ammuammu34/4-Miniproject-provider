package com.ashokit.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Phonebook;
import com.ashokit.repo.PhonebookRepository;
import com.ashokit.service.PhonebookService;
@Service
public class PhonebookServiceImpl implements PhonebookService {

	@Autowired
	private PhonebookRepository repo;
	@Override
	public String upsert(Phonebook book) {
		repo.save(book);

		return "success";
	}

	@Override
	public Phonebook getById(Integer id) {
		Optional<Phonebook> findById=repo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Phonebook> getAllContacts() {
		return repo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "delete Success";
		}else {
			return "no records found";
		}
	}

}