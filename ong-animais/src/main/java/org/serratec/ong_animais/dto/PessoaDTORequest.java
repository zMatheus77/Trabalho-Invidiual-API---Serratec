package org.serratec.ong_animais.dto;

import org.serratec.ong_animais.domain.Pessoa;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PessoaDTORequest {
    @NotBlank(message = "Nome é um atributo obrigatório")
    @Size(min = 2, max = 50)
    @Pattern(
    regexp = "^[A-Za-zÀ-ÿ\\s]{2,50}$",
    message = "Nome deve conter apenas letras e espaços")
    @Schema(description = "Nome da pessoa", example = "João")
    private String nome;

    @Email(message = "O email informado é inválido")
    @NotBlank(message = "O atributo email é obrigatório")
    @Size(max = 100)
    @Schema(description = "Email da pessoa", example = "joao@gmail.com")
    private String email;

    @NotBlank(message = "O atributo telefone é obrigatório")
    @Size(max = 11)
    @Pattern(
    regexp = "^\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}$",
    message = "Telefone inválido. Ex: (21)99999-9999")
    @Schema(description = "Telefone da pessoa", example = "21999991111")
    private String telefone;

    @NotNull(message = "O atributo endereço é obrigatório")
    @Valid
    private EnderecoDTORequest endereco;

    public PessoaDTORequest() {
        super();
    }

    public PessoaDTORequest(Pessoa pessoa) {
        this.email = pessoa.getEmail();
        this.endereco = new EnderecoDTORequest(pessoa.getEndereco());
        this.nome = pessoa.getNome();
        this.telefone = pessoa.getTelefone();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EnderecoDTORequest getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTORequest endereco) {
        this.endereco = endereco;
    }
}