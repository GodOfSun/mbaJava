package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Governador;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CandidatoAbstractService;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.UfService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/governador")
public class GovernadorController extends AbstractCandidatoController<Governador> {

    @Qualifier("Governador")
    private final CandidatoAbstractService<Governador> candidatoService;
    private final UfService ufService;

    public GovernadorController(CandidatoAbstractService<Governador> candidatoService, UfService ufService) {
        this.candidatoService = candidatoService;
        this.ufService = ufService;
    }

    @Override
    protected CandidatoAbstractService<Governador> getCandidatoService() {
        return candidatoService;
    }

    @Override
    public ResponseEntity<Governador> create(Governador candidato) {
        Optional<Uf> uf = this.ufService.findBySigla(candidato.getUf().getSigla());
        candidato.setUf(uf.orElseThrow());
        return super.create(candidato);
    }

    @Override
    public ResponseEntity<Governador> update(UUID id, Governador candidato) {
        Optional<Uf> uf = this.ufService.findBySigla(candidato.getUf().getSigla());
        candidato.setUf(uf.orElseThrow());
        return super.update(id, candidato);
    }
}