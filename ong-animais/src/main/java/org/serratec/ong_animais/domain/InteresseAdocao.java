package org.serratec.ong_animais.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class InteresseAdocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_InteresseAdocao")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa interessado;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    private LocalDate dataInteresse;

    public InteresseAdocao(Animal animal, LocalDate dataInteresse, Long id, Pessoa interessado) {
        this.animal = animal;
        this.dataInteresse = dataInteresse;
        this.id = id;
        this.interessado = interessado;
    }

    public InteresseAdocao() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getInteressado() {
        return interessado;
    }

    public void setInteressado(Pessoa interessado) {
        this.interessado = interessado;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public LocalDate getDataInteresse() {
        return dataInteresse;
    }

    public void setDataInteresse(LocalDate dataInteresse) {
        this.dataInteresse = dataInteresse;
    }
}
