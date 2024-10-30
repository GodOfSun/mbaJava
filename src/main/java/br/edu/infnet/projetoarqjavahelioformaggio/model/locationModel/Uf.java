package br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel;

import br.edu.infnet.projetoarqjavahelioformaggio.core.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "uf")
public class Uf extends BaseEntity {
    private String nome;
    private String code;
}
