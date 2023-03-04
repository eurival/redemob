package br.com.redemob.rocket.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.redemob.rocket.domain.model.enumeration.TipoDocumento;

import java.io.Serializable;

/**
 * A Entidade Arquivo armazena os dados dos arquivos feitos em uploads
 * 
 */

@Data
@Entity
@Table(name = "arquivo")
public class Arquivo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nome_arquivo", nullable = false)
    private String nomeArquivo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoDocumento tipo;

    @NotNull
    @Column(name = "caminho_arquivo", nullable = false)
    private String caminhoArquivo;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "cidade", "pessoa", "arquivos" }, allowSetters = true)
    private Inscricao inscricao;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Arquivo)) {
            return false;
        }
        return id != null && id.equals(((Arquivo) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Arquivo{" +
            "id=" + getId() +
            ", nomeArquivo='" + getNomeArquivo() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", caminhoArquivo='" + getCaminhoArquivo() + "'" +
            "}";
    }
}
