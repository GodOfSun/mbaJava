package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.DeputadoFederal;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.DeputadoFederalRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Qualifier("DeputadoFederal")
public class DeputadoFederalSeviceImpl implements CandidatoService<DeputadoFederal> {

    private final DeputadoFederalRepository deputadoFederalRepository;

    public DeputadoFederalSeviceImpl(DeputadoFederalRepository deputadoFederalRepository) {
        this.deputadoFederalRepository = deputadoFederalRepository;
    }

    @Override
    public Optional<DeputadoFederal> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public DeputadoFederal findByCode(String code) {
        return null;
    }

    @Override
    public List<DeputadoFederal> findByPartido(String codigoPartido) {
        return List.of();
    }

    @Override
    public List<DeputadoFederal> findAll() {
        return List.of();
    }

    @Override
    public DeputadoFederal save(DeputadoFederal candidato) {
        return null;
    }

    @Override
    public void delete(DeputadoFederal candidato) {

    }

    @Override
    public void deleteById(UUID id) {

    }
}
