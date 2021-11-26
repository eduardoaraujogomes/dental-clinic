package com.example.dentalclinic.controller;

import com.example.dentalclinic.persistence.entities.AppointmentEntity;
import com.example.dentalclinic.services.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentServiceImpl appointmentService;

    @PostMapping("/save")
    public ResponseEntity<AppointmentEntity> saveAppointment(@RequestBody AppointmentEntity appointment) {
        return ResponseEntity.ok(appointmentService.save(appointment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentEntity> getAppointment(@PathVariable Integer id){
        return ResponseEntity.ok(appointmentService.searchById(id));
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<AppointmentEntity>> getAllAppointments(){
        return ResponseEntity.ok(appointmentService.searchAll());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Integer id){
        appointmentService.delete(id);
        return ResponseEntity.ok("Appointment deletado com sucesso");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AppointmentEntity> updateAppointment(@PathVariable Integer id,@RequestBody AppointmentEntity appointment){
        return ResponseEntity.ok(appointmentService.update(id, appointment));
    }
}
