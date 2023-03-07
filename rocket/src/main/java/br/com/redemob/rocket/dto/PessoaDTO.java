package br.com.redemob.rocket.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A PessoaDTO para trabalhar na View
 */

@Data
public class PessoaDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private String nomePessoa;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    private String nomeMae;
    private UsuarioDTO usuario;
    public String toString() {
        return "Pessoa{" +
            "id=" + getId() +
            ", nomePessoa='" + getNomePessoa() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", email='" + getEmail() + "'" +
            ", dataNascimento='" + getDataNascimento() + "'" +
            ", nomeMae='" + getNomeMae() + "'" +
            "}";
    }
}
