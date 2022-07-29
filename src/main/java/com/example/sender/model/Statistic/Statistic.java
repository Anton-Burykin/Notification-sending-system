package com.example.sender.model.Statistic;

import com.example.sender.model.Person.Person;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(nullable = false)
    private String message;

    @Column
    private boolean email = false;

    @Column
    private boolean telegram = false;

    @Column(nullable = false)
    private Long number;

    @Column(nullable = false)
    private Long date;

}
