package br.edu.utfpr.cm.tsi.pi.sistemaru.exceptions;

import java.io.Serializable;

public class PersistanceException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public PersistanceException(String message) {
		super(message);
	}

	public PersistanceException(Exception cause) {
		super(cause);
	}

}