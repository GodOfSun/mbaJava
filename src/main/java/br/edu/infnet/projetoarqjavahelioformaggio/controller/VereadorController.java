package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Vereador;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CandidatoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vereador")
public class VereadorController extends AbstractCandidatoController<Vereador> {

    @Qualifier("Vereador")
    private final CandidatoService<Vereador> candidatoService;

    public VereadorController(CandidatoService<Vereador> candidatoService) {
        this.candidatoService = candidatoService;
    }

    @Override
    protected CandidatoService<Vereador> getCandidatoService() {
        return candidatoService;
    }
}