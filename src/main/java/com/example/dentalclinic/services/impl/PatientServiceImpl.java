package com.example.dentalclinic.services.impl;

import com.example.dentalclinic.persistence.entities.PatientEntity;
import com.example.dentalclinic.persistence.repository.PatientRepository;
import com.example.dentalclinic.services.DentalClinicService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientServiceImpl implements DentalClinicService<PatientEntity> {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AddressServiceImpl addressService;


    @Override
    public PatientEntity save(PatientEntity patientEntity) {
        addressService.save(patientEntity.getAddress());
        return patientRepository.save(patientEntity);
    }

    @Override
    public List<PatientEntity> searchAll() {
        return patientRepository.findAll();
    }

    @Override
    public PatientEntity update(Integer id, PatientEntity patientEntity) {
        if (patientRepository.findById(id).isPresent()) {
            PatientEntity patient = patientRepository.findById(id).get();
            patient.setName(patientEntity.getName());
            patient.setSurname(patientEntity.getSurname());
            if (patientEntity.getAddress() != null) {
                addressService.update(patientEntity.getAddress().getId(), patientEntity.getAddress());
            }
            return patientRepository.saveAndFlush(patient);
        }
        return null;
    }

    @Override
    public PatientEntity searchById(Integer id) {
        if (patientRepository.existsById(id)) {
            return patientRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
        }

    }
}
