package com.app.esg.esgcore.controller;


import com.app.esg.esgcore.model.dto.AtividadeDTO;
import com.app.esg.esgcore.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService service;


    @GetMapping()
    public ResponseEntity<List<AtividadeDTO>> retornaTodasAtividades() {
        return ResponseEntity.ok(service.retornaTodasAtividades());
    }

    @GetMapping("/{atividade_id}")
    public ResponseEntity<AtividadeDTO> retornaAtividadePorId(@PathVariable("atividade_id") Long atividadeId) {
        return ResponseEntity.ok(service.retornaAtividadePorId(atividadeId));
    }

    @GetMapping("/usuarios/{usuario_id}")
    public ResponseEntity<List<AtividadeDTO>> retornaAtividadesUsuario(@PathVariable("usuario_id") Long usuarioId) {
        return ResponseEntity.ok(service.retornaAtividadesUsuario(usuarioId));
    }

    @PostMapping()
    public ResponseEntity<AtividadeDTO> salvaAtividadeUsuario(@RequestBody AtividadeDTO atividadeDTO) {
        return ResponseEntity.status(201).body(service.salvaAtividadeUsuario(atividadeDTO));
    }

    @PutMapping("/{atividade_id}")
    public ResponseEntity<AtividadeDTO> atualizaAtividadeUsuario(@PathVariable("atividade_id") Long atividadeId, @RequestBody AtividadeDTO atividadeDTO) {
        return ResponseEntity.ok(service.atualizaAtividadeUsuario(atividadeId, atividadeDTO));
    }

    @DeleteMapping("/{atividade_id}")
    public ResponseEntity<Void> deletaAtividadeUsuario(@PathVariable("atividade_id") Long atividadeId) {
        service.deletaAtividadeUsuario(atividadeId);
        return ResponseEntity.ok().build();
    }
}
