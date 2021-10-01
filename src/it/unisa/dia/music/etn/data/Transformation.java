package it.unisa.dia.music.etn.data;

import it.meh.score.data.*;

import java.util.*;


public class Transformation implements Cloneable {
	public Note[] getNotes() {
		return notes;
	}
	
	public void setNotes(Note[] notes) {
		this.notes = notes;
	}
	
	public Series getSeries() {
		return series;
	}
	
	public void setSeries(Series series) {
		this.series = series;
	}
	
	public Transformation clone() throws CloneNotSupportedException {
		Transformation clonedTransformation = (Transformation) super.clone();
		
		clonedTransformation.notes = notes.clone();
		clonedTransformation.series = series.clone();
		
		return clonedTransformation;
	}
	
	public String toString() {
		return "[ notes = " + Arrays.toString(notes) + 
			   ", series = " + series +
			   "]";
	}
	
	
	/* Transformation notes */
	private Note[] notes = null;
	/* Transformation series */
	private Series series = null; 
}
