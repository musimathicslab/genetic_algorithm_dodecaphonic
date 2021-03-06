package it.meh.score.data;

import it.unisa.dia.music.etn.constants.DoubleStaveConstants;
import it.unisa.dia.music.etn.constants.ScoreConstants;
import it.unisa.dia.music.etn.constants.StaveConstants;

import java.util.*;

import org.jfugue.Pattern;


public class Score implements ScoreConstants, DoubleStaveConstants, StaveConstants {
	public Score() {
		this(DEFAULT_TITLE, DEFAULT_COMPOSER, DEFAULT_COPYRIGHT, DEFAULT_KEY_SIGNATURE, DEFAULT_RYTHM_COUNT,DEFAULT_RYTHM_UNIT, DEFAULT_VOLUME, DEFAULT_TEMPO);
	}
	
	public Score(String title, String composer, String copyright, String keySignature, int rythmCount, int rythmUnit, int volume, int tempo) {
		initNote2Value();
		
		setTitle(title);
		setComposer(composer);
		setCopyright(copyright);
		setKeySignature(keySignature);
		setRythmCount(rythmCount);
		setRythmUnit(rythmUnit);
		setVolume(volume);	
		setTempo(tempo);
		
        buildTriads();
		buildQuadriads();
        
		setInstrument(BASSO, new Instrument());
		setInstrument(TENORE, new Instrument());
		setInstrument(ALTO, new Instrument());
		setInstrument(SOPRANO, new Instrument());
		
		setNotes(BASSO, new Vector());
		setNotes(TENORE, new Vector());
		setNotes(ALTO, new Vector());
		setNotes(SOPRANO, new Vector());
	}
    
	private void initNote2Value() {
		note2value.put("C", new Integer(0));
		note2value.put("C#", new Integer(1));
		note2value.put("Db", new Integer(1));
		note2value.put("D", new Integer(2));
		note2value.put("D#", new Integer(3));
		note2value.put("Eb", new Integer(3));
		note2value.put("E", new Integer(4));
		note2value.put("Fb", new Integer(4));
		note2value.put("E#", new Integer(5));
		note2value.put("F", new Integer(5));
		note2value.put("F#", new Integer(6));
		note2value.put("Gb", new Integer(6));
		note2value.put("G", new Integer(7));
		note2value.put("G#", new Integer(8));
		note2value.put("Ab", new Integer(8));
		note2value.put("A", new Integer(9));
		note2value.put("A#", new Integer(10));
		note2value.put("Bb", new Integer(10));
		note2value.put("B", new Integer(11));
	}

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getComposer() {
    	return composer;
    }
    
    public void setComposer(String composer) {
    	this.composer = composer;
    }
    
    public String getCopyright() {
    	return copyright;
    }
    
    public void setCopyright(String copyright) {
    	this.copyright = copyright;
    }
    
    public int getTempo() {
    	return tempo;
    }
    
    public void setTempo(int tempo) {
    	 this.tempo = 14400 / tempo;
    }

    public int getVolume() {
        return (volume / 16383) * 100;
    }
    
    public void setVolume(int volume) {
        this.volume = (volume / 100) * 16383;
    }
    
    public Instrument getInstrumentFromVoice(int voice) {
    	switch(voice) {
    		case BASSO: 
    			return instrumentBasso;
			
    		case TENORE:
    			return instrumentTenore;
			
    		case ALTO:
    			return instrumentAlto;
			
    		case SOPRANO:
    			return instrumentSoprano;
		
    		default:
    			return instrumentBasso;
    	}
    }
    
    public void setInstrument(int voice, Instrument instrument) {
    	switch(voice) {
    		case BASSO: 
    			instrumentBasso = instrument;
    			break;
    			
    		case TENORE:
    			instrumentTenore = instrument;
    			break;
    			
    		case ALTO:
    			instrumentAlto = instrument;
    			break;
    			
    		case SOPRANO:
    			instrumentSoprano = instrument;
    			break;
    			
    		default:
    			instrumentBasso = instrument;
    	}
    }
    
    public String getKeySignature() {
    	return keySignature;
    }
   
    
    public String convertSiglaKey(String key) {
    	if(key.equals("Cmaj"))
    		return "C Major";
    	else if(key.equals("Gmaj"))
    		return "G Major";
    	else if(key.equals("Dmaj"))
    		return "D Major";
    	else if(key.equals("Amaj"))
    		return "A Major";
    	else if(key.equals("Emaj"))
    		return "E Major";
    	else if(key.equals("Bmaj"))
    		return "B Major";
    	else if(key.equals("F#maj"))
    		return "F Sharp Major";
    	else if(key.equals("C#maj"))
    		return "C Sharp Major";
    	else if(key.equals("Fmaj"))
    		return "F Major";
    	else if(key.equals("Bbmaj"))
    		return "B Flat Major";
    	else if(key.equals("Ebmaj"))
    		return "E Flat Major";
    	else if(key.equals("Abmaj"))
    		return "A Flat Major";
    	else if(key.equals("Dbmaj"))
    		return "D Flat Major";
    	else if(key.equals("Gbmaj"))
    		return "G Flat Major";
    	else if(key.equals("Cbmaj"))
    		return "C Flat Major";
    	else if(key.equals("Amin"))
    		return "A Minor";
    	else if(key.equals("Emin"))
    		return "E Minor";
    	else if(key.equals("Bmin"))
    		return "B Minor";
    	else if(key.equals("F#min"))
    		return "F Sharp Minor";
    	else if(key.equals("C#min"))
    		return "C Sharp Minor";
    	else if(key.equals("G#min"))
    		return "G Sharp Minor";
    	else if(key.equals("D#min"))
    		return "D Sharp Minor";
    	else if(key.equals("A#min"))
    		return "A Sharp Minor";
    	else if(key.equals("Dmin"))
    		return "D Minor";
    	else if(key.equals("Gmin"))
    		return "G Minor";
    	else if(key.equals("Cmin"))
    		return "C Minor";
    	else if(key.equals("Fmin"))
    		return "F Minor";
    	else if(key.equals("Bbmin"))
    		return "B Flat Minor";
    	else if(key.equals("Ebmin"))
    		return "E Flat Minor";
    	else if(key.equals("Abmin"))
    		return "A Flat Minor";
    	else 
    		return null;
    			
    }
    public void setKeySignature(String keySignatureLabel) {
    	  keySignature = "";
           
           keySignatureSharpsCount = 0;
           keySignatureFlatsCount = 0;
           scale = C_MAJ_SCALE;
           
           // C
           if (keySignatureLabel.substring(0, 1).compareTo(C_NOTE_SYMBOL) == 0) {
        	   keySignature = keySignature + C_NOTE_SYMBOL;
        	   
           		if(keySignatureLabel.substring(0, 6).compareTo(C_NOTE_SYMBOL + " Flat") == 0) {
           			keySignature = keySignature + FLAT_SYMBOL;
           			
                    keySignatureFlatsCount = 7;
                    keySignatureSharpsCount = 0;
                    scale = C_FLAT_MAJ_SCALE;
           		} else if(keySignatureLabel.substring(0, 7).compareTo("C Sharp") == 0) {
           			keySignature = keySignature + SHARP_SYMBOL;
           			
           			if(keySignatureLabel.substring(8).compareTo("Major") == 0) {
           				keySignature = keySignature + MAJOR_SYMBOL;
                        keySignatureSharpsCount = 7;
                        keySignatureFlatsCount = 0;
                        scale = C_SHARP_MAJ_SCALE;           				
           			} else {
           				keySignature = keySignature + MINOR_SYMBOL;
           				keySignatureSharpsCount = 4;
           				keySignatureFlatsCount = 0;
                        scale = C_SHARP_MIN_SCALE;
           			}

           		} else {
           			if(keySignatureLabel.substring(2).compareTo("Major") == 0) {
           				keySignature = keySignature + MAJOR_SYMBOL;
           				keySignatureSharpsCount = 0;
           				keySignatureFlatsCount = 0;
           				scale = C_MAJ_SCALE;           			
           			} else {
           				keySignature = keySignature + MINOR_SYMBOL;
           				keySignatureFlatsCount = 3;
           				keySignatureSharpsCount = 0;
           				scale = C_MIN_SCALE;
           			}
           		}
           } else // D
            if (keySignatureLabel.substring(0, 1).compareTo("D") == 0) {
            	keySignature = keySignature + D_NOTE_SYMBOL;
            	
           		if(keySignatureLabel.substring(0, 6).compareTo("D Flat") == 0) {
           			keySignature = keySignature + FLAT_SYMBOL;
                    keySignatureFlatsCount = 5;
                    keySignatureSharpsCount = 0;
                    scale = D_FLAT_MAJ_SCALE;
           		} else if(keySignatureLabel.substring(0, 7).compareTo("D Sharp") == 0) {
           			keySignature = keySignature + SHARP_SYMBOL;
           			
           			if(keySignatureLabel.substring(8).compareTo("Major") == 0) {
           				
           			} else {
           				keySignature = keySignature + MINOR_SYMBOL;
                        keySignatureSharpsCount = 6;
                        keySignatureFlatsCount = 0;
                        scale = D_SHARP_MIN_SCALE;
           			}
           		} else {
           			if(keySignatureLabel.substring(2).compareTo("Major") == 0) {
           				keySignature = keySignature + MAJOR_SYMBOL;
                        keySignatureSharpsCount = 2;
                        keySignatureFlatsCount = 0;
                        scale = D_MAJ_SCALE;
           			} else {
           				keySignature = keySignature + MINOR_SYMBOL;
           				keySignatureFlatsCount = 1;
           				keySignatureSharpsCount = 0;
                        scale = D_MIN_SCALE;
           			}
           		}
           } else // E
            if (keySignatureLabel.substring(0, 1).compareTo("E") == 0) {
            	keySignature = keySignature + E_NOTE_SYMBOL;
           		if(keySignatureLabel.substring(0, 6).compareTo("E Flat") == 0) {
           			keySignature = keySignature + FLAT_SYMBOL;
           			if(keySignatureLabel.substring(7).compareTo("Major") == 0) {
           				keySignature = keySignature + MAJOR_SYMBOL;
                        keySignatureFlatsCount = 3;
                        keySignatureSharpsCount = 0;
                        scale = E_FLAT_MAJ_SCALE;
           			} else {
           				keySignature = keySignature + MINOR_SYMBOL;
           				keySignatureFlatsCount = 6;
           				keySignatureSharpsCount = 0;
                        scale = E_FLAT_MIN_SCALE;
           			}
           		} else {
           			if(keySignatureLabel.substring(2).compareTo("Major") == 0) {
           				keySignature = keySignature + MAJOR_SYMBOL;
                        keySignatureSharpsCount = 4;
                        keySignatureFlatsCount = 0;
                        scale = E_MAJ_SCALE;
           			} else {
           				keySignature = keySignature + MINOR_SYMBOL;
           				keySignatureSharpsCount = 1;
           				keySignatureFlatsCount = 0;
                        scale = E_MIN_SCALE;
           			}
           		}
           } else // F
            if (keySignatureLabel.substring(0, 1).compareTo("F") == 0) {
            	keySignature = keySignature + F_NOTE_SYMBOL;
           		if(keySignatureLabel.substring(0, 7).compareTo("F Sharp") == 0) {
           			keySignature = keySignature + SHARP_SYMBOL;
           			if(keySignatureLabel.substring(8).compareTo("Major") == 0) {
           				keySignature = keySignature + MAJOR_SYMBOL;
                        keySignatureSharpsCount = 6;
                        keySignatureFlatsCount = 0;
                        scale = F_SHARP_MAJ_SCALE;
           			} else {
           				keySignature = keySignature + MINOR_SYMBOL;
                        keySignatureSharpsCount = 3;
                        keySignatureFlatsCount = 0;
                        scale = F_SHARP_MIN_SCALE;
           			}
           		} else {
           			if(keySignatureLabel.substring(2).compareTo("Major") == 0) {
           				keySignature = keySignature + MAJOR_SYMBOL;
           				keySignatureFlatsCount = 1;
           				keySignatureSharpsCount = 0;
           				scale = F_MAJ_SCALE;
           			} else {
           				keySignature = keySignature + MINOR_SYMBOL;
           				keySignatureFlatsCount = 4;
           				keySignatureSharpsCount = 0;
           				scale = F_MIN_SCALE;
           			}
           		}
           } else // G
            if (keySignatureLabel.substring(0, 1).compareTo("G") == 0) {
            	keySignature = keySignature + G_NOTE_SYMBOL;
           		if(keySignatureLabel.substring(0, 6).compareTo("G Flat") == 0) {
           			keySignature = keySignature + FLAT_SYMBOL;
                    keySignatureFlatsCount = 6;
                    keySignatureSharpsCount = 0;
                    scale = G_FLAT_MAJ_SCALE;
           		} else if(keySignatureLabel.substring(0, 7).compareTo("G Sharp") == 0) {
           			keySignature = keySignature + SHARP_SYMBOL;
           			if(keySignatureLabel.substring(8).compareTo("Major") == 0) {

           			} else {
           				keySignature = keySignature + MINOR_SYMBOL;
                        keySignatureSharpsCount = 5;
                        keySignatureFlatsCount = 0;
                        scale = G_SHARP_MIN_SCALE;
           			}
           		} else {
           			if(keySignatureLabel.substring(2).compareTo("Major") == 0) {
           				keySignature = keySignature + MAJOR_SYMBOL;
                        keySignatureSharpsCount = 1;
                        keySignatureFlatsCount = 0;
                        scale = G_MAJ_SCALE;
           			} else {
           				keySignature = keySignature + MINOR_SYMBOL;
                        keySignatureFlatsCount = 2;
                        keySignatureSharpsCount = 0;
                        scale = G_MIN_SCALE;
           			
           			}
           			
           		}
           } else // A
            if (keySignatureLabel.substring(0, 1).compareTo("A") == 0) {
            	keySignature = keySignature + A_NOTE_SYMBOL;
           		if(keySignatureLabel.substring(0, 6).compareTo("A Flat") == 0) {
           			keySignature = keySignature + FLAT_SYMBOL;
           			if(keySignatureLabel.substring(7).compareTo("Major") == 0) {
           				keySignature = keySignature + MAJOR_SYMBOL;
           				keySignatureFlatsCount = 4;
           				keySignatureSharpsCount = 0;
                        scale = A_FLAT_MAJ_SCALE;    
           			} else {
           				keySignature = keySignature + MINOR_SYMBOL;
           				keySignatureFlatsCount = 7;
           				keySignatureSharpsCount = 0;
                        scale = A_FLAT_MIN_SCALE;    
           			}
                    
           		} else if(keySignatureLabel.substring(0, 7).compareTo("A Sharp") == 0) {
           			keySignature = keySignature + SHARP_SYMBOL;
           			if(keySignatureLabel.substring(8).compareTo("Major") == 0) {
           				
           			}else {
           				keySignature = keySignature + MINOR_SYMBOL;
           				keySignatureSharpsCount = 7;
           				keySignatureFlatsCount = 0;
                        scale = A_SHARP_MIN_SCALE;
           			}
           		} else {
           			if(keySignatureLabel.substring(2).compareTo("Major") == 0) {
           				keySignature = keySignature + MAJOR_SYMBOL;
           				keySignatureSharpsCount = 3;
           				keySignatureFlatsCount = 0;
           				scale = A_MAJ_SCALE;
           			} else {
           				keySignature = keySignature + MINOR_SYMBOL;
           				keySignatureSharpsCount = 0;
           				keySignatureFlatsCount = 0;
           				scale = A_MIN_SCALE;
           			}
           		}
           } else // B
            if (keySignatureLabel.substring(0, 1).compareTo("B") == 0) {
            	keySignature = keySignature + B_NOTE_SYMBOL;
           		if(keySignatureLabel.substring(0, 6).compareTo("B Flat") == 0) {
           			keySignature = keySignature + FLAT_SYMBOL;
           			if(keySignatureLabel.substring(7).compareTo("Major") == 0) {
           				keySignature = keySignature + MAJOR_SYMBOL;
           				keySignatureFlatsCount = 2;
           				keySignatureSharpsCount = 0;
           				scale = B_FLAT_MAJ_SCALE;
           			} else {
           				keySignature = keySignature + MINOR_SYMBOL;
           				keySignatureFlatsCount = 5;
           				keySignatureSharpsCount = 0;
           				scale = B_FLAT_MIN_SCALE;
           			}
           		} else {
           			if(keySignatureLabel.substring(2).compareTo("Major") == 0) {
           				keySignature = keySignature + MAJOR_SYMBOL;
           				keySignatureSharpsCount = 5;
           				keySignatureFlatsCount = 0;
           				scale = B_MAJ_SCALE;
           			} else {
           				keySignature = keySignature + MINOR_SYMBOL;
           				keySignatureSharpsCount = 2;
           				keySignatureFlatsCount = 0;
           				scale = B_MIN_SCALE;
           			}
           		}
           } 
               
           nativeNoteValues.clear();
           
           for (int i = 0; i < scale.length; i++) {
               nativeNoteValues.add(note2value.get(scale[i]));
           }
           
           for (int i = 0; i < keySignatureSharpsCount; i++) {
               restoreNoteValues.add(note2value.get(sharpNotesSequence[i].substring(0,1)));
               alteredNoteValues.add(note2value.get(sharpNotesSequence[i]));
           }
           
           for (int i = 0; i < keySignatureFlatsCount; i++) {
               restoreNoteValues.add(note2value.get(flatNotesSequence[i].substring(0,1)));
               alteredNoteValues.add(note2value.get(flatNotesSequence[i]));
           }
           
           // Ricostruiamo le triadi e le quadriadi
           buildTriads();
           buildQuadriads();
    }
     
    public int getRythmCount() {
        return rythmCount;
    }
    
    public void setRythmCount(int rythmCount) {
        this.rythmCount = rythmCount;
    }
    
    public int getRythmUnit() {
        return rythmUnit;
    }
    
    public void setRythmUnit(int rythmUnit) {
        this.rythmUnit = rythmUnit;
    }
    
    public int getKeySignatureSharpsCount() {
        return keySignatureSharpsCount;
    }
    
    public int getKeySignatureFlatsCount() {
        return keySignatureFlatsCount;
    }
        
    public Vector getAlteredNoteValues() {
        return alteredNoteValues;
    }
    
    public Vector getNativeNoteValues() {
        return nativeNoteValues;
    }
        
    public Vector getRestoreNoteValues() {
        return restoreNoteValues;
    }
    
    public void setNotes(int voiceType, Vector notes) {
    	switch(voiceType) {
    		case BASSO:
    			bassoNotes = notes;
    			break;
    			
    		case TENORE:
    			tenoreNotes = notes;
    			break;
    			
    		case ALTO:
    			altoNotes = notes;
    			break;
    			
    		case SOPRANO:
    			sopranoNotes = notes;
    	}
    }
    
    public void removeNotes(int voiceType) {
    	switch(voiceType) {
    		case BASSO:
    			bassoNotes = new Vector();
    			break;
    			
    		case TENORE:
    			tenoreNotes = new Vector();
    			break;
    			
    		case ALTO:
    			altoNotes = new Vector();
    			break;
    			
    		case SOPRANO:
    			sopranoNotes = new Vector();
    	}
    }
    
    public Vector getNotes(int voiceType) {
    	Vector notes = null;
    	
    	switch(voiceType) {
    		case BASSO:
    			notes = bassoNotes;
    			break;
    			
    		case TENORE:
    			notes = tenoreNotes;
    			break;
    			
    		case ALTO:
    			notes = altoNotes;
    			break;
    			
    		case SOPRANO:
    			notes = sopranoNotes;
    	}
    	
    	return notes;
    }

	public Instrument getInstrument(int voiceType) {
		Instrument instrument = null;
		
		switch(voiceType) {
			case BASSO:
				instrument = instrumentBasso;
				break;
			
			case TENORE:
				instrument = instrumentTenore;
				break;
				
			case ALTO:
				instrument = instrumentAlto;
				break;
				
			case SOPRANO:
				instrument = instrumentSoprano;
		}
		
		return instrument;
	}
	
    private Pattern getPatternFromNotes(Vector notes, int voice) {
    	Pattern pattern = new Pattern("V" + voice);
    	
    	Note n = null;
    	
    	String s = "";

    	if(volume == 0) {
    		volume = 16383;
    	}
        // viene impostato il volume
        s += "X[Volume]=" + volume + " ";
        
        // viene impostato il tempo
        s += "T" + tempo + " ";
        
        // viene impostata la key signature
        s += "K" + keySignature + " ";
        
        // viene impostato lo strumento da utilizzare per la riproduzione
        s += "I[" + getInstrumentFromVoice(voice).getDescription() + "] ";
        
        for(int i = 0; i < notes.size(); i++) {
        	n = (Note) notes.get(i);
        	
        	s += ((Note) n).toString() + " ";
        }
    
        pattern.add(s);
        
        return pattern;
    }
    
    public Pattern getSongPattern() {
    	Pattern songPattern = new Pattern();
    	songPattern.add(getPatternFromNotes(bassoNotes, DoubleStaveConstants.BASSO));
    	songPattern.add(getPatternFromNotes(tenoreNotes, DoubleStaveConstants.TENORE));
    	songPattern.add(getPatternFromNotes(altoNotes, DoubleStaveConstants.ALTO));
    	songPattern.add(getPatternFromNotes(sopranoNotes, DoubleStaveConstants.SOPRANO));
    	
    	return songPattern;
    }
    
    public String[][] getTriads() {
    	return triads;
    }
    
    public String[][] getQuadriads() {
    	return quadriads;
    }
    
    public String[] getScale() {
    	return scale;
    }
    
    private void buildTriads() {
    	
    	triads = new String[7][];
    	
    	String[] triad = null;
    	    	
    	// Riempimento iniziale
    	for(int i = 0; i < scale.length; i++) {
    		triad = new String[3];
    		
    		if(isMinor(scale)) {
    			if(i == 4) {
    				// Siamo sulla dominante quindi ci metto la sensibile
    				String notaSensibile = scale[(i + 2) % scale.length];
    				if(notaSensibile.indexOf("b") != -1) {
    					// E' un b quindi lo tolgo
    					notaSensibile = notaSensibile.replace("b","");
    				} else if(notaSensibile.indexOf("#") != -1) {
    					notaSensibile = getNextSemitone(notaSensibile);
    				} else {
    					notaSensibile += "#";
    				}
    				
    				triad[0] = scale[i];
    				triad[1] = notaSensibile;
    				
    			} else if(i == 6) {
    				// Siamo sulla dominante quindi ci metto la sensibile
    				String notaSensibile = scale[i];
    				if(notaSensibile.indexOf("b") != -1) {
    					// E' un b quindi lo tolgo
    					notaSensibile = notaSensibile.replace("b","");
    				} else if(notaSensibile.indexOf("#") != -1) {
    					notaSensibile = getNextSemitone(notaSensibile);
    				} else {
    					notaSensibile += "#";
    				}
    				
    				triad[0] = notaSensibile;
    				triad[1] = scale[(i + 2) % scale.length];    				
    			} else {
    				triad[0] = scale[i];
        			triad[1] = scale[(i + 2) % scale.length];
    			}
    		} else {
    			triad[0] = scale[i];
    			triad[1] = scale[(i + 2) % scale.length];
    		}
    		
    		triad[2] = scale[(i + 4) % scale.length]; 
    		triads[i] = triad;

    	}
    	
    }
    
    private String getNextSemitone(String nota) {
    	
    	if(nota.equals("C#")) {
    		return "D";
    	} else if(nota.equals("D#")) {
    		return "E";
    	} if(nota.equals("F#")) {
    		return "G";
    	} if(nota.equals("G#")) {
    		return "A";
    	} if(nota.equals("A#")) {
    		return "B";
    	} else 
    		return null;
    }
    
    private String[] getMinoreArmonica(String[] scale) {
    	if(scale == A_MIN_SCALE)
    		return A_MIN_SCALE_ARMONICA;
    	else if(scale == E_MIN_SCALE)
    		return E_MIN_SCALE_ARMONICA;
    	else if(scale == B_MIN_SCALE)
    		return B_MIN_SCALE_ARMONICA;
    	else if(scale == F_SHARP_MIN_SCALE)
    		return F_SHARP_MIN_SCALE_ARMONICA;
    	else if(scale == C_SHARP_MIN_SCALE)
    		return C_SHARP_MIN_SCALE_ARMONICA;
    	else if(scale == G_SHARP_MIN_SCALE)
    		return G_SHARP_MIN_SCALE_ARMONICA;
    	else if(scale == D_SHARP_MIN_SCALE)
    		return D_SHARP_MIN_SCALE_ARMONICA;
    	else if(scale == A_SHARP_MIN_SCALE)
    		return A_SHARP_MIN_SCALE_ARMONICA;
    	else if(scale == D_MIN_SCALE)
    		return D_MIN_SCALE_ARMONICA;
    	else if(scale == G_MIN_SCALE)
    		return G_MIN_SCALE_ARMONICA;
    	else if(scale == C_MIN_SCALE)
    		return C_MIN_SCALE_ARMONICA;
    	else if(scale == F_MIN_SCALE)
    		return F_MIN_SCALE_ARMONICA;
    	else if(scale == B_FLAT_MIN_SCALE)
    		return B_FLAT_MIN_SCALE_ARMONICA;
    	else if(scale == E_FLAT_MIN_SCALE)
    		return E_FLAT_MIN_SCALE_ARMONICA;
    	else if(scale == A_FLAT_MIN_SCALE)
    		return A_FLAT_MIN_SCALE_ARMONICA;
    	else return null;
    	
      
    }

    
    private String[] getMinoreMelodica(String[] scale) {
    	if(scale == A_MIN_SCALE)
    		return A_MIN_SCALE_MELODICA;
    	else if(scale == E_MIN_SCALE)
    		return E_MIN_SCALE_MELODICA;
    	else if(scale == B_MIN_SCALE)
    		return B_MIN_SCALE_MELODICA;
    	else if(scale == F_SHARP_MIN_SCALE)
    		return F_SHARP_MIN_SCALE_MELODICA;
    	else if(scale == C_SHARP_MIN_SCALE)
    		return C_SHARP_MIN_SCALE_MELODICA;
    	else if(scale == G_SHARP_MIN_SCALE)
    		return G_SHARP_MIN_SCALE_MELODICA;
    	else if(scale == D_SHARP_MIN_SCALE)
    		return D_SHARP_MIN_SCALE_MELODICA;
    	else if(scale == A_SHARP_MIN_SCALE)
    		return A_SHARP_MIN_SCALE_MELODICA;
    	else if(scale == D_MIN_SCALE)
    		return D_MIN_SCALE_MELODICA;
    	else if(scale == G_MIN_SCALE)
    		return G_MIN_SCALE_MELODICA;
    	else if(scale == C_MIN_SCALE)
    		return C_MIN_SCALE_MELODICA;
    	else if(scale == F_MIN_SCALE)
    		return F_MIN_SCALE_MELODICA;
    	else if(scale == B_FLAT_MIN_SCALE)
    		return B_FLAT_MIN_SCALE_MELODICA;
    	else if(scale == E_FLAT_MIN_SCALE)
    		return E_FLAT_MIN_SCALE_MELODICA;
    	else if(scale == A_FLAT_MIN_SCALE)
    		return A_FLAT_MIN_SCALE_MELODICA;
    	else return null;
    	
      
    }

    private void buildQuadriads() {
   		quadriads = new String[7][];
    	
    	String[] quadriad = null;
    	
       	for(int i = 0; i < scale.length; i++) {
    		quadriad = new String[4];
    		
    		if(isMinor(scale)) {
    			if(i == 4) {
    				// Siamo sulla dominante quindi ci metto la sensibile
    				String notaSensibile = scale[(i + 2) % scale.length];
    				if(notaSensibile.indexOf("b") != -1) {
    					// E' un b quindi lo tolgo
    					notaSensibile = notaSensibile.replace("b","");
    				} else if(notaSensibile.indexOf("#") != -1) {
    					notaSensibile = getNextSemitone(notaSensibile);
    				} else {
    					notaSensibile += "#";
    				}
    				
    				quadriad[0] = scale[i];
    				quadriad[1] = notaSensibile;
    				
    			} else if(i == 6) {
    				// Siamo sulla dominante quindi ci metto la sensibile
    				String notaSensibile = scale[i];
    				if(notaSensibile.indexOf("b") != -1) {
    					// E' un b quindi lo tolgo
    					notaSensibile = notaSensibile.replace("b","");
    				} else if(notaSensibile.indexOf("#") != -1) {
    					notaSensibile = getNextSemitone(notaSensibile);
    				} else {
    					notaSensibile += "#";
    				}
    				
    				quadriad[0] = notaSensibile;
    				quadriad[1] = scale[(i + 2) % scale.length];    				
    			} else {
    				quadriad[0] = scale[i];
        			quadriad[1] = scale[(i + 2) % scale.length];
    			}
    		} else {
    			quadriad[0] = scale[i];
    			quadriad[1] = scale[(i + 2) % scale.length];
    		}
    		quadriad[2] = scale[(i + 4) % scale.length]; 
    		quadriad[3] = scale[(i + 6) % scale.length];
    		
    		quadriads[i] = quadriad;
    	}
       	
    }

    private boolean isMinor(String[] scala) {
    	boolean result = false;
    	for(int i = 0; i < circoloQuinteMin.length;i++) {
    		if(scala == circoloQuinteMin[i]) {
    			result = true;
    			break;
    		}
    	}
    	return result;
    }
    
	public HashMap getNote2value() {
		return note2value;
	}
	
	public void setNote2value(HashMap note2value) {
		this.note2value = note2value;
	}

    public static void main(String[] args) {
    	Score s = new Score();
    }
    
	private String title;
	private String composer;
	private String copyright;
	
    private int tempo; 
    private int volume;
    
	private int rythmCount;
    private int rythmUnit;
    
    private String keySignature;
    
    private int keySignatureSharpsCount = 0;
    private int keySignatureFlatsCount = 0;
    
    private Vector bassoNotes;
    private Vector tenoreNotes;
    private Vector altoNotes;
    private Vector sopranoNotes;

    private Vector alteredNoteValues = new Vector();
    private Vector restoreNoteValues = new Vector();
    private Vector nativeNoteValues = new Vector();
        	
    private String [] sharpNotesSequence = {"F#","C#","G#","D#","A#","E#","B#"};
    private String [] flatNotesSequence = {"Bb","Eb","Ab","Db","Gb","Cb","Fb"};
        
    private String [] scale;
    
    private HashMap note2value = new HashMap();
    
    private String[][] triads    = null;
    private String[][] quadriads = null;
    
    private Instrument instrumentBasso;
    private Instrument instrumentTenore;
    private Instrument instrumentAlto;
    private Instrument instrumentSoprano;
	
}
