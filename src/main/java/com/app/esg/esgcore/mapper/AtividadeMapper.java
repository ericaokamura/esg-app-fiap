package com.app.esg.esgcore.mapper;

import com.app.esg.esgcore.model.Atividade;
import com.app.esg.esgcore.model.dto.AtividadeDTO;
import com.app.esg.esgcore.model.enums.Categoria;

import java.time.LocalDateTime;

public class AtividadeMapper {

    public static AtividadeDTO convertToDTO(Atividade atividade) {
        AtividadeDTO dto = new AtividadeDTO();
        dto.setId(atividade.getId() != null ? atividade.getId() : null);
        dto.setCategoria(atividade.getCategoria().name());
        dto.setDescricao(atividade.getDescricao());
        dto.setTitulo(atividade.getTitulo());
        dto.setUsuarioId(atividade.getUsuario().getId());
        dto.setCriadoEm(atividade.getCriadoEm().toString());
        return dto;
    }

    public static Atividade convertToModel(AtividadeDTO dto) {
        Atividade atividade = new Atividade();
        atividade.setId(dto.getId() != null ? dto.getId() : null);
        atividade.setCategoria(Categoria.valueOf(dto.getCategoria()));
        atividade.setDescricao(dto.getDescricao());
        atividade.setTitulo(dto.getTitulo());
        if(dto.getCriadoEm() == null) {
            atividade.setCriadoEm(LocalDateTime.now());
        } else {
            atividade.setCriadoEm(LocalDateTime.parse(dto.getCriadoEm()));
        }
        return atividade;
    }
}
