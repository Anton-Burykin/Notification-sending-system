package com.example.sender.model.Person.service.dto;


import com.example.sender.model.ContactInfo.service.dto.ContactInfoMapper;
import com.example.sender.model.Person.Person;

public class PersonMapper {
    public static PersonDto toDto(Person person){
       PersonDto pd = new PersonDto();
       pd.setId(person.getId());
       pd.setName(person.getName());
       pd.setContactInfoDto(ContactInfoMapper.toDto(person.getContactInfo()));
       return pd;
    }
    public static Person fromDto(PersonDto personDto){
        Person p = new Person();
        p.setId(personDto.getId());
        p.setName(personDto.getName());
        p.setContactInfo(ContactInfoMapper.fromDto(personDto.getContactInfoDto()));
        return p;
    }
}
