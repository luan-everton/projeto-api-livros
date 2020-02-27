package com.gft.LojaLivros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.LojaLivros.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

}
