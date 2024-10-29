package br.edu.infnet.projetoarqjavahelioformaggio.model.domain;

import br.edu.infnet.projetoarqjavahelioformaggio.model.Cidade;
import br.edu.infnet.projetoarqjavahelioformaggio.model.Uf;
import lombok.Data;

@Data
public class Prefeito extends Candidato{
    private String codigoCandidato;
    private Cidade cidade;
    private Uf estado;
}
