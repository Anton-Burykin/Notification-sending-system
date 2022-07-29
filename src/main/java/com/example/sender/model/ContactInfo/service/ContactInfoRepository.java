package com.example.sender.model.ContactInfo.service;

import com.example.sender.model.ContactInfo.ContactInfo;
import com.example.sender.model.Person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInfoRepository extends JpaRepository <ContactInfo,Long> {

    ContactInfo findContactInfoById (Long id);
}
