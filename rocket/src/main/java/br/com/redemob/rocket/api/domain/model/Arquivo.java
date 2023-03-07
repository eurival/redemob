package br.com.redemob.rocket.api.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.redemob.rocket.api.domain.model.enumeration.TipoDocumento;

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
    @SequenceGenerator(name = "ARQUIVO_ID_GENERATOR", sequenceName="ARQUIVO_ID_SEQ", allocationSize=1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARQUIVO_ID_GENERATOR")
 
    private Long id;
    @NotNull
    @Column(name = "nome_arquivo", nullable = false)
    private String nomeArquivo;
    
    @Column(name = "tipo")
    private String tipo;

    @NotNull
    @Column(name = "caminho_arquivo", nullable = false)
    private String caminhoArquivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inscricao_id", nullable = false)
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
