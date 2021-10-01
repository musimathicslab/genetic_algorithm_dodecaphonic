package it.unisa.dia.music.etn.data;

import it.unisa.dia.music.etn.constants.data.*;
import it.unisa.dia.music.etn.exception.*;
import it.unisa.dia.music.etn.util.*;

public class Interval implements IntervalConstants, Cloneable {
	public Interval(String description) {
		try {
			Integer semitones = IntervalUtilities.getIntervalSemitonesFromDescription(description);

			this.description = description;
			this.semitones   = semitones;
		} catch (InvalidIntervalException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
	
	public Interval(Integer semitones) {
		try {
			String description = IntervalUtilities.getIntervalDescriptionFromSemitones(semitones);

			this.description = description;
			this.semitones = semitones;		
		} catch (InvalidIntervalException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}		
	}
		
	public String getDescription() {
		return description;
	}
	
	public Integer getSemitones() {
		return semitones;
	}
	
	public String toString() {
		return getSemitones() + "";
	}
	
	public Interval clone() throws CloneNotSupportedException {
		Interval clonedInterval = (Interval) super.clone();
		
		clonedInterval.description = description;
		clonedInterval.semitones = semitones.intValue();
		
		return clonedInterval;
	}
	
	
	/* Interval description */
	private String description = null;
	/* Interval semitones */
	private Integer semitones  = null;
}
