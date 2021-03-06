package it.meh.score.data;

import java.util.Vector;

import it.meh.score.util.InvalidNoteException;
import it.meh.score.util.NoteUtilities;
import it.unisa.dia.music.etn.constants.StaveConstants;

public class Note implements StaveConstants, Cloneable {
	public Note() {}
	
	public Note(String durationSymbol) {	
		try {
			setDurationSymbol(durationSymbol);
			setDuration(NoteUtilities.getDurationValueFromSymbol(durationSymbol));
		} catch(InvalidNoteException e) {
			e.printStackTrace();
		}
	}
	
	public Note(int value) {
		try {
			setValue(value);
			//setDurationSymbol(NoteUtilities.getDurationSymbolFromValue(value));
		} catch(InvalidNoteException e) {
			e.printStackTrace();
		}
	}
	
	public Note(double duration) {
		try {
			setDuration(duration);
			setDurationSymbol(NoteUtilities.getDurationSymbolFromValue(value));
		} catch(InvalidNoteException e) {
			e.printStackTrace();
		}
	} 
	
	public double getDuration() {
		return duration;
	}
	
	public void setDuration(double duration) {      
		this.duration = duration;
		
		// Settiamo il simbolo
		if(duration == WHOLE_NOTE_DURATION)
			durationSymbol = WHOLE_NOTE_SYMBOL;
		else if(duration == HALF_NOTE_DURATION)
			durationSymbol = HALF_NOTE_SYMBOL;
		else if(duration == QUARTER_NOTE_DURATION)
			durationSymbol = QUARTER_NOTE_SYMBOL;
		else if(duration == EIGHTH_NOTE_DURATION)
			durationSymbol = EIGHTH_NOTE_SYMBOL;
		else if(duration == SIXTEENTH_NOTE_DURATION)
			durationSymbol = SIXTEENTH_NOTE_SYMBOL;
		else 
			durationSymbol = "";
 
	}
 
	public String getDurationSymbol() {  
		return durationSymbol;    
	}
	 
	public void setDurationSymbol(String durationSymbol) throws InvalidNoteException {   
		if(!NoteUtilities.isCorrectDurationSymbol(durationSymbol))
			throw new InvalidNoteException();  
		
		this.durationSymbol = durationSymbol;
	}
	 
	public String getNoteSymbol() {
        return noteSymbol;
    }
	
	public void setNoteSymbol(String noteSymbol) throws InvalidNoteException {
		if (!NoteUtilities.isCorrectNoteSymbol(noteSymbol))
            throw new InvalidNoteException();
        
		this.noteSymbol = noteSymbol;
    }
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) throws InvalidNoteException {
		if(value == -1) {
			this.value = value;
			noteSymbol = "R";
			octave = 0;
			sharp = false;
			flat = false;
			return;
		}
		
		if(value < MIN_NOTE_VALUE || value > MAX_NOTE_VALUE)
			throw new InvalidNoteException();
		
		 this.value = value;
	     octave = value / 12;
	     int r = value % 12;
	     
	     switch(r) {
         	case 0:
         		noteSymbol = C_NOTE_SYMBOL;
         		alterSymbol = NO_ALTER_SYMBOL;
         		break;
         	case 1:
         		noteSymbol = C_NOTE_SYMBOL;
         		alterSymbol = SHARP_SYMBOL;
         		break;
         	case 2:
         		noteSymbol = D_NOTE_SYMBOL;
         		alterSymbol = NO_ALTER_SYMBOL;
         		break;
         	case 3:
         		noteSymbol = D_NOTE_SYMBOL;
         		alterSymbol = SHARP_SYMBOL;
         		break;
         	case 4:
         		noteSymbol = E_NOTE_SYMBOL;
         		alterSymbol = NO_ALTER_SYMBOL;
         		break;
         	case 5:
         		noteSymbol = F_NOTE_SYMBOL;
         		alterSymbol = NO_ALTER_SYMBOL;
         		break;
         	case 6:
         		noteSymbol = F_NOTE_SYMBOL;
         		alterSymbol = SHARP_SYMBOL;
         		break;
         	case 7:
         		noteSymbol = G_NOTE_SYMBOL;
         		alterSymbol = NO_ALTER_SYMBOL;
         		break;
         	case 8:
         		noteSymbol = G_NOTE_SYMBOL;
         		alterSymbol = SHARP_SYMBOL;
         		break;
         	case 9:
         		noteSymbol = A_NOTE_SYMBOL;
         		alterSymbol = NO_ALTER_SYMBOL;
         		break;
         	case 10:
         		noteSymbol = A_NOTE_SYMBOL;
         		alterSymbol = SHARP_SYMBOL;
         		break;
         	case 11:
         		noteSymbol = B_NOTE_SYMBOL;
         		alterSymbol = NO_ALTER_SYMBOL;
	     }
	}
    
    public int getOctave() {
        return octave;
    }
    
    public void setOctave(int octave) throws InvalidNoteException {
        if (octave < MIN_OCTAVE || octave > MAX_OCTAVE)
            throw new InvalidNoteException();
        
        this.octave = octave;
        value = (value % 12) + octave * 12;
    }
	
    public boolean isDotted() {
        return dotted;
    }
    
    public void setDotted(boolean dotted) {
        this.dotted = dotted;
        
        if (dotted)
            duration = 1.5 * duration;
    }
    
    public boolean isAltered() {
    	return sharp || flat;
    }
    
    public boolean isSharp() {
        return sharp;
    }
    
    public void setSharp(boolean sharp) {
        this.sharp = sharp;
    }
    
    public boolean isFlat() {
        return flat;
    }
    
    public void setFlat(boolean flat) {
        this.flat = flat;
    }
    
    public boolean isRestore() {
        return restore;
    }
    
    public void setRestore(boolean restore) {
        this.restore = restore;
    }
    
    public int getAttackVelocity() {
        return attackVelocity;
    }
    
    public void setAttackVelocity(int attackVelocity) throws InvalidNoteException {
        if (attackVelocity < MIN_ATTACK_VELOCITY || attackVelocity > MAX_ATTACK_VELOCITY)
            throw new InvalidNoteException();
        
        this.attackVelocity = attackVelocity;
    }
    
    public int getDecayVelocity() {
        return decayVelocity;
    }
    
    public void setDecayVelocity(int decayVelocity) throws InvalidNoteException {
        if (decayVelocity < MIN_ATTACK_DECAY || decayVelocity > MAX_ATTACK_DECAY)
            throw new InvalidNoteException();
        
        this.decayVelocity = decayVelocity;
    }
    
    public String toString() {
        String s = noteSymbol;
      
        s += alterSymbol;
        
        if(!s.equals(REST_SYMBOL))
            s += octave;
        
        if(isLeftTied())
        	s+= "-";
        	
        s += durationSymbol;
        
        if(isRightTied())
        	s+= "-";
        
        if (dotted)
            s += ".";
        
        if (attackVelocity != 64)
            s += "a" + attackVelocity;
        
        if (decayVelocity != 64)
            s += "d" + decayVelocity;
        
        return s;
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    public boolean isSelected() {
        return this.selected;
    }
      
	public Note getNextNote() {
		return nextNote;
	}
	
	public void setNextNote(Note nextNote) {
		this.nextNote = nextNote;
	}

	public Note getPreviousNote() {
		return previousNote;
	}
	
	public void setPreviousNote(Note previousNote) {
		this.previousNote = previousNote;
	}
	
	public Note clone() throws CloneNotSupportedException {
		Note clonedNote = (Note) super.clone();
		
		clonedNote.value = value;
		clonedNote.noteSymbol = noteSymbol;
		clonedNote.octave = octave;
		clonedNote.duration = duration;
		clonedNote.durationSymbol = durationSymbol;
		clonedNote.dotted = dotted;
		clonedNote.sharp = sharp;
		clonedNote.flat = flat;
		clonedNote.restore = restore;
		clonedNote.visible = visible;
		clonedNote.rightTied = rightTied;
		clonedNote.leftTied = leftTied;

		return clonedNote;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setPositionOffset(int positionOffset) {
		this.positionOffset = positionOffset;
	}
	
	public int getPositionOffset() {
		return positionOffset;
	}
	
	public String getAlterSymbol() {
		return alterSymbol;
	}

	public void setAlterSymbol(String alterSymbol) {
		this.alterSymbol = alterSymbol;
	}
		
	public void setLeftTied(boolean leftTied) {
		this.leftTied = leftTied;
	}
	
	public boolean isLeftTied() {
		return leftTied;
	}
	
	public void setRightTied(boolean rightTied) {
		this.rightTied = rightTied;
	}
	
	public boolean isRightTied() {
		return rightTied;
	}

	public int getCountRightTied() {
		return countRightTied;
	}

	public void setCountRightTied(int countRightTied) {
		this.countRightTied = countRightTied;
	}

	public int getCountLeftTied() {
		return countLeftTied;
	}

	public void setCountLeftTied(int countLeftTied) {
		this.countLeftTied = countLeftTied;
	}

	public Vector getCountRightTiedDurations() {
		return countRightTiedDurations;
	}

	public void setCountRightTiedDurations(Vector countRightTiedDurations) {
		this.countRightTiedDurations = countRightTiedDurations;
	}
	
	public boolean isRest() {
		return noteSymbol.equals(REST_SYMBOL);
	}
	
	private double duration               = QUARTER_NOTE_DURATION;
	private String durationSymbol         = QUARTER_NOTE_SYMBOL;
	private String noteSymbol             = C_NOTE_SYMBOL;  
	
	private int value                     = DEFAULT_NOTE_VALUE;       
	     
	private String alterSymbol            = NO_ALTER_SYMBOL;      
	
	private int octave                    = DEFAULT_OCTAVE;
	
	private boolean dotted                = false;
	private boolean sharp                 = false;
	private boolean flat                  = false;
	private boolean restore               = false;
	
	private int attackVelocity            = DEFAULT_ATTACK_VELOCITY;
	private int decayVelocity             = DEFAULT_DECAY_VELOCITY;
	
	private boolean selected              = false;
		
	private int positionOffset            = 0;
	
	private int x                         = -1;
	private int y                         = -1;
	
	private boolean visible               = true;
	
	private Note previousNote             = null;
	private Note nextNote                 = null;

	private boolean leftTied              = false;
	private boolean rightTied             = false;
	
	private int countRightTied = 0;
	private int countLeftTied = 0;
    private Vector countRightTiedDurations = new Vector();

}
