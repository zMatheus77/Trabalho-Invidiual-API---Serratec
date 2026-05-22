package org.serratec.ong_animais.dto;

import java.time.LocalDate;

import org.serratec.ong_animais.domain.InteresseAdocao;

public class InteresseAdocaoDTOResponse{
    private Long id;

    private Long interessadoId;
    private String interessadoNome;

    private Long animalId;
    private String animalNome;

    private LocalDate dataInteresse;

    public InteresseAdocaoDTOResponse() {
        super();
    }

    public InteresseAdocaoDTOResponse(InteresseAdocao interesse) {

        this.id = interesse.getId();
        this.dataInteresse = interesse.getDataInteresse();

        if (interesse.getInteressado() != null) {
            this.interessadoId = interesse.getInteressado().getId();
            this.interessadoNome = interesse.getInteressado().getNome();
        }

        if (interesse.getAnimal() != null) {
            this.animalId = interesse.getAnimal().getId();
            this.animalNome = interesse.getAnimal().getNome();
        }
    }

    public Long getId() {
        return id;
    }

    public Long getInteressadoId() {
        return interessadoId;
    }

    public String getInteressadoNome() {
        return interessadoNome;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public String getAnimalNome() {
        return animalNome;
    }

    public LocalDate getDataInteresse() {
        return dataInteresse;
    }
}