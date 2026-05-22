package org.serratec.ong_animais.controller;

import java.util.List;

import org.serratec.ong_animais.dto.AnimalDTORequest;
import org.serratec.ong_animais.dto.AnimalDTOResponse;
import org.serratec.ong_animais.service.AnimalService;
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
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/animais")
public class AnimalController{

    @Autowired
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<AnimalDTOResponse> inserir(@Valid @RequestBody AnimalDTORequest animal){
        AnimalDTOResponse criado = animalService.inserir(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<AnimalDTOResponse>> listar(){
        return ResponseEntity.ok(animalService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTOResponse> buscar(@PathVariable Long id){
        AnimalDTOResponse animal = animalService.buscarPorId(id);

        if (animal == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(animal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalDTOResponse> atualizar(
            @Valid @RequestBody AnimalDTORequest animal,
            @PathVariable Long id) {

        AnimalDTOResponse atualizado = animalService.atualizar(id, animal);

        if (atualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        boolean removido = animalService.deletar(id);

        if (!removido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}