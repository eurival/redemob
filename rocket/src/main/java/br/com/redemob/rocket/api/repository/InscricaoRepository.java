package br.com.redemob.rocket.api.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.redemob.rocket.api.domain.model.Inscricao;
import br.com.redemob.rocket.api.domain.model.Pessoa;
import jakarta.persistence.TypedQuery;
 
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
	
	List<Inscricao> findAllByPessoaId(Long id);
	
    default Optional<Inscricao> findOneWithEagerRelationships(Long id) {
        return this.findOneWithToOneRelationships(id);
    }

    default List<Inscricao> findAllWithEagerRelationships() {
        return this.findAllWithToOneRelationships();
    }

    default Page<Inscricao> findAllWithEagerRelationships(Pageable pageable) {
        return this.findAllWithToOneRelationships(pageable);
    }

    @Query(
        value = "select distinct inscricao from Inscricao inscricao left join fetch inscricao.cidade left join fetch inscricao.pessoa",
        countQuery = "select count(distinct inscricao) from Inscricao inscricao"
    )
    Page<Inscricao> findAllWithToOneRelationships(Pageable pageable);

    @Query("select distinct inscricao from Inscricao inscricao left join fetch inscricao.cidade left join fetch inscricao.pessoa")
    List<Inscricao> findAllWithToOneRelationships();

    @Query(
        "select inscricao from Inscricao inscricao left join fetch inscricao.cidade left join fetch inscricao.pessoa where inscricao.id =:id"
    )
    Optional<Inscricao> findOneWithToOneRelationships(@Param("id") Long id);
}
