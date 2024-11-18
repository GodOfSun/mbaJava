package br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel;

import br.edu.infnet.projetoarqjavahelioformaggio.core.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "cidade")
public class Cidade extends BaseEntity {

    @NotBlank(message = "O nome da cidade é obrigatório")
    @Size(min = 2, max = 100, message = "O nome da cidade deve ter entre 2 e 100 caracteres")
    private String nome;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_estado", nullable = false)
    @NotNull(message = "O estado é obrigatório")
    private Uf estado;

    @NotNull(message = "O código da cidade é obrigatório")
    @Column(name = "code", unique = true)
    private Integer code;

    public Cidade(CidadeDTO cidadeDTO) {
        if (cidadeDTO == null) return;
        setNome(cidadeDTO.getNome());
        setCode(cidadeDTO.getId());
        setEstado(new Uf(cidadeDTO.getUf()));
    }

    public Cidade() {

    }
}
