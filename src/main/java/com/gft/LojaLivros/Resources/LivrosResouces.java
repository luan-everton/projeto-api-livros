package com.gft.LojaLivros.Resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gft.LojaLivros.domain.Comentario;
import com.gft.LojaLivros.domain.Livro;
import com.gft.LojaLivros.services.LivrosService;

@RestController

@RequestMapping("/livros")
public class LivrosResouces {
	
	@Autowired
	private LivrosService livrosService;

	
	@GetMapping
	public ResponseEntity <List<Livro>> Listar() {
		
		return  ResponseEntity.status(HttpStatus.OK).body(livrosService.listar()) ;
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	 public ResponseEntity<Void> salvar(@Valid @RequestBody Livro livro) {
		 livro = livrosService.salvar(livro);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				 .path("/{id}").buildAndExpand(livro.getId()).toUri();
		 return ResponseEntity.created(uri).build();
		 
	 }
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar (@PathVariable("id")  Long id) { 
	Optional<Livro> livro = livrosService.buscar(id);
	
	CacheControl cacheControl = CacheControl.maxAge(30, TimeUnit.SECONDS);
			
			
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(livro);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		livrosService.deletar(id);
		
		 return ResponseEntity.noContent().build();
		
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar (@RequestBody Livro livro,  @PathVariable("id")  Long id) {
	
		livro.setId(id);
		livrosService.atualizar(livro);
		
		return ResponseEntity.noContent().build();
		
  }
	@RequestMapping(value ="/{id}/comentarios",method = RequestMethod.POST)
	public ResponseEntity<Void> adicionarComentario(@PathVariable("id") Long livroId, @RequestBody Comentario comentario ) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		comentario.setUsuario(auth.getName());
		livrosService.salvarComentario(livroId , comentario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		
		return ResponseEntity.created(uri).build();
	}
	@GetMapping("/{id}/comentarios")
	public ResponseEntity<List<Comentario>> listarComentarios(@PathVariable("id") Long livroId){
		
		List<Comentario> comentarios = livrosService.listarComentario(livroId);
		
		return ResponseEntity.status(HttpStatus.OK).body(comentarios);
		
	}
	
}

