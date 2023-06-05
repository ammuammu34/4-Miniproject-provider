package com.ashokit.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.Phonebook;

public interface PhonebookRepository extends JpaRepository<Phonebook, Integer>{
	


}
