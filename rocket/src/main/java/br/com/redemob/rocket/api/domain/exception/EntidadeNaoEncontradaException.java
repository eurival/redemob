package br.com.redemob.rocket.api.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntidadeNaoEncontradaException extends RuntimeException{
	/**    
	 * 	Auxilia no tratamento de menssagens da API.
	 */
	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
