package org.serratec.ong_animais.dto;

import org.serratec.ong_animais.domain.Caracteristica;
import org.serratec.ong_animais.enumerated.Porte;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CaracteristicaDTORequest {

    @NotNull(message = "O porte é obrigatório")
    private Porte porte;

    @NotBlank(message = "A cor é obrigatória")
    @Size(min = 2, max = 30)
    private String cor;

    @NotNull(message = "O peso é obrigatório")
    @DecimalMin(value = "0.0", message = "Peso não pode ser menor que 0")
    @DecimalMax(value = "1000.0", message = "Peso não pode ser maior que 1000")
    private Double peso;

    @NotBlank(message = "A raça é obrigatória")
    @Size(min = 2, max = 50)
    private String raca;

    public CaracteristicaDTORequest() {
        super();
    }

    public CaracteristicaDTORequest(Caracteristica caracteristica) {
        this.cor = caracteristica.getCor();
        this.peso = caracteristica.getPeso();
        this.porte = caracteristica.getPorte();
        this.raca = caracteristica.getRaca();
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}