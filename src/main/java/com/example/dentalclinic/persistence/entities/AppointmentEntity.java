package com.example.dentalclinic.persistence.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "appointments")
public class AppointmentEntity {

    @Id
    @SequenceGenerator(name = "appointment_seq", sequenceName = "appointment_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "appointment_seq")
    @Column(name="id")
    private Integer id;

    @OneToOne(fetch= FetchType.EAGER, targetEntity = PatientEntity.class)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;


    @OneToOne(fetch= FetchType.EAGER, targetEntity = DentistEntity.class)
    @JoinColumn(name = "dentist_id")
    private DentistEntity dentist;



}
