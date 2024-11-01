package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Prefeito;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.PrefeitoRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Qualifier("Prefeito")
public class PrefeitoServiceImpl implements CandidatoService<Prefeito>{

    private final PrefeitoRepository prefeitoRepository;

    public PrefeitoServiceImpl(PrefeitoRepository prefeitoRepository) {
        this.prefeitoRepository = prefeitoRepository;
    }

    @Override
    public Optional<Prefeito> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Prefeito findByCode(String code) {
        return null;
    }

    @Override
    public List<Prefeito> findByPartido(String codigoPartido) {
        return List.of();
    }

    @Override
    public List<Prefeito> findAll() {
        return List.of();
    }

    @Override
    public Prefeito save(Prefeito candidato) {
        return null;
    }

    @Override
    public void delete(Prefeito candidato) {

    }

    @Override
    public void deleteById(UUID id) {

    }
}
