package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Governador;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CandidatoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/governador")
public class GovernadorController extends AbstractCandidatoController<Governador> {

    @Qualifier("Governador")
    private final CandidatoService<Governador> candidatoService;

    public GovernadorController(CandidatoService<Governador> candidatoService) {
        this.candidatoService = candidatoService;
    }

    @Override
    protected CandidatoService<Governador> getCandidatoService() {
        return candidatoService;
    }
}