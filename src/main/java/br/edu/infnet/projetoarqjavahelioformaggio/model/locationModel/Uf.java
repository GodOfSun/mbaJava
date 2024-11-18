package br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel;

import br.edu.infnet.projetoarqjavahelioformaggio.core.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "uf")
public class Uf extends BaseEntity {

    @NotBlank(message = "O nome do estado é obrigatório")
    @Size(min = 2, max = 100, message = "O nome do estado deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotBlank(message = "O código do estado é obrigatório")
    @Size(min = 1, max = 2, message = "A sigla do estado deve ter 1 ou 2 caracteres")
    @Column(name = "sigla", unique = true)
    private String sigla;

    @NotNull(message = "O código da uf é obrigatório")
    @Column(name = "code", unique = true)
    private Integer code;

    public Uf(UfDTO ufDTO) {
        if (ufDTO == null) return;
        this.nome = ufDTO.getNome();
        this.sigla = ufDTO.getSigla();
        this.code = ufDTO.getId();
    }

    public Uf() {

    }
}
