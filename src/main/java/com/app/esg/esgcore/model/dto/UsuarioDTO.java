package com.app.esg.esgcore.model.dto;

import com.app.esg.esgcore.model.Atividade;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UsuarioDTO {

    private String nomeCompleto;

    private String email;

    private List<AtividadeDTO> atividades = new ArrayList<>();

}
