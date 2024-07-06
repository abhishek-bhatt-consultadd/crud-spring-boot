package com.example.crud.crud_app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.crud.crud_app.model.Medicine;
import com.example.crud.crud_app.repo.MedicineRepository;
import com.example.crud.crud_app.util.Patcher;
import com.github.fge.jsonpatch.JsonPatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MedicineController {

    @Autowired
    MedicineRepository medicineRepository;

    @Autowired
    Patcher patcher;

    @GetMapping("/getAllMedicines")
    public ResponseEntity<List<Medicine>> getAllMedicines() {
        try {
            List<Medicine> medicineList = new ArrayList<>();
            medicineRepository.findAll().forEach(medicineList::add);

            if (medicineList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(medicineList, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getMedicinebyId/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
        try {
           Optional<Medicine> med = medicineRepository.findById(id);

            if (med.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(med.get(), HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addMedicines")
    public ResponseEntity<Medicine> addMedicines(@RequestBody Medicine med) {
        try {
          Medicine objmed =  medicineRepository.save(med);
          return new ResponseEntity<>(objmed, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateMedicine/{id}")
    public ResponseEntity<Medicine> updateMed(@PathVariable Long id, @RequestBody Medicine med) {
        try {
            Optional<Medicine> medData = medicineRepository.findById(id);
            if (medData.isPresent()) {
                Medicine updatedData = medData.get();
                updatedData.setTitle(med.getTitle());
                Medicine medObj = medicineRepository.save(updatedData);
                return new ResponseEntity<>(medObj, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @PatchMapping("/updateSingleMedicine/{id}")
    // public ResponseEntity<Medicine> updateSingleMed(@PathVariable Long id, @RequestBody JsonPatch patch) {
    //     try {
    //         Optional<Medicine> medData = medicineRepository.findById(id);
    //         if (medData.isPresent()) {
    //             Medicine updatedData = medData.get();
                
    //             Patcher.internPatcher(updatedData, patch);
    //             medicineRepository.save(updatedData);

    //             return new ResponseEntity<>(updatedData, HttpStatus.CREATED);
    //         }

    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }


    @DeleteMapping("/deleteMedById/{id}")
    public ResponseEntity<String> deleteMed(@PathVariable Long id) {
        try {
            medicineRepository.deleteById(id);
            return new ResponseEntity<>("Deleted with id" + id.toString() ,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteAllMed")
    public ResponseEntity<String> deleteAllMed() {
        try {
            medicineRepository.deleteAll();
            return new ResponseEntity<>("Deleted All" ,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

}