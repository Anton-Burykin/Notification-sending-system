package com.example.sender.model.Person.service.dto;


import com.example.sender.model.ContactInfo.service.dto.ContactInfoDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PersonDto {
    
    Long id;

    private String name;

    private ContactInfoDto contactInfoDto;
}
