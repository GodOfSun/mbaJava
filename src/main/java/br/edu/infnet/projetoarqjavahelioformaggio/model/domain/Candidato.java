package br.edu.infnet.projetoarqjavahelioformaggio.model.domain;

import lombok.Data;

@Data
public class Candidato {
    private String nome;
    private String email;
    private int numeroPartido;
    private boolean ativo;
}
