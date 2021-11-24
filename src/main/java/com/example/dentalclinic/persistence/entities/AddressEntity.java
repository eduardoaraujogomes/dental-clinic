package com.example.dentalclinic.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "addresses")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="id")
    private Integer id;

    @Column(name="street")
    private String street;

    @Column(name="number")
    private String number;


}
