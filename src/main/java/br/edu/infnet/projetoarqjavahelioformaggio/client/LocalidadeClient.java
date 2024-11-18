package br.edu.infnet.projetoarqjavahelioformaggio.client;

import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Cidade;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.CidadeDTO;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.UfDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(url = "https://servicodados.ibge.gov.br/api/v1/localidades", name = "ibge")
public interface LocalidadeClient {

	@GetMapping(value = "/estados")
	Collection<UfDTO> obterEstados();
	
	@GetMapping(value = "/estados/{uf}/municipios")
	Collection<CidadeDTO> obterMunicipios(@PathVariable Integer uf);
}