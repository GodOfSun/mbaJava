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
public class PrefeitoServiceImpl extends CandidatoAbstractService<Prefeito> {

    private final PrefeitoRepository prefeitoRepository;

    public PrefeitoServiceImpl(PrefeitoRepository prefeitoRepository) {
        this.prefeitoRepository = prefeitoRepository;
    }

    @Override
    public PrefeitoRepository getRepository() {
        return prefeitoRepository;
    }
}
