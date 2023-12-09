package com.app.esg.esgcore.exception;

public class AtividadeNaoExistenteException extends RuntimeException {

    public AtividadeNaoExistenteException() {
    }

    public AtividadeNaoExistenteException(String message) {
        super(message);
    }

    public AtividadeNaoExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
}
