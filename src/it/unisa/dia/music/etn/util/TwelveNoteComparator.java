package it.unisa.dia.music.etn.util;

import it.unisa.dia.music.etn.ga.chromosome.TwelveNoteChromosome;

import java.util.Comparator;
import java.util.Random;

public class TwelveNoteComparator  implements Comparator {
		 
	  	
	 public int compare(Object o1, Object o2) {
	    int result = 0;
	    Random generator = new Random();
		
	    TwelveNoteChromosome c1 = (TwelveNoteChromosome) o1;
		double f1 = generator.nextDouble();
				
		TwelveNoteChromosome c2 = (TwelveNoteChromosome) o2;
		double f2 = generator.nextDouble();
				
		if(f1 > f2) {
		    result = 1;
		} else if(f2 > f1) {
		    result = -1;
		} else {
			result = 0;
		}
		
		return result;
	}
			
	public boolean equals(Object obj) {
	   return true;
	}	
			
}	
			
