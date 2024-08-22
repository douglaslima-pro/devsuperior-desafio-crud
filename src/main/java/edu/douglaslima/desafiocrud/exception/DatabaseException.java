package edu.douglaslima.desafiocrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Erro no banco de dados")
public class DatabaseException extends RuntimeException {

	public DatabaseException() {
		super();
	}
	
	public DatabaseException(String msg) {
		super(msg);
	}
	
	public DatabaseException(String msg, Object... params) {
		super(String.format(msg, params));
	}
	
	public DatabaseException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public DatabaseException(String msg, Throwable cause, Object... params) {
		super(String.format(msg, params), cause);
	}

}
