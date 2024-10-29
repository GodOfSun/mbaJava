package br.edu.infnet.projetoarqjavahelioformaggio.model;

import lombok.Data;

@Data
public class Cidade {
    private String nome;
    private Uf estado;
    private String code;
}
