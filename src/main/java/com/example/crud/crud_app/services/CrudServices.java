package com.example.crud.crud_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.crud.crud_app.model.Medicine;
import com.example.crud.crud_app.repo.MedicineRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CrudServices {
    @Autowired private MedicineRepository medRepo;

    public ResponseEntity<List<Medicine>> getAllUsers(){
        try {
            List<Medicine> medicineList = new ArrayList<>();
            medRepo.findAll().forEach(medicineList::add);
            
            if (medicineList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(medicineList, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Medicine> getUserById(Long id){
        try {
           Optional<Medicine> med = medRepo.findById(id);

            if (med.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(med.get(), HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Medicine> addMedicine(Medicine med){
        try {
            Medicine objmed =  medRepo.save(med);
            return new ResponseEntity<>(objmed, HttpStatus.OK);
          } catch(Exception ex) {
              return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }

    public ResponseEntity<Medicine> updateMed(Long id, Medicine med){
        try {
            Optional<Medicine> medData = medRepo.findById(id);
            if (medData.isPresent()) {
                Medicine updatedData = medData.get();
                updatedData.setTitle(med.getTitle());
                Medicine medObj = medRepo.save(updatedData);
                return new ResponseEntity<>(medObj, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Medicine> updateSingleMed(Long id, String comp){
        try {
            Optional<Medicine> medData = medRepo.findById(id);
            if (medData.isPresent()) {
                Medicine updatedData = medData.get();               
                updatedData.setCompany(comp);
                medRepo.save(updatedData);

                return new ResponseEntity<>(updatedData, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteAll(){
        try {
            medRepo.deleteAll();
            return new ResponseEntity<>("Deleted All" ,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteById(Long id){
        try {
            medRepo.deleteById(id);
            return new ResponseEntity<>("Deleted with id " + id.toString() ,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
