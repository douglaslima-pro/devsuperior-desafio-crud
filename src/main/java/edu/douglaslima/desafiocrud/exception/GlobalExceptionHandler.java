package edu.douglaslima.desafiocrud.exception;

import java.time.Instant;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import edu.douglaslima.desafiocrud.dto.CustomError;
import edu.douglaslima.desafiocrud.dto.InvalidFieldMessage;
import edu.douglaslima.desafiocrud.dto.ValidationError;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomError> handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
		CustomError errorBody = new CustomError(Instant.now(), HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorBody);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<CustomError> handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
		CustomError errorBody = new CustomError(Instant.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationError errorBody = new ValidationError(Instant.now(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Dados inválidos", request.getRequestURI());
		e.getFieldErrors().forEach(error -> {
			errorBody.addError(new InvalidFieldMessage(error.getField(), error.getDefaultMessage()));
		});
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorBody);
	}
	
}
