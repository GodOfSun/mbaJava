package br.edu.infnet.projetoarqjavahelioformaggio.model.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseCrudRepository <ENTITY, ID> extends CrudRepository<ENTITY, ID> {

    Iterable<ENTITY> findAll(Sort sort);

}
