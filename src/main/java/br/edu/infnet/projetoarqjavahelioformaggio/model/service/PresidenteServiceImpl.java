package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Presidente;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.CandidatoRepository;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.PresidenteRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Qualifier("Presidente")
public class PresidenteServiceImpl extends CandidatoAbstractService<Presidente> {

    private final PresidenteRepository presidenteRepository;

    public PresidenteServiceImpl(PresidenteRepository presidenteRepository) {
        super(presidenteRepository);
        this.presidenteRepository = presidenteRepository;
    }

}
