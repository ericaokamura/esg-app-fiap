package com.app.esg.esgcore.controller;


import com.app.esg.esgcore.model.dto.AtividadeDTO;
import com.app.esg.esgcore.model.dto.UsuarioDTO;
import com.app.esg.esgcore.service.AtividadeService;
import com.app.esg.esgcore.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @GetMapping()
    public ResponseEntity<List<UsuarioDTO>> retornaTodosUsuarios() {
        return ResponseEntity.ok(service.retornaTodosUsuarios());
    }

    @GetMapping("/{usuario_id}")
    public ResponseEntity<UsuarioDTO> retornaUsuario(@PathVariable("usuario_id") Long usuarioId) {
        return ResponseEntity.ok(service.retornaUsuario(usuarioId));
    }

    @PostMapping()
    public ResponseEntity<UsuarioDTO> salvaUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.status(201).body(service.salvaUsuario(usuarioDTO));
    }

    @PutMapping("/{usuario_id}")
    public ResponseEntity<UsuarioDTO> atualizaUsuario(@PathVariable("usuario_id") Long usuarioId, @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(service.atualizaUsuario(usuarioId, usuarioDTO));
    }

    @DeleteMapping("/{usuario_id}")
    public ResponseEntity<Void> deletaUsuario(@PathVariable("usuario_id") Long usuarioId) {
        service.deletaUsuario(usuarioId);
        return ResponseEntity.ok().build();
    }
}
