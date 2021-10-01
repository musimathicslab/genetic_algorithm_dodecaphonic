package it.unisa.dia.music.etn.util;


import it.unisa.dia.music.etn.constants.data.*;

import java.awt.*;

import javax.swing.ImageIcon;



public class ToolkitImages implements DoubleStaveConstants, PropertiesBuilderConstants {
	private ToolkitImages() {
		toolkit = Toolkit.getDefaultToolkit();
		
		propertiesManager = PropertiesBuilder.getInstance();
		
		loadClefImages();
		loadNumberImages();
        loadNoteImages(DEFAULT_NOTES_COLOR);
        loadRestImages();
        loadIconImages();
   }
	
	private void loadClefImages() {
		trebleClef = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_CLEF_TREBLE)));
        bassClef   = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_CLEF_BASS)));
	}
	
	private void loadNumberImages() {		
		numberOne     = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_NUMBER_ONE)));
        numberTwo     = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_NUMBER_TWO)));
        numberThree   = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_NUMBER_THREE)));
        numberFour    = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_NUMBER_FOUR)));
        numberFive    = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_NUMBER_FIVE)));
        numberSix     = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_NUMBER_SIX)));
        numberEight   = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_NUMBER_EIGHT)));
        numberNine    = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_NUMBER_NINE)));
        numberTwelve  = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_NUMBER_TWELVE)));
        numberSixteen = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_NUMBER_SIXTEEN)));
	}
	
	public void loadNoteImages(String notesColor) {
		String notesDirectory = null;
		
		if(notesColor.equals(BLACK_COLOR_NOTES))
			notesDirectory = propertiesManager.getProperty(PROPERTY_KEY_DIR_NOTES_BLACK);
		else if(notesColor.equals(BLUE_COLOR_NOTES))
			notesDirectory = propertiesManager.getProperty(PROPERTY_KEY_DIR_NOTES_BLUE);
		else if(notesColor.equals(RED_COLOR_NOTES))
			notesDirectory = propertiesManager.getProperty(PROPERTY_KEY_DIR_NOTES_RED);
		else if(notesColor.equals(GREEN_COLOR_NOTES))
			notesDirectory = propertiesManager.getProperty(PROPERTY_KEY_DIR_NOTES_GREEN);
		else
			notesDirectory = propertiesManager.getProperty(PROPERTY_KEY_DIR_NOTES_BLACK);
					
		wholeNote = toolkit.getImage(getClass().getClassLoader().getResource(notesDirectory + propertiesManager.getProperty(PROPERTY_KEY_FILE_NOTE_WHOLE)));
		 
		halfNoteUp      = toolkit.getImage(getClass().getClassLoader().getResource(notesDirectory + propertiesManager.getProperty(PROPERTY_KEY_FILE_NOTE_HALF_UP)));
        quarterNoteUp   = toolkit.getImage(getClass().getClassLoader().getResource(notesDirectory + propertiesManager.getProperty(PROPERTY_KEY_FILE_NOTE_QUARTER_UP)));
        eightNoteUp     = toolkit.getImage(getClass().getClassLoader().getResource(notesDirectory + propertiesManager.getProperty(PROPERTY_KEY_FILE_NOTE_EIGHTH_UP)));
        sixteenthNoteUp = toolkit.getImage(getClass().getClassLoader().getResource(notesDirectory + propertiesManager.getProperty(PROPERTY_KEY_FILE_NOTE_SIXTEENTH_UP)));
        
        halfNoteDown      = toolkit.getImage(getClass().getClassLoader().getResource(notesDirectory + propertiesManager.getProperty(PROPERTY_KEY_FILE_NOTE_HALF_DOWN)));
        quarterNoteDown   = toolkit.getImage(getClass().getClassLoader().getResource(notesDirectory + propertiesManager.getProperty(PROPERTY_KEY_FILE_NOTE_QUARTER_DOWN)));
        eightNoteDown     = toolkit.getImage(getClass().getClassLoader().getResource(notesDirectory + propertiesManager.getProperty(PROPERTY_KEY_FILE_NOTE_EIGHTH_DOWN)));
        sixteenthNoteDown = toolkit.getImage(getClass().getClassLoader().getResource(notesDirectory + propertiesManager.getProperty(PROPERTY_KEY_FILE_NOTE_SIXTEENTH_DOWN)));
        
        flat    = toolkit.getImage(getClass().getClassLoader().getResource(notesDirectory + propertiesManager.getProperty(PROPERTY_KEY_FILE_NOTE_FLAT)));
        dot     = toolkit.getImage(getClass().getClassLoader().getResource(notesDirectory + propertiesManager.getProperty(PROPERTY_KEY_FILE_NOTE_DOT)));
        sharp   = toolkit.getImage(getClass().getClassLoader().getResource(notesDirectory + propertiesManager.getProperty(PROPERTY_KEY_FILE_NOTE_SHARP)));
        restore = toolkit.getImage(getClass().getClassLoader().getResource(notesDirectory + propertiesManager.getProperty(PROPERTY_KEY_FILE_NOTE_RESTORE)));
	}
	
	private void loadRestImages() {
		 wholeRest     = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_REST_WHOLE)));
	     halfRest      = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_REST_HALF)));
	     quarterRest   = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_REST_QUARTER)));
	     eightRest     = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_REST_EIGHT)));
	     sixteenthRest = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_REST_SIXTEENTH)));
	}
	
	private void loadIconImages() { 
		flatIcon    = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_FLAT)));  
		sharpIcon   = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_SHARP)));
		restoreIcon = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_RESTORE)));  
		tieIcon     =  toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_TIE)));
		  
	    wholeNoteIcon     = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_WHOLE_NOTE)));	    
	    halfNoteIcon      = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_HALF_NOTE)));
	    quarterNoteIcon   = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_QUARTER_NOTE)));
	    eightNoteIcon     = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_EIGHT_NOTE)));
	    sixteenthNoteIcon = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_SIXTEENTH_NOTE)));
	        
	    wholeRestIcon     = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_WHOLE_REST)));
	    halfRestIcon      = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_HALF_REST)));
	    quarterRestIcon   = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_QUARTER_REST)));
	    eightRestIcon     = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_EIGHT_REST)));
	    sixteenthRestIcon = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_SIXTEENTH_REST)));

	    rewindIcon  = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_REWIND)));
	    stopIcon    = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_STOP)));
	    playIcon    = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_PLAY)));
	    pauseIcon   = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_PAUSE)));
	    forwardIcon = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_FORWARD)));
	    
	    openIcon = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_OPEN)));
	    saveIcon = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_SAVE)));
	    
	    newIcon  = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_NEW)));  
	    checkIcon = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_CHECK)));
	    
	    infoIcon = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_INFO)));
	    
	    arrowUp   = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_ARROW_UP)));
	    arrowDown = toolkit.getImage(getClass().getClassLoader().getResource(propertiesManager.getProperty(PROPERTY_KEY_FILE_ICON_ARROW_DOWN)));
	}

	public static ToolkitImages getInstance() {
		if(instance == null)
			instance = new ToolkitImages();
	        
		return instance;
	}
	    
	public Image getTrebleClef() {
		return trebleClef;
	}
	
	public Image getBassClef() {
		return bassClef;
	}
	
	public Image getNumber(int number) {
		Image image = null;
		
		switch(number) {
			case 1:  
				image = numberOne; 
				break;
				
			case 2:  
				image = numberTwo;	 
				break;
				
			case 3:  
				image = numberThree;	 
				break;
				
			case 4:  
				image = numberFour;
				break;
				
			case 5:  
				image = numberFive;	 
				break;
				
			case 6:  
				image = numberSix;
				break;
				
			case 8:  
				image = numberEight;	 
				break;
				
			case 9:  
				image = numberNine;
				break;
				
			case 12: 
				image = numberTwelve;	 
				break;
				
			case 16: 
				image = numberSixteen;
		}
		
		return image;
	}
	
	public Image getNoteSymbol(double duration) {
		Image symbol = null;
		
		if(duration == WHOLE_NOTE_DURATION)
            symbol = wholeNote;
        else if(duration == HALF_NOTE_DURATION)
            symbol = halfNoteUp;
        else if(duration == QUARTER_NOTE_DURATION)
            symbol = quarterNoteUp;
        else if(duration == EIGHTH_NOTE_DURATION)
            symbol = eightNoteUp;
        else if(duration == SIXTEENTH_NOTE_DURATION)
            symbol = sixteenthNoteUp;
 
        return symbol;
	}
	
	public Image getNoteSymbolDown(double duration) {
		Image symbol = null;
		
		if(duration == WHOLE_NOTE_DURATION)
            symbol = wholeNote;
        else if(duration == HALF_NOTE_DURATION)
            symbol = halfNoteDown;
        else if(duration == QUARTER_NOTE_DURATION)
            symbol = quarterNoteDown;
        else if(duration == EIGHTH_NOTE_DURATION)
            symbol = eightNoteDown;
        else if(duration == SIXTEENTH_NOTE_DURATION)
            symbol = sixteenthNoteDown;
 
        return symbol;
	}
	
	public Image getRestSymbol(double duration) {
		Image symbol = null;
		
		if(duration == WHOLE_NOTE_DURATION)
            symbol = wholeRest;
        else if(duration == HALF_NOTE_DURATION)
            symbol = halfRest;
        else if(duration == QUARTER_NOTE_DURATION)
            symbol = quarterRest;
        else if(duration == EIGHTH_NOTE_DURATION)
            symbol = eightRest;
        else if(duration == SIXTEENTH_NOTE_DURATION)
            symbol = sixteenthRest;
 
        return symbol;
	}
	
	public Image getNoteIcon(double duration) {
		Image image = null;
		
		if(duration == WHOLE_NOTE_DURATION) 
            image = wholeNoteIcon;
		else if(duration == HALF_NOTE_DURATION)
            image = halfNoteIcon;
		else if(duration == QUARTER_NOTE_DURATION)
            image = quarterNoteIcon;
		else if(duration == EIGHTH_NOTE_DURATION)
            image = eightNoteIcon;
		else if(duration == SIXTEENTH_NOTE_DURATION)
            image = sixteenthNoteIcon;
		
		return image;
	}
	
	public Image getRestIcon(double duration) {
		Image image = null;
		
		if(duration == WHOLE_NOTE_DURATION)
            image = wholeRestIcon;
        else if(duration == HALF_NOTE_DURATION)
            image = halfRestIcon;
        else if(duration == QUARTER_NOTE_DURATION)
            image = quarterRestIcon;
        else if(duration == EIGHTH_NOTE_DURATION)
            image = eightRestIcon;
        else if(duration == SIXTEENTH_NOTE_DURATION)
            image = sixteenthRestIcon;
        	
		return image;
	}
	
	public Image getFlat() {
		return flat;
	}
	
	public Image getSharp() {
		return sharp;
	}
	
	public Image getRestore() {
		return restore;
	}
	
	public Image getDot() {
		return dot;
	}
	
	public Image getFlatIcon() {
		return flatIcon;
	}
	
	public Image getSharpIcon() {
		return sharpIcon;
	}
	
	public Image getDotIcon() {
		return dotIcon;
	}
	
	public Image getRestoreIcon() {
		return restoreIcon;
	}
	
	public Image getRewindIcon() {
		return rewindIcon;
	}
	
	public Image getPlayIcon() {
		return playIcon;
	}
	
	public Image getPauseIcon() {
		return pauseIcon;
	}
	
	public Image getStopIcon() {
		return stopIcon;
	}
	
	public Image getForwardIcon() {
		return forwardIcon;
	}
	
	public Image getOpenIcon() {
		return openIcon;
	}
	
	public Image getSaveIcon() {
		return saveIcon;
	}
	
	public Image getMidiIcon() {
		return midiIcon;
	}
	
	public Image getNewIcon() {
		return newIcon;
	}
	
	public Image getTieIcon() {
		return tieIcon;
	}
	
	public Image getCheckIcon() {
		return checkIcon;
	}
	
	public Image getInfoIcon() {
		return infoIcon;
	}
	
	public Image getArrowUp() {
		return arrowUp;
	}
	
	public Image getArrowDown() {
		return arrowDown;
	}
	
	// main di prova
	public static void main(String[] args) {
		ToolkitImages t = ToolkitImages.getInstance();
		ImageIcon icon = new ImageIcon(t.getRestIcon(QUARTER_NOTE_DURATION));
	}
	
	private PropertiesBuilder propertiesManager = null;
	
	private static ToolkitImages instance = null;
	
	private Toolkit toolkit = null;
	
    private Image trebleClef = null;
    private Image bassClef   = null;
    
    private Image numberOne     = null;
    private Image numberTwo     = null;
    private Image numberThree   = null;
    private Image numberFour    = null;
    private Image numberFive    = null;
    private Image numberSix     = null;
    private Image numberEight   = null;
    private Image numberNine    = null;
    private Image numberTwelve  = null;
    private Image numberSixteen = null;
    
    private Image flat    = null; 
    private Image sharp   = null;
    private Image dot     = null;
    private Image restore = null;
    
    private Image wholeNote = null;
    
    private Image halfNoteUp      = null;
    private Image quarterNoteUp   = null;
    private Image eightNoteUp     = null;
    private Image sixteenthNoteUp = null;
    
    private Image halfNoteDown      = null;
    private Image quarterNoteDown   = null;
    private Image eightNoteDown     = null;
    private Image sixteenthNoteDown = null;
    
    private Image wholeRest     = null;
    private Image halfRest      = null;
    private Image quarterRest   = null;
    private Image eightRest     = null;
    private Image sixteenthRest = null;
    
    private Image wholeNoteIcon     = null;
    private Image halfNoteIcon      = null;
    private Image quarterNoteIcon   = null;
    private Image eightNoteIcon     = null;
    private Image sixteenthNoteIcon = null;
   
    private Image wholeRestIcon     = null;
    private Image halfRestIcon      = null;
    private Image quarterRestIcon   = null;
    private Image eightRestIcon     = null;
    private Image sixteenthRestIcon = null;
    
    private Image flatIcon    = null;
    private Image sharpIcon   = null;
    private Image dotIcon     = null;
    private Image restoreIcon = null;
    private Image tieIcon     = null;
    
    private Image rewindIcon  = null;
    private Image stopIcon    = null;
    private Image playIcon    = null;
    private Image pauseIcon   = null;
    private Image forwardIcon = null;
    
    private Image openIcon = null;
    private Image saveIcon = null;
    private Image midiIcon = null;
    private Image newIcon  = null;
    
    private Image checkIcon = null;
    
    private Image infoIcon = null;
    
    private Image arrowDown = null;
    private Image arrowUp   = null;
    
    public static final String BLACK_COLOR_NOTES   = "black";
    public static final String BLUE_COLOR_NOTES    = "blue";
    public static final String GREEN_COLOR_NOTES   = "green";
    public static final String RED_COLOR_NOTES     = "red";
    public static final String DEFAULT_NOTES_COLOR = BLACK_COLOR_NOTES;
}