package edu.douglaslima.desafiocrud.exception;

@SuppressWarnings("serial")
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
