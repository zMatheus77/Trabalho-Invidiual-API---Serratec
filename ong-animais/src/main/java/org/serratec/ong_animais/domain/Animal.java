package org.serratec.ong_animais.domain;

import java.time.LocalDate;

import org.serratec.ong_animais.enumerated.Especie;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_animal")
    @Schema(description = "Identificador único do animal", example = "1")
    private Long id;

    @Column(length = 40)
    @Schema(description = "Nome do animal", example = "Thor")
    private String nome;

    @Column
    @Enumerated(EnumType.STRING)
    @Schema(description = "Espécia do animal, exemplos: CACHORRO,\r\n" + //
                "    GATO,\r\n" + //
                "    CAVALO,\r\n" + //
                "    PASSARO,\r\n" + //
                "    COELHO,\r\n" + //
                "    HAMSTER,\r\n" + //
                "    OUTRO")
    private Especie especie;

    @Embedded
    private Caracteristica caracteristica;

    @ManyToOne
    @JoinColumn(name = "responsavel_id", nullable = false)
    @JsonBackReference
    private Pessoa responsavel;

    @Column(length = 200)
    private String descricao;

    @Column
    private LocalDate dataNascimento;

    public Animal(Caracteristica caracteristica, 
            String descricao, 
            Especie especie, 
            Long id, 
            String nome, 
            Pessoa responsavel,
            LocalDate dataNascimento) {

        this.caracteristica = caracteristica;
        this.descricao = descricao;
        this.especie = especie;
        this.id = id;
        this.nome = nome;
        this.responsavel = responsavel;
        this.dataNascimento = dataNascimento;
    }

    public Animal() {
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

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
