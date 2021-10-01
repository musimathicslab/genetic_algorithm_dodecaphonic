package it.unisa.dia.music.etn.util;

import it.meh.score.data.Note;
import it.unisa.dia.music.etn.constants.data.*;
import it.unisa.dia.music.etn.data.*;
import it.unisa.dia.music.etn.exception.*;


public class IntervalUtilities implements IntervalConstants {
	public static String getIntervalDescriptionFromSemitones(Integer semitones) throws InvalidIntervalException {
		String description = null;
		
		if(semitones == null)
			throw new InvalidIntervalException("no interval semitones value specified");
		
		switch (semitones) {
			/* unison */
			case 0:
				description = DESCRIPTION_UNISON;
				break;
			/* second minor */
			case 1:
				description = DESCRIPTION_SECOND_MIN;
				break;
			/* second major */
			case 2:
				description = DESCRIPTION_SECOND_MAJ;
				break;
			/* third minor */
			case 3:
				description = DESCRIPTION_THIRD_MIN;
				break;
			/* third major */
			case 4:
				description = DESCRIPTION_THIRD_MAJ;
				break;
			/* fourth */
			case 5:
				description = DESCRIPTION_FOURTH;
				break;
			/* tritone */
			case 6:
				description = DESCRIPTION_TRITONE;
				break;
			/* fifth */
			case 7:
				description = DESCRIPTION_FIFTH;
				break;
			/* sixth minor */
			case 8:
				description = DESCRIPTION_SIXTH_MIN;
				break;
			/* sixth major */
			case 9:
				description = DESCRIPTION_SIXHT_MAJ;
				break;
			/* seventh minor */
			case 10:
				description = DESCRIPTION_SEVENTH_MIN;
				break;
			/* seventh major */
			case 11:
				description = DESCRIPTION_SEVENTH_MAJ;
				break;
			/* invalid interval */
			default:
				throw new InvalidIntervalException("invalid interval semitones value");
		}
		
		return description;
	}
	
	public static Integer getIntervalSemitonesFromDescription(String description) throws InvalidIntervalException {
		Integer semitones = null;
		
		if(description == null)
			throw new InvalidIntervalException("no interval description specified");
		
		/* unison */
		if(description.equals(DESCRIPTION_UNISON))
			semitones = SEMITONES_UNISON;
		/* second minor */
		else if(description.equals(DESCRIPTION_SECOND_MIN))
			semitones = SEMITONES_SECOND_MIN;
		/* second major */
		else if(description.equals(DESCRIPTION_SECOND_MAJ))
			semitones = SEMITONES_SECOND_MAJ;
		/* third minor */
		else if(description.equals(DESCRIPTION_THIRD_MIN))
			semitones = SEMITONES_THIRD_MIN;
		/* thir major */
		else if(description.equals(DESCRIPTION_THIRD_MAJ))
			semitones = SEMITONES_THIRD_MAJ;
		/* fourth minor */
		else if(description.equals(DESCRIPTION_FOURTH))
			semitones = SEMITONES_FOURTH;
		/* tritone */
		else if(description.equals(DESCRIPTION_TRITONE))
			semitones = SEMITONES_TRITONE;
		/* fifth */
		else if(description.equals(DESCRIPTION_FIFTH))
			semitones = SEMITONES_FIFTH;
		/* sixth minor */
		else if(description.equals(DESCRIPTION_SIXTH_MIN))
			semitones = SEMITONES_SIXTH_MIN;
		/* sixth major */
		else if(description.equals(DESCRIPTION_SIXHT_MAJ))
			semitones = SEMITONES_SIXTH_MAJ;
		/* seventh minor */
		else if(description.equals(DESCRIPTION_SEVENTH_MIN))
			semitones = SEMITONES_SEVENTH_MIN;
		/* seventh major */
		else if(description.equals(DESCRIPTION_SEVENTH_MAJ))
			semitones = SEMITONES_SEVENTH_MAJ;
		/* invalid interval description */
		else
			throw new InvalidIntervalException("invalid interval description");
			
		
		return semitones;
	}
	
	
	public static Interval getInterval(Note note1, Note note2) throws InvalidIntervalException {
		Integer difference = Math.abs(note1.getValue() - note2.getValue()) % 12;
		
		return new Interval(difference);
	}
	
	/* Test main */
	public static void main(String[] args) throws InvalidIntervalException {

	}
}
