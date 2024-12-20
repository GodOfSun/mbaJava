package br.edu.infnet.projetoarqjavahelioformaggio.client;

import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Cep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
public interface EnderecoClient {

    @GetMapping(value = "/{cep}/json/")
    Cep findByCep(@PathVariable String cep);
}