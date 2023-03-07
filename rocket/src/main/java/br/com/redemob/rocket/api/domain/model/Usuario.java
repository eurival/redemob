package br.com.redemob.rocket.api.domain.model;

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
    @SequenceGenerator(name = "USUARIO_ID_GENERATOR", sequenceName="USUARIO_ID_SEQ", allocationSize=1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_ID_GENERATOR")
 
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "admin")
    private Boolean admin;

    @OneToOne
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
            ", senha='" + getSenha() + "'" +
            ", admin='" + getAdmin() + "'" +
            "}";
    }
}
