package it.unisa.dia.music.etn.constants.data;

import it.meh.score.data.Note;
import it.unisa.dia.music.etn.data.*;

public interface SeriesConstants {
	/* Series interval number */
	public static final Integer SERIES_LENGTH = 11;
	
	/* Constants relative to derived forms of the series */
	public enum Form {
		F,      /* fondamentale */
		RE,     /* retrograda */
		RO,     /* rovescio */
		RE_RO,  /* retrograda del rovescio */
		IV,     /* trasformazione alla quarta */
		V,      /* trasformazione alla quinta */
		RE_IV,  /* retrograda della trasformazione alla quarta */
		RE_V;   /* retrograda della trasformazione alla quinta" */
	};
	
	/* Default series form */
	public static final Form DEFAULT_SERIES_FORM = Form.F;

	/* Default series intervals: 2 - 1 - 7 - 3 - 4 - 6 - 9 - 8 - 5 - 10 - 11 */
	public static final Interval[] DEFAULT_SERIES_INTERVALS = new Interval[] { new Interval(2), 
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
	
	/* Default series */
	public static final Series DEFAULT_SERIES = new Series(DEFAULT_SERIES_INTERVALS, DEFAULT_SERIES_FORM);
	
	/* Default series starting note */
	public static final Note DEFAULT_SERIES_STARTING_NOTE = new Note(0);
}
