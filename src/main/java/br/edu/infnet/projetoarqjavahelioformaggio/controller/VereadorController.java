package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Vereador;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CandidatoAbstractService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vereador")
public class VereadorController extends AbstractCandidatoController<Vereador> {

    @Qualifier("Vereador")
    private final CandidatoAbstractService<Vereador> candidatoService;

    public VereadorController(CandidatoAbstractService<Vereador> candidatoService) {
        this.candidatoService = candidatoService;
    }

    @Override
    protected CandidatoAbstractService<Vereador> getCandidatoService() {
        return candidatoService;
    }
}