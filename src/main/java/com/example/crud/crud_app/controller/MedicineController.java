package com.example.crud.crud_app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.crud.crud_app.model.Medicine;
import com.example.crud.crud_app.repo.MedicineRepository;
import com.example.crud.crud_app.services.CrudServices;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MedicineController {

    @Autowired MedicineRepository medicineRepository;
    @Autowired CrudServices service;

    @GetMapping("/getAllMedicine")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MODERATOR', 'ROLE_ADMIN')")
    public ResponseEntity<List<Medicine>> getAllMedicines() {
       return service.getAllUsers();
    }

    @GetMapping("/")
    public String Home(){
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/getMedicinebyId/{id}")
    @PreAuthorize("hasRole(‘ROLE_ADMIN’)")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
        return service.getUserById(id);
    }


    @PostMapping("/addMedicines")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Medicine> addMedicines(@RequestBody Medicine med) {
        return service.addMedicine(med);
    }

    @PutMapping("/updateMedicine/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Medicine> updateMed(@PathVariable Long id, @RequestBody Medicine med) {
        return service.updateMed(id, med);
    }

    @PatchMapping("/updateCompany/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Medicine> updateSingleMed(@PathVariable Long id, @RequestBody String comp) {
        return service.updateSingleMed(id, comp);
    }

    @DeleteMapping("/deleteMedById/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteMed(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @DeleteMapping("/deleteAllMed")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteAllMed() {
       return service.deleteAll();
    }
    

}