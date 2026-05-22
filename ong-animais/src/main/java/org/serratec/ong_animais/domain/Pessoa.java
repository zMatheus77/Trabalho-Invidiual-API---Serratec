package org.serratec.ong_animais.domain;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    @Schema(description = "Identificador único da pessoa", example = "1")
    private Long id;

    @Column
    private String nome;

    @Column(unique = true)
    private String email;

    @Column 
    private String telefone;

    @Embedded
    private Endereco endereco;
    
    @OneToMany(mappedBy = "interessado",
           cascade = CascadeType.ALL,
           orphanRemoval = true, fetch = FetchType.LAZY)
    private List<InteresseAdocao> interesses;

    public Pessoa(String email, Endereco endereco, Long id, List<InteresseAdocao> interesses, String nome, String telefone) {
        this.email = email;
        this.endereco = endereco;
        this.id = id;
        this.interesses = interesses;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Pessoa() {
        super();
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<InteresseAdocao> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<InteresseAdocao> interesses) {
        this.interesses = interesses;
    }
}
