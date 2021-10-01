package it.unisa.dia.music.etn.ga.fitness;

import java.util.Random;


public class TwelveNoteFitnessFunction {
	protected double evaluate() {

		Random generator = new Random();
		return generator.nextDouble();
	}

	
	private static final long serialVersionUID = -2813044629004990672L;
}
