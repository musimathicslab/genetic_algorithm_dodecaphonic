package it.unisa.dia.music.etn.ga.operator;

import java.util.Random;

import it.unisa.dia.music.etn.exception.InvalidIntervalException;
import it.unisa.dia.music.etn.exception.InvalidSeriesException;
import it.unisa.dia.music.etn.ga.chromosome.TwelveNoteChromosome;
import it.unisa.dia.music.etn.ga.configuration.TwelveNoteConfiguration;
import it.unisa.dia.music.etn.ga.gene.TwelveNoteVerticalGene;

public class CrossoverOperator implements TwelveNoteOperator {

private TwelveNoteConfiguration configuration;
	
public CrossoverOperator(TwelveNoteConfiguration configuration) {
	super();
	
	this.configuration = configuration;
}

public void operate(TwelveNoteChromosome t1, TwelveNoteChromosome t2) throws CloneNotSupportedException, InvalidSeriesException, InvalidIntervalException {
	TwelveNoteChromosome t3 = null;
	TwelveNoteChromosome t4 = null;
	Random indexGenerator = new Random();
	int index = indexGenerator.nextInt(t1.getGenes().length);
	
	t3 = new TwelveNoteChromosome();
		TwelveNoteVerticalGene[] gene3 = new TwelveNoteVerticalGene[t1.getGenes().length];
		
		t4 = new TwelveNoteChromosome();
		TwelveNoteVerticalGene[] gene4 = new TwelveNoteVerticalGene[t1.getGenes().length];
		
		System.out.println("INDEX: " + index);
		
		// Creazione t3
		for(int i = 0; i < index; i++) {
			gene3[i] = t1.getGenes()[i].clone();
		}
		for(int i = index; i < t2.getGenes().length; i++) {
			gene3[i] = t2.getGenes()[i].clone();
		}
		t3.setGenes(gene3);
		
		// Creazione t4
		for(int i = 0; i < index; i++) {
			gene4[i] = t2.getGenes()[i].clone();
		}
		for(int i = index; i < t1.getGenes().length; i++) {
			
			gene4[i] = t1.getGenes()[i].clone();
		}
		t4.setGenes(gene4);
				
		
		// Inserimento di t3, t4 in currentPopulation di configuration
		configuration.getCurrentPopulation().add(t3);
		configuration.getCurrentPopulation().add(t4);
		
	}
}
