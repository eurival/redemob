package br.com.redemob.rocket.dto;

import br.com.redemob.rocket.api.domain.model.Pessoa;
import java.io.Serializable;
import lombok.Data;

/**
 * A Usuario.
 */
@Data
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String senha;
    private Boolean admin;
    private Pessoa pessoa;
}
