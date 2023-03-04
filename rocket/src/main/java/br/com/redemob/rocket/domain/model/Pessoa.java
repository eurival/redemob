package br.com.redemob.rocket.domain.model;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "nome_pessoa", length = 100, nullable = false)
    private String nomePessoa;

    @NotNull
    @Size(max = 11)
    @Column(name = "cpf", length = 11, nullable = false)
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
    @JsonIgnoreProperties(value = { "cidade", "pessoa", "arquivos" }, allowSetters = true)
    private Set<Inscricao> inscricoes = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public Pessoa id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePessoa() {
        return this.nomePessoa;
    }

    public Pessoa nomePessoa(String nomePessoa) {
        this.setNomePessoa(nomePessoa);
        return this;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Pessoa cpf(String cpf) {
        this.setCpf(cpf);
        return this;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public Pessoa email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getFoto() {
        return this.foto;
    }

    public Pessoa foto(byte[] foto) {
        this.setFoto(foto);
        return this;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getFotoContentType() {
        return this.fotoContentType;
    }

    public Pessoa fotoContentType(String fotoContentType) {
        this.fotoContentType = fotoContentType;
        return this;
    }

    public void setFotoContentType(String fotoContentType) {
        this.fotoContentType = fotoContentType;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public Pessoa dataNascimento(LocalDate dataNascimento) {
        this.setDataNascimento(dataNascimento);
        return this;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeMae() {
        return this.nomeMae;
    }

    public Pessoa nomeMae(String nomeMae) {
        this.setNomeMae(nomeMae);
        return this;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

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

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

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
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
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
