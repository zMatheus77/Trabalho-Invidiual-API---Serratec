package org.serratec.ong_animais.dto;

import java.util.List;

import org.serratec.ong_animais.domain.Pessoa;

public class PessoaDTOResponse {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private List<InteresseAdocaoDTOResponse> interesses;

    public PessoaDTOResponse() {
        super();
    }

    public PessoaDTOResponse(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.email = pessoa.getEmail();
        this.telefone = pessoa.getTelefone();
        if (pessoa.getInteresses() != null) {
            this.interesses = pessoa.getInteresses()
                    .stream()
                    .map(InteresseAdocaoDTOResponse::new)
                    .toList();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<InteresseAdocaoDTOResponse> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<InteresseAdocaoDTOResponse> interesses) {
        this.interesses = interesses;
    }
}