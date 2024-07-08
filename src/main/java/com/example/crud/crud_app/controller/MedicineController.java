package com.example.crud.crud_app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.crud.crud_app.model.Medicine;
import com.example.crud.crud_app.repo.MedicineRepository;
import com.example.crud.crud_app.services.CrudServices;
import java.util.List;
import java.util.Optional;

@RestController
public class MedicineController {

    @Autowired MedicineRepository medicineRepository;
    @Autowired CrudServices service;

    @GetMapping("/getAllMedicine")
    public ResponseEntity<List<Medicine>> getAllMedicines() {
       return service.getAllUsers();
    }

    @GetMapping("/getMedicinebyId/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping("/")
    public String Home(){
        return ("<h1>Welcome</h1>");
    }

    @PostMapping("/addMedicines")
    public ResponseEntity<Medicine> addMedicines(@RequestBody Medicine med) {
        return service.addMedicine(med);
    }

    @PutMapping("/updateMedicine/{id}")
    public ResponseEntity<Medicine> updateMed(@PathVariable Long id, @RequestBody Medicine med) {
        return service.updateMed(id, med);
    }

    @PatchMapping("/updateCompany/{id}")
    public ResponseEntity<Medicine> updateSingleMed(@PathVariable Long id, @RequestBody String comp) {
        return service.updateSingleMed(id, comp);
    }

    @DeleteMapping("/deleteMedById/{id}")
    public ResponseEntity<String> deleteMed(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @DeleteMapping("/deleteAllMed")
    public ResponseEntity<String> deleteAllMed() {
       return service.deleteAll();
    }
    

}