package br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel;

import br.edu.infnet.projetoarqjavahelioformaggio.core.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cidade")
public class Cidade extends BaseEntity {
    private String nome;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_estado", nullable = false)
    private Uf estado;

    private String code;
}
