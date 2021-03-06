package it.meh.stave;

import it.meh.score.data.Measure;
import it.meh.score.data.Note;

public class StaveElement {
	public StaveElement(Measure measure, Note note, int voice) {
		this.measure = measure;
		this.note = note;
		this.voice = voice;
	}
	
	public Measure getMeasure() {
		return measure;
	}
	
	public Note getNote() {
		return note;
	}
	
	public int getVoice() {
		return voice;
	}
	
	private Measure measure;
	private Note note;
	private int voice;
}
