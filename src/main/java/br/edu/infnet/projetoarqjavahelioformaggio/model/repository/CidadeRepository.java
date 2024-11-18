package br.edu.infnet.projetoarqjavahelioformaggio.model.repository;

import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Cidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CidadeRepository extends BaseCrudRepository<Cidade, UUID> {

    Optional<Cidade> findByNomeOrderByNome(String nome);
}
