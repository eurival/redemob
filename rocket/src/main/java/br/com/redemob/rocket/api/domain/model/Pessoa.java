package br.com.redemob.rocket.api.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A Pessoa.
 */
@Entity
@Table(name = "pessoa")
@Data
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @SequenceGenerator(name = "PESSOA_ID_GENERATOR", sequenceName="PESSOA_ID_SEQ", allocationSize=1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_ID_GENERATOR")
 
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "nome_pessoa", length = 100, nullable = false)
    private String nomePessoa;

    @NotNull
    @Size(max = 14)
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Lob
    @Column(name = "foto")
    private byte[] foto;

    @Column(name = "foto_content_type")
    private String fotoContentType;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Size(max = 60)
    @Column(name = "nome_mae", length = 60)
    private String nomeMae;

    @OneToMany(mappedBy = "pessoa")
    @JsonIgnoreProperties
    private Set<Inscricao> inscricoes = new HashSet<>();

    public Set<Inscricao> getInscricoes() {
        return this.inscricoes;
    }

    public void setInscricoes(Set<Inscricao> inscricaos) {
        if (this.inscricoes != null) {
            this.inscricoes.forEach(i -> i.setPessoa(null));
        }
        if (inscricaos != null) {
            inscricaos.forEach(i -> i.setPessoa(this));
        }
        this.inscricoes = inscricaos;
    }

    public Pessoa inscricoes(Set<Inscricao> inscricaos) {
        this.setInscricoes(inscricaos);
        return this;
    }

    public Pessoa addInscricoes(Inscricao inscricao) {
        this.inscricoes.add(inscricao);
        inscricao.setPessoa(this);
        return this;
    }

    public Pessoa removeInscricoes(Inscricao inscricao) {
        this.inscricoes.remove(inscricao);
        inscricao.setPessoa(null);
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pessoa)) {
            return false;
        }
        return id != null && id.equals(((Pessoa) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Pessoa{" +
            "id=" + getId() +
            ", nomePessoa='" + getNomePessoa() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", email='" + getEmail() + "'" +
            ", foto='" + getFoto() + "'" +
            ", fotoContentType='" + getFotoContentType() + "'" +
            ", dataNascimento='" + getDataNascimento() + "'" +
            ", nomeMae='" + getNomeMae() + "'" +
            "}";
    }
}
