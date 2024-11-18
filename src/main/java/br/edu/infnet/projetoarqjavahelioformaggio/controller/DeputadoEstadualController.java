package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.DeputadoEstadual;
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
@RequestMapping("/api/deputado-estadual")
public class DeputadoEstadualController extends AbstractCandidatoController<DeputadoEstadual> {

    @Qualifier("DeputadoEstadual")
    private final CandidatoAbstractService<DeputadoEstadual> candidatoService;

    private final UfService ufService;

    public DeputadoEstadualController(
            CandidatoAbstractService<DeputadoEstadual> candidatoService,
            UfService ufService) {
        this.candidatoService = candidatoService;
        this.ufService = ufService;
    }

    @Override
    protected CandidatoAbstractService<DeputadoEstadual> getCandidatoService() {
        return candidatoService;
    }

    @Override
    public ResponseEntity<DeputadoEstadual> create(DeputadoEstadual candidato) {
        Optional<Uf> uf = this.ufService.findBySigla(candidato.getUf().getSigla());
        candidato.setUf(uf.orElseThrow());
        return super.create(candidato);
    }

    @Override
    public ResponseEntity<DeputadoEstadual> update(UUID id, DeputadoEstadual candidato) {
        Optional<Uf> uf = this.ufService.findBySigla(candidato.getUf().getSigla());
        candidato.setUf(uf.orElseThrow());
        return super.update(id, candidato);
    }
}