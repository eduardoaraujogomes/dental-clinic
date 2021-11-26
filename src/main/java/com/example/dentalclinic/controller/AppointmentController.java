package com.example.dentalclinic.controller;

import com.example.dentalclinic.persistence.entities.AppointmentEntity;
import com.example.dentalclinic.services.impl.AppointmentServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private Logger logger = Logger.getLogger(AppointmentController.class);

    @Autowired
    private AppointmentServiceImpl appointmentService;

    @PostMapping("/save")
    public ResponseEntity<AppointmentEntity> saveAppointment(@RequestBody AppointmentEntity appointment) {
        logger.info("Saving a new appointment");
        return ResponseEntity.ok(appointmentService.save(appointment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentEntity> getAppointment(@PathVariable Integer id){
        logger.info("Searching appointment by id: " + id);
        return ResponseEntity.ok(appointmentService.searchById(id));
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<AppointmentEntity>> getAllAppointments(){
        logger.info("Searching all appointments");
        return ResponseEntity.ok(appointmentService.searchAll());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Integer id){
        logger.info("Deleting appointment by id: " + id);
        appointmentService.delete(id);
        return ResponseEntity.ok("Appointment successfully deleted");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AppointmentEntity> updateAppointment(@PathVariable Integer id,@RequestBody AppointmentEntity appointment){
        logger .info("Updating  appointment by id: " + id);
        return ResponseEntity.ok(appointmentService.update(id, appointment));
    }
}
