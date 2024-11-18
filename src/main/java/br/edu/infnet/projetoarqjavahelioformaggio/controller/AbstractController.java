package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.core.BaseEntity;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.AbstractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class AbstractController<T extends BaseEntity> {

    protected abstract AbstractService<T> getService();

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable UUID id) {
        Optional<T> entidade = getService().getById(id);
        return entidade.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        Iterable<T> entidades = getService().getAll();
        List<T> entidadeList = StreamSupport.stream(entidades.spliterator(), false)
                .collect(Collectors.toList());
        return ResponseEntity.ok(entidadeList);
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entidade) {
        T savedentidade = (T) getService().create(entidade);
        return ResponseEntity.ok(savedentidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable UUID id, @RequestBody T entidade) {
        if (getService().getById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        entidade.setId(id); // Assuming the entity has a setId method
        T updatedentidade = (T) getService().update(id, entidade);
        return ResponseEntity.ok(updatedentidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }
}
