package com.example.sender.model.Person.service;

import com.example.sender.model.ContactInfo.service.ContactInfoService;
import com.example.sender.model.Person.Person;
import com.example.sender.model.Person.service.dto.PersonDto;
import com.example.sender.model.Person.service.dto.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ContactInfoService contactInfoService;

    public PersonDto add(PersonDto body) {
        body.setContactInfoDto(contactInfoService.getById(body.getContactInfoDto().getId()));
        return PersonMapper.toDto(personRepository.save(PersonMapper.fromDto(body)));
    }


    public PersonDto update(PersonDto body, Long id) {

        PersonDto pD = PersonMapper.toDto(personRepository.findById(id).orElse(null));
        if (pD.equals(null)) {return null;}
        pD.setName(body.getName());
        pD.setContactInfoDto(body.getContactInfoDto());
        return add(pD);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }


    public List<PersonDto> getAll() {

        List<Person> all = personRepository.findAll();
        return all.stream()
                .map(person -> {
                    PersonDto personDto = new PersonDto();
                    personDto.setName(person.getName());
                    return personDto;
                })
                .collect(Collectors.toList());
    }

    public PersonDto getById(Long id) {
        return PersonMapper.toDto(personRepository.findById(id).orElse(null));
    }
}
