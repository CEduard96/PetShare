package com.creanga.petshare.petshare.controller;

import com.creanga.petshare.petshare.model.Pet;
import com.creanga.petshare.petshare.service.PetManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetManagement petManagement;

    @Autowired
    public PetController(PetManagement petManagement) {
        this.petManagement = petManagement;
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petManagement.getAllPets();
    }

    @PostMapping
    public void addPet(@RequestBody Pet pet) {
        petManagement.addPet(pet);
    }
}
