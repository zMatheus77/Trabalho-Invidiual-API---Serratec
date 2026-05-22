package org.serratec.ong_animais.controller;

import java.util.List;

import org.serratec.ong_animais.dto.PessoaDTORequest;
import org.serratec.ong_animais.dto.PessoaDTOResponse;
import org.serratec.ong_animais.service.PessoaService;
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
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaDTOResponse inserir(@Valid @RequestBody PessoaDTORequest pessoa) {
        return pessoaService.inserir(pessoa);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTOResponse>> listar() {
        return ResponseEntity.ok(pessoaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTOResponse> buscar(@PathVariable Long id) {

        PessoaDTOResponse pessoa = pessoaService.buscarPorId(id);

        if (pessoa == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTOResponse> atualizar(
            @Valid @RequestBody PessoaDTORequest pessoa,
            @PathVariable Long id) {

        PessoaDTOResponse pessoaAtualizada = pessoaService.atualizar(id, pessoa);

        if (pessoaAtualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pessoaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {

        boolean removido = pessoaService.deletar(id);

        if (!removido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}