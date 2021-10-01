package it.unisa.dia.music.etn.exception;

public class InvalidSeriesException extends Exception {
	public InvalidSeriesException() {
		super();
	}
	
	public InvalidSeriesException(String message) {
		super(message);
	}
	
	public InvalidSeriesException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
	private static final long serialVersionUID = -7301049687249879317L;
}
