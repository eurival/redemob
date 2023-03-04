package br.com.redemob.rocket.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * A Usuario.
 */
@Entity
@Table(name = "usuario")
@Data
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 11)
    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @NotNull
    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "admin")
    private Boolean admin;

    @JsonIgnoreProperties(value = { "inscricoes" }, allowSetters = true)
    @OneToOne
    @JoinColumn(unique = true)
    private Pessoa pessoa;

   
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Usuario)) {
            return false;
        }
        return id != null && id.equals(((Usuario) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Usuario{" +
            "id=" + getId() +
            ", cpf='" + getCpf() + "'" +
            ", senha='" + getSenha() + "'" +
            ", admin='" + getAdmin() + "'" +
            "}";
    }
}
