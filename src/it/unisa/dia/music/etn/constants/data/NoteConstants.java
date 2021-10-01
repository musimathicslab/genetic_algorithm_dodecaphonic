package it.unisa.dia.music.etn.constants.data;

public interface NoteConstants {
	/* note durations */
    public static final Double WHOLE_NOTE_DURATION     =    1.0;
    public static final Double HALF_NOTE_DURATION      =    0.5;
    public static final Double QUARTER_NOTE_DURATION   =   0.25;
    public static final Double EIGHTH_NOTE_DURATION    =  0.125;
    public static final Double SIXTEENTH_NOTE_DURATION = 0.0625;
    
    public static final Double DEFAULT_NOTE_DURATION   = QUARTER_NOTE_DURATION;
    
    public static final Double[] NOTE_DURATIONS = new Double[] {
    	WHOLE_NOTE_DURATION,
    	HALF_NOTE_DURATION,
    	QUARTER_NOTE_DURATION,
    	EIGHTH_NOTE_DURATION,
    	SIXTEENTH_NOTE_DURATION
    };
    
    /* note values */
	public static final Integer DEFAULT_NOTE_VALUE =  0;
	public static final Integer REST_VALUE         = -1;
}
