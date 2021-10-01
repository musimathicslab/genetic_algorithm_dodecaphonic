package it.unisa.dia.music.etn.exception;

public class InvalidIntervalException extends Exception {
	public InvalidIntervalException() {
		super();
	}
	
	public InvalidIntervalException(String message) {
		super(message);
	}
	
	public InvalidIntervalException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
	private static final long serialVersionUID = 512276269221162367L;
}
