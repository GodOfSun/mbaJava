package br.edu.infnet.projetoarqjavahelioformaggio.exceptions;

import java.io.Serial;

public class CandidatoNaoEncontrado extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public CandidatoNaoEncontrado() {
    }

    public CandidatoNaoEncontrado(String message) {
        super(message);
    }

    public CandidatoNaoEncontrado(Throwable cause) {
        super(cause);
    }
}
