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
public class VereadorServiceImpl extends CandidatoAbstractService<Vereador> {

    private final VereadorRepository vereadorRepository;

    public VereadorServiceImpl(VereadorRepository vereadorRepository) {
        this.vereadorRepository = vereadorRepository;
    }

    @Override
    public VereadorRepository getRepository() {
        return vereadorRepository;
    }
}
