package com.example.dentalclinic.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "patients")
public class PatientEntity {

    @Id
    @SequenceGenerator(name = "patient_seq", sequenceName = "patient_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "patient_seq")
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @OneToOne(fetch= FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "address_id")
    private AddressEntity address;
}
