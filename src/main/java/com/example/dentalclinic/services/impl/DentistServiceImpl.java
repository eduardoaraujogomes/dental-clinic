package com.example.dentalclinic.services.impl;

import com.example.dentalclinic.persistence.entities.DentistEntity;
import com.example.dentalclinic.persistence.repository.DentistRepository;
import com.example.dentalclinic.services.DentalClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
            if(dentistEntity.getRegistrationNumber() != null)
                dentist.setRegistrationNumber(dentistEntity.getRegistrationNumber());
            if(dentistEntity.getName() != null)
                dentist.setName(dentistEntity.getName());
            if(dentistEntity.getSurname() != null)
                dentist.setSurname(dentistEntity.getSurname());
            return dentistRepository.saveAndFlush(dentist);
        }
        return null;
    }

    @Override
    public DentistEntity searchById(Integer id) {
        if(dentistRepository.findById(id).isPresent())
            return dentistRepository.findById(id).get();
        return null;
    }

    @Override
    public void delete(Integer id) {
        if(dentistRepository.findById(id).isPresent()){
            dentistRepository.deleteById(id);
        }
    }
}
