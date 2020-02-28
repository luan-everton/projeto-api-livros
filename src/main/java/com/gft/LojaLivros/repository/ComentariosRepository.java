package com.gft.LojaLivros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.LojaLivros.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long>{

}
