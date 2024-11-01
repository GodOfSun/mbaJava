package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.DeputadoFederal;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CandidatoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deputado-federal")
public class DeputadoFederalController extends AbstractCandidatoController<DeputadoFederal> {

    @Qualifier("DeputadoFederal")
    private final CandidatoService<DeputadoFederal> candidatoService;

    public DeputadoFederalController(CandidatoService<DeputadoFederal> candidatoService) {
        this.candidatoService = candidatoService;
    }

    @Override
    protected CandidatoService<DeputadoFederal> getCandidatoService() {
        return candidatoService;
    }
}