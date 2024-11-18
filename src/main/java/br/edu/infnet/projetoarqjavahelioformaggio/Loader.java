package br.edu.infnet.projetoarqjavahelioformaggio;

import br.edu.infnet.projetoarqjavahelioformaggio.client.ExternalClientService;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Cidade;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.CidadeDTO;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.UfDTO;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.UfRepository;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.CidadeService;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.UfService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class Loader implements ApplicationRunner {

    private final ExternalClientService externalClientService;
    private final UfService ufService;
    private final CidadeService cidadeService;

    public Loader(ExternalClientService externalClientService, UfService ufService, CidadeService cidadeService) {
        this.externalClientService = externalClientService;
        this.ufService = ufService;
        this.cidadeService = cidadeService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Collection<UfDTO> estados = this.externalClientService.obterEstados();

        Collection<Uf> estadosEntity = new ArrayList<>();
        for(UfDTO estado : estados) {
            estadosEntity.add(new Uf(estado));
        }
        this.ufService.create(estadosEntity);

        for(UfDTO estado : estados) {
            Uf estadoEntity = this.ufService.findBySilga(estado.getSigla());
            Collection<CidadeDTO> cidades = this.externalClientService.obterMunicipios(estado.getId());

            Collection<Cidade> cidadesEntity = new ArrayList<>();
            for(CidadeDTO cidadeDTO : cidades) {
                Cidade cidadeEntity = new Cidade(cidadeDTO);
                cidadeEntity.setEstado(estadoEntity);
                cidadesEntity.add(cidadeEntity);
            }
            this.cidadeService.create(cidadesEntity);
        }
    }
}
