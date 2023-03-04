package br.com.redemob.rocket.domain.model;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * A Cidade.
 */
@Entity
@Table(name = "cidade")
@Data
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Size(max = 60)
    @Column(name = "nome_cidade", length = 60)
    private String nomeCidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cidade)) {
            return false;
        }
        return id != null && id.equals(((Cidade) o).id);
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
