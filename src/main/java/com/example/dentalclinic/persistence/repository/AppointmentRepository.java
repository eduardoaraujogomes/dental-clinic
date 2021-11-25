package com.example.dentalclinic.persistence.repository;

import com.example.dentalclinic.persistence.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {
}
