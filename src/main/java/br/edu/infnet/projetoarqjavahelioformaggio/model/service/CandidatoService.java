package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Candidato;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CandidatoService<T extends Candidato> {

    public Optional<T> findById(UUID id);
    public T findByCode(String code);
    public List<T> findByPartido(String codigoPartido);
    public List<T> findAll();
    public T save(T candidato);
    public void delete(T candidato);
    public void deleteById(UUID id);

}
