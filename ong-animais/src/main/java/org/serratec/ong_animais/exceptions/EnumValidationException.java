package org.serratec.ong_animais.exceptions;

public class EnumValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EnumValidationException(String message) {
		super(message);
	}
}