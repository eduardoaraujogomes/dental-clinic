package com.example.dentalclinic.controller;

import com.example.dentalclinic.persistence.entities.PatientEntity;
import com.example.dentalclinic.services.impl.PatientServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private Logger logger = Logger.getLogger(PatientController.class);

    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping("/save")
    public ResponseEntity<PatientEntity> savePatient(@RequestBody PatientEntity patient) {
        logger.info("Salvando paciente: " + patient.getName());
        return ResponseEntity.ok(patientService.save(patient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientEntity> getPatient(@PathVariable Integer id){
        logger.info("Buscando paciente com id: " + id );
        return ResponseEntity.ok(patientService.searchById(id));
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<PatientEntity>> getAllPatients(){
        logger.info("Buscando todos os pacientes");
        return ResponseEntity.ok(patientService.searchAll());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Integer id){
        logger.info("Deletando paciente com id: " + id);
        patientService.delete(id);
       return ResponseEntity.ok("Paciente deletado com sucesso");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PatientEntity> updatePatient(@PathVariable Integer id, @RequestBody PatientEntity patient){
        logger.info("Atualizando paciente com id: " + id);
        return ResponseEntity.ok(patientService.update(id, patient));
    }
}
