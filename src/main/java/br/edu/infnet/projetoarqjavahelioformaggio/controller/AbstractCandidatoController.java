package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Candidato;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CandidatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class AbstractCandidatoController<T extends Candidato> {

    protected abstract CandidatoService<T> getCandidatoService();

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable UUID id) {
        Optional<T> candidato = getCandidatoService().findById(id);
        return candidato.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<T> getByCode(@PathVariable String code) {
        T candidato = getCandidatoService().findByCode(code);
        return ResponseEntity.ok(candidato);
    }

    @GetMapping("/partido/{codigoPartido}")
    public ResponseEntity<List<T>> getByPartido(@PathVariable String codigoPartido) {
        List<T> candidatos = getCandidatoService().findByPartido(codigoPartido);
        return ResponseEntity.ok(candidatos);
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        List<T> candidatos = getCandidatoService().findAll();
        return ResponseEntity.ok(candidatos);
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T candidato) {
        T savedCandidato = getCandidatoService().save(candidato);
        return ResponseEntity.ok(savedCandidato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable UUID id, @RequestBody T candidato) {
        if (!getCandidatoService().findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        candidato.setId(id); // Assuming the entity has a setId method
        T updatedCandidato = getCandidatoService().save(candidato);
        return ResponseEntity.ok(updatedCandidato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        getCandidatoService().deleteById(id);
        return ResponseEntity.noContent().build();
    }
}