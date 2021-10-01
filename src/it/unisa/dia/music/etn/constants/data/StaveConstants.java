package it.unisa.dia.music.etn.constants.data;

import java.awt.Color;

public interface StaveConstants {
	// costanti relative alle durate delle note e delle pause
    public static final double WHOLE_NOTE_DURATION     = 1.0;
    public static final double HALF_NOTE_DURATION      = 0.5;
    public static final double QUARTER_NOTE_DURATION   = 0.25;
    public static final double EIGHTH_NOTE_DURATION    = 0.125;
    public static final double SIXTEENTH_NOTE_DURATION = 0.0625;
    
    // costanti relative ai simboli delle note e delle pause
    public static final String WHOLE_NOTE_SYMBOL     = "w";
    public static final String HALF_NOTE_SYMBOL      = "h";
    public static final String QUARTER_NOTE_SYMBOL   = "q";
    public static final String EIGHTH_NOTE_SYMBOL    = "i";
    public static final String SIXTEENTH_NOTE_SYMBOL = "s";
    
    
    // costanti relative ai simboli utilizzati per le note
    public static final String C_NOTE_SYMBOL = "C";
    public static final String D_NOTE_SYMBOL = "D";
    public static final String E_NOTE_SYMBOL = "E";
    public static final String F_NOTE_SYMBOL = "F";
    public static final String G_NOTE_SYMBOL = "G";
    public static final String A_NOTE_SYMBOL = "A";
    public static final String B_NOTE_SYMBOL = "B";

    // costante relativo al simbolo utilizzato per le pause
    public static final String REST_SYMBOL = "R";
    
    // costanti relative ai simboli utilizzati per le alterazioni
    public static final String SHARP_SYMBOL    = "#";
    public static final String FLAT_SYMBOL     = "b";
    public static final String NO_ALTER_SYMBOL = "";
    
    public static final String MAJOR_SYMBOL = "maj";
    public static final String MINOR_SYMBOL = "min";
    
    public static final String [] SHARP_NOTES_SEQUENCE = { F_NOTE_SYMBOL + SHARP_SYMBOL, C_NOTE_SYMBOL + SHARP_SYMBOL, G_NOTE_SYMBOL + SHARP_SYMBOL, D_NOTE_SYMBOL + SHARP_SYMBOL, A_NOTE_SYMBOL + SHARP_SYMBOL, E_NOTE_SYMBOL + SHARP_SYMBOL, B_NOTE_SYMBOL + SHARP_SYMBOL };
    public static final String [] FLAT_NOTES_SEQUENCE  = { B_NOTE_SYMBOL + FLAT_SYMBOL, E_NOTE_SYMBOL + FLAT_SYMBOL, A_NOTE_SYMBOL + FLAT_SYMBOL, D_NOTE_SYMBOL + FLAT_SYMBOL, G_NOTE_SYMBOL + FLAT_SYMBOL, C_NOTE_SYMBOL + FLAT_SYMBOL, F_NOTE_SYMBOL + FLAT_SYMBOL };
    
    // costanti relative alle scale
    public static final String [] C_MAJ_SCALE =       { C_NOTE_SYMBOL, D_NOTE_SYMBOL, E_NOTE_SYMBOL, F_NOTE_SYMBOL, G_NOTE_SYMBOL, A_NOTE_SYMBOL, B_NOTE_SYMBOL };
    public static final String [] G_MAJ_SCALE =       { G_NOTE_SYMBOL, A_NOTE_SYMBOL, B_NOTE_SYMBOL, C_NOTE_SYMBOL, D_NOTE_SYMBOL, E_NOTE_SYMBOL, F_NOTE_SYMBOL + SHARP_SYMBOL };
    public static final String [] D_MAJ_SCALE =       { D_NOTE_SYMBOL, E_NOTE_SYMBOL, F_NOTE_SYMBOL + SHARP_SYMBOL, G_NOTE_SYMBOL, A_NOTE_SYMBOL, B_NOTE_SYMBOL, C_NOTE_SYMBOL + SHARP_SYMBOL };
    public static final String [] A_MAJ_SCALE =       { A_NOTE_SYMBOL, B_NOTE_SYMBOL, C_NOTE_SYMBOL + SHARP_SYMBOL, D_NOTE_SYMBOL, E_NOTE_SYMBOL, F_NOTE_SYMBOL + SHARP_SYMBOL, G_NOTE_SYMBOL + SHARP_SYMBOL };
    public static final String [] E_MAJ_SCALE =       { E_NOTE_SYMBOL, F_NOTE_SYMBOL + SHARP_SYMBOL, G_NOTE_SYMBOL + SHARP_SYMBOL, A_NOTE_SYMBOL, B_NOTE_SYMBOL, C_NOTE_SYMBOL + SHARP_SYMBOL, D_NOTE_SYMBOL + SHARP_SYMBOL };
    public static final String [] B_MAJ_SCALE =       { B_NOTE_SYMBOL, C_NOTE_SYMBOL + SHARP_SYMBOL, D_NOTE_SYMBOL + SHARP_SYMBOL, E_NOTE_SYMBOL, F_NOTE_SYMBOL + SHARP_SYMBOL, G_NOTE_SYMBOL + SHARP_SYMBOL, A_NOTE_SYMBOL + SHARP_SYMBOL };
    public static final String [] F_SHARP_MAJ_SCALE = { F_NOTE_SYMBOL + SHARP_SYMBOL, G_NOTE_SYMBOL + SHARP_SYMBOL, A_NOTE_SYMBOL + SHARP_SYMBOL, B_NOTE_SYMBOL, C_NOTE_SYMBOL + SHARP_SYMBOL, D_NOTE_SYMBOL + SHARP_SYMBOL, E_NOTE_SYMBOL + SHARP_SYMBOL };
    public static final String [] C_SHARP_MAJ_SCALE = { C_NOTE_SYMBOL + SHARP_SYMBOL, D_NOTE_SYMBOL + SHARP_SYMBOL, E_NOTE_SYMBOL + SHARP_SYMBOL, F_NOTE_SYMBOL + SHARP_SYMBOL, G_NOTE_SYMBOL + SHARP_SYMBOL, A_NOTE_SYMBOL + SHARP_SYMBOL, B_NOTE_SYMBOL + SHARP_SYMBOL};
    public static final String [] F_MAJ_SCALE =       { F_NOTE_SYMBOL, G_NOTE_SYMBOL, A_NOTE_SYMBOL, B_NOTE_SYMBOL + FLAT_SYMBOL, C_NOTE_SYMBOL, D_NOTE_SYMBOL, E_NOTE_SYMBOL };
    public static final String [] B_FLAT_MAJ_SCALE =  { B_NOTE_SYMBOL + FLAT_SYMBOL, C_NOTE_SYMBOL, D_NOTE_SYMBOL, E_NOTE_SYMBOL + FLAT_SYMBOL, F_NOTE_SYMBOL, G_NOTE_SYMBOL, A_NOTE_SYMBOL };
    public static final String [] E_FLAT_MAJ_SCALE =  { E_NOTE_SYMBOL + FLAT_SYMBOL, F_NOTE_SYMBOL, G_NOTE_SYMBOL, A_NOTE_SYMBOL + FLAT_SYMBOL, B_NOTE_SYMBOL + FLAT_SYMBOL, C_NOTE_SYMBOL, D_NOTE_SYMBOL };
    public static final String [] A_FLAT_MAJ_SCALE =  { A_NOTE_SYMBOL + FLAT_SYMBOL, B_NOTE_SYMBOL + FLAT_SYMBOL, C_NOTE_SYMBOL, D_NOTE_SYMBOL + FLAT_SYMBOL, E_NOTE_SYMBOL + FLAT_SYMBOL, F_NOTE_SYMBOL, G_NOTE_SYMBOL }; 
    public static final String [] D_FLAT_MAJ_SCALE =  { D_NOTE_SYMBOL + FLAT_SYMBOL, E_NOTE_SYMBOL + FLAT_SYMBOL, F_NOTE_SYMBOL, G_NOTE_SYMBOL + FLAT_SYMBOL, A_NOTE_SYMBOL + FLAT_SYMBOL, B_NOTE_SYMBOL + FLAT_SYMBOL, C_NOTE_SYMBOL };
    public static final String [] G_FLAT_MAJ_SCALE =  { G_NOTE_SYMBOL + FLAT_SYMBOL, A_NOTE_SYMBOL + FLAT_SYMBOL, B_NOTE_SYMBOL + FLAT_SYMBOL, C_NOTE_SYMBOL + FLAT_SYMBOL, D_NOTE_SYMBOL + FLAT_SYMBOL, E_NOTE_SYMBOL + FLAT_SYMBOL, F_NOTE_SYMBOL };
    public static final String [] C_FLAT_MAJ_SCALE =  { C_NOTE_SYMBOL + FLAT_SYMBOL, D_NOTE_SYMBOL + FLAT_SYMBOL, E_NOTE_SYMBOL + FLAT_SYMBOL, F_NOTE_SYMBOL + FLAT_SYMBOL, G_NOTE_SYMBOL + FLAT_SYMBOL, A_NOTE_SYMBOL + FLAT_SYMBOL, B_NOTE_SYMBOL + FLAT_SYMBOL };
    
    public static final String [] A_MIN_SCALE =       { A_NOTE_SYMBOL, B_NOTE_SYMBOL,C_NOTE_SYMBOL, D_NOTE_SYMBOL, E_NOTE_SYMBOL, F_NOTE_SYMBOL, G_NOTE_SYMBOL };
    public static final String [] E_MIN_SCALE =       { E_NOTE_SYMBOL, F_NOTE_SYMBOL + SHARP_SYMBOL, G_NOTE_SYMBOL, A_NOTE_SYMBOL, B_NOTE_SYMBOL, C_NOTE_SYMBOL, D_NOTE_SYMBOL };
    public static final String [] B_MIN_SCALE =       { B_NOTE_SYMBOL, C_NOTE_SYMBOL + SHARP_SYMBOL,D_NOTE_SYMBOL, E_NOTE_SYMBOL, F_NOTE_SYMBOL + SHARP_SYMBOL, G_NOTE_SYMBOL, A_NOTE_SYMBOL };
    public static final String [] F_SHARP_MIN_SCALE = { F_NOTE_SYMBOL + SHARP_SYMBOL, G_NOTE_SYMBOL + SHARP_SYMBOL,A_NOTE_SYMBOL, B_NOTE_SYMBOL, C_NOTE_SYMBOL + SHARP_SYMBOL, D_NOTE_SYMBOL, E_NOTE_SYMBOL};
    public static final String [] C_SHARP_MIN_SCALE = { C_NOTE_SYMBOL + SHARP_SYMBOL, D_NOTE_SYMBOL + SHARP_SYMBOL,E_NOTE_SYMBOL, F_NOTE_SYMBOL + SHARP_SYMBOL, G_NOTE_SYMBOL + SHARP_SYMBOL, A_NOTE_SYMBOL, B_NOTE_SYMBOL };
    public static final String [] G_SHARP_MIN_SCALE = { G_NOTE_SYMBOL + SHARP_SYMBOL, A_NOTE_SYMBOL + SHARP_SYMBOL,B_NOTE_SYMBOL, C_NOTE_SYMBOL + SHARP_SYMBOL, D_NOTE_SYMBOL + SHARP_SYMBOL, E_NOTE_SYMBOL, F_NOTE_SYMBOL + SHARP_SYMBOL };
    public static final String [] D_SHARP_MIN_SCALE = { D_NOTE_SYMBOL + SHARP_SYMBOL, E_NOTE_SYMBOL + SHARP_SYMBOL,F_NOTE_SYMBOL + SHARP_SYMBOL, G_NOTE_SYMBOL + SHARP_SYMBOL, A_NOTE_SYMBOL + SHARP_SYMBOL, B_NOTE_SYMBOL, C_NOTE_SYMBOL + SHARP_SYMBOL };
    public static final String [] A_SHARP_MIN_SCALE = { A_NOTE_SYMBOL + SHARP_SYMBOL, B_NOTE_SYMBOL + SHARP_SYMBOL, C_NOTE_SYMBOL + SHARP_SYMBOL, D_NOTE_SYMBOL + SHARP_SYMBOL, E_NOTE_SYMBOL + SHARP_SYMBOL, F_NOTE_SYMBOL + SHARP_SYMBOL, G_NOTE_SYMBOL + SHARP_SYMBOL};
    public static final String [] D_MIN_SCALE =       { D_NOTE_SYMBOL, E_NOTE_SYMBOL, F_NOTE_SYMBOL, G_NOTE_SYMBOL, A_NOTE_SYMBOL, B_NOTE_SYMBOL + FLAT_SYMBOL, C_NOTE_SYMBOL};
    public static final String [] G_MIN_SCALE =       { G_NOTE_SYMBOL, A_NOTE_SYMBOL, B_NOTE_SYMBOL + FLAT_SYMBOL, C_NOTE_SYMBOL, D_NOTE_SYMBOL, E_NOTE_SYMBOL + FLAT_SYMBOL, F_NOTE_SYMBOL };
    public static final String [] C_MIN_SCALE =       { C_NOTE_SYMBOL, D_NOTE_SYMBOL, E_NOTE_SYMBOL + FLAT_SYMBOL, F_NOTE_SYMBOL, G_NOTE_SYMBOL, A_NOTE_SYMBOL + FLAT_SYMBOL, B_NOTE_SYMBOL + FLAT_SYMBOL }; 
    public static final String [] F_MIN_SCALE =       { F_NOTE_SYMBOL, G_NOTE_SYMBOL, A_NOTE_SYMBOL + FLAT_SYMBOL, B_NOTE_SYMBOL + FLAT_SYMBOL, C_NOTE_SYMBOL, D_NOTE_SYMBOL + FLAT_SYMBOL, E_NOTE_SYMBOL + FLAT_SYMBOL};
    public static final String [] B_FLAT_MIN_SCALE =  { B_NOTE_SYMBOL + FLAT_SYMBOL, C_NOTE_SYMBOL, D_NOTE_SYMBOL + FLAT_SYMBOL, E_NOTE_SYMBOL + FLAT_SYMBOL, F_NOTE_SYMBOL, G_NOTE_SYMBOL + FLAT_SYMBOL, A_NOTE_SYMBOL + FLAT_SYMBOL };
    public static final String [] E_FLAT_MIN_SCALE =  { E_NOTE_SYMBOL + FLAT_SYMBOL, F_NOTE_SYMBOL, G_NOTE_SYMBOL + FLAT_SYMBOL, A_NOTE_SYMBOL + FLAT_SYMBOL, B_NOTE_SYMBOL + FLAT_SYMBOL, C_NOTE_SYMBOL + FLAT_SYMBOL, D_NOTE_SYMBOL + FLAT_SYMBOL };
    public static final String [] A_FLAT_MIN_SCALE =  { A_NOTE_SYMBOL + FLAT_SYMBOL, B_NOTE_SYMBOL + FLAT_SYMBOL, C_NOTE_SYMBOL + FLAT_SYMBOL, D_NOTE_SYMBOL + FLAT_SYMBOL, E_NOTE_SYMBOL + FLAT_SYMBOL, F_NOTE_SYMBOL + FLAT_SYMBOL, G_NOTE_SYMBOL + FLAT_SYMBOL };
    
    public static final String[][] SCALES = { C_MAJ_SCALE, G_MAJ_SCALE, D_MAJ_SCALE, A_MAJ_SCALE, E_MAJ_SCALE, B_MAJ_SCALE, F_SHARP_MAJ_SCALE, C_SHARP_MAJ_SCALE, F_MAJ_SCALE, B_FLAT_MAJ_SCALE, E_FLAT_MAJ_SCALE, A_FLAT_MAJ_SCALE, D_FLAT_MAJ_SCALE, G_FLAT_MAJ_SCALE, C_FLAT_MAJ_SCALE,
    										  A_MIN_SCALE, E_MIN_SCALE, B_MIN_SCALE, F_SHARP_MIN_SCALE, C_SHARP_MIN_SCALE, G_SHARP_MIN_SCALE, D_SHARP_MIN_SCALE, A_SHARP_MIN_SCALE, D_MIN_SCALE, G_MIN_SCALE, C_MIN_SCALE, F_MIN_SCALE, B_FLAT_MIN_SCALE, E_FLAT_MIN_SCALE, A_FLAT_MIN_SCALE
    										 };
    
    // costanti relative alle velocity
    public static final int DEFAULT_ATTACK_VELOCITY = 60;
    public static final int DEFAULT_DECAY_VELOCITY  = 60;
    
    // costanti relative alle ottave 
    public static final int FIRST_OCTAVE   = 0;
    public static final int SECOND_OCTAVE  = 1;
    public static final int THIRD_OCTAVE   = 2;
    public static final int FOURTH_OCTAVE  = 3;
    public static final int FIFTH_OCTAVE   = 4;
    public static final int SIXTH_OCTAVE   = 5;
    public static final int SEVENTH_OCTAVE = 6;
    public static final int EIGHTY_OCTAVE  = 7;
    public static final int NINTH_OCTAVE   = 8;
    public static final int TENTH_OCTAVE   = 9;
    
    public static final int MIN_OCTAVE     = FIRST_OCTAVE;
    public static final int MAX_OCTAVE     = TENTH_OCTAVE;
    public static final int DEFAULT_OCTAVE = SIXTH_OCTAVE;
    
    // costanti relative ai valori MIDI delle note
    public static final int MIN_NOTE_VALUE = 0;
    public static final int MAX_NOTE_VALUE = 127;
    
    // costanti relative ai valori di velocity
    public static final int MIN_ATTACK_VELOCITY = 0;
    public static final int MAX_ATTACK_VELOCITY = 127;
    
    public static final int MIN_ATTACK_DECAY = 0;
    public static final int MAX_ATTACK_DECAY = 127;
    
    public static final int DEFAULT_NOTE_VALUE = 60;
    
    public static final Color BG_COLOR = Color.white;
    
    public final int CLEF_CENTER_G = 60;
    
	public final int PREFIX_CENTER_G = 28;
	
    public final int PREFIX_WIDTH = 7;
    
    public static final double[] SHARP_POSITION_FACTORS = new double[] {0.0, 1.5, -0.5, 1.0, 2.5, 0.5, 2.0};
    
    public static final double[] FLAT_POSITION_FACTORS = new double[] {2.0, 0.5, 2.5, 1.0, -0.5, 1.5, 0.0};
    
    public static final int MAX_ALTERATIONS = 7;
}
