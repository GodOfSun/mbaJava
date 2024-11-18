package br.edu.infnet.projetoarqjavahelioformaggio.client;

import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Cidade;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.CidadeDTO;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.UfDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExternalClientService {

    private final EnderecoClient enderecoClient;
    private final LocalidadeClient localidadeClient;

    public ExternalClientService(EnderecoClient enderecoClient, LocalidadeClient localidadeClient) {
        this.enderecoClient = enderecoClient;
        this.localidadeClient = localidadeClient;
    }

    public Collection<UfDTO> obterEstados(){
        return localidadeClient.obterEstados();
    }

    public Collection<CidadeDTO> obterMunicipios(Integer ufCode){
        return localidadeClient.obterMunicipios(ufCode);
    }


}
