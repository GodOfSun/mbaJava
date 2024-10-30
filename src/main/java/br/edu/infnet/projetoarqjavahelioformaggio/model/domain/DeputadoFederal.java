package br.edu.infnet.projetoarqjavahelioformaggio.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "deputado_federal")
public class DeputadoFederal extends Candidato{
    private String codigoFederal;
}
