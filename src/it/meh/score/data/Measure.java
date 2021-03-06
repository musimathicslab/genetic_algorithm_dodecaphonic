package it.meh.score.data;

import it.meh.score.util.InvalidNoteException;
import it.meh.score.util.NoteUtilities;
import it.unisa.dia.music.etn.constants.DoubleStaveConstants;

import java.util.Collections;
import java.util.Vector;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;


public class Measure implements DoubleStaveConstants {
	public Measure(int rythmUnit, int rythmCount) {
		this.rythmUnit = rythmUnit;
		this.rythmCount = rythmCount;
		
		minDuration = duration = (1.0 / rythmUnit) * rythmCount;
	}
		
	public void replaceNote(Note noteToReplace, Note substituteNote, int voiceType) {
		Vector notes = getNotes(voiceType);
				
		if(!contains(noteToReplace, voiceType))
			return;
		
		double noteToReplaceDuration = noteToReplace.getDuration();
		double substituteNoteDuration = substituteNote.getDuration();
		
		if(substituteNoteDuration > noteToReplaceDuration)
			return;
		
		if(substituteNoteDuration < noteToReplaceDuration)
			NoteUtilities.splitNote(noteToReplace, substituteNoteDuration);
		
		int noteToReplaceIndex = notes.indexOf(noteToReplace);
		
		notes.setElementAt(substituteNote, noteToReplaceIndex);
	}
	
	public Note addNoteAt(Note note, int voiceType, int position) {
		Vector notes = getNotes(voiceType);
		
		Note extraNote = null;
		
		double noteDuration = note.getDuration();
		double availableDuration = getAvailableDuration(voiceType);
		
		if(isFull(voiceType))
			return note;
		
		if(noteDuration > availableDuration)
			return null;
		
		noteDuration = note.getDuration();	
				
		notes.insertElementAt(note, position++);
		incrementVoiceDuration(voiceType, noteDuration);
		
		if(noteDuration < minDuration)
			setMinimumDuration(noteDuration);
					
		return extraNote;
	}
	
	public Note addNote(Note note, int voiceType) {
		Vector notes = getNotes(voiceType);
		Note newNote = null;
		
		newNote = addNoteAt(note, voiceType, notes.size());
		
		return newNote;
	}
	
	public Note splitNote(Note note, double newDuration, int voiceType) {
		Vector notes = getNotes(voiceType);
		
		if(!contains(note, voiceType))
			return null;
	
		if(newDuration > note.getDuration())
			return null;
		
		int noteIndex = notes.indexOf(note);
			
		Note newNote = (Note) NoteUtilities.splitNote(note, newDuration);
		notes.insertElementAt(newNote, noteIndex + 1);
		
		return newNote;
	}
	
	public void adjustNoteDuration(Note note, int voiceType) {
		Vector notes = getNotes(voiceType);
		
		if(!contains(note, voiceType))
			return;
			
		int index = notes.indexOf(note);	
		
		while(!NoteUtilities.isCorrectDuration(note.getDuration())) {
			Note newNote = NoteUtilities.adjustNoteDuration(note);
			notes.insertElementAt(newNote, ++index);
		}
	}
	
	public void removeNotes(Vector notes, int voiceType) {
		for(int i = 0; i < notes.size(); i++) {
			Note n = (Note) notes.elementAt(i);
			removeNote(n, voiceType);
		}
	}
	
	public void removeNote(Note note, int voiceType) {		
		if(!contains(note, voiceType))
			return;
		
		Vector notes = getNotes(voiceType);
		
		double duration = note.getDuration();
		
		notes.remove(note);
		incrementVoiceDuration(voiceType, duration * -1);
		
		updateMinimumDuration();
	}
		
	public boolean contains(Note note, int voiceType) {
		Vector notes = getNotes(voiceType);
		int size = notes.size();
		
		for(int i = 0; i < size; i++) {
			Note n = (Note) notes.elementAt(i);
			
			if(n == note)
				return true;
		}
		
		return false;
	}
	 
	public boolean isEmpty(int voiceType) {
		boolean result = false;
		
		switch(voiceType) {
			case BASSO:
				result = (totalDurationBasso == 0.0);
				break;
			
			case TENORE:
				result = (totalDurationTenore == 0.0);
				break;
			
			case ALTO:
				result = (totalDurationAlto == 0.0);
				break;
			
			case SOPRANO:
				result = (totalDurationSoprano == 0.0);
		}
		
		return result;
	}
	
	public boolean isFull(int voiceType) {
		boolean result = false;
		
		switch(voiceType) {
			case BASSO:
				result = (totalDurationBasso == duration);
				break;
			
			case TENORE:
				result = (totalDurationTenore == duration);
				break;
			
			case ALTO:
				result = (totalDurationAlto == duration);
				break;
			
			case SOPRANO:
				result = (totalDurationSoprano == duration);
		}
		
		return result;
	}
	
	public void updateMinimumDuration() {		
		double bassoMinDuration = getVoiceMinimumDuration(BASSO);
		double tenoreMinDuration = getVoiceMinimumDuration(TENORE);
		double sopranoMinDuration = getVoiceMinimumDuration(SOPRANO);
		double altoMinDuration = getVoiceMinimumDuration(ALTO);
		
		Vector durations = new Vector();
		durations.add(new Double(bassoMinDuration));
		durations.add(new Double(tenoreMinDuration));
		durations.add(new Double(sopranoMinDuration));
		durations.add(new Double(altoMinDuration));
		
		Collections.sort(durations.subList(0, durations.size()));
		minDuration = ((Double) durations.elementAt(0)).doubleValue();
	}
	
	private double getVoiceMinimumDuration(int voiceType) {
		double minimumDuration = duration;
		
		Vector notes = getNotes(voiceType);
		Note note = null;
		
		double duration = 0.0;
		
		for(int i = 0; i < notes.size(); i++) {
			note = (Note) notes.elementAt(i);
			duration = note.getDuration();
			
			if(duration < minimumDuration)
				minimumDuration = duration;
		}
		
		return minimumDuration;
	}
	
	public double getMinimumDuration() {		
		return minDuration;
	}
	
	public void updateTotalDuration(double totalDuration, int voiceType) {
		switch(voiceType) {
			case BASSO:
				totalDurationBasso = totalDuration;
				break;
			
			case TENORE:
				totalDurationTenore = totalDuration;
				break;
			
			case ALTO:
				totalDurationAlto = totalDuration;
				break;
			
			case SOPRANO:
				totalDurationSoprano = totalDuration;
				break;
		}
	}
	
	public double getTotalDuration(int voiceType) {
		double totalDuration = 0.0;
		
		switch(voiceType) {
			case BASSO:
				totalDuration = totalDurationBasso;
				break;
				
			case TENORE:
				totalDuration = totalDurationTenore;
				break;
				
			case ALTO:
				totalDuration = totalDurationAlto;
				break;
				
			case SOPRANO:
				totalDuration = totalDurationSoprano;
				break;
		}
		
		return totalDuration;
	}
	
	private void setMinimumDuration(double minDuration) {
		this.minDuration = minDuration;
	}
	
	public Vector getNotes() {
		Vector notes = new Vector();
		notes.addAll(getNotes(BASSO));
		notes.addAll(getNotes(TENORE));
		notes.addAll(getNotes(ALTO));
		notes.addAll(getNotes(SOPRANO));
		
		return notes;
	}
	
	public Note getMeasureFirstNote(int voiceType) {
		Vector notes = getNotes(voiceType);
		
		if(notes.isEmpty())
			return null;
		
		return (Note) notes.firstElement();
	}
	
	public Vector getNotes(int voiceType) {
		Vector notes = null;
			
		switch(voiceType) {
			case BASSO: 
				notes = notesBasso;
				break;
					
			case TENORE:
				notes = notesTenore;
				break;
					
			case ALTO:
				notes = notesAlto;
				break;
				
			case SOPRANO:
				notes = notesSoprano;
		}
			
		return notes;
	}
	
	private Vector getValuesNoteFromVector(Vector notes) {
		Vector valueNotes = new Vector();
		int size = notes.size();
		for(int i = 0; i < size; i++) {
			valueNotes.add(((Note)notes.elementAt(i)).getValue());
		}
		return valueNotes;
	}
	
	public Vector getValueNotes(int voiceType) {
		Vector valueNotes = null;
			
		switch(voiceType) {
			case BASSO: 
				valueNotes = getValuesNoteFromVector(notesBasso);
				break;
					
			case TENORE:
				valueNotes = getValuesNoteFromVector(notesTenore);
				break;
					
			case ALTO:
				valueNotes = getValuesNoteFromVector(notesAlto);
				break;
				
			case SOPRANO:
				valueNotes = getValuesNoteFromVector(notesSoprano);
		}
			
		return valueNotes;
	}
	
	public double getAvailableDuration(int voice) {
		double availableDuration = 0.0;
		
		switch(voice) {
			case BASSO:
				availableDuration = duration - totalDurationBasso;
				break;
			
			case TENORE:
				availableDuration = duration - totalDurationTenore;
				break;
			
			case ALTO:
				availableDuration = duration - totalDurationAlto;
				break;
			
			case SOPRANO:
				availableDuration = duration - totalDurationSoprano;	
		}
		
		return availableDuration;
	}
		
	public double getMeasureDuration() {
		return duration;
	}
	
	private void incrementVoiceDuration(int voiceType, double duration) {
		switch(voiceType) {
			case BASSO:
				totalDurationBasso += duration;
				break;
				
			case TENORE:
				totalDurationTenore += duration;
				break;
				
			case ALTO:
				totalDurationAlto += duration;
				break;
				
			case SOPRANO:
				totalDurationSoprano += duration;
		}
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}
	
	public int getStartPosition() {
		return startPosition;
	}
	
	public void setEndPosition(int endPosition) {
		this.endPosition = endPosition;
	}
	
	public int getEndPosition() {
		return endPosition;
	}
	
	public void print() {
		System.out.print("BASSO: ");
		printNotes(notesBasso);
		
		System.out.print("\nTENORE: ");
		printNotes(notesTenore);
		
		System.out.print("\nALTO: ");
		printNotes(notesAlto);
		
		System.out.print("\nSOPRANO: ");
		printNotes(notesSoprano);
		
		System.out.println("\n\nMinimun duration: " + getMinimumDuration());
	}
	
	private void printNotes(Vector notes) {
		for(int i = 0; i < notes.size(); i++) {
			Note note = (Note) notes.elementAt(i);
			System.out.print(note.getDuration() + " ");
		}	
	}
		
	public static void main(String[] args) throws InvalidNoteException {
		Vector v = new Vector();
		v.add("1");
		v.add("2");
		
		for(int i = 0; i < v.size(); i++)
			System.out.print(v.elementAt(i) + " ");
		
		System.out.println();
		
		v.insertElementAt("3", v.size());
		
		for(int i = 0; i < v.size(); i++)
			System.out.print(v.elementAt(i) + " ");
		
		System.out.println();
		
	}
	
	private double duration = 0.0;
	private double minDuration = 0.0;
	
	private int rythmUnit = 0;
	private int rythmCount = 0;
	
	private int number = 0;
	
	// posizione sullo stave in cui inizia la misura
	private int startPosition = -1;
	// posizione sullo stave in cui finisce la misura
	private int endPosition = -1;
	
	private Vector notesBasso = new Vector();
	private Vector notesTenore = new Vector();
	private Vector notesAlto = new Vector();
	private Vector notesSoprano = new Vector();
	
	private double totalDurationBasso = 0.0;
	private double totalDurationTenore = 0.0;
	private double totalDurationAlto = 0.0;
	private double totalDurationSoprano = 0.0;
}
