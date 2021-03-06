package it.unisa.dia.music.etn.constants;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

public interface MainFrameConstants {
	public static final String MAINFRAME_TITLE = "MEH - Musical Evolution Harmonization";
	
	public static final int MAINFRAME_WIDTH = 1044;
	
	public static final int MAINFRAME_HEIGHT = 700;
	public static final int MIANFRAME_RESIZED_HEIGHT = 480;
		
	public final int PNL_DOUBLE_STAVE_WIDTH = 1020;
	public final int PNL_DOUBLE_STAVE_RESIZED_WIDTH = 660;
	
	public final int PNL_DOUBLE_STAVE_HEIGHT = 415;

	public final int MODE_NORMAL = 0;
	public final int MODE_CHECK = 1;

	public final int PLAYER_MODE_PLAY = 0;
	public final int PLAYER_MODE_PAUSE = 1;
	public final int PLAYER_MODE_STOP = 2;
	public final int PLAYER_MODE_REWIND = 3;
	public final int PLAYER_MODE_FORWARD = 4;
	
	public final long TRACK_POSITION_OFFSET = 1000000; 
		
	public final int UNIT_INCREMENT_STAVE_SCROLLER = 30;
	public final int BLOCK_INCREMENT_STAVE_SCROLLER = 200;
	
	public final int UNIT_INCREMENT_PROBLEMS_SCROLLER = 30;
	public final int BLOCK_INCREMENT_PROBLEMS_SCROLLER = 100; 
	
	public final Color BG_COLOR = new Color(245, 245, 245);
	public static final Color WAIT_COLOR = new Color(150, 150, 150);
	
	public static final Font LBL_FONT = new Font("Verdana", Font.PLAIN, 11);
	
	// costanti relative alle immagini utilizzate
	public static final ImageIcon WAIT_IMAGE = new ImageIcon("img/waiting.gif");
	public static final ImageIcon NO_IMAGE = null;
	
	// costanti relativi ai messaggi informativi utilizzati
	public static final String NO_MESSAGE = "";
	public static final String WAIT_MESSAGE = "<html><b>Wait please...</b></html>";
	
	// costanti relative alle intestazioni delle tabelle utilizzate
	public static final String[] PROBLEMS_TABLE_HEADER = new String[] { "Description", "Measure(s)", "Type" };
	public static final int[] PROBLEMS_TABLE_COLUMN_SIZE = new int[] { 185, 100, 65 };

	
}
