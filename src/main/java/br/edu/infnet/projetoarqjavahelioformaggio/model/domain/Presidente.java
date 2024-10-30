package br.edu.infnet.projetoarqjavahelioformaggio.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "presidente")
public class Presidente extends Candidato{
    private String codigoPresidente;
}
