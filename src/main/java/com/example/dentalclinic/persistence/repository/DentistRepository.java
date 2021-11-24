package com.example.dentalclinic.persistence.repository;

import com.example.dentalclinic.persistence.entities.DentistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<DentistEntity, Integer> {
}
