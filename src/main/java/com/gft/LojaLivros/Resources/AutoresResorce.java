package com.gft.LojaLivros.Resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gft.LojaLivros.domain.Autor;
import com.gft.LojaLivros.services.AutoresService;

import io.swagger.annotations.Api;
@Api(tags ="Livros")
@RestController
@RequestMapping("/autores")
public class AutoresResorce {

	@Autowired
	private AutoresService autoresService ;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Autor>> listar(){
		List<Autor> autores = autoresService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(autores);
	}

	@RequestMapping(method = RequestMethod.POST )
	public ResponseEntity<Void> salvar(@Valid @RequestBody Autor autor){
	autor = autoresService.salvar(autor)	;
	URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getId()).toUri();
	
	return ResponseEntity.created(uri).build(); 
	
	
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Autor>> buscar(@PathVariable Long id){
		Optional<Autor> autor = autoresService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(autor);
	}
	
	
}