package br.edu.infnet.projetoarqjavahelioformaggio.model.repository;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.DeputadoEstadual;
import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Presidente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PresidenteRepository extends BaseCrudRepository<Presidente, UUID> {
}
