package com.example.sender.model.Person;

import com.example.sender.model.ContactInfo.ContactInfo;
import com.example.sender.model.MessageInfo.MessageInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "contact_info_id")
    private ContactInfo contactInfo;
}
