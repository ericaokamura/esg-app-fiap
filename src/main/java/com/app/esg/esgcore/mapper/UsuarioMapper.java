package com.app.esg.esgcore.mapper;

import com.app.esg.esgcore.model.Atividade;
import com.app.esg.esgcore.model.Usuario;
import com.app.esg.esgcore.model.dto.AtividadeDTO;
import com.app.esg.esgcore.model.dto.UsuarioDTO;
import com.app.esg.esgcore.model.enums.Categoria;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {

    public static UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setEmail(usuario.getEmail());
        dto.setNomeCompleto(usuario.getNomeCompleto());
        List<AtividadeDTO> atividades = new ArrayList<>();
        if(usuario.getAtividades() != null) {
            usuario.getAtividades().forEach(atividade -> atividades.add(AtividadeMapper.convertToDTO(atividade)));
        }
        dto.setAtividades(atividades);
        return dto;
    }

    public static Usuario convertToModel(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setNomeCompleto(dto.getNomeCompleto());
        List<Atividade> atividades = new ArrayList<>();
        dto.getAtividades().forEach(atividade -> atividades.add(AtividadeMapper.convertToModel(atividade)));
        usuario.setAtividades(atividades);
        return usuario;
    }
}
