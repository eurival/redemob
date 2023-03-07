package br.com.redemob.rocket.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.redemob.rocket.api.domain.model.enumeration.StatusIncricao;
import io.micrometer.common.lang.Nullable;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * A InscricaoMap
 */
@Data
public class InscricaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private StatusIncricao status;

    private String endereco;

    private String complemento;

    private String bairro;
    
    @CreatedDate
    private LocalDateTime dataInscricao;
    
    private CidadeDTO cidade; 
    
    private PessoaDTO pessoa;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InscricaoDTO)) {
            return false;
        }
        return id != null && id.equals(((InscricaoDTO) o).id);
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
