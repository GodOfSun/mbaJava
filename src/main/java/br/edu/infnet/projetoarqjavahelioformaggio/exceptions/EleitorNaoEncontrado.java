package br.edu.infnet.projetoarqjavahelioformaggio.exceptions;

import java.io.Serial;

public class EleitorNaoEncontrado extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 2L;

    public EleitorNaoEncontrado(String message) {
        super(message);
    }

    public EleitorNaoEncontrado(Throwable cause) {
        super(cause);
    }

    public EleitorNaoEncontrado() {
    }
}
