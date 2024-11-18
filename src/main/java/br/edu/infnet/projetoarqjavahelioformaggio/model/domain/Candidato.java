package br.edu.infnet.projetoarqjavahelioformaggio.model.domain;

import br.edu.infnet.projetoarqjavahelioformaggio.core.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;

@Data
@MappedSuperclass
public class Candidato extends BaseEntity {

    private @NonNull @Size(min = 3, max = 100) String nome;

    @Email(message = "O e-mail deve ser válido")
    private String email;

    @Min(value = 1, message = "O número do partido deve ser maior que zero")
    @Max(value = 999, message = "O número do partido deve ser menor que 1000")
    private @NonNull
    int numeroPartido;

    private @NonNull
    boolean ativo;

    @PositiveOrZero(message = "O gasto de campanha deve ser zero ou positivo")
    private float gastoCampanha;

    private @NonNull @Size(min = 3, max = 20) String codigo;

    public Candidato() {
    }

    public Candidato(@NonNull String nome, @NonNull int numeroPartido, @NonNull boolean ativo, @NonNull String codigo) {
    }
}
