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
public class DeputadoFederalSeviceImpl extends CandidatoAbstractService<DeputadoFederal> {

    private final DeputadoFederalRepository deputadoFederalRepository;

    public DeputadoFederalSeviceImpl(DeputadoFederalRepository deputadoFederalRepository) {
        super(deputadoFederalRepository);
        this.deputadoFederalRepository = deputadoFederalRepository;
    }


}
