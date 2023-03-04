package br.com.redemob.rocket.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.redemob.rocket.domain.model.enumeration.StatusIncricao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * A Inscricao.
 */
@Entity
@Table(name = "inscricao")
@Data

public class Inscricao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "departmento_name", nullable = false)
    private String departmentoName;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusIncricao status;

    @Size(max = 100)
    @Column(name = "endereco", length = 100)
    private String endereco;

    @Size(max = 50)
    @Column(name = "complemento", length = 50)
    private String complemento;

    @Size(max = 30)
    @Column(name = "bairro", length = 30)
    private String bairro;

    @ManyToOne(optional = false)
    @NotNull
    private Cidade cidade;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "inscricoes" }, allowSetters = true)
    private Pessoa pessoa;

    @OneToMany(mappedBy = "inscricao")
    @JsonIgnoreProperties(value = { "inscricao" }, allowSetters = true)
    private Set<Arquivo> arquivos = new HashSet<>();




    public void setArquivos(Set<Arquivo> arquivos) {
        if (this.arquivos != null) {
            this.arquivos.forEach(i -> i.setInscricao(null));
        }
        if (arquivos != null) {
            arquivos.forEach(i -> i.setInscricao(this));
        }
        this.arquivos = arquivos;
    }

    public Inscricao arquivos(Set<Arquivo> arquivos) {
        this.setArquivos(arquivos);
        return this;
    }

    public Inscricao addArquivos(Arquivo arquivo) {
        this.arquivos.add(arquivo);
        arquivo.setInscricao(this);
        return this;
    }

    public Inscricao removeArquivos(Arquivo arquivo) {
        this.arquivos.remove(arquivo);
        arquivo.setInscricao(null);
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Inscricao)) {
            return false;
        }
        return id != null && id.equals(((Inscricao) o).id);
    }

    @Override
    public int hashCode() {
            return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Inscricao{" +
            "id=" + getId() +
            ", departmentoName='" + getDepartmentoName() + "'" +
            ", status='" + getStatus() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", complemento='" + getComplemento() + "'" +
            ", bairro='" + getBairro() + "'" +
            "}";
    }
}
