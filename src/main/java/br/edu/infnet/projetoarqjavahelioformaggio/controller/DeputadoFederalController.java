package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.DeputadoFederal;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CandidatoAbstractService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deputado-federal")
public class DeputadoFederalController extends AbstractCandidatoController<DeputadoFederal> {

    @Qualifier("DeputadoFederal")
    private final CandidatoAbstractService<DeputadoFederal> candidatoService;

    public DeputadoFederalController(CandidatoAbstractService<DeputadoFederal> candidatoService) {
        this.candidatoService = candidatoService;
    }

    @Override
    protected CandidatoAbstractService<DeputadoFederal> getCandidatoService() {
        return candidatoService;
    }
}