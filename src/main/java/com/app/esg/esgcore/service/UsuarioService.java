package com.app.esg.esgcore.service;


import com.app.esg.esgcore.exception.AtividadeNaoExistenteException;
import com.app.esg.esgcore.exception.UsuarioJaExistenteException;
import com.app.esg.esgcore.exception.UsuarioNaoExistenteException;
import com.app.esg.esgcore.mapper.AtividadeMapper;
import com.app.esg.esgcore.mapper.UsuarioMapper;
import com.app.esg.esgcore.model.Atividade;
import com.app.esg.esgcore.model.Usuario;
import com.app.esg.esgcore.model.dto.AtividadeDTO;
import com.app.esg.esgcore.model.dto.UsuarioDTO;
import com.app.esg.esgcore.repository.AtividadeRepository;
import com.app.esg.esgcore.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;


    public List<UsuarioDTO> retornaTodosUsuarios() {
        List<UsuarioDTO> dtos = new ArrayList<>();
        repository.findAll().forEach(user -> dtos.add(UsuarioMapper.convertToDTO(user)));
        return dtos;
    }

    public UsuarioDTO retornaUsuario(Long usuarioId) {
        Optional<Usuario> usuario = repository.findById(usuarioId);
        if(usuario.isEmpty()) {
            throw new UsuarioNaoExistenteException("Usuario com o id informado nao existe.");
        }
        return UsuarioMapper.convertToDTO(usuario.get());
    }

    public UsuarioDTO salvaUsuario(UsuarioDTO dto) {
        Optional<Usuario> usuario = repository.findByEmail(dto.getEmail());
        if(usuario.isPresent()) {
            throw new UsuarioJaExistenteException("Nao é possivel salvar, usuario ja existente.");
        }
        Usuario retorno = repository.save(UsuarioMapper.convertToModel(dto));
        return UsuarioMapper.convertToDTO(retorno);
    }

    public UsuarioDTO atualizaUsuario(Long usuarioId, UsuarioDTO dto) {
        Optional<Usuario> usuario = repository.findById(usuarioId);
        if(usuario.isEmpty()) {
            throw new UsuarioNaoExistenteException("Usuario com o id informado nao existe.");
        }
        Usuario retorno = repository.save(UsuarioMapper.convertToModel(dto));
        return UsuarioMapper.convertToDTO(retorno);
    }

    public void deletaUsuario(Long usuarioId) {
        Optional<Usuario> usuario = repository.findById(usuarioId);
        if(usuario.isEmpty()) {
            throw new UsuarioNaoExistenteException("Usuario com o id informado nao existe.");
        }
        repository.delete(usuario.get());
    }
}
