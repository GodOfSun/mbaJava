package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Presidente;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.PresidenteRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Qualifier("Presidente")
public class PresidenteServiceImpl implements CandidatoService<Presidente> {

    private final PresidenteRepository presidenteRepository;

    public PresidenteServiceImpl(PresidenteRepository presidenteRepository) {
        this.presidenteRepository = presidenteRepository;
    }

    @Override
    public Optional<Presidente> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Presidente findByCode(String code) {
        return null;
    }

    @Override
    public List<Presidente> findByPartido(String codigoPartido) {
        return List.of();
    }

    @Override
    public List<Presidente> findAll() {
        return List.of();
    }

    @Override
    public Presidente save(Presidente candidato) {
        return null;
    }

    @Override
    public void delete(Presidente candidato) {

    }

    @Override
    public void deleteById(UUID id) {

    }
}
