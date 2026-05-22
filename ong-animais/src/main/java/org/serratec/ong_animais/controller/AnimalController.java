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

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/animais")
public class AnimalController{

    @Autowired
    private AnimalService animalService;

    @Operation(summary = "Cadastrar um animal")
    @PostMapping
    public ResponseEntity<AnimalDTOResponse> inserir(@Valid @RequestBody AnimalDTORequest animal){
        AnimalDTOResponse criado = animalService.inserir(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @Operation(summary = "Listar animais", description = "Retorna todos os animais cadastrados")
    @GetMapping
    public ResponseEntity<List<AnimalDTOResponse>> listar(){
        return ResponseEntity.ok(animalService.listar());
    }

    @Operation(summary = "Buscar animal por ID", description = "Retorna um animal específico pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTOResponse> buscar(@PathVariable Long id){
        AnimalDTOResponse animal = animalService.buscarPorId(id);

        if (animal == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(animal);
    }

    @Operation(summary = "Atualizar animal", description = "Atualiza os dados de um animal existente")
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

    @Operation(summary = "Remover animal", description = "Remove um animal pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        boolean removido = animalService.deletar(id);

        if (!removido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}