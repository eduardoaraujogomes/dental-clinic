package com.example.dentalclinic.controller;

import com.example.dentalclinic.persistence.entities.DentistEntity;
import com.example.dentalclinic.services.impl.DentistServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    private Logger logger = Logger.getLogger(DentistController.class);

    @Autowired
    private DentistServiceImpl dentistService;

    @PostMapping("/save")
    public ResponseEntity<DentistEntity> saveDentist(@RequestBody DentistEntity dentist) {
        logger.info("Salvando dentista: " + dentist.getName());
        return ResponseEntity.ok(dentistService.save(dentist));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistEntity> getDentist(@PathVariable Integer id){
        logger.info("Buscando dentista: " + id);
        return ResponseEntity.ok(dentistService.searchById(id));
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<DentistEntity>> getAllDentists(){
        logger.info("Buscando todos os dentistas");
        return ResponseEntity.ok(dentistService.searchAll());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDentist(@PathVariable Integer id){
        logger.info("Deletando dentista: " + id);
        dentistService.delete(id);
        return ResponseEntity.ok("Dentist deletado com sucesso");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DentistEntity> updateDentist(@PathVariable Integer id, @RequestBody DentistEntity dentist){
        logger.info("Atualizando dentista: " + id);
        return ResponseEntity.ok(dentistService.update(id, dentist));
    }
}
