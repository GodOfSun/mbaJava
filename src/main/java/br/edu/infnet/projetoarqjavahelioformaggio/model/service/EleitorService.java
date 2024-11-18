package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Eleitor;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.EleitorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EleitorService extends AbstractService<Eleitor> {
    
    private final EleitorRepository eleitorRepository;
    
    public EleitorService(EleitorRepository eleitorRepository) {
        super(eleitorRepository);
        this.eleitorRepository = eleitorRepository;
    }

}
