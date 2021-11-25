package com.example.dentalclinic.services.impl;

import com.example.dentalclinic.persistence.entities.AppointmentEntity;
import com.example.dentalclinic.persistence.repository.AppointmentRepository;
import com.example.dentalclinic.services.DentalClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements DentalClinicService<AppointmentEntity> {


    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private DentistServiceImpl dentistService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public AppointmentEntity save(AppointmentEntity appointmentEntity) {
        patientService.save(appointmentEntity.getPatient());
        dentistService.save(appointmentEntity.getDentist());
        return appointmentRepository.save(appointmentEntity);
    }

    @Override
    public List<AppointmentEntity> searchAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public AppointmentEntity update(Integer id, AppointmentEntity appointmentEntity){
        if(appointmentRepository.findById(id).isPresent()) {
            AppointmentEntity appointment = appointmentRepository.findById(id).get();
            if(appointmentEntity.getPatient() != null)
                appointment.setPatient(appointmentEntity.getPatient());
            if(appointmentEntity.getDentist() != null)
                appointment.setDentist(appointmentEntity.getDentist());
            return appointmentRepository.save(appointment);
        }
        return null;
    }

    @Override
    public AppointmentEntity searchById(Integer id) {
        if(appointmentRepository.findById(id).isPresent())
            return appointmentRepository.findById(id).get();
        return null;
    }

    @Override
    public void delete(Integer id) {
          if (appointmentRepository.findById(id).isPresent())
             appointmentRepository.deleteById(id);
    }
}
