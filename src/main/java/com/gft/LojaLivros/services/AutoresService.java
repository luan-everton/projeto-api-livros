package com.gft.LojaLivros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.LojaLivros.domain.Autor;
import com.gft.LojaLivros.repository.AutoresRepository;
import com.gft.LojaLivros.services.exceptions.AutorExistenteException;
import com.gft.LojaLivros.services.exceptions.AutorNaoEncontradoException;


@Service
public class AutoresService {
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor>listar(){
		return autoresRepository.findAll();
		
	}
	
	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
		Optional<Autor> a = autoresRepository.findById(autor.getId());
		 if(a !=null) {
			 throw new AutorExistenteException("o autor ja existe .");
		 }
		}
		return autoresRepository.save(autor);
	}
	
	public Optional<Autor> buscar (Long id) {
	Optional<Autor>autor = autoresRepository.findById(id);
		if(autor.isPresent()) {
			
		} else {
			throw new AutorNaoEncontradoException("O autor não foi encontrado.");
		}
		return autor;
	}
	
	

	

}
