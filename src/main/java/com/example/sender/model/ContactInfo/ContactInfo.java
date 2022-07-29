package com.example.sender.model.ContactInfo;


import com.example.sender.model.Person.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Long number;

    @Column(nullable = false)
    private String telegramName;

}
