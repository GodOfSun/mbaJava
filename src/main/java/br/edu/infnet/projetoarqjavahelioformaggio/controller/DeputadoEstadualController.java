package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.DeputadoEstadual;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CandidatoAbstractService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deputado-estadual")
public class DeputadoEstadualController extends AbstractCandidatoController<DeputadoEstadual> {

    @Qualifier("DeputadoEstadual")
    private final CandidatoAbstractService<DeputadoEstadual> candidatoService;

    public DeputadoEstadualController(CandidatoAbstractService<DeputadoEstadual> candidatoService) {
        this.candidatoService = candidatoService;
    }

    @Override
    protected CandidatoAbstractService<DeputadoEstadual> getCandidatoService() {
        return candidatoService;
    }
}