package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Vereador;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.VereadorRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Qualifier("Vereador")
public class VereadorServiceImpl implements CandidatoService<Vereador>{

    private final VereadorRepository vereadorRepository;

    public VereadorServiceImpl(VereadorRepository vereadorRepository) {
        this.vereadorRepository = vereadorRepository;
    }

    @Override
    public Optional<Vereador> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Vereador findByCode(String code) {
        return null;
    }

    @Override
    public List<Vereador> findByPartido(String codigoPartido) {
        return List.of();
    }

    @Override
    public List<Vereador> findAll() {
        return List.of();
    }

    @Override
    public Vereador save(Vereador candidato) {
        return null;
    }

    @Override
    public void delete(Vereador candidato) {

    }

    @Override
    public void deleteById(UUID id) {

    }
}
