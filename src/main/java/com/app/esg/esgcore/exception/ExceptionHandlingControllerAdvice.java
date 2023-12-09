package com.app.esg.esgcore.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingControllerAdvice {

    @ExceptionHandler(UsuarioNaoExistenteException.class)
    public ResponseEntity<Void> usuarioNaoExistenteException(){
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(UsuarioJaExistenteException.class)
    public ResponseEntity<Void> usuarioJaExistenteException(){
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(AtividadeNaoExistenteException.class)
    public ResponseEntity<Void> atividadeNaoExistenteException(){
        return ResponseEntity.badRequest().build();
    }

}
