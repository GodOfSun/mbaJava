package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Governador;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.GovernadorRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Qualifier("Governador")
public class GovernadorServiceImpl implements CandidatoService<Governador>{

    private final GovernadorRepository governadorRepository;

    public GovernadorServiceImpl(GovernadorRepository governadorRepository) {
        this.governadorRepository = governadorRepository;
    }

    @Override
    public Optional<Governador> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Governador findByCode(String code) {
        return null;
    }

    @Override
    public List<Governador> findByPartido(String codigoPartido) {
        return List.of();
    }

    @Override
    public List<Governador> findAll() {
        return List.of();
    }

    @Override
    public Governador save(Governador candidato) {
        return null;
    }

    @Override
    public void delete(Governador candidato) {

    }

    @Override
    public void deleteById(UUID id) {

    }
}
