package com.gft.LojaLivros.services.exceptions;

public class AutorExistenteException extends  RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5197788311394097194L;


	public AutorExistenteException(String mensagem) {
		super(mensagem);
	}
	

	public AutorExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
