package com.app.esg.esgcore.exception;

public class UsuarioJaExistenteException extends RuntimeException {

    public UsuarioJaExistenteException() {
    }

    public UsuarioJaExistenteException(String message) {
        super(message);
    }

    public UsuarioJaExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
}
