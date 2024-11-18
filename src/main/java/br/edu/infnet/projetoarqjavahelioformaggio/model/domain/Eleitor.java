package br.edu.infnet.projetoarqjavahelioformaggio.model.domain;

import br.edu.infnet.projetoarqjavahelioformaggio.core.BaseEntity;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Cidade;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name = "eleitor")
public class Eleitor extends BaseEntity {

    @NonNull
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve seguir o padrão 000.000.000-00")
    private String cpf;

    @NotBlank(message = "O título eleitoral é obrigatório")
    @Pattern(regexp = "\\d{4}\\s\\d{4}\\s\\d{4}", message = "O título eleitoral deve seguir o padrão 0000 0000 0000")
    private String tituloEleitoral;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_uf", nullable = false)
    @NotNull(message = "A UF é obrigatória")
    private Uf uf;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_cidade", nullable = false)
    @NotNull(message = "A cidade é obrigatória")
    private Cidade cidade;

    public Eleitor() {

    }
}
