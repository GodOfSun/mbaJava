package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Presidente;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CandidatoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/presidente")
public class PresidenteController extends AbstractCandidatoController<Presidente> {

    @Qualifier("Presidente")
    private final CandidatoService<Presidente> candidatoService;

    public PresidenteController(CandidatoService<Presidente> candidatoService) {
        this.candidatoService = candidatoService;
    }

    @Override
    protected CandidatoService<Presidente> getCandidatoService() {
        return candidatoService;
    }
}