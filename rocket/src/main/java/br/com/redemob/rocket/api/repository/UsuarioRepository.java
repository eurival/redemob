package br.com.redemob.rocket.api.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.redemob.rocket.api.domain.model.Usuario;

/**
 * Repositorio responsável pela manupulação e login de usuário
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    default Optional<Usuario> findOneWithEagerRelationships(Long id) {
        return this.findOneWithToOneRelationships(id);
    }

    default List<Usuario> findAllWithEagerRelationships() {
        return this.findAllWithToOneRelationships();
    }

    default Page<Usuario> findAllWithEagerRelationships(Pageable pageable) {
        return this.findAllWithToOneRelationships(pageable);
    }

    @Query(
        value = "select distinct usuario from Usuario usuario left join fetch usuario.pessoa",
        countQuery = "select count(distinct usuario) from Usuario usuario"
    )
    Page<Usuario> findAllWithToOneRelationships(Pageable pageable);

    @Query("select distinct usuario from Usuario usuario left join fetch usuario.pessoa")
    List<Usuario> findAllWithToOneRelationships();

    @Query("select usuario from Usuario usuario left join fetch usuario.pessoa where usuario.id =:id")
    Optional<Usuario> findOneWithToOneRelationships(@Param("id") Long id);
    
    @Query("select usuario from Usuario usuario left join fetch usuario.pessoa where usuario.pessoa.cpf=:cpf and usuario.senha=:senha")
    Optional<Usuario> Logar(@Param("cpf") String cpf, @Param("senha") String senha );
    
}
