package com.example.dentalclinic.services.impl;

import com.example.dentalclinic.persistence.entities.DentistEntity;
import com.example.dentalclinic.persistence.repository.DentistRepository;
import com.example.dentalclinic.services.DentalClinicService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DentistServiceImpl implements DentalClinicService<DentistEntity> {

    @Autowired
    private DentistRepository dentistRepository;


    @Override
    public DentistEntity save(DentistEntity dentistEntity) {
        return dentistRepository.save(dentistEntity);
    }

    @Override
    public List<DentistEntity> searchAll() {
        return dentistRepository.findAll();
    }

    @Override
    public DentistEntity update(Integer id, DentistEntity dentistEntity) {
        if(dentistRepository.findById(id).isPresent()){
            DentistEntity dentist = dentistRepository.findById(id).get();
            dentist.setName(dentistEntity.getName());
            dentist.setSurname(dentistEntity.getSurname());
            dentist.setRegistrationNumber(dentistEntity.getRegistrationNumber());
        }
        return null;
    }

    @Override
    public DentistEntity searchById(Integer id) {
        if(dentistRepository.findById(id).isPresent()){
            return dentistRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        if(dentistRepository.findById(id).isPresent()){
            dentistRepository.deleteById(id);
        }
    }
}
