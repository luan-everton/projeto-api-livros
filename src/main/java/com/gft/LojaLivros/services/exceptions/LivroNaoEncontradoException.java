package com.gft.LojaLivros.services.exceptions;

public class LivroNaoEncontradoException extends  RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5197788311394097194L;


	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	

	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
