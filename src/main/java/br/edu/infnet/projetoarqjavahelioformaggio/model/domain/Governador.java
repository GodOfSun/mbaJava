package br.edu.infnet.projetoarqjavahelioformaggio.model.domain;

import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "governador")
public class Governador extends Candidato{
    private String codigoGovernador;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_uf", nullable = false)
    private Uf uf;

}
