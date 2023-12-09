package com.app.esg.esgcore.exception;

public class UsuarioNaoExistenteException extends RuntimeException {
    public UsuarioNaoExistenteException() {
    }

    public UsuarioNaoExistenteException(String message) {
        super(message);
    }

    public UsuarioNaoExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
}
