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
public class GovernadorServiceImpl extends CandidatoAbstractService<Governador> {

    private final GovernadorRepository governadorRepository;

    public GovernadorServiceImpl(GovernadorRepository governadorRepository) {
        super(governadorRepository);
        this.governadorRepository = governadorRepository;
    }

}
