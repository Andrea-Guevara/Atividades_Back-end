package org.serratec.backend.java2.projetoBorracharia.exception;

public class BorrachariaException extends Exception {

	private static final long serialVersionUID = 1L;

	public BorrachariaException() {
		super();
	}

	public BorrachariaException(String message) {
		super(message);
	}

	public BorrachariaException(String message, Exception cause) {
		super(message, cause);
	}

	public BorrachariaException(Exception e) {
		super(e);
	}
}
