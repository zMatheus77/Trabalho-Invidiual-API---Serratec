package org.serratec.ong_animais.domain;

import org.serratec.ong_animais.enumerated.Especie;

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
    private Long id;

    @Column(length = 40)
    private String nome;

    @Column
    @Enumerated(EnumType.STRING)
    private Especie especie;

    @Embedded
    private Caracteristica caracteristica;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Pessoa responsavel;

    @Column
    private String descricao;

    public Animal(Caracteristica caracteristica, String descricao, Especie especie, Long id, String nome, Pessoa responsavel) {
        this.caracteristica = caracteristica;
        this.descricao = descricao;
        this.especie = especie;
        this.id = id;
        this.nome = nome;
        this.responsavel = responsavel;
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
}
