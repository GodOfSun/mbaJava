package br.edu.infnet.projetoarqjavahelioformaggio.model.domain;

import br.edu.infnet.projetoarqjavahelioformaggio.model.Uf;
import lombok.Data;

@Data
public class DeputadoEstadual extends Candidato{
    private String codigoCandidato;
    private Uf estado;
}
