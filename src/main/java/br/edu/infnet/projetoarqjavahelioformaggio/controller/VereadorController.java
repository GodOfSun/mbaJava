package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Prefeito;
import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Vereador;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Cidade;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CandidatoAbstractService;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CidadeService;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.UfService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/vereador")
public class VereadorController extends AbstractCandidatoController<Vereador> {

    @Qualifier("Vereador")
    private final CandidatoAbstractService<Vereador> candidatoService;
    private final UfService ufService;
    private final CidadeService cidadeService;

    public VereadorController(
            CandidatoAbstractService<Vereador> candidatoService,
            UfService ufService,
            CidadeService cidadeService) {
        this.candidatoService = candidatoService;
        this.ufService = ufService;
        this.cidadeService = cidadeService;
    }

    @Override
    protected CandidatoAbstractService<Vereador> getCandidatoService() {
        return candidatoService;
    }

    @Override
    public ResponseEntity<Vereador> create(Vereador candidato) {
        Optional<Uf> uf = this.ufService.findBySigla(candidato.getUf().getSigla());
        candidato.setUf(uf.orElseThrow());
        Optional<Cidade> cidade = this.cidadeService.findByNome(candidato.getCidade().getNome());
        candidato.setCidade(cidade.orElseThrow());
        return super.create(candidato);
    }

    @Override
    public ResponseEntity<Vereador> update(UUID id, Vereador candidato) {
        Optional<Uf> uf = this.ufService.findBySigla(candidato.getUf().getSigla());
        candidato.setUf(uf.orElseThrow());
        Optional<Cidade> cidade = this.cidadeService.findByNome(candidato.getCidade().getNome());
        candidato.setCidade(cidade.orElseThrow());
        return super.update(id, candidato);
    }
}