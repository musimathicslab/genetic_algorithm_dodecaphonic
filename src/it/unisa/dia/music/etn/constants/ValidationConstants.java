package it.unisa.dia.music.etn.constants;

public interface ValidationConstants {
	// costanti relative al tipo di problema
	public static final int ERROR = 0;
	public static final int WARNING = 1;
	
	public static final String ERROR_TXT   = "error";
	public static final String WARNING_TXT = "warning";
	
	public static final int ERROR_INCROCIO = 2;
	
	// costanti relative agli errori di moto retto
	public static final int ERROR_UNISONO = 3;
	public static final int ERROR_QUINTA_PARALLELA = 4;
	public static final int ERROR_OTTAVA_PARALLELA = 5;
	public static final int ERROR_UNISONO_NASCOSTO = 6;
	public static final int ERROR_QUINTA_NASCOSTA = 7;
	public static final int ERROR_OTTAVA_NASCOSTA = 8;

	// costanti relative alle eccezioni per gli errori di moto retto
	public static final int WARNING_UNISONO_NASCOSTO = 9;
	public static final int WARNING_OTTAVA_NASCOSTA = 10;
	public static final int WARNING_QUINTA_NASCOSTA = 11;
	
	// costanti relative agli errori nella costruzione degli accordi
	public static final int ERROR_UNKNOWN_ACCORD = 12;
	
	public static final String ERROR_MSG_INCROCIO = "Incrocio";
	
	// costanti relative ai messaggi di errore di moto retto
	public static final String ERROR_MSG_UNISONO = "Unisono";
	public static final String ERROR_MSG_QUINTA_PARALLELA = "Quinte parallele";
	public static final String ERROR_MSG_OTTAVA_PARALLELA = "Ottave parallele";
	public static final String ERROR_MSG_UNISONO_NASCOSTO = "Unisono nascosto";
	public static final String ERROR_MSG_QUINTA_NASCOSTA = "Quinta nascosta";
	public static final String ERROR_MSG_OTTAVA_NASCOSTA = "Ottava nascosta";

	// costanti relative ai messaggi relativi alle eccezioni per gli errori di moto retto
	public static final String WARNING_MSG_UNISONO_NASCOSTO = "Unisono nascosto ammesso";
	public static final String WARNING_MSG_OTTAVA_NASCOSTA = "Ottava nascosta ammessa";
	public static final String WARNING_MSG_QUINTA_NASCOSTA = "Quinta nascosta ammessa";
	
	// costanti relative ai messaggi relativi agli errori nella costruzione degli accordi
	public static final String MSG_UNKNOWN_ACCORD = "Accord sconosciuto";
	
	public static final String NO_DESCRIPTION = "Nessuna descrizione disponibile";	
	
	public static final int[][] BENEFITS = { { 20, 12, 12, 20, 20, 16, 0}, 
		                                     { 10, 25, 10, 15, 25, 15, 0},
		                                     { 10, 10, 25, 20, 10, 25, 0},
		                                     { 15, 15, 10, 25, 25, 10, 0},
		                                     { 25, 10, 10, 15, 25, 15, 0},
		                                     { 10, 20, 15, 15, 20, 20, 0},
		                                     { 25,  5, 25,  5,  5, 10, 25}
	                                       };
}
