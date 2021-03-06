package it.meh.stave;

import it.meh.score.data.Measure;
import it.meh.score.data.Note;
import it.meh.score.data.Score;
import it.meh.score.util.InvalidNoteException;
import it.meh.score.util.NoteUtilities;
import it.unisa.dia.music.etn.constants.DoubleStaveConstants;
import it.unisa.dia.music.etn.constants.ScoreConstants;

import java.util.Vector;


public class Stave implements DoubleStaveConstants, ScoreConstants {
	public Stave() {
		this(DEFAULT_RYTHM_UNIT, DEFAULT_RYTHM_COUNT);
	}
	
	public Stave(int rythmUnit, int rythmCount) {
		this.rythmUnit = rythmUnit;
		this.rythmCount = rythmCount;	
 		
		Measure m = new Measure(rythmUnit, rythmCount);
		
		measures = new Vector();
		measures.add(m);	
		m.setNumber(measures.size());
	}
	
	public boolean isEmpty() {
		Vector bassoNotes = getNotes(BASSO);
		Vector tenoreNotes = getNotes(TENORE);
		Vector altoNotes = getNotes(ALTO);
		Vector sopranoNotes = getNotes(SOPRANO);
		
		return (bassoNotes.size() == 0 && tenoreNotes.size() == 0 && altoNotes.size() == 0 && sopranoNotes.size() == 0);		
	}
	
	public void addNotes(Vector notes, int voiceType) {
		int size = notes.size();
		
		for(int i = 0; i < size; i++) {
			Note note = (Note) notes.elementAt(i);
			addNote(note, voiceType);
		}
	}
	
	public void addNote(Note note, int voiceType) {
		int measureIndex = -1;
		Measure measure = null;
		
		measureIndex = getCurrentMeasureIndex(voiceType);
		measure = (Measure) measures.elementAt(measureIndex);

		if(measure.isFull(voiceType)) {
			// nel caso in cui sia l'ultima misura ne creiamo una nuova
			if(measureIndex == (measures.size() - 1)) {
				measure = new Measure(rythmUnit, rythmCount);
				measures.add(measure);
				measure.setNumber(measures.size());
			}

			// recuperiamo l'indice della successiva misura disponibile
			incrementMeasureIndex(voiceType);
			measureIndex = getCurrentMeasureIndex(voiceType);
			measure = (Measure) measures.elementAt(measureIndex);	
		}

		if(previousNote != null)
			previousNote.setNextNote(note);
			
		note.setPreviousNote(previousNote);
		
		measure.addNote(note, voiceType);
		
		previousNote = note;
	}
	
	public void replaceNote(Note noteToReplace, Note substituteNote, int voiceType) {
		int size = measures.size();
		int measureIndex;
		
		Measure measure = null;
		
		for(measureIndex = 0; measureIndex < size; measureIndex++) {
			measure = (Measure) measures.elementAt(measureIndex);
			
			if(measure.contains(noteToReplace, voiceType))
				break;
		}
		
		if(measure != null) {
			double durationSubstituteNote = substituteNote.getDuration();
			double durationNoteToReplace = noteToReplace.getDuration();
			
			if(durationSubstituteNote < durationNoteToReplace) {
				Note extraNote = null;
				int index = measure.getNotes(voiceType).indexOf(noteToReplace);
				
				extraNote = NoteUtilities.splitNote(noteToReplace, durationSubstituteNote);
				
				measure.updateTotalDuration(measure.getTotalDuration(voiceType) - (durationNoteToReplace - durationSubstituteNote), voiceType);
				
				measure.updateMinimumDuration();			
				
				measure.addNoteAt(extraNote, voiceType, index + 1);
			}
				
			measure.replaceNote(noteToReplace, substituteNote, voiceType);
		}
	}
	
	public void removeNote(Note note, int voiceType) {
		int size = measures.size();
		int measureIndex;
		
		Vector notes = null;
		
		Measure measure = null;
		
		for(measureIndex = 0; measureIndex < size; measureIndex++) {
			measure = (Measure) measures.elementAt(measureIndex);
			
			if(measure.contains(note, voiceType))
				break;
		}
		
		if(measure != null) {
			notes = measure.getNotes(voiceType);
			
			if((measure == measures.lastElement()) && (note == notes.lastElement()))
				measure.removeNote(note, voiceType);
			else
				note.setVisible(false);
		}
	}
	
	
	public void removeNotes(int voiceType) {
		int size = measures.size();
		int measureIndex;
		
		Measure measure = null;
		
		for(measureIndex = 0; measureIndex < size; measureIndex++) {
			measure = (Measure) measures.elementAt(measureIndex);
			Vector notes = measure.getNotes(voiceType);
			
			for(int i = 0; i < notes.size();i++) {
				Note note = (Note) notes.elementAt(i);
				measure.removeNote(note, voiceType);
				
			}
			
		}
		
		
	}
	// gestire il caso in cui aumento la durata
	public void changeNoteDuration(Note note, double newDuration, int voice) throws InvalidNoteException {
		int measuresSize = measures.size();
		int measureIndex;
	
		double oldDuration = note.getDuration();
		
		Measure measure = null;
		
		for(measureIndex = 0; measureIndex < measuresSize; measureIndex++) {
			measure = (Measure) measures.elementAt(measureIndex);
				
			if(measure.contains(note, voice))
				break;
		}
		
		if(measure != null) {
			Vector notes = measure.getNotes(voice);
		
			int noteIndex = notes.indexOf(note);
			double previousNotesDuration = 0.0;
			
			// recupero la durata totale delle note precedenti nella misura a quella per la quale si vuole cambiare la durata
			for(int i = 0; i < noteIndex; i++) {
				Note n = (Note) notes.elementAt(i);
				previousNotesDuration += n.getDuration();
			}
					
			double usableDuration = measure.getMeasureDuration() - previousNotesDuration;
			double measureTotalDuration = measure.getTotalDuration(voice);
			double incrementOfDuration = newDuration - oldDuration;
			
			if(newDuration <= usableDuration) {											
				note.setDuration(newDuration);
				measure.updateTotalDuration(measureTotalDuration + incrementOfDuration, voice);
				measure.updateMinimumDuration();
				
				if((newDuration < oldDuration) && (measure != measures.lastElement())) {
					Note n = new Note(measure.getAvailableDuration(voice));
					n.setVisible(false);
					measure.addNote(n, voice);
				}
	
				updateCurrentMeasureIndex(voice);
			} 
		}
	}
	
	private void updateCurrentMeasureIndex(int voiceType) {
		int size = measures.size();
	
		Measure measure = null;
		
		for(int i = 0; i < size; i++) {
			measure = (Measure) measures.elementAt(i);
			
			if(!measure.isFull(voiceType)) {
				setCurrentMeasureIndex(i, voiceType);
				break;
			}
		}
	}
	
	public double getRythmUnitDuration() {
		return 1.0 / rythmUnit;
	}
	
	public Vector getMeasures() {
		return measures;
	}
	
	public Vector getNotes(int voiceType) {
		int size = measures.size();
		
		Vector notes = new Vector();
		
		for(int i = 0; i < size; i++) {
			Measure m = (Measure) measures.elementAt(i);
			notes.addAll(m.getNotes(voiceType));
		}
		
		return notes;
	}
	
	public Vector getValueNotes(int voiceType) {
		int size = measures.size();
		
		Vector notes = new Vector();
		
		for(int i = 0; i < size; i++) {
			Measure m = (Measure) measures.elementAt(i);
			notes.addAll(m.getValueNotes(voiceType));
		}
		
		return notes;
	}
	
	private void setCurrentMeasureIndex(int value, int voiceType) {
		switch(voiceType) {
			case BASSO:
				currentMeasureBasso = value;
				break;
			
			case TENORE:
				currentMeasureTenore = value;
				break;
			
			case ALTO:
				currentMeasureAlto = value;	
				break;
			
			case SOPRANO:
				currentMeasureSoprano = value;
		}
	}
	
	private int getCurrentMeasureIndex(int voiceType) {
		int currentMeasureIndex = -1;
		
		switch(voiceType) {
			case BASSO:
				currentMeasureIndex = currentMeasureBasso;
				break;
				
			case TENORE:
				currentMeasureIndex = currentMeasureTenore;
				break;
				
			case ALTO:
				currentMeasureIndex = currentMeasureAlto;	
				break;
				
			case SOPRANO:
				currentMeasureIndex = currentMeasureSoprano;
		}
		
		return currentMeasureIndex;
	}
	
	private void incrementMeasureIndex(int voiceType) {
		switch(voiceType) {
			case BASSO:
				currentMeasureBasso++;
				break;
			
			case TENORE:
				currentMeasureTenore++;
				break;
			
			case ALTO:
				currentMeasureAlto++;
				break;
			
			case SOPRANO:
				currentMeasureSoprano++;
		}
	}
			
	public void print() {
		System.out.println("--------------------------------");
		
		for(int i = 0; i < measures.size(); i++) {
			System.out.println("Measure " + (i+1));
			System.out.println("--------------------------------");
			
			Measure m = (Measure) measures.elementAt(i);
			m.print();
			System.out.println("\n--------------------------------");
		}
	}
	
	public Vector getStaveElements(int voiceType) {
		Vector items = new Vector();
		Vector notes = null;
		
		Measure m = null;
		Note n = null;
		
		StaveElement item = null;
		
		for(int i = 0; i < measures.size(); i++) {
			m = (Measure) measures.elementAt(i);
			notes = m.getNotes(voiceType);
			
			for(int j = 0; j < notes.size(); j++) {
				n = (Note) notes.elementAt(j);
				item = new StaveElement(m, n, voiceType);
				items.add(item);
			}
		}
		
		return items;
	}
	
	public static void main(String[] args) {
		Stave s = new Stave(4, 4);

		Note n1 = new Note(0.25);
		Note n2 = new Note(1.0);
		
		s.addNote(n1, BASSO);
		s.addNote(n2, BASSO);

		s.print();
	}
	
	private Score score = null;
	
	private Vector measures = null;
	
	private Note previousNote = null;
	
	private int currentMeasureBasso = 0;
	private int currentMeasureTenore = 0;
	private int currentMeasureAlto = 0;
	private int currentMeasureSoprano = 0;
	
	private int rythmUnit = 0;
	private int rythmCount = 0;
}
