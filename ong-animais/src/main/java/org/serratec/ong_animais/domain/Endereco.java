package org.serratec.ong_animais.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    @Column
    private String nomeRua;

    @Column
    private String cidade;

    @Column
    private Integer numero;

    @Column
    private String estado;

    @Column
    private String bairro;

    public Endereco(String bairro, String cidade, String estado, String nomeRua, Integer numero) {
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.nomeRua = nomeRua;
        this.numero = numero;
    }

    public Endereco() {
        super();
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
