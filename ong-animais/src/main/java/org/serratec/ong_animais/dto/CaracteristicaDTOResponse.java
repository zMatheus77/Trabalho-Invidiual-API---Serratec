package org.serratec.ong_animais.dto;

import org.serratec.ong_animais.domain.Caracteristica;
import org.serratec.ong_animais.enumerated.Porte;

public class CaracteristicaDTOResponse {

    private Porte porte;
    private String cor;
    private Double peso;
    private String raca;

    public CaracteristicaDTOResponse() {
        super();
    }

    public CaracteristicaDTOResponse(Caracteristica caracteristica) {
        this.cor = caracteristica.getCor();
        this.peso = caracteristica.getPeso();
        this.porte = caracteristica.getPorte();
        this.raca = caracteristica.getRaca();
    }

    public Porte getPorte() {
        return porte;
    }

    public String getCor() {
        return cor;
    }

    public Double getPeso() {
        return peso;
    }

    public String getRaca() {
        return raca;
    }
}