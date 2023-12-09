package com.app.esg.esgcore.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMECOMPLETO")
    private String nomeCompleto;

    @Column(name = "EMAIL")
    private String email;

    @OneToMany
    @Column(name = "ATIVIDADES")
    @Transient
    private List<Atividade> atividades = new ArrayList<>();

}
