package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.exceptions.CandidatoNaoEncontrado;
import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Candidato;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CandidatoAbstractService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class AbstractCandidatoController<T extends Candidato> {

    protected abstract CandidatoAbstractService<T> getCandidatoService();

    @Operation(summary = "Recupera o candidato pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable UUID id) {
        Optional<T> candidato = getCandidatoService().findById(id);
        return candidato.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Recupera o candidato pelo código")
    @GetMapping("/code/{code}")
    public ResponseEntity<T> getByCode(@PathVariable String code) {
        Optional<T> candidato = getCandidatoService().findByCode(code);

        if( candidato.isEmpty())
            throw new CandidatoNaoEncontrado("Candidato não encontrado!");

        return ResponseEntity.ok(candidato.get());
    }

    @Operation(summary = "Recupera todos os candidatos pelo código do partido")
    @GetMapping("/partido/{codigoPartido}")
    public ResponseEntity<List<T>> getByPartido(@PathVariable int codigoPartido) {
        List<T> candidatos = getCandidatoService().findByPartido(codigoPartido);
        return ResponseEntity.ok(candidatos);
    }

    @Operation(summary = "Recupera todos os candidatos")
    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        Iterable<T> candidatos = getCandidatoService().findAll();
        List<T> candidatoList = StreamSupport.stream(candidatos.spliterator(), false)
                .collect(Collectors.toList());
        return ResponseEntity.ok(candidatoList);
    }

    @PostMapping
    @Operation(summary = "Inclui um candidato")
    public ResponseEntity<T> create(@RequestBody T candidato) {
        T savedCandidato = (T) getCandidatoService().save(candidato);
        return ResponseEntity.ok(savedCandidato);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edita um candidato pelo ID e dados")
    public ResponseEntity<T> update(@PathVariable UUID id, @RequestBody T candidato) {
        if (getCandidatoService().findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        candidato.setId(id); // Assuming the entity has a setId method
        T updatedCandidato = (T) getCandidatoService().save(candidato);
        return ResponseEntity.ok(updatedCandidato);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um candidato pelo ID")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        getCandidatoService().deleteById(id);
        return ResponseEntity.noContent().build();
    }
}