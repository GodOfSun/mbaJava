package br.edu.infnet.projetoarqjavahelioformaggio.model.repository;

import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UfRepository extends CrudRepository<Uf, UUID> {

    Uf findBySigla(String sigla);
    Uf findByNome(String nome);
}
