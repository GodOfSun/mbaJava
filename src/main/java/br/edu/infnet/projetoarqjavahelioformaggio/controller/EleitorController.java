package br.edu.infnet.projetoarqjavahelioformaggio.controller;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Eleitor;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.AbstractService;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CidadeService;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.EleitorService;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.UfService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/eleitor")
public class EleitorController extends AbstractController<Eleitor> {

    private final EleitorService service;
    private final UfService ufService;
    private final CidadeService cidadeService;

    public EleitorController(
            EleitorService service,
            UfService ufService,
            CidadeService cidadeService) {
        this.service = service;
        this.ufService = ufService;
        this.cidadeService = cidadeService;
    }

    @Override
    protected AbstractService<Eleitor> getService() {
        return service;
    }

    @Override
    public ResponseEntity<Eleitor> create(Eleitor entidade) {
        entidade.setUf(ufService.findBySigla(entidade.getUf().getSigla()).orElseThrow());
        entidade.setCidade(cidadeService.findByNome(entidade.getCidade().getNome()).orElseThrow());
        return super.create(entidade);
    }

    @Override
    public ResponseEntity<Eleitor> update(UUID id, Eleitor entidade) {
        entidade.setUf(ufService.findBySigla(entidade.getUf().getSigla()).orElseThrow());
        entidade.setCidade(cidadeService.findByNome(entidade.getCidade().getNome()).orElseThrow());
        return super.update(id, entidade);
    }
}
