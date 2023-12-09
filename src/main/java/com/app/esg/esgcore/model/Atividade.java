package com.app.esg.esgcore.model;


import com.app.esg.esgcore.model.enums.Categoria;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    private String descricao;

    private Categoria categoria;

    private LocalDateTime criadoEm;

    @ManyToOne
    private Usuario usuario;


}
