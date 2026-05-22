package org.serratec.ong_animais.dto;

import java.time.LocalDate;

import org.serratec.ong_animais.domain.Animal;
import org.serratec.ong_animais.enumerated.Especie;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AnimalDTORequest{
    @NotBlank(message = "O nome do animal é obrigatório")
    @Size(min = 2, max = 50)
    @Pattern(
    regexp = "^[A-Za-zÀ-ÿ\\s]{2,50}$",
    message = "Nome deve conter apenas letras e espaços")
    @Schema(description = "Nome do animal", example = "Thor")
    private String nome;

    @NotNull(message = "A espécie do animal é obrigatória")
    @Schema(description = "Espécia do animal, exemplos: CACHORRO,\r\n" + //
                "    GATO,\r\n" + //
                "    CAVALO,\r\n" + //
                "    PASSARO,\r\n" + //
                "    COELHO,\r\n" + //
                "    HAMSTER,\r\n" + //
                "    OUTRO")
    private Especie especie;

    @NotBlank(message = "A descrição do animal é obrigatória")
    @Size(min = 2, max = 200)
    @Schema(description = "Descricao do animal", example = "Cachorro muito dócil que gosta de brincar")
    private String descricao;

    private CaracteristicaDTORequest caracteristica;

    @Past
    @Schema(description = "Data de nascimento do animal", example = "2020-01-01")
    private LocalDate dataNascimento;

    @NotNull(message = "O id do responsável não pode ser nulo")
    @Schema(description = "Identificador único do responsável do animal", example = "1")
    private Long responsavelId;

    public AnimalDTORequest() {
        super();
    }

    public AnimalDTORequest(Animal animal) {
        this.caracteristica = new CaracteristicaDTORequest(animal.getCaracteristica());
        this.descricao = animal.getDescricao();
        this.especie = animal.getEspecie();
        this.nome = animal.getNome();
        this.dataNascimento = animal.getDataNascimento();
        if (animal.getResponsavel() != null) {
            this.responsavelId = animal.getResponsavel().getId();
        }
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CaracteristicaDTORequest getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(CaracteristicaDTORequest caracteristica) {
        this.caracteristica = caracteristica;
    }

    public Long getResponsavelId() {
        return responsavelId;
    }

    public void setResponsavelId(Long responsavelId) {
        this.responsavelId = responsavelId;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
