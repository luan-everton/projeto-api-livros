package com.gft.LojaLivros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gft.LojaLivros.domain.Livro;
import com.gft.LojaLivros.repository.LivrosRepository;
import com.gft.LojaLivros.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosrepository;
	
	public List<Livro> listar(){
		
		return livrosrepository.findAll();
	}
	
	public Optional<Livro> buscar (Long id) {
		Optional<Livro> livro = livrosrepository.findById(id);
		if(livro.isEmpty()) {
			throw new LivroNaoEncontradoException("O livro não pode ser encontrado.");
		}
		return livro;
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosrepository.save(livro);
	}
	
	public void deletar (Long id) {
		
		try {
			livrosrepository.deleteById(id);

		} catch ( EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O livro não pode ser encontrado.");
		}
		
	}
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livrosrepository.save(livro);
		
	}
	private void verificarExistencia (Livro livro) {
		buscar(livro.getId());
		
	}
	
	
	
	
	
	
	
}





