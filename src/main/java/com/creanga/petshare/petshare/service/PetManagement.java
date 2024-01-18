package com.creanga.petshare.petshare.service;

import com.creanga.petshare.petshare.model.Pet;
import com.creanga.petshare.petshare.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetManagement {

    private final PetRepository petRepository;

    @Autowired
    public PetManagement(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public void addPet(Pet pet) {
        petRepository.saveAndFlush(pet);

    }

    public List<Pet> getPetsBySpecies(String species){
        return petRepository.findBySpecies(species);
    }
}