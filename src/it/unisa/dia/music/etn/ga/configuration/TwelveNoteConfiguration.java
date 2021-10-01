package it.unisa.dia.music.etn.ga.configuration;

import it.meh.score.data.Note;
import it.unisa.dia.music.etn.constants.data.*;
import it.unisa.dia.music.etn.data.*;
import it.unisa.dia.music.etn.ga.chromosome.TwelveNoteChromosome;
import it.unisa.dia.music.etn.ga.fitness.*;
import it.unisa.dia.music.etn.ga.operator.*;

import java.util.*;

public class TwelveNoteConfiguration implements TwelveNoteConfigurationConstants {	
	
	public Vector<TwelveNoteChromosome> getCurrentPopulation() {
		return currentPopulation;
	}

	public void setCurrentPopulation(TwelveNoteChromosome[] population) {
		if(population != null)  {
			currentPopulation = new Vector<TwelveNoteChromosome>();
			for (int i = 0; i < population.length; i++) {
				currentPopulation.add(population[i]);
			}
		}
		
	}

	public Integer getPopulationSize() {
		return populationSize;
	}
	
	public void setPopulationSize(Integer populationSize) {
		this.populationSize = populationSize;
	}
	
	public Integer getMaxGenerations() {
		return maxGenerations;
	}

	public void setMaxGenerations(Integer maxGenerations) {
		this.maxGenerations = maxGenerations;
	}

	public Vector<TwelveNoteOperator> getOperators() {
		return operators;
	}
	
	public void setOperators(Vector<TwelveNoteOperator> operators) {
		this.operators = operators;
	}
	
	public TwelveNoteFitnessFunction getFitnessFunction() {
		return fitnessFunction;
	}
	
	public void setFitnessFunction(TwelveNoteFitnessFunction fitnessFunction) {
		this.fitnessFunction = fitnessFunction;
	}

	public Series getReferenceSeries() {
		return referenceSeries;
	}

	public void setReferenceSeries(Series referenceSeries) {
		this.referenceSeries = referenceSeries;
	}

	public Note getStartingSeriesNote() {
		return startingSeriesNote;
	}

	public void setStartingSeriesNote(Note startingSeriesNote) {
		this.startingSeriesNote = startingSeriesNote;
	}

	public Integer getRythmCount() {
		return rythmCount;
	}

	public void setRythmCount(Integer rythmCount) {
		this.rythmCount = rythmCount;
	}

	public Integer getRythmUnit() {
		return rythmUnit;
	}

	public void setRythmUnit(Integer rythmUnit) {
		this.rythmUnit = rythmUnit;
	}

	public Integer getTransformationNumber() {
		return transformationNumber;
	}

	public void setTransformationNumber(Integer transformationNumber) {
		this.transformationNumber = transformationNumber;
	}

	public Integer getMelodicLineNumber() {
		return melodicLineNumber;
	}

	public void setMelodicLineNumber(Integer melodicLineNumber) {
		this.melodicLineNumber = melodicLineNumber;
	}


	private static final long serialVersionUID = -7752452042459187976L;
	
	/* Population size */
	private Integer populationSize = null;
	/* Maximum number of generations */
	private Integer maxGenerations = null;
	
	/* Genetic operators */
	private Vector<TwelveNoteOperator> operators = null;
	/* Fitness function */
	private TwelveNoteFitnessFunction fitnessFunction = null;
	/* Reference series */
	private Series referenceSeries = null;
	/* Starting series note */
	private Note startingSeriesNote = null;
	/* Rythm count */
	private Integer rythmCount = null;
	/* Rythm unit */
	private Integer rythmUnit = null;
	/* Transformation number */
	private Integer transformationNumber = null;
	/* Melodic Line Number */
	private Integer melodicLineNumber = null;
	
	private Vector <TwelveNoteChromosome> currentPopulation = null;
	
}
