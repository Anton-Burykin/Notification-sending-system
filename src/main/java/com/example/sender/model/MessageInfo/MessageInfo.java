package com.example.sender.model.MessageInfo;

import com.example.sender.model.MessagePattern.MessagePattern;
import com.example.sender.model.Person.Person;
import com.example.sender.model.Person.service.dto.PersonDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MessageInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pattern_id")
    private MessagePattern pattern;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @Column(nullable = false)
    private Long date;
    @Column(nullable = false)
    private boolean status = false;
    @JoinColumn(name = "zone_id")
    @Column(nullable = false)
    private String zoneId;

}
