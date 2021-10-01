package it.unisa.dia.music.etn.exception;

public class InvalidNoteException extends Exception {
	public InvalidNoteException() {
		super();
	}
	
	public InvalidNoteException(String message) {
		super(message);
	}
	
	public InvalidNoteException(String message, Throwable cause) {
		super(message, cause);
	}

	
	private static final long serialVersionUID = 7488062701915405654L;
}
