package com.example.dentalclinic.services.impl;

import com.example.dentalclinic.persistence.entities.AddressEntity;
import com.example.dentalclinic.persistence.repository.AddressRepository;
import com.example.dentalclinic.services.DentalClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements DentalClinicService<AddressEntity> {

    @Autowired
    private AddressRepository addressRepository;



    @Override
    public AddressEntity save(AddressEntity addressEntity) {
       return addressRepository.save(addressEntity);
    }

    @Override
    public List<AddressEntity> searchAll() {
        return addressRepository.findAll();
    }

    @Override
    public AddressEntity update(Integer id, AddressEntity addressEntity) {
          if(addressRepository.findById(id).isPresent()) {
              AddressEntity address = addressRepository.findById(id).get();
              if(addressEntity.getStreet() != null)
                  address.setStreet(addressEntity.getStreet());
              if(addressEntity.getNumber() != null)
                  address.setNumber(addressEntity.getNumber());

              return addressRepository.saveAndFlush(address);
          }
          return null;
    }

    @Override
    public AddressEntity searchById(Integer id) {
        if(addressRepository.findById(id).isPresent())
            return addressRepository.findById(id).get();
        return null;
    }

    @Override
    public void delete(Integer id) {
        if (addressRepository.findById(id).isPresent()) {
            addressRepository.deleteById(id);
        }
    }
}
