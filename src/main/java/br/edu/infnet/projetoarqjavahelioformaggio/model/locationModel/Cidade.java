package br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cidade")
public class Cidade {
    private String nome;
    private Uf estado;
    private String code;
}
