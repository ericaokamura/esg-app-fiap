package com.app.esg.esgcore.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AtividadeDTO {

    private String titulo;

    private String descricao;

    private String categoria;

    private String criadoEm;

    private Long usuarioId;
}
