package br.edu.infnet.projetoarqjavahelioformaggio.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface CandidatoRepository<ENTITY,ID> extends CrudRepository<ENTITY,ID> {

    @Query("SELECT e FROM #{#entityName} e WHERE e.codigo = :code")
    Optional<ENTITY> findByCode(@Param("code") String code);

    @Query("SELECT e FROM #{#entityName} e WHERE e.numeroPartido = :partido")
    List<ENTITY> findByPartido(@Param("partido") int partido);

}
