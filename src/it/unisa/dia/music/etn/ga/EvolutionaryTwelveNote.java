package it.unisa.dia.music.etn.ga;

import it.meh.score.data.Note;
import it.unisa.dia.music.etn.constants.data.*;
import it.unisa.dia.music.etn.data.*;
import it.unisa.dia.music.etn.exception.*;
import it.unisa.dia.music.etn.ga.chromosome.*;
import it.unisa.dia.music.etn.ga.configuration.*;
import it.unisa.dia.music.etn.ga.fitness.*;
import it.unisa.dia.music.etn.ga.gpm.GPMFunction;
import it.unisa.dia.music.etn.ga.operator.*;
import it.unisa.dia.music.etn.manager.*;
import it.unisa.dia.music.etn.util.TwelveNoteComparator;

import java.io.*;
import java.util.*;

import jm.util.View;
import jm.util.Write;


public class EvolutionaryTwelveNote implements SeriesConstants, TwelveNoteConfigurationConstants {
	public EvolutionaryTwelveNote() throws InvalidSeriesException, InvalidIntervalException {
		init();
	}
	
	
	private void init() throws InvalidSeriesException, InvalidIntervalException {
		createConfiguration();
	}

	private void createOperators() {
		operators = new Vector<TwelveNoteOperator>();
		
		/* Crossover operator */
		CrossoverOperator crossoverOperator = new CrossoverOperator(configuration);
		operators.add(crossoverOperator);
		
		/* Mutation operator */
		MutationOperator mutationOperator = new MutationOperator(configuration);
		operators.add(mutationOperator);
	}

	private void createConfiguration() throws InvalidSeriesException, InvalidIntervalException {
		configurationPropertiesManager = new PropertiesManager(new File(CONFIGURATION_FILE));

		/* create a new algorithm configuration */
		configuration = new TwelveNoteConfiguration();

		/* load the reference series */
		loadReferenceSeries();

		/* load the series starting note */
		loadSeriesStartingNote();
				
		/* load the transformation number */
		loadTransformationNumber();
		
		/* load the population size */
		loadPopulationSize();
		
		/* load the maximum number of generations */
		loadMaxGenerations();
		
		/* load the composition rythm */
		loadRythm();
		
		/* load the melodic line number*/
		loadMelodicLineNumber();
		
		/* set the genetic operators */
		createOperators();
		configuration.setOperators(operators);

		/* set the fitness function */
		TwelveNoteFitnessFunction fitnessFunction = new TwelveNoteFitnessFunction();
		configuration.setFitnessFunction(fitnessFunction);		
	}
	
	/* loads the reference series from the configuration file */
	private void loadReferenceSeries() throws NumberFormatException, InvalidIntervalException, InvalidSeriesException {
		Series referenceSeries = null;
		String referenceSeriesPropertyValue = configurationPropertiesManager.loadProperty(PROPERTY_REFERENCE_SERIES);
		
		if(referenceSeriesPropertyValue != null) {
			StringTokenizer tokenizer = new StringTokenizer(referenceSeriesPropertyValue, "-");
			
			Vector<Interval> seriesIntervalVector = new Vector<Interval>();
			
			while(tokenizer.hasMoreTokens()) {
				Interval seriesInterval = new Interval(Integer.parseInt(tokenizer.nextToken()));
				seriesIntervalVector.add(seriesInterval);
			}
			
			Interval[] seriesInterval = new Interval[seriesIntervalVector.size()];
			seriesIntervalVector.toArray(seriesInterval);
			
			referenceSeries = new Series();
			referenceSeries.setForm(Form.F);
			referenceSeries.setIntervals(seriesInterval);
		} else {
			referenceSeries = DEFAULT_SERIES;
		}
		
		configuration.setReferenceSeries(referenceSeries);
	}
	
	/* loads the series starting note from the configuration file */
	private void loadSeriesStartingNote() {
		Note seriesStartingNote = null;
		String seriesStartingNotePropertyValue = configurationPropertiesManager.loadProperty(PROPERTY_SERIES_STARTING_NOTE);
		
		if(seriesStartingNotePropertyValue != null)
			seriesStartingNote = new Note(Integer.parseInt(seriesStartingNotePropertyValue));
		else
			seriesStartingNote = DEFAULT_SERIES_STARTING_NOTE;
			
		configuration.setStartingSeriesNote(seriesStartingNote);		
	}
	
	/* loads the transformation number from the configuration file */
	private void loadTransformationNumber() {
		Integer transformationNumber = null;
		String transformationNumberPropertyValue = configurationPropertiesManager.loadProperty(PROPERTY_TRANSFORMATION_NUMBER);
		
		if(transformationNumberPropertyValue != null)
			transformationNumber = Integer.parseInt(transformationNumberPropertyValue);
		else
			transformationNumber = DEFAULT_TRANSFORMATION_NUMBER;
		
		configuration.setTransformationNumber(transformationNumber);
	}
	
	/* loads the population size from the configuration file */
	private void loadPopulationSize() {
		Integer populationSize = null;
		String populationSizePropertyValue = configurationPropertiesManager.loadProperty(PROPERTY_POPULATION_SIZE);
		
		if(populationSizePropertyValue != null)
			populationSize = Integer.parseInt(populationSizePropertyValue);
		else
			populationSize = DEFAULT_POPULATION_SIZE;
		
		configuration.setPopulationSize(populationSize);
	}
	
	/* loads the maximun number of generations from the configuration file */
	private void loadMaxGenerations() {
		Integer maxGenerations = null;
		
		String maxGenerationsPropertyValue = configurationPropertiesManager.loadProperty(PROPERTY_MAX_GENERATIONS);
		
		if(maxGenerationsPropertyValue != null)
			maxGenerations = Integer.parseInt(maxGenerationsPropertyValue);
		else
			maxGenerations = DEFAULT_MAX_GENERATIONS;

		configuration.setMaxGenerations(maxGenerations);
	}
	
	/* loads the rythm from the configuration file */
	private void loadRythm() {
		/* Rythm count */
		Integer rythmCount = null;
		String rythmCountProperty = configurationPropertiesManager.loadProperty(PROPERTY_RYTHM_COUNT);
		
		if(rythmCountProperty != null)
			rythmCount = Integer.parseInt(rythmCountProperty);
		else
			rythmCount = DEFAULT_RYTHM_COUNT;
		
		configuration.setRythmCount(rythmCount);
		
		/* Rythm unit */
		Integer rythmUnit = null;
		String rythmUnitProperty = configurationPropertiesManager.loadProperty(PROPERTY_RYTHM_UNIT);
		
		if(rythmUnitProperty != null)
			rythmUnit = Integer.parseInt(rythmUnitProperty);
		else
			rythmUnit = DEFAULT_RYTHM_UNIT;
			
		configuration.setRythmUnit(rythmUnit);		
	}
	
	/* loads the melodic line numbers */
	private void loadMelodicLineNumber() {
		/* Melodic Line Numbers */
		Integer melodicLineNumber = null;
		String melodicLineNumberProperty = configurationPropertiesManager.loadProperty(PROPERTY_MELODIC_LINE_NUMBER);
		
		if(melodicLineNumberProperty != null)
			melodicLineNumber = Integer.parseInt(melodicLineNumberProperty);
		else
			melodicLineNumber = DEFAULT_MELODIC_LINE_NUMBER;
		
		configuration.setMelodicLineNumber(melodicLineNumber);
		
	}
	
	public void evolve() throws CloneNotSupportedException, InvalidSeriesException, InvalidIntervalException {
		/* create the initial population */
		createInitialPopulation();
							
		/* evolution process */
		for(int i = 0; i < configuration.getMaxGenerations(); i++) {	
			
			for(int j = 0; j < population.length; j++) {
				
				for(int k = 0; k < population.length; k++) {
					
					// Selezione cromosomi
					TwelveNoteChromosome t1 = population[j];
					TwelveNoteChromosome t2 = population[k];
					
					// Applicazione operatori
					for(int z = 0; z < configuration.getOperators().size(); z++) {
						
						TwelveNoteOperator operator = configuration.getOperators().elementAt(z);
						if(operator instanceof CrossoverOperator) {
							((CrossoverOperator)operator).operate(t1, t2);
						} else if(operator instanceof MutationOperator) {
							((MutationOperator)operator).operate(t1);
							((MutationOperator)operator).operate(t2);
						}
					}
				}
									
			}
			
			// Selezione dei migliori individui e aggiornamento della popolazione
			Vector<TwelveNoteChromosome> pop = configuration.getCurrentPopulation();
			Object[] currentPopulation = pop.toArray();
			Arrays.sort(currentPopulation, new TwelveNoteComparator());
			for(int j = 0; j < population.length; j++){
				population[j] = new TwelveNoteChromosome();
				population[j].setGenes(((TwelveNoteChromosome)currentPopulation[j]).getGenes());
			}
			
			configuration.setCurrentPopulation(population);
		}
		
		// Il primo elemento di population il migliore
		System.out.println("Dodecaphonic Composition: " + population[0]);
		jm.music.data.Score score = GPMFunction.map(population[0], configuration);
		
		View.notate(score);
		Write.midi(score,"BestSolution.mid");
		
	}
	
	private TwelveNoteChromosome[] createInitialPopulation() throws CloneNotSupportedException, InvalidSeriesException, InvalidIntervalException {
		/* get the population size */
		Integer populationSize = configuration.getPopulationSize();
		/* get the transformation number */
		Integer transformationNumber = configuration.getTransformationNumber();
		/* get the melodic line  number */
		Integer melodicLineNumber = configuration.getMelodicLineNumber();
		/* get the composition series */
		Series referenceSeries = configuration.getReferenceSeries();
		/* get the series starting note */
		Note seriesStartingNote = configuration.getStartingSeriesNote();
				
		population = new TwelveNoteChromosome[populationSize];
		
		/* create the initial population */
		for(int i = 0; i < populationSize; i++) {
			/* create an individual of the initial population */
			population[i] = new TwelveNoteChromosome(referenceSeries, seriesStartingNote, transformationNumber, melodicLineNumber);
		}
		
		// Settiamo la popolazione iniziale nella configuration
		configuration.setCurrentPopulation(population);
		return population;
	}
	
	/* Test main */
	public static void main(String[]args) throws InvalidSeriesException, InvalidIntervalException, CloneNotSupportedException {
		EvolutionaryTwelveNote etn = new EvolutionaryTwelveNote();
		etn.evolve();
		
		System.out.println();
	}
	
	/* Twelve note operators */
	private Vector<TwelveNoteOperator> operators = null;
	/* Algorithm configuration */
	private TwelveNoteConfiguration configuration = null;
	/* Population */
	private TwelveNoteChromosome[] population = null;
	/* Configuration property manager */
	private PropertiesManager configurationPropertiesManager = null;
}
