package br.edu.infnet.projetoarqjavahelioformaggio.model.repository;

import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Cidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade, UUID> {

    Cidade findByNome(String nome);
}
