package br.com.redemob.rocket.dto;


import java.io.Serializable;

import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * A Cidade.
 */
@Data
public class CidadeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @Size(max = 60)
    private String nomeCidade;
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CidadeDTO)) {
            return false;
        }
        return id != null && id.equals(((CidadeDTO) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Cidade{" +
            "id=" + getId() +
            ", nomeCidade='" + getNomeCidade() + "'" +
            "}";
    }
}
