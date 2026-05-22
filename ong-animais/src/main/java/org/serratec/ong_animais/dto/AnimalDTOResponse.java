package org.serratec.ong_animais.dto;

import java.time.LocalDate;

import org.serratec.ong_animais.domain.Animal;
import org.serratec.ong_animais.domain.Caracteristica;
import org.serratec.ong_animais.enumerated.Especie;

public class AnimalDTOResponse {
    private Long id;
    private String nome;
    private Especie especie;
    private String descricao;

    private Caracteristica caracteristica;

    private Long responsavelId;
    private String responsavelNome;

    private LocalDate dataNascimento;

    public AnimalDTOResponse() {
        super();
    }

    public AnimalDTOResponse(Animal animal) {
        this.caracteristica = animal.getCaracteristica();
        this.descricao = animal.getDescricao();
        this.especie = animal.getEspecie();
        this.id = animal.getId();
        this.nome = animal.getNome();
        this.dataNascimento = animal.getDataNascimento();
        if (animal.getResponsavel() != null) {
            this.responsavelId = animal.getResponsavel().getId();
            this.responsavelNome = animal.getResponsavel().getNome();
        }
    }
    
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Especie getEspecie() {
        return especie;
    }

    public String getDescricao() {
        return descricao;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public Long getResponsavelId() {
        return responsavelId;
    }

    public String getResponsavelNome() {
        return responsavelNome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
