package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Cidade;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.CidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CidadeService extends AbstractService<Cidade> {

    private final CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        super(cidadeRepository);
        this.cidadeRepository = cidadeRepository;
    }

}
