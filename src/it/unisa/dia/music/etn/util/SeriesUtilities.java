package it.unisa.dia.music.etn.util;

import java.util.*;

import it.meh.score.data.Note;
import it.unisa.dia.music.etn.constants.data.*;
import it.unisa.dia.music.etn.data.*;
import it.unisa.dia.music.etn.exception.InvalidIntervalException;
import it.unisa.dia.music.etn.exception.InvalidSeriesException;


public class SeriesUtilities implements SeriesConstants, IntervalConstants, NoteConstants {
	public static Note[] getSeriesNotes(Note startingSeriesNote, Series series) throws CloneNotSupportedException {
		Note[] seriesNotes = new Note[SERIES_LENGTH + 1];

		/* get series intervals */
		Interval[] seriesIntervals = series.getIntervals();
		
		/* get series notes */
		seriesNotes[0] = startingSeriesNote.clone();
		
		for(int i = 1; i < (SERIES_LENGTH + 1); i++) {
			Note previousNote = seriesNotes[i-1];
			Interval derivatedIntervalSemitones = seriesIntervals[i-1];
			
			seriesNotes[i] = new Note((previousNote.getValue() + derivatedIntervalSemitones.getSemitones()) % 12);
		}
		
		return seriesNotes;
	}
	
	public static Transformation generateTransformation(Note seriesStartingNote, Series series) throws CloneNotSupportedException, InvalidSeriesException, InvalidIntervalException {
		Transformation generatedTransformation = null;
		
		/* select a derivated form randomly */
		Form[] derivatedForms = Form.values();
		Form selectedForm = derivatedForms[(int) (Math.random() * derivatedForms.length)];
		
		/* get the derivated series */
		Series derivatedSeries = getDerivatedForm(series, selectedForm);
		
		/* get the notes of the derivated series */
		Note[] derivatedSeriesNotes = getSeriesNotes(seriesStartingNote, derivatedSeries);
		
		int placedSerieNoteNumber = 0;
		
		Vector<Note> transformationNotesVector = new Vector<Note>();

		Note note = new Note(0);

		while(placedSerieNoteNumber < derivatedSeriesNotes.length) {		
			double rand = Math.random();
			
			if(rand >= 0.3) { /* select a series note */
				note = derivatedSeriesNotes[placedSerieNoteNumber].clone();
				placedSerieNoteNumber++;
			} else { /* place a rest */
				/* if the previous element is a pause continue */
				if(note.isRest())
					continue;
				
				note = new Note(-1);
			}
			
			/* select a note duration randomly */
			Double duration = NOTE_DURATIONS[(int) (Math.random() * NOTE_DURATIONS.length)];
			note.setDuration(duration);
			
			transformationNotesVector.add(note);
		}
		
		/* set the generated transformation */
		generatedTransformation = new Transformation();
		
		Note[] transformationNotes = new Note[transformationNotesVector.size()];
		transformationNotesVector.toArray(transformationNotes);
		
		generatedTransformation.setNotes(transformationNotes);
		generatedTransformation.setSeries(derivatedSeries);
		
		
		return generatedTransformation;
	}
	
	public static Series getDerivatedForm(Series series, Form form) throws CloneNotSupportedException, InvalidSeriesException, InvalidIntervalException {
		Series derivatedSeries = null;
		
		switch(form) {
			case F:
				derivatedSeries = series.clone();
				break;
			case RE:
				derivatedSeries = getRetrogradeForm(series);
				break;
			case RO:
				derivatedSeries = getInversionForm(series);
				break;
			case RE_RO:
				derivatedSeries = getRetrogradeOfInversionForm(series);
				break;
			case IV:
				derivatedSeries = getFourthForm(series);
				break;
			case V:
				derivatedSeries = getFifthForm(series);
				break;
			case RE_IV:
				derivatedSeries = getRetrogradeOfFourthForm(series);
				break;
			case RE_V:
				derivatedSeries = getRetrogradeOfFifthForm(series);
				break;
		}
		
		return derivatedSeries;
	}
	
 	/* returns the retrograde form of a series */
	public static Series getRetrogradeForm(Series series) throws InvalidSeriesException {
		Series derivedSeries = null;
		
		if(series != null) {
			derivedSeries = new Series();
			
			/* get the intervals of the series */
			Interval[] seriesIntervals = series.getIntervals();
			
			/* get the retrograde of the above intervals */
			List<Interval> seriesIntervalList = Arrays.asList(seriesIntervals.clone());
			Collections.reverse(seriesIntervalList);
			
			/* set the intervals of the derived series */
			Interval[] derivedSeriesIntervalList = (Interval[]) seriesIntervalList.toArray();
			derivedSeries.setIntervals(derivedSeriesIntervalList);
			
			/* set the form of the derived series */
			derivedSeries.setForm(Form.RE);
		}
		
		return derivedSeries;
	}
	
	/* returns the inversion form of a series */
	public static Series getInversionForm(Series series) throws InvalidIntervalException, InvalidSeriesException {
		Series derivedSeries = null;
		
		if(series != null) {
			derivedSeries = new Series();
		
			/* get the intervals of the series */
			Interval[] seriesIntervals = series.getIntervals();
			
			/* get the inversion of the above intervals */		
			Interval[] derivedSeriesIntervals = new Interval[SERIES_LENGTH];
			
			for(int i = 0; i < SERIES_LENGTH; i++) {
				Interval seriesInterval = seriesIntervals[i];
				derivedSeriesIntervals[i] = new Interval(12 - seriesInterval.getSemitones());
			}
			
			/* set the invervals of the derived series */		
			derivedSeries.setIntervals(derivedSeriesIntervals);
			
			/* set the form of the derived series */
			derivedSeries.setForm(Form.RO);
		}
		
		return derivedSeries;		
	}
	
	/* returns the retrograde of inversion form of a series */
	public static Series getRetrogradeOfInversionForm(Series series) throws InvalidSeriesException, InvalidIntervalException {
		Series derivedSeries = null;
		
		if(series != null) {
			derivedSeries = getRetrogradeForm(getInversionForm(series));
			
			/* set the form of the derived series */
			derivedSeries.setForm(Form.RE_RO);
		}
		
		return derivedSeries;
	}
	
	/* returns the fourth form of a series */
	public static Series getFourthForm(Series series) throws InvalidIntervalException, InvalidSeriesException {
		Series derivedSeries = null;
		
		if(series != null) {
			derivedSeries = new Series();
			
			/* get the intervals of the series */
			Interval[] seriesIntervals = series.getIntervals();
			
			/* get the inversion of the above intervals */		
			Interval[] derivedSeriesIntervals = new Interval[SERIES_LENGTH];
			
			for(int i = 0; i < SERIES_LENGTH; i++) {
				Interval seriesInterval = seriesIntervals[i];
				derivedSeriesIntervals[i] = new Interval((seriesInterval.getSemitones() * 5) % 12);
			}
			
			/* set the invervals of the derived series */		
			derivedSeries.setIntervals(derivedSeriesIntervals);
			
			/* set the form of the derived series */
			derivedSeries.setForm(Form.IV);

		}
		
		return derivedSeries;
	}
	
	/* returns the fifth form of a series */
	public static Series getFifthForm(Series series) throws InvalidIntervalException, InvalidSeriesException {
		Series derivedSeries = null;
		
		if(series != null) {
			derivedSeries = new Series();
			
			/* get the intervals of the series */
			Interval[] seriesIntervals = series.getIntervals();
			
			/* get the inversion of the above intervals */		
			Interval[] derivedSeriesIntervals = new Interval[SERIES_LENGTH];
			
			for(int i = 0; i < SERIES_LENGTH; i++) {
				Interval seriesInterval = seriesIntervals[i];
				derivedSeriesIntervals[i] = new Interval((seriesInterval.getSemitones() * 7) % 12);
			}
			
			/* set the invervals of the derived series */		
			derivedSeries.setIntervals(derivedSeriesIntervals);
			
			/* set the form of the derived series */
			derivedSeries.setForm(Form.IV);

		}
		
		return derivedSeries;
	}
	
	/* returns the retrograde of the fourth form of a series */
	public static Series getRetrogradeOfFourthForm(Series series) throws InvalidSeriesException, InvalidIntervalException {
		Series derivedSeries = null;
		
		if(series != null) {
			derivedSeries = getRetrogradeForm(getFourthForm(series));
			
			/* set the form of the derived series */
			derivedSeries.setForm(Form.RE_IV);
		}
		
		return derivedSeries;
	}
	
	/* returns the retrograde of the fifth form of a series */
	public static Series getRetrogradeOfFifthForm(Series series) throws InvalidSeriesException, InvalidIntervalException {
		Series derivedSeries = null;
		
		if(series != null) {
			derivedSeries = getRetrogradeForm(getFifthForm(series));
			
			/* set the form of the derived series */
			derivedSeries.setForm(Form.RE_V);
		}
		
		return derivedSeries;
	}
	
	/* Test main */
	public static void main(String[] args) throws InvalidIntervalException, InvalidSeriesException, CloneNotSupportedException {
		/* fondamentale */
		Form seriesForm = Form.F;
		/* 2 - 1 - 7 - 3 - 4 - 6 - 9 - 8 - 5 - 10 - 11 */
		Interval[] seriesIntervals = new Interval[] { new Interval(2), 
													  new Interval(1), 
													  new Interval(7), 
													  new Interval(3), 
													  new Interval(4), 
													  new Interval(6),
													  new Interval(9), 
													  new Interval(8),  
													  new Interval(5),
													  new Interval(10), 
													  new Interval(11)
               										};
		
		Series series = new Series();
		series.setForm(seriesForm);
		series.setIntervals(seriesIntervals);
		
		Transformation generatedTransformation = generateTransformation(new Note(0), series);
		
		System.out.println(generatedTransformation);
	}
}
