package org.serratec.ong_animais.service;

import java.util.List;

import org.serratec.ong_animais.domain.Endereco;
import org.serratec.ong_animais.domain.Pessoa;
import org.serratec.ong_animais.dto.PessoaDTORequest;
import org.serratec.ong_animais.dto.PessoaDTOResponse;
import org.serratec.ong_animais.exceptions.DuplicateEntryException;
import org.serratec.ong_animais.exceptions.ResourceNotFoundException;
import org.serratec.ong_animais.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDTOResponse inserir(PessoaDTORequest pessoaDto) {
        if (pessoaRepository.existsByEmail(pessoaDto.getEmail())) {
            throw new DuplicateEntryException("Já existe uma pessoa cadastrada com esse email");
        }

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDto.getNome());
        pessoa.setEmail(pessoaDto.getEmail());
        pessoa.setTelefone(pessoaDto.getTelefone());

        Endereco endereco = new Endereco();
        endereco.setNomeRua(pessoaDto.getEndereco().getNomeRua());
        endereco.setCidade(pessoaDto.getEndereco().getCidade());
        endereco.setEstado(pessoaDto.getEndereco().getEstado());
        endereco.setBairro(pessoaDto.getEndereco().getBairro());
        endereco.setNumero(pessoaDto.getEndereco().getNumero());

        pessoa.setEndereco(endereco);

        Pessoa salva = pessoaRepository.save(pessoa);

        return new PessoaDTOResponse(salva);
    }

    public List<PessoaDTOResponse> listar() {
        return pessoaRepository.findAll()
                .stream()
                .map(PessoaDTOResponse::new)
                .toList();
    }

    public PessoaDTOResponse buscarPorId(Long id) {
        return pessoaRepository.findById(id)
                .map(PessoaDTOResponse::new)
                .orElseThrow(() ->
                new ResourceNotFoundException("Responsável não encontrado"));
    }

    public PessoaDTOResponse atualizar(Long id, PessoaDTORequest pessoaDto) {
        if (pessoaRepository.existsByEmail(pessoaDto.getEmail())) {
            throw new DuplicateEntryException("Já existe uma pessoa cadastrada com esse email");
        }

        return pessoaRepository.findById(id)
                .map(pessoa -> {

                    pessoa.setNome(pessoaDto.getNome());
                    pessoa.setEmail(pessoaDto.getEmail());
                    pessoa.setTelefone(pessoaDto.getTelefone());

                    Endereco endereco = new Endereco();
                    endereco.setNomeRua(pessoaDto.getEndereco().getNomeRua());
                    endereco.setCidade(pessoaDto.getEndereco().getCidade());
                    endereco.setEstado(pessoaDto.getEndereco().getEstado());
                    endereco.setBairro(pessoaDto.getEndereco().getBairro());
                    endereco.setNumero(pessoaDto.getEndereco().getNumero());

                    pessoa.setEndereco(endereco);

                    return new PessoaDTOResponse(pessoaRepository.save(pessoa));
                })
                .orElseThrow(() ->
                new ResourceNotFoundException("Responsável não encontrado"));
    }

    public boolean deletar(Long id) {
        if (!pessoaRepository.existsById(id)) {
            return false;
        }

        pessoaRepository.deleteById(id);
        return true;
    }
}