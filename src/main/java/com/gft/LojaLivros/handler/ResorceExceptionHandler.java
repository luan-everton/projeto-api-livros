package com.gft.LojaLivros.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gft.LojaLivros.domain.DetalhesError;
import com.gft.LojaLivros.services.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResorceExceptionHandler {
	
	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalhesError>HandleLivroNaoEncontradoException(LivroNaoEncontradoException e, HttpServletRequest Request){
		
		
		DetalhesError erro = new DetalhesError();
		erro.setStatus(404l);
		erro.setTitulo("O livro não pode ser encontrado");
		erro.setMensagemDesenvolvedor("http://errors.LojaLivros.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}
