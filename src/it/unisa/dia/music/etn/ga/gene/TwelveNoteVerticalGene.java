package it.unisa.dia.music.etn.ga.gene;

import it.meh.score.data.Note;
import it.unisa.dia.music.etn.data.Series;
import it.unisa.dia.music.etn.data.Transformation;
import it.unisa.dia.music.etn.exception.InvalidIntervalException;
import it.unisa.dia.music.etn.exception.InvalidSeriesException;
import it.unisa.dia.music.etn.util.SeriesUtilities;

import java.io.*;

public class TwelveNoteVerticalGene implements Serializable, Cloneable {
	public TwelveNoteVerticalGene(Series referenceSeries, Note seriesStartingNote, Integer melodicLineNumber) throws CloneNotSupportedException, InvalidSeriesException, InvalidIntervalException {
		this.referenceSeries = referenceSeries;
		this.seriesStartingNote = seriesStartingNote;
		this.melodicLineNumber = melodicLineNumber;
		
		initGene();
	}

	/* inits each gene transformation randomly */
	private void initGene() throws CloneNotSupportedException, InvalidSeriesException, InvalidIntervalException {
		/*bassVoiceTransformation    = SeriesUtilities.generateTransformation(seriesStartingNote, referenceSeries);
		tenorVoiceTransformation   = SeriesUtilities.generateTransformation(seriesStartingNote, referenceSeries);
		altoVoiceTransformation    = SeriesUtilities.generateTransformation(seriesStartingNote, referenceSeries);
		sopranoVoiceTransformation = SeriesUtilities.generateTransformation(seriesStartingNote, referenceSeries);
*/	
		transformations = new Transformation[melodicLineNumber];
		for(int i = 0; i < melodicLineNumber; i++) {
			transformations[i] = SeriesUtilities.generateTransformation(seriesStartingNote, referenceSeries);
		}
		
	}

	public Series getReferenceSeries() {      
		return referenceSeries;
	}

	public void setReferenceSeries(Series referenceSeries) {
		this.referenceSeries = referenceSeries;
	}

	public Note getSeriesStartingNote() {
		return seriesStartingNote;
	}

	public void setSeriesStartingNote(Note seriesStartingNote) {
		this.seriesStartingNote = seriesStartingNote;
	}

	public Transformation[] getTransformations() {
		return transformations;
	}

	public void setTransformations(Transformation[] transformations) {
		this.transformations = transformations;
	}
	
	public Integer getMelodicLineNumber() {
		return melodicLineNumber;
	}

	public void setMelodicLineNumber(Integer melodicLineNumber) {
		this.melodicLineNumber = melodicLineNumber;
	}
	/*public Transformation getBassVoiceTransformation() {
		return bassVoiceTransformation;
	}

	public void setBassVoiceTransformation(Transformation bassVoiceTransformation) {
		this.bassVoiceTransformation = bassVoiceTransformation;
	}

	public Transformation getTenorVoiceTransformation() {
		return tenorVoiceTransformation;
	}

	public void setTenorVoiceTransformation(Transformation tenorVoiceTransformation) {
		this.tenorVoiceTransformation = tenorVoiceTransformation;
	}

	public Transformation getAltoVoiceTransformation() {
		return altoVoiceTransformation;
	}

	public void setAltoVoiceTransformation(Transformation altoVoiceTransformation) {
		this.altoVoiceTransformation = altoVoiceTransformation;
	}

	public Transformation getSopranoVoiceTransformation() {
		return sopranoVoiceTransformation;
	}

	public void setSopranoVoiceTransformation(
			Transformation sopranoVoiceTransformation) {
		this.sopranoVoiceTransformation = sopranoVoiceTransformation;
	}
*/

	public TwelveNoteVerticalGene clone() throws CloneNotSupportedException {
		TwelveNoteVerticalGene clonedGene = (TwelveNoteVerticalGene) super.clone();
		
		/*clonedGene.setBassVoiceTransformation(bassVoiceTransformation.clone());
		clonedGene.setTenorVoiceTransformation(tenorVoiceTransformation.clone());
		clonedGene.setAltoVoiceTransformation(altoVoiceTransformation.clone());
		clonedGene.setSopranoVoiceTransformation(sopranoVoiceTransformation.clone());
		*/
		
		clonedGene.setTransformations(new Transformation[melodicLineNumber]); 
		for(int i = 0; i < melodicLineNumber; i++) {
			clonedGene.getTransformations()[i] = this.getTransformations()[i].clone();
		}
		
		return clonedGene;
	}
	
	private static final long serialVersionUID = 1016533559482204092L;

	/* Reference series */
	private Series referenceSeries  = null;
	/* Series starting note */
	private Note seriesStartingNote = null;
	/* Melodic Line Number */
	private Integer melodicLineNumber = null;
	
	/* Bass voice transformation */
	//private Transformation bassVoiceTransformation    = null;
	/* Tenor voice transformation */
	//private Transformation tenorVoiceTransformation   = null;
	/* Alto voice transformation */
	//private Transformation altoVoiceTransformation    = null;
	/* Soprano voice trnasformation */
	//private Transformation sopranoVoiceTransformation = null;
	
	private Transformation[] transformations = null;
}
