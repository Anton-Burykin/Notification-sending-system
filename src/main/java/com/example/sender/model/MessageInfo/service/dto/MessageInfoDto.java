package com.example.sender.model.MessageInfo.service.dto;

import com.example.sender.model.MessagePattern.MessagePattern;
import com.example.sender.model.MessagePattern.service.dto.MessagePatternDto;
import com.example.sender.model.Person.Person;
import com.example.sender.model.Person.service.dto.PersonDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
@ToString
@Getter
@Setter
public class MessageInfoDto {
    private Long id;
    private MessagePatternDto pattern;
    private PersonDto person;
    private LocalDateTime date;
    private boolean status;
    private String zoneId;
}
