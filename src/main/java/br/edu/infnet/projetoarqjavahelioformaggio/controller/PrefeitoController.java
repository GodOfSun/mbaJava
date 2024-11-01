package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Prefeito;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CandidatoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prefeito")
public class PrefeitoController extends AbstractCandidatoController<Prefeito> {

    @Qualifier("Prefeito")
    private final CandidatoService<Prefeito> candidatoService;

    public PrefeitoController(CandidatoService<Prefeito> candidatoService) {
        this.candidatoService = candidatoService;
    }

    @Override
    protected CandidatoService<Prefeito> getCandidatoService() {
        return candidatoService;
    }
}