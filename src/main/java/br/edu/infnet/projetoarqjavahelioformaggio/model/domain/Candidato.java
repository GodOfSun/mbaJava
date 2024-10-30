package br.edu.infnet.projetoarqjavahelioformaggio.model.domain;

import br.edu.infnet.projetoarqjavahelioformaggio.core.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class Candidato extends BaseEntity {
    private String nome;
    private String email;
    private int numeroPartido;
    private boolean ativo;
    private float gastoCampanha;

}
