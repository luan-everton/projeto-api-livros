package com.gft.LojaLivros.services.exceptions;

public class AutorNaoEncontradoException extends  RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5197788311394097194L;


	public AutorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	

	public AutorNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
