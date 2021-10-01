package it.unisa.dia.music.etn.ga.operator;

import java.util.Random;

import it.unisa.dia.music.etn.exception.InvalidIntervalException;
import it.unisa.dia.music.etn.exception.InvalidSeriesException;
import it.unisa.dia.music.etn.ga.chromosome.TwelveNoteChromosome;
import it.unisa.dia.music.etn.ga.configuration.TwelveNoteConfiguration;
import it.unisa.dia.music.etn.ga.gene.TwelveNoteVerticalGene;

public class MutationOperator implements TwelveNoteOperator {

	public MutationOperator(TwelveNoteConfiguration configuration) {
		super();
		
		this.configuration = configuration;
	}
	
	public void operate(TwelveNoteChromosome t1) throws CloneNotSupportedException, InvalidSeriesException, InvalidIntervalException {
		TwelveNoteChromosome t2 = null;
				
		Random indexGenerator = new Random();
		int index = indexGenerator.nextInt(t1.getGenes().length);
		
		t2 = new TwelveNoteChromosome();
		TwelveNoteVerticalGene[] gene2 = new TwelveNoteVerticalGene[t1.getGenes().length];
			
		// Creazione t2
		for(int i = 0; i < t1.getGenes().length; i++) {
			
			if(i == index) {
				gene2[i] = new TwelveNoteVerticalGene(t1.getGenes()[i].getReferenceSeries(),t1.getGenes()[i].getSeriesStartingNote(), t1.getGenes()[i].getMelodicLineNumber());
			} else {
				gene2[i] = t1.getGenes()[i].clone();
			}
			
		}
		t2.setGenes(gene2);	
			
		// Inserimento di t2 in currentPopulation di configuration
		configuration.getCurrentPopulation().add(t2);
				
	}
	
	private TwelveNoteConfiguration configuration;
}
