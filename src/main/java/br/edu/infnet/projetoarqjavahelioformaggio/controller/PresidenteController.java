package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Presidente;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CandidatoAbstractService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/presidente")
public class PresidenteController extends AbstractCandidatoController<Presidente> {

    @Qualifier("Presidente")
    private final CandidatoAbstractService<Presidente> candidatoService;

    public PresidenteController(CandidatoAbstractService<Presidente> candidatoService) {
        this.candidatoService = candidatoService;
    }

    @Override
    protected CandidatoAbstractService<Presidente> getCandidatoService() {
        return candidatoService;
    }

}