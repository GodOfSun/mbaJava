package br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel;

import lombok.Data;

@Data
public class CidadeDTO {
    int id;
    String nome;
    UfDTO uf;
}
