package com.app.esg.esgcore.service;


import com.app.esg.esgcore.exception.AtividadeNaoExistenteException;
import com.app.esg.esgcore.exception.UsuarioNaoExistenteException;
import com.app.esg.esgcore.mapper.AtividadeMapper;
import com.app.esg.esgcore.model.Atividade;
import com.app.esg.esgcore.model.Usuario;
import com.app.esg.esgcore.model.dto.AtividadeDTO;
import com.app.esg.esgcore.repository.AtividadeRepository;
import com.app.esg.esgcore.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<AtividadeDTO> retornaTodasAtividades() {
        List<AtividadeDTO> dtos = new ArrayList<>();
        repository.findAll().forEach(user -> dtos.add(AtividadeMapper.convertToDTO(user)));
        return dtos;
    }

    public AtividadeDTO retornaAtividadePorId(Long atividadeId) {
        Optional<Atividade> atividade = repository.findById(atividadeId);
        if(atividade.isEmpty()) {
            throw new AtividadeNaoExistenteException("Atividade com o id informado nao existe.");
        }
        return AtividadeMapper.convertToDTO(atividade.get());
    }

    public List<AtividadeDTO> retornaAtividadesUsuario(Long usuarioId) {
        List<AtividadeDTO> dtos = new ArrayList<>();
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
        if(usuario.isEmpty()) {
            throw new UsuarioNaoExistenteException("Usuario com o id informado nao existe.");
        }
        repository.findAllByUsuario(usuario.get()).forEach(user -> dtos.add(AtividadeMapper.convertToDTO(user)));
        return dtos;
    }

    public AtividadeDTO salvaAtividadeUsuario(AtividadeDTO dto) {
        Optional<Usuario> usuario = usuarioRepository.findById(dto.getUsuarioId());
        if(usuario.isEmpty()) {
            throw new UsuarioNaoExistenteException("Nao é possivel salvar atividade para um usuario inexistente.");
        }
        Atividade converted = AtividadeMapper.convertToModel(dto);
        converted.setUsuario(usuario.get());
        Atividade atividade = repository.save(converted);
        return AtividadeMapper.convertToDTO(atividade);
    }

    public AtividadeDTO atualizaAtividadeUsuario(Long atividadeId, AtividadeDTO dto) {
        Optional<Usuario> usuario = usuarioRepository.findById(dto.getUsuarioId());
        if(usuario.isEmpty()) {
            throw new UsuarioNaoExistenteException("Nao é possivel atualizar atividade para um usuario inexistente.");
        }
        Optional<Atividade> atividade = repository.findById(atividadeId);
        if(atividade.isEmpty()) {
            throw new AtividadeNaoExistenteException("Atividade com o id informado nao existe.");
        }
        Atividade converted = AtividadeMapper.convertToModel(dto);
        converted.setUsuario(usuario.get());
        converted.setId(atividadeId);
        Atividade retorno = repository.save(converted);
        return AtividadeMapper.convertToDTO(retorno);
    }

    public void deletaAtividadeUsuario(Long atividadeId) {
        Optional<Atividade> atividade = repository.findById(atividadeId);
        if(atividade.isEmpty()) {
            throw new AtividadeNaoExistenteException("Atividade com o id informado nao existe.");
        }
        repository.delete(atividade.get());
    }
}
