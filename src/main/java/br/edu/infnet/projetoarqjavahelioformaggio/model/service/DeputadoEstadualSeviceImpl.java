package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.DeputadoEstadual;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.DeputadoEstadualRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Qualifier("DeputadoEstadual")
public class DeputadoEstadualSeviceImpl implements CandidatoService<DeputadoEstadual> {

    private final DeputadoEstadualRepository deputadoEstadualRepository;

    public DeputadoEstadualSeviceImpl(DeputadoEstadualRepository deputadoEstadualRepository) {
        this.deputadoEstadualRepository = deputadoEstadualRepository;
    }

    @Override
    public Optional<DeputadoEstadual> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public DeputadoEstadual findByCode(String code) {
        return null;
    }

    @Override
    public List<DeputadoEstadual> findByPartido(String codigoPartido) {
        return List.of();
    }

    @Override
    public List<DeputadoEstadual> findAll() {
        return List.of();
    }

    @Override
    public DeputadoEstadual save(DeputadoEstadual candidato) {
        return null;
    }

    @Override
    public void delete(DeputadoEstadual candidato) {

    }

    @Override
    public void deleteById(UUID id) {

    }
}
