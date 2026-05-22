package org.serratec.ong_animais.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.ong_animais.domain.Animal;
import org.serratec.ong_animais.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/animais")
public class AnimalController {
    @Autowired
    private AnimalRepository animalRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Animal inserir(@RequestBody Animal animal){
        return animalRepository.save(animal);
    }

    @GetMapping
    public ResponseEntity<List<Animal>> listar(){
        return ResponseEntity.ok(animalRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscar(@PathVariable Long id){
        Optional<Animal> animal = animalRepository.findById(id);

        if(animal.isPresent()){
            return ResponseEntity.ok(animal.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
	public ResponseEntity<Animal> atualizar(@Valid @RequestBody Animal animal,
			@PathVariable Long id) {
		
		if(!animalRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		animal.setId(id);
		animal = animalRepository.save(animal);
		return ResponseEntity.ok(animal);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Animal> remover(@PathVariable Long id) {
		if (!animalRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		animalRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
