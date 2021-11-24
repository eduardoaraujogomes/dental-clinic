package com.example.dentalclinic.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "dentists")
public class DentistEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="id")
    private Integer id;

    @Column(name="registration_number")
    private String registrationNumber;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    
}
