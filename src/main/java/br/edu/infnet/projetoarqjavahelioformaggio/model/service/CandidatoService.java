package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CandidatoService<T> {

    public Optional<T> findById(UUID id);
    public T findByCode(String code);
    public List<T> findByPartido(String codigoPartido);
    public List<T> findAll();

}
