package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.DeputadoEstadual;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.CandidatoRepository;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.DeputadoEstadualRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Qualifier("DeputadoEstadual")
public class DeputadoEstadualSeviceImpl extends CandidatoAbstractService<DeputadoEstadual> {

    private final DeputadoEstadualRepository deputadoEstadualRepository;

    public DeputadoEstadualSeviceImpl(DeputadoEstadualRepository deputadoEstadualRepository) {
        super(deputadoEstadualRepository);
        this.deputadoEstadualRepository = deputadoEstadualRepository;
    }

}
