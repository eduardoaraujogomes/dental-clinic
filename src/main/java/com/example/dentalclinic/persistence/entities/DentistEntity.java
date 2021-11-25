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
    @SequenceGenerator(name = "dentist_seq", sequenceName = "dentist_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "dentist_seq")
    @Column(name="id")
    private Integer id;

    @Column(name="registration_number")
    private String registrationNumber;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    
}
