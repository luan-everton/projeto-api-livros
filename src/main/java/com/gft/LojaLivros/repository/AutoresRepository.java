package com.gft.LojaLivros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.LojaLivros.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long>{

}
