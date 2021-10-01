package it.unisa.dia.music.etn.constants.data;

import java.awt.Color;

public interface DoubleStaveConstants extends StaveConstants {
	// costanti relative al pentagramma
    public static final int INTERSPACE       = 10; // spazio tra due linee
    public static final int STAVE_INTERSPACE = 80; // spazio tra i due pentagrammi
    public static final int LEFT_MARGIN      = 20;
    public static final int RIGHT_MARGIN     = 60;
    public static final int HEADER           = 50;
    public static final int FOOTER           = 60;
    public static final int HEIGHT           = HEADER + 8 * INTERSPACE + STAVE_INTERSPACE + FOOTER;   
    public static final int WIDTH            = 925;
    
    // costanti relative alla voci
    public static final int BASSO   = 0;
    public static final int TENORE  = 1;
    public static final int ALTO    = 2;
    public static final int SOPRANO = 3;
     
    // costanti relative al valore midi della nota scelta come riferimento per ciascuna voce
    public static final int REF_VALUE_BASSO   = 48;
    public static final int REF_VALUE_TENORE  = 60;
    public static final int REF_VALUE_ALTO    = 60;
    public static final int REF_VALUE_SOPRANO = 72;
    
    // costanti relative alla ordinata in pixel della nota scelta come riferimento per ciascuna voce
    public static final int REF_POSITION_BASSO   = HEADER + INTERSPACE * 4 + STAVE_INTERSPACE + ((INTERSPACE / 2) * 5);
    public static final int REF_POSITION_TENORE  = HEADER + INTERSPACE * 4 + (STAVE_INTERSPACE - 10); // HEADER + INTERSPACE * 5
    public static final int REF_POSITION_ALTO    = HEADER + INTERSPACE * 5;
    public static final int REF_POSITION_SOPRANO = HEADER + ((INTERSPACE / 2) * 3);
    
    // costanti relative alle ottave di riferimento per ciascuna voce
    public static final int REF_OCTAVE_BASSO   = 4;
    public static final int REF_OCTAVE_TENORE  = 5;
    public static final int REF_OCTAVE_ALTO    = 5;
    public static final int REF_OCTAVE_SOPRANO = 6;
    
    public static final int NOTES_ABOVE_BASSO   = 8;
    public static final int NOTES_BENEATH_BASSO = 6; 
    
    public static final int NOTES_ABOVE_TENORE   = 5;
    public static final int NOTES_BENEATH_TENORE = 8; 
    
    public static final int NOTES_ABOVE_ALTO   = 8;
    public static final int NOTES_BENEATH_ALTO = 4; 
    
    public static final int NOTES_ABOVE_SOPRANO   = 6;
    public static final int NOTES_BENEATH_SOPRANO = 8; 
    
    public static final int G_REF_POS = 72;
    public static final int F_REF_POS = 52;
    
	public final static Color BASSO_NOTECOLOR   = Color.black;
	public final static Color TENORE_NOTECOLOR  = new Color(0, 0, 189);
	public final static Color ALTO_NOTECOLOR    = new Color(198, 0, 0);
	public final static Color SOPRANO_NOTECOLOR = new Color(0, 121, 0);
	
    public final int PREFIX_CENTER_F = 18; 
    public final int CLEF_CENTER_F   = 40;
    
    public final int POS_INTERVAL = 200;
    
    public final int[] SHARP_NOTE_OFFSET = { 0, 0, INTERSPACE / 2, INTERSPACE / 2, INTERSPACE, (INTERSPACE / 2) * 3, (INTERSPACE / 2) * 3, INTERSPACE * 2, INTERSPACE * 2, (INTERSPACE / 2) * 5, (INTERSPACE / 2) * 5, INTERSPACE * 3 };
    public final int[] FLAT_NOTE_OFFSET  = { 0, INTERSPACE / 2, INTERSPACE / 2, INTERSPACE, INTERSPACE, (INTERSPACE / 2) * 3, INTERSPACE * 2, INTERSPACE * 2, (INTERSPACE / 2) * 5, (INTERSPACE / 2) * 5, INTERSPACE * 3, INTERSPACE * 3 };
}
