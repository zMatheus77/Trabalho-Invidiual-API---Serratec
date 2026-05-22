package org.serratec.ong_animais.domain;

import org.serratec.ong_animais.enumerated.Porte;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Embeddable
public class Caracteristica {
    @Column
    @Enumerated(EnumType.STRING)
    private Porte porte; 

    @Column(length = 30)
    private String cor;

    @Column
    @DecimalMin(value = "0.0", message = "Peso não pode ser menor que 0")
    @DecimalMax(value = "1000.0", message = "Peso não pode ser maior que 1000")
    private Double peso;

    @Column(length = 50)
    private String raca;

    public Caracteristica() {
        super();
    }

    public Caracteristica(String cor, Double peso, Porte porte, String raca) {
        this.cor = cor;
        this.peso = peso;
        this.porte = porte;
        this.raca = raca;
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
