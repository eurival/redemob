package br.com.redemob.rocket.api.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.redemob.rocket.api.domain.model.enumeration.StatusIncricao;
import io.micrometer.common.lang.Nullable;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INSCRICAO_ID_SEQ")
    @SequenceGenerator(name = "INSCRICAO_ID_SEQ")
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private String status;

    @Size(max = 100)
    @Column(name = "endereco", length = 100)
    private String endereco;

    @Size(max = 50)
    @Column(name = "complemento", length = 50)
    private String complemento;

    @Column(name = "bairro")
    private String bairro;
    
    @CreatedDate
    @Column(name="data_inscricao", nullable=false)
    private LocalDateTime dataInscricao;
    
    @ManyToOne(optional = false)
    @NotNull
    private Cidade cidade;
    
    

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnore
    private Pessoa pessoa;

    @OneToMany(mappedBy = "inscricao", cascade = CascadeType.ALL)
    private List<Arquivo> arquivos;




    public void setArquivos(List<Arquivo> arquivos) {
        if (this.arquivos != null) {
            this.arquivos.forEach(i -> i.setInscricao(null));
        }
        if (arquivos != null) {
            arquivos.forEach(i -> i.setInscricao(this));
        }
        this.arquivos = arquivos;
    }

    public Inscricao arquivos(List<Arquivo> arquivos) {
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
            
            ", status='" + getStatus() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", complemento='" + getComplemento() + "'" +
            ", bairro='" + getBairro() + "'" +
            "}";
    }
}
