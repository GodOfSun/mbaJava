package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.DeputadoEstadual;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CandidatoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deputado-estadual")
public class DeputadoEstadualController extends AbstractCandidatoController<DeputadoEstadual> {

    @Qualifier("DeputadoEstadual")
    private final CandidatoService<DeputadoEstadual> candidatoService;

    public DeputadoEstadualController(CandidatoService<DeputadoEstadual> candidatoService) {
        this.candidatoService = candidatoService;
    }

    @Override
    protected CandidatoService<DeputadoEstadual> getCandidatoService() {
        return candidatoService;
    }
}