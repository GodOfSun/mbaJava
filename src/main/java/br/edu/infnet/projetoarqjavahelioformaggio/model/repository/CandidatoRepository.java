package br.edu.infnet.projetoarqjavahelioformaggio.model.repository;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Candidato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CandidatoRepository extends CrudRepository<Candidato, UUID> {
}
