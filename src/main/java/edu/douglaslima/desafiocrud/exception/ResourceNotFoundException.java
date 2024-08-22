package edu.douglaslima.desafiocrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Recurso não encontrado")
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super();
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	
	public ResourceNotFoundException(String msg, Object... params) {
		super(String.format(msg, params));
	}
	
	public ResourceNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public ResourceNotFoundException(String msg, Throwable cause, Object... params) {
		super(String.format(msg, params), cause);
	}

}
