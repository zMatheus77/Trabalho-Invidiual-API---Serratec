package org.serratec.ong_animais.dto;

import org.serratec.ong_animais.domain.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class EnderecoDTORequest {
    @NotBlank(message = "Nome da rua é obrigatório")
    @Size(min = 2, max = 100)
    private String nomeRua;

    @NotBlank(message = "Cidade é obrigatória")
    @Size(min = 2, max = 50)
    private String cidade;

    @NotNull(message = "Número é obrigatório")
    @Positive
    private Integer numero;

    @NotBlank(message = "Estado é obrigatório")
    @Pattern(
        regexp = "^[A-Z]{2}$",
        message = "Estado deve conter 2 letras maiúsculas (ex: RJ, SP)"
    )
    private String estado;

    @NotBlank(message = "Bairro é obrigatório")
    @Size(min = 2, max = 50)
    private String bairro;

    public EnderecoDTORequest() {}

    public EnderecoDTORequest(Endereco endereco) {
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
        this.nomeRua = endereco.getNomeRua();
        this.numero = endereco.getNumero();
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