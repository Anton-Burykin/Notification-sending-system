package com.example.sender.model.Person.service;

import com.example.sender.model.ContactInfo.ContactInfo;
import com.example.sender.model.Person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <Person, Long> {

    Person findPersonById(Long id);

}
