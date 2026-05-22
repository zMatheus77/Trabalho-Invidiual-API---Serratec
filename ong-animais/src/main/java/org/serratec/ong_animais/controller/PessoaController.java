package org.serratec.ong_animais.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.ong_animais.domain.Pessoa;
import org.serratec.ong_animais.repository.PessoaRepository;
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
    private PessoaRepository pessoaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Pessoa inserir(@RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar(){
        return ResponseEntity.ok(pessoaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscar(@PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        if(pessoa.isPresent()){
            return ResponseEntity.ok(pessoa.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@Valid @RequestBody Pessoa pessoa,
			@PathVariable Long id) {
		
		if(!pessoaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		pessoa.setId(id);
		pessoa = pessoaRepository.save(pessoa);
		return ResponseEntity.ok(pessoa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Pessoa> remover(@PathVariable Long id) {
		if (!pessoaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		pessoaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
