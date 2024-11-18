package br.edu.infnet.projetoarqjavahelioformaggio.model.domain;

import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Cidade;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "prefeito")
public class Prefeito extends Candidato{
    private String codigoPrefeito;

    @ManyToOne
    @JoinColumn(name = "id_uf", nullable = false)
    @NotNull(message = "O Estado é obrigatório")
    private Uf uf;

    @ManyToOne
    @JoinColumn(name = "id_cidade", nullable = false)
    @NotNull(message = "A cidade é obrigatória")
    private Cidade cidade;
}
