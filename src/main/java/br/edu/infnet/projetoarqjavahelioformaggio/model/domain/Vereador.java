package br.edu.infnet.projetoarqjavahelioformaggio.model.domain;

import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Cidade;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import jakarta.persistence.*;

@Entity
@Table(name = "vereador")
public class Vereador extends Candidato{

    private String codigoVereador;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_uf", nullable = false)
    private Uf uf;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_cidade", nullable = false)
    private Cidade cidade;
}

