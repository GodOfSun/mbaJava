package br.edu.infnet.projetoarqjavahelioformaggio.model.domain;

import br.edu.infnet.projetoarqjavahelioformaggio.core.BaseEntity;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Cidade;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "eleitor")
public class Eleitor extends BaseEntity {
    String nome;
    String cpf;
    String tituloEleitoral;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_uf", nullable = false)
    private Uf uf;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_cidade", nullable = false)
    private Cidade cidade;
}
