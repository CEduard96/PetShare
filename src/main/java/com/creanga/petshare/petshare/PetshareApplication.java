package com.creanga.petshare.petshare;

import com.creanga.petshare.petshare.model.Pet;
import com.creanga.petshare.petshare.repository.PetRepository;
import com.creanga.petshare.petshare.service.PetManagement;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class PetshareApplication implements CommandLineRunner {



	@Autowired
	private PetRepository petRepository;

	@Autowired
	private PetManagement petManagement;

	public static void main(String[] args) {
		SpringApplication.run(PetshareApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(petRepository.findById(1).get());


		Pet newPet = new Pet("Blondaneata", "Bee", 1, "Loves to fly", 0.1);
		 petRepository.saveAndFlush(newPet);

		 Optional<Pet> optionalPetWithId1 = petRepository.findById(1);

		 Pet petWithId1 = optionalPetWithId1.orElse(null);

		 petWithId1.setSpecies("Tiger");

		 petRepository.saveAndFlush(petWithId1);


		Set<Pet> setOfPetsToBeDeleted = Set.of(petWithId1, petRepository.findById(5).orElse(null));

		petRepository.deleteAll(setOfPetsToBeDeleted);
		petRepository.flush();


		System.out.println(petManagement.getPetsBySpecies("DOG"));


	}
}