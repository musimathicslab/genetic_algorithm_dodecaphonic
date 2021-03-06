package it.meh.score.data;

import it.unisa.dia.music.etn.constants.*;


public class Instrument implements ScoreConstants {
	public Instrument() {
		this(DEFAULT_CATEGORY, DEFAULT_DESCRIPTION, DEFAULT_MIDI_NUMBER);
	}
	
    public Instrument(String category, String description, int midiNumber) {
    	setCategory(category);
        setDescription(description);
        setMidiNumber(midiNumber);
        setPath(null);
    }

    public int getMidiNumber() {
        return midiNumber;
    }

    public void setMidiNumber(int midiNumber) {
        this.midiNumber = midiNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String toString() {
    	return description;
    }
    
	public Object getPath() {
		return path;
	}

	public void setPath(Object path) {
		this.path = path;
	}
	
    public boolean equals(Object obj) {
    	if(!(obj instanceof Instrument)) {
    		return false;
    	}
    	
    	if(this == obj) {
    		return true;
    	}
    	
    	Instrument instrument = (Instrument)obj; 
    	
    	if((instrument.getCategory().equals(this.getCategory())) && (instrument.getDescription().equals(this.getDescription())) && (instrument.getMidiNumber() == this.getMidiNumber())) {
    		return true;	
    	} else {
    		return false;
    	}
    }
    

    private int midiNumber;
    private String category;
    private String description;
    private Object path;
}
