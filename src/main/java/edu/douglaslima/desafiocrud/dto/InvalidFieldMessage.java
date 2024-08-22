package edu.douglaslima.desafiocrud.dto;

public class InvalidFieldMessage {

	private String fieldName;
	private String message;
	
	public InvalidFieldMessage(String fieldName, String message) {
		this.fieldName = fieldName;
		this.message = message;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public String getMessage() {
		return message;
	}
	
}
