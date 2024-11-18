package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.core.BaseEntity;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public abstract class AbstractService<T extends BaseEntity> {


    private static final Logger logger = LoggerFactory.getLogger(AbstractService.class);
    private final CrudRepository<T, UUID> repository;

    public AbstractService(CrudRepository<T, UUID> repository) {
        this.repository = repository;
    }

    public T create(T entity) {
        logger.info("Creating entity: {}", entity);
        T savedEntity = repository.save(entity);
        logger.info("Entity created: {}", savedEntity);
        return savedEntity;
    }

    public Iterable<T> create(Iterable<T> entities) {
        logger.info("Creating entities: {}", entities);
        Iterable<T> savedEntities = repository.saveAll(entities);
        logger.info("Entities created: {}", savedEntities);
        return savedEntities;
    }

    public Optional<T> getById(UUID id) {
        return repository.findById(id);
    }

    public Iterable<T> getAll() {
        return repository.findAll();
    }

    public T update(UUID id, T entity) {
        if (repository.existsById(id)) {
            entity.setId(id);
            return repository.save(entity);
        }
        throw new EntityNotFoundException("Entidade não encontrada com id " + id);
    }

    public void delete(UUID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Entidade não encontrada com id " + id);
        }
    }
}
