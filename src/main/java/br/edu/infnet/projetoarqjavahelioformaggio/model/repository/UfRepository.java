package br.edu.infnet.projetoarqjavahelioformaggio.model.repository;

import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UfRepository extends CrudRepository<Uf, UUID> {

    Optional<Uf> findBySigla(String sigla);
    Optional<Uf> findByNome(String nome);
}
