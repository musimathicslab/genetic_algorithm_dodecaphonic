package it.unisa.dia.music.etn.ga.gpm;

import java.util.Random;
import java.util.Vector;

import jm.constants.Durations;
import jm.constants.Pitches;
import jm.music.data.Part;
import jm.music.data.Phrase;

import it.meh.score.data.*;
import it.meh.stave.*;
import it.unisa.dia.music.etn.constants.*;
import it.unisa.dia.music.etn.data.*;
import it.unisa.dia.music.etn.ga.chromosome.*;
import it.unisa.dia.music.etn.ga.configuration.*;
import it.unisa.dia.music.etn.ga.gene.*;


public class GPMFunction implements StaveConstants, DoubleStaveConstants {
	public static jm.music.data.Score map(TwelveNoteChromosome chromosome, TwelveNoteConfiguration configuration) {
		jm.music.data.Score twelveNoteComposition = new jm.music.data.Score("Best Dodecaphonic Composition");
		
		TwelveNoteVerticalGene[] genes = chromosome.getGenes();
		
		Transformation transformation = null;
		
		for(int i = 0; i < configuration.getMelodicLineNumber(); i++) {
			Part p = new Part("Voice" + i, i);
			for(int j = 0; j < genes.length; j++) {
				
				transformation = genes[j].getTransformations()[i];
				Vector<Note> compositionNotes = getNotesFromTransformation(transformation, i);
				p.addPhrase(fromNotesToPhrase(compositionNotes));
				
			}
			twelveNoteComposition.addPart(p);
		}
		
		
		return twelveNoteComposition;
	}
	
	private static Phrase fromNotesToPhrase(Vector<Note> compositionNotes) {
		Phrase f = new Phrase();	
		
		Vector convertedNotePitch = new Vector();
		Vector convertedNoteRythm = new Vector();
		for(int i = 0; i < compositionNotes.size(); i++) {
			Note note = compositionNotes.elementAt(i);
			Integer pitch =  null;
			Double rythm = null;
			if(note.getValue() == -1) {
				pitch = Pitches.REST;
				rythm = fromSymbolToRythm(note.getDurationSymbol());
			} else {
			    pitch = note.getValue();
				rythm = fromSymbolToRythm(note.getDurationSymbol());
				
			}
			convertedNotePitch.add(pitch);
			convertedNoteRythm.add(rythm);
		}
		
		int[] pitch = new int[convertedNotePitch.size()];
		for(int i = 0; i < convertedNotePitch.size(); i++) {
			pitch[i] = (Integer)convertedNotePitch.elementAt(i);
		}
		
		double[] rythm = new double[convertedNoteRythm.size()];
		for(int i = 0; i < convertedNoteRythm.size(); i++) {
			rythm[i] = (Double)convertedNoteRythm.elementAt(i);
		}
		
		f.addNoteList(pitch,rythm);
		
		return f;
	}
	
	private static double fromSymbolToRythm(String noteDuration) {
		double rythm = -1;
		
		if(noteDuration.equalsIgnoreCase(WHOLE_NOTE_SYMBOL))
			rythm = Durations.SEMIBREVE;
		else if(noteDuration.equalsIgnoreCase(HALF_NOTE_SYMBOL))
			rythm = Durations.MINIM;
		else if(noteDuration.equalsIgnoreCase(QUARTER_NOTE_SYMBOL))
			rythm = Durations.QUARTER_NOTE;
		else if(noteDuration.equalsIgnoreCase(EIGHTH_NOTE_SYMBOL))
			rythm = Durations.EIGHTH_NOTE;
		else if(noteDuration.equalsIgnoreCase(SIXTEENTH_NOTE_SYMBOL))
			rythm = Durations.SIXTEENTH_NOTE;
		
		return rythm;
	}
	
	private static String fromSymbolToAlterSymbol(String alterSymbol) {
		String alter = null;
		
		if(alterSymbol.equalsIgnoreCase(SHARP_SYMBOL))
			alter = "S";
		else if(alterSymbol.equalsIgnoreCase(FLAT_SYMBOL))
			alter = "F";
		else if(alterSymbol.equalsIgnoreCase(NO_ALTER_SYMBOL))
			alter = "";
		
		return alter;
	}
	
	private static Vector<Note> getNotesFromTransformation(Transformation transformation, int voice) {
		Vector<Note> compositionNotes = new Vector<Note>();
		
		Note[] transformationNotes = transformation.getNotes();
		
		for(Note note : transformationNotes) {
			Note realNote = null;
			
			if(note.isRest()) {
				realNote = note;
			} else {
				Integer[] realNotes = fromOctaveToVoiceRelative(voice, note.getValue());
				realNote = new Note(realNotes[(int) (Math.random() * realNotes.length)]);
				
			}	
			// Variazione ritmica
				double [] durations = {WHOLE_NOTE_DURATION,HALF_NOTE_DURATION, QUARTER_NOTE_DURATION,EIGHTH_NOTE_DURATION,SIXTEENTH_NOTE_DURATION};
				Random generator = new Random();
				int index = generator.nextInt(durations.length);
				realNote.setDuration(durations[index]);
			
			
			compositionNotes.add(realNote);
		}
		
		return compositionNotes;
	}
	
	/* 
	 * Restituisce le note (in valore MIDI) comprese nell'intervallo della voce 
	 * richiesta corrispondenti all'insieme di note (relative all'ottava) specificate 
	 * in input.
	 */
	private static Integer[][] fromOctaveToVoiceRelative(int voice, Integer[] octaveRelativeNotes) {
		int relativeNotesNumber = octaveRelativeNotes.length;  
		
		Integer[][] voiceRelativeNotes = new Integer[relativeNotesNumber][];
		
		for(int i = 0; i < octaveRelativeNotes.length; i++) {
			Integer[] voiceRelativeNotesForSingleNote = fromOctaveToVoiceRelative(voice, octaveRelativeNotes[i]);
			voiceRelativeNotes[i] = voiceRelativeNotesForSingleNote;
		}
		
		return voiceRelativeNotes;
	}
	
	/* 
	 * Restituisce le note (in valore MIDI) comprese nell'intervallo della voce 
	 * richiesta corrispondenti alla nota (relativa all'ottava) specificata in input.
	 * 
	 * Ex.
	 * INPUT
	 * -----
	 * voice = BASS --> Interval = [40, 62]
	 * octaveRelativeNote = G (7)
	 * 
	 * OUTPUT
	 * ------
	 * RealNoteValues = {43, 55}
	 */
	private static Integer[] fromOctaveToVoiceRelative(int voice, Integer octaveRelativeNote) {
		Integer[] voiceRelativeNotes = null;
	
		int voiceLowerBound = getVoiceLowerBound(voice);
		int voiceUpperBound = getVoiceUpperBound(voice);
		
		Vector<Integer> realNoteValues = new Vector<Integer>();
		
		int offset = octaveRelativeNote - (voiceLowerBound % 12);
			
		if(offset < 0)
			offset += 12;
			
		while((voiceLowerBound + offset) <= voiceUpperBound) {
			realNoteValues.add(voiceLowerBound + offset);
			offset += 12;
		}
		
		voiceRelativeNotes = new Integer[realNoteValues.size()];
		realNoteValues.toArray(voiceRelativeNotes);
		
		return voiceRelativeNotes;
	}
	
	private static int getVoiceLowerBound(int voice) {
		int lowerBound = 0;
		
		switch(voice) {
			case BASSO:
				lowerBound = BASSO_LB;
				break;
			case TENORE:
				lowerBound = TENORE_LB;
				break;
			case ALTO:
				lowerBound = ALTO_LB;
				break;
			case SOPRANO:
				lowerBound = SOPRANO_LB;
		}
		
		return lowerBound;
	}

	private static int getVoiceUpperBound(int voice) {
		int upperBound = 0;
		
		switch(voice) {
			case BASSO:
				upperBound = BASSO_UB;
				break;
			case TENORE:
				upperBound = TENORE_UB;
				break;
			case ALTO:
				upperBound = ALTO_UB;
				break;
			case SOPRANO:
				upperBound = SOPRANO_UB;
		}
		
		return upperBound;
	}
}
