package com.app.esg.esgcore.repository;

import com.app.esg.esgcore.model.Atividade;
import com.app.esg.esgcore.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    List<Atividade> findAllByUsuario(Usuario usuario);
}
