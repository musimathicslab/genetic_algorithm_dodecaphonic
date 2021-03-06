package it.meh.score.util;

import it.meh.score.data.*;
import it.unisa.dia.music.etn.constants.*;


public class NoteUtilities implements DoubleStaveConstants{
	public static Note splitNote(Note note, double newDuration) {
		return splitRealNote((Note) note, newDuration);
	}
	
	private static Note splitRealNote(Note note, double newDuration) {
    	Note newNote = null;
		try {
			newNote = note.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
    	newNote.setPreviousNote(null);
    	newNote.setNextNote(null);
    	
    	double oldDuration = note.getDuration();
    	
    	note.setDuration(newDuration);
    	newNote.setDuration(oldDuration - newDuration);

    	if(note.getValue() != -1) { 
    		if(note.getNextNote() != null) {
    			newNote.setNextNote(note.getNextNote());
    			newNote.setPreviousNote(note);				

    			note.getNextNote().setPreviousNote(newNote);
    			note.setNextNote(newNote);
    		} else {
    			note.setNextNote(newNote);
    			newNote.setPreviousNote(note);
    		}
    	}
		
		return newNote;
    }
	
	public static Note adjustNoteDuration(Note note) {	
		double duration = note.getDuration();
		Note newNote = null;
	    	
	    if(duration > HALF_NOTE_DURATION)
	    	newNote = splitNote(note, HALF_NOTE_DURATION);
	    else if(duration  > QUARTER_NOTE_DURATION)
	    	newNote = splitNote(note, QUARTER_NOTE_DURATION);
	    else if(duration > EIGHTH_NOTE_DURATION)
	    	newNote = splitNote(note, EIGHTH_NOTE_DURATION);
	    else if(duration > SIXTEENTH_NOTE_DURATION)
	    	newNote = splitNote(note, SIXTEENTH_NOTE_DURATION);
	    	
	    return newNote;
	}
		 
	public static double getDurationValueFromSymbol(String durationSymbol) {
		double duration = 0.0;
		
		if(NoteUtilities.isCorrectDurationSymbol(durationSymbol)) {
			if(durationSymbol.equals(WHOLE_NOTE_SYMBOL))
				duration = WHOLE_NOTE_DURATION;
			else if(durationSymbol.equals(HALF_NOTE_SYMBOL))
				duration = HALF_NOTE_DURATION;
			else if(durationSymbol.equals(QUARTER_NOTE_SYMBOL))
				duration = QUARTER_NOTE_DURATION;
			else if(durationSymbol.equals(EIGHTH_NOTE_SYMBOL))
				duration = EIGHTH_NOTE_DURATION;
			else if(durationSymbol.equals(SIXTEENTH_NOTE_SYMBOL))
				duration = SIXTEENTH_NOTE_DURATION;
		}
		
		return duration;
	}
	
	public static String getDurationSymbolFromValue(double duration) {
		String durationSymbol = null;
		
		int i = (new Double((duration * 16))).intValue();
		
		switch(i) {
			case 0:
				durationSymbol = QUARTER_NOTE_SYMBOL;
				break;
	
			case 1:
				durationSymbol = SIXTEENTH_NOTE_SYMBOL;
				break;
			
			case 2:
				durationSymbol = EIGHTH_NOTE_SYMBOL;
				break;
			
			case 4:
				durationSymbol = QUARTER_NOTE_SYMBOL;
				break;
			
			case 8:
				durationSymbol = HALF_NOTE_SYMBOL;
				break;
        
			case 16:
				durationSymbol = WHOLE_NOTE_SYMBOL;
		}
		
		return durationSymbol;
	}
	
	public static boolean isCorrectDurationSymbol(String durationSymbol) {
		boolean result = false;
		
		if(durationSymbol != null) { 
			if(durationSymbol.equals(WHOLE_NOTE_SYMBOL))
				result = true;
			else if(durationSymbol.equals(HALF_NOTE_SYMBOL))
				result = true;
			else if(durationSymbol.equals(QUARTER_NOTE_SYMBOL))
				result = true;
			else if(durationSymbol.equals(EIGHTH_NOTE_SYMBOL))
				result = true;
			else if(durationSymbol.equals(SIXTEENTH_NOTE_SYMBOL))
				result = true;
			else if(durationSymbol.equals(REST_SYMBOL))
				result = true;
		} 
		return result;
	}
	
	public static boolean isCorrectDuration(double duration) { 		
		boolean result = false;
				
		if(duration == WHOLE_NOTE_DURATION)	
			result = true;    
		else if(duration == HALF_NOTE_DURATION)	
			result = true;    
		else if(duration == QUARTER_NOTE_DURATION)	
			result = true;    
		else if(duration == EIGHTH_NOTE_DURATION)	
			result = true;    
		else if(duration == SIXTEENTH_NOTE_DURATION)	
			result = true;
	    
		return result;  
	}
	
	public static boolean isCorrectNoteSymbol(String noteSymbol) {		
		boolean result = false;
		
		if(noteSymbol.equals(C_NOTE_SYMBOL))
			result = true;
		else if(noteSymbol.equals(D_NOTE_SYMBOL))
			result = true;
		else if(noteSymbol.equals(E_NOTE_SYMBOL))
			result = true;
		else if(noteSymbol.equals(F_NOTE_SYMBOL))
			result = true;
		else if(noteSymbol.equals(G_NOTE_SYMBOL))
			result = true;
		else if(noteSymbol.equals(A_NOTE_SYMBOL))
			result = true;
		else if(noteSymbol.equals(B_NOTE_SYMBOL))
			result = true;
		else if(noteSymbol.equals(REST_SYMBOL))
			result = true;
		
		return result;
	}
	
	public static int getNotesAbove(int voiceType) {
		int notesAbove = -1;
		
		switch(voiceType) {
			case BASSO:
				notesAbove = NOTES_ABOVE_BASSO;
				break;
				
			case TENORE:
				notesAbove = NOTES_ABOVE_TENORE;
				break;
				
			case ALTO:
				notesAbove = NOTES_ABOVE_ALTO;
				break;
				
			case SOPRANO:
				notesAbove = NOTES_ABOVE_SOPRANO;
		}
		
		return notesAbove;
	}
	
	
	public static int getNotesBeneath(int voiceType) {
		int notesBeneath = -1;
		
		switch(voiceType) {
			case BASSO:
				notesBeneath = NOTES_BENEATH_BASSO;
				break;
				
			case TENORE:
				notesBeneath = NOTES_BENEATH_TENORE;
				break;
				
			case ALTO:
				notesBeneath = NOTES_BENEATH_ALTO;
				break;
				
			case SOPRANO:
				notesBeneath = NOTES_BENEATH_SOPRANO;
		}
		
		return notesBeneath;
	}
	
	public static int getReferencePosition(int voiceType) {
		int position = -1;
		
		switch(voiceType) {
			case BASSO:
				position = REF_POSITION_BASSO;
				break;
				
			case TENORE:
				position = REF_POSITION_TENORE;
				break;
				
			case ALTO:
				position = REF_POSITION_ALTO;
				break;
				
			case SOPRANO:
				position = REF_POSITION_SOPRANO;
		}
		
		return position;
	}
	
	public static int getReferenceOctave(int voiceType) {
		int octave = -1;
		
		switch(voiceType) {
			case BASSO:
				octave = REF_OCTAVE_BASSO;
				break;
			
			case TENORE:
				octave = REF_OCTAVE_TENORE;
				break;
			
			case ALTO:
				octave = REF_OCTAVE_ALTO;
				break;
			
			case SOPRANO:
				octave = REF_OCTAVE_SOPRANO;
		}
	
		return octave;
	}
	
	public static int getReferenceValue(int voiceType) {
		int value = -1;
		
		switch(voiceType) {
			case BASSO:
				value = REF_VALUE_BASSO;
				break;
			
			case TENORE:
				value = REF_VALUE_TENORE;
				break;
			
			case ALTO:
				value = REF_VALUE_ALTO;
				break;
			
			case SOPRANO:
				value = REF_VALUE_SOPRANO;
		}
	
		return value;
	}
	
	public static String getSiglaScale(String[] scale) {
		if(scale == C_MAJ_SCALE) 
			return "CMaj";
		else if(scale == G_MAJ_SCALE) 
			return "GMaj";
		else if(scale == D_MAJ_SCALE) 
			return "DMaj";
		else if(scale == A_MAJ_SCALE) 
			return "AMaj";
		else if(scale == E_MAJ_SCALE) 
			return "EMaj";
		else if(scale == B_MAJ_SCALE) 
			return "BMaj";
		else if(scale == G_FLAT_MAJ_SCALE) 
			return "GbMaj";
		else if(scale == D_FLAT_MAJ_SCALE) 
			return "DbMaj";
		else if(scale == A_FLAT_MIN_SCALE) 
			return "AbMaj";
		else if(scale == E_FLAT_MAJ_SCALE) 
			return "EbMaj";
		else if(scale == B_FLAT_MAJ_SCALE) 
			return "BbMaj";
		else if(scale == F_MAJ_SCALE) 
			return "FMaj";
		else if(scale == A_MIN_SCALE) 
			return "Amin";
		else if(scale == E_MIN_SCALE) 
			return "Emin";
		else if(scale == B_MIN_SCALE) 
			return "Bmin";
		else if(scale == F_SHARP_MIN_SCALE) 
			return "F#min";
		else if(scale == C_SHARP_MIN_SCALE) 
			return "C#min";
		else if(scale == A_SHARP_MIN_SCALE) 
			return "A#min";
		else if(scale == E_FLAT_MIN_SCALE) 
			return "Ebmin";
		else if(scale == B_FLAT_MIN_SCALE) 
			return "Bbmin";
		else if(scale == F_MIN_SCALE) 
			return "Fmin";
		else if(scale == C_MIN_SCALE) 
			return "Cmin";
		else if(scale == G_MIN_SCALE) 
			return "Gmin";
		else if(scale == D_MIN_SCALE) 
			return "Dmin";
		else  
			return null;
	
	}
}
