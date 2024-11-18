package br.edu.infnet.projetoarqjavahelioformaggio.model.domain;

import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name = "deputado_estadual")
public class DeputadoEstadual extends Candidato{

    private String codigoEstadual;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_uf", nullable = false)
    @NotNull(message = "O Estado é obrigatório")
    private Uf uf;

    public DeputadoEstadual(@NonNull String nome, @NonNull int numeroPartido, @NonNull boolean ativo, @NonNull String codigo) {
        super(nome, numeroPartido, ativo, codigo);
    }

    public DeputadoEstadual() {
        super();
    }
}
