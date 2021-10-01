package it.unisa.dia.music.etn.ga.chromosome;

import it.meh.score.data.*;
import it.unisa.dia.music.etn.data.*;
import it.unisa.dia.music.etn.exception.*;
import it.unisa.dia.music.etn.ga.gene.*;

public class TwelveNoteChromosome {
	
	public TwelveNoteChromosome() {
		
	}
	
	public TwelveNoteChromosome(Series referenceSeries, Note seriesStartingNote, Integer chromosomeSize, Integer melodicLineNumber) throws CloneNotSupportedException, InvalidSeriesException, InvalidIntervalException {		
		initChromosome(referenceSeries, seriesStartingNote, chromosomeSize, melodicLineNumber);
	}
	
	private void initChromosome(Series referenceSeries, Note seriesStartingNote, Integer chromosomeSize, Integer melodicLineNumber) throws CloneNotSupportedException, InvalidSeriesException, InvalidIntervalException {
		/* set the chromosome size */
		genes = new TwelveNoteVerticalGene[chromosomeSize];
		
		/* set the chomosome genes */
		for(int i = 0; i < chromosomeSize; i++)
			genes[i] = new TwelveNoteVerticalGene(referenceSeries, seriesStartingNote, melodicLineNumber);
	}
	
	public TwelveNoteVerticalGene[] getGenes() {
		return genes;
	}
	
	public void setGenes(TwelveNoteVerticalGene[] genes) {
		this.genes = genes;
	}
	
	/* Chromosome genes */
	private TwelveNoteVerticalGene[] genes = null;
}