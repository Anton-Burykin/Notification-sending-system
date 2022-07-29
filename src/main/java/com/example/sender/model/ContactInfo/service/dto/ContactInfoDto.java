package com.example.sender.model.ContactInfo.service.dto;

import com.example.sender.model.Person.Person;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ContactInfoDto {

    private Long id;

    private String email;

    private Long number;

    private String telegramName;
}
