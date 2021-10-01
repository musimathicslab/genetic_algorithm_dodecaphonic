package it.unisa.dia.music.etn.data;

import java.util.*;

import it.unisa.dia.music.etn.constants.data.*;
import it.unisa.dia.music.etn.exception.*;


public class Series implements SeriesConstants, IntervalConstants, Cloneable {
	public Series() {}
	
	public Series(Interval[] intervals, Form form) {
		this.intervals = intervals;
		this.form      = form;
	}
	
	public Interval[] getIntervals() {
		return intervals;
	}
	
	public void setIntervals(Interval[] intervals) throws InvalidSeriesException {
		if(intervals != null && intervals.length != SERIES_LENGTH)
			throw new InvalidSeriesException("Invalid series length");
		
		this.intervals = intervals;
	}
	
	public Form getForm() {
		return form;
	}
	
	public void setForm(Form form) {
		this.form = form;
	}

	public String toString() {
		return "[ Form = " + form.toString()
			   + ", Intervals = " + Arrays.toString(intervals)
			   + "]";
	}
	
	public Series clone() throws CloneNotSupportedException {
		Series clonedSeries = (Series) super.clone();
		
		clonedSeries.form = form;
		clonedSeries.intervals = intervals.clone();
		
		return clonedSeries;
	}
		
	public static void main(String[] args) throws InvalidIntervalException {
		
	}
	
	
	/* Series form */
	private Form form  = null;
	/* Series intervals */
	private Interval[] intervals = null;
}
