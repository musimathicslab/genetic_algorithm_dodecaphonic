package it.unisa.dia.music.etn.constants.data;

public interface MiniSingleStaveConstants extends StaveConstants {
	//	 costanti relative al pentagramma
    public static final int INTERSPACE       = 10;
    
    public static final int LEFT_MARGIN      = 0;
    public static final int RIGHT_MARGIN     = 0;
    public static final int HEADER           = 30;
    public static final int FOOTER           = 30;
    
    public static final int HEIGHT           = HEADER + 4 * INTERSPACE + FOOTER;   
    public static final int WIDTH            = 200;
    
    public final int CLEF_CENNTER_G = 60;
}
