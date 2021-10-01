package it.unisa.dia.music.etn.constants.data;

public interface TwelveNoteConfigurationConstants extends TwelveNoteCompositionConstants, SeriesConstants {
	/* Population size property */
	public static final String PROPERTY_POPULATION_SIZE = "population-size";
	
	/* Maximum number of generations property */
	public static final String PROPERTY_MAX_GENERATIONS = "max-generations";
	
	/* Rythm count property */
	public static final String PROPERTY_RYTHM_COUNT = "rythm-count";
	
	/* Rythm unit property */
	public static final String PROPERTY_RYTHM_UNIT = "rythm-unit";

	/* Reference series property */
	public static final String PROPERTY_REFERENCE_SERIES = "reference-series";
	
	/* Starting series note property */
	public static final String PROPERTY_SERIES_STARTING_NOTE = "series-starting-note"; 
	
	/* Melodic line number property */
	public static final String PROPERTY_MELODIC_LINE_NUMBER = "melodic-line-number";
	
	/* Transformation number property */
	public static final String PROPERTY_TRANSFORMATION_NUMBER = "transformation-number";
	
	
	/* Default population size */
	public static final Integer DEFAULT_POPULATION_SIZE = 50;

	/* Default maximum number of generations */
	public static final Integer DEFAULT_MAX_GENERATIONS = 50;
	
	/* Default melodic line number */
	public static final Integer DEFAULT_MELODIC_LINE_NUMBER = 4;
	
	/* Default transformation number */
	public static final Integer DEFAULT_TRANSFORMATION_NUMBER = 10;
		
	
	/* Configuration properties file */
	public static final String CONFIGURATION_FILE = "conf/configuration.properties";
}
