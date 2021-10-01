package it.unisa.dia.music.etn.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import it.unisa.dia.music.etn.constants.data.*;
import it.unisa.dia.music.etn.exception.InvalidIntervalException;
import it.unisa.dia.music.etn.exception.InvalidSeriesException;
import it.unisa.dia.music.etn.ga.EvolutionaryTwelveNote;
import it.unisa.dia.music.etn.manager.PropertiesManager;

import javax.swing.*;
import javax.swing.border.*;

public class MainFrame extends JFrame implements MainFrameConstants,SeriesConstants, TwelveNoteConfigurationConstants {
	public MainFrame() {
		super(MAINFRAME_TITLE);
		
		setProperties();
		
		buildComponents();
		
		setVisible(true);
		
		try {
        	Thread.sleep(400);
	 	} catch (Exception ex) {
	 		ex.printStackTrace();
	 	}
	}
	
	private void setProperties() {
		setSize(MAINFRAME_WIDTH, MAINFRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().setBackground(MAINFRAME_BG_COLOR);
	}
	
	private void buildComponents() {
		buildSeedSeriesPanel();
		buildAlgorithmParametersPanel();
		buildConsolePanel();
	}
	
	private void buildSeedSeriesPanel() {
		Border border = BorderFactory.createEtchedBorder();
		TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "  Seed Series ", TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, new Font("Verdana", Font.ITALIC + Font.BOLD, 11));
		
		pnlSeedSeries = new JPanel();
		pnlSeedSeries.setSize(500, 160);
		pnlSeedSeries.setLocation(10, 10);
		pnlSeedSeries.setLayout(null);
		pnlSeedSeries.setBorder(titledBorder);
		pnlSeedSeries.setBackground(MAINFRAME_BG_COLOR);
		 
		keyboard = new Keyboard(this);	
		keyboard.setLocation(20, 20);	
		keyboard.turnOn();
		pnlSeedSeries.add(keyboard);	
		
		/* Series notes */
		lblSeriesNotes = new JLabel("<html>Series Notes</html>", JLabel.LEFT);
		lblSeriesNotes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSeriesNotes.setSize(100, 30);
		lblSeriesNotes.setLocation(160, 25);

		pnlSeedSeries.add(lblSeriesNotes);
		
		txtSeriesNotes = new JTextField();
		txtSeriesNotes.setFont(new Font("Verdana", Font.BOLD, 12));
		txtSeriesNotes.setSize(320, 40);
		txtSeriesNotes.setLocation(160, 45);
		txtSeriesNotes.setBorder(null);
		txtSeriesNotes.setBackground(MAINFRAME_BG_COLOR);
		txtSeriesNotes.setEditable(false);
		txtSeriesNotes.setText("");
	
		pnlSeedSeries.add(txtSeriesNotes);
		
		/* Reset button */
		btnReset = new JButton("Reset");
		btnReset.setSize(100, 30);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setToolTipText("Reset seed series");
		btnReset.setLocation(40, 120);
		btnReset.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				resetSeedSeries();
			}
		});

		pnlSeedSeries.add(btnReset);
		
		/* Start button */
		btnStart = new JButton("Start");
		btnStart.setSize(100, 30);
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStart.setToolTipText("Start the evolution algorithm");
		btnStart.setLocation(200, 120);
		btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
					startComposition();
				} catch (InvalidSeriesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvalidIntervalException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		
		pnlSeedSeries.add(btnStart);

		/* Stop button */
		btnStop = new JButton("Stop");
		btnStop.setSize(100, 30);
		btnStop.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStop.setToolTipText("Stop the evolution algorithm");
		btnStop.setLocation(360, 120);
		
		pnlSeedSeries.add(btnStop);
		

		getContentPane().add(pnlSeedSeries);
	}
	
	private void buildAlgorithmParametersPanel() {
		Border border = BorderFactory.createEtchedBorder();
		TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "  Algorithm Parameters ", TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, new Font("Verdana", Font.ITALIC + Font.BOLD, 11));
		
		pnlAlgorithmParameters = new JPanel();
		pnlAlgorithmParameters.setSize(180, 160);
		pnlAlgorithmParameters.setLocation(520, 10);
		pnlAlgorithmParameters.setLayout(null);
		pnlAlgorithmParameters.setBorder(titledBorder);
		pnlAlgorithmParameters.setBackground(MAINFRAME_BG_COLOR);
		
		/* Population size */
		JLabel lblPopulationSize = new JLabel("<html>Population size</html>", JLabel.LEFT);
		lblPopulationSize.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPopulationSize.setSize(100, 30);
		lblPopulationSize.setLocation(10, 20);
		
		pnlAlgorithmParameters.add(lblPopulationSize);
		
		txtPopulationSize = new JTextField();
		txtPopulationSize.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtPopulationSize.setSize(40, 25);
		txtPopulationSize.setLocation(120, 20);
		txtPopulationSize.setBorder(border);
		
		pnlAlgorithmParameters.add(txtPopulationSize);
		
		/* Iterations */
		JLabel lblIterations = new JLabel("<html>Iterations</html>", JLabel.LEFT);
		lblIterations.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIterations.setSize(100, 30);
		lblIterations.setLocation(10, 50);
		
		pnlAlgorithmParameters.add(lblIterations);
		
		txtIterations = new JTextField();
		txtIterations.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtIterations.setSize(40, 25);
		txtIterations.setLocation(120, 50);
		txtIterations.setBorder(border);
		
		pnlAlgorithmParameters.add(txtIterations);
		
		/* Transformations */ 
		JLabel lblTrasformations = new JLabel("<html>Trasformations</html>", JLabel.LEFT);
		lblTrasformations.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTrasformations.setSize(100, 30);
		lblTrasformations.setLocation(10, 80);
		
		pnlAlgorithmParameters.add(lblTrasformations);
		
		txtTransformations = new JTextField();
		txtTransformations.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtTransformations.setSize(40, 25);
		txtTransformations.setLocation(120, 80);
		txtTransformations.setBorder(border);
		
		pnlAlgorithmParameters.add(txtTransformations);
		
		/* Melodic Line Number */ 
		JLabel lblMelodicLines = new JLabel("<html>Melodic lines</html>", JLabel.LEFT);
		lblMelodicLines.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMelodicLines.setSize(100, 30);
		lblMelodicLines.setLocation(10, 110);
		
		pnlAlgorithmParameters.add(lblMelodicLines);
		
		txtMelodicLines = new JTextField();
		txtMelodicLines.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtMelodicLines.setSize(40, 25);
		txtMelodicLines.setLocation(120, 110);
		txtMelodicLines.setBorder(border);
		
		pnlAlgorithmParameters.add(txtMelodicLines);
		getContentPane().add(pnlAlgorithmParameters);		
	}
	
	private void buildAlgorithmControlPanel() {
		Border border = BorderFactory.createEtchedBorder();
		TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "  Algorithm Control ", TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, new Font("Verdana", Font.ITALIC + Font.BOLD, 11));
		
		pnlAlgorithmControl = new JPanel();
		pnlAlgorithmControl.setSize(690, 80);
		pnlAlgorithmControl.setLocation(10, 170);
		pnlAlgorithmControl.setLayout(null);
		pnlAlgorithmControl.setBorder(titledBorder);
		pnlAlgorithmControl.setBackground(MAINFRAME_BG_COLOR);
				
	
		
		getContentPane().add(pnlAlgorithmControl);	
	}
	
	public void addNoteToSeries(Integer pitch) {
		if(seedSeries.size() < 12 && !seedSeries.containsKey(pitch)) {
			String note = NOTES.get(pitch);
			
			seedSeries.put(pitch, note);
			serieNotes.add(pitch);
			if(txtSeriesNotes.getText().equals(""))
				txtSeriesNotes.setText(note);	
			else
				txtSeriesNotes.setText(txtSeriesNotes.getText() + "-" + note);
		}
	}
	
	private void buildConsolePanel() {
		Border border = BorderFactory.createEtchedBorder();
		TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "  Console ", TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, new Font("Verdana", Font.ITALIC + Font.BOLD, 11));
		
		pnlConsole = new JPanel();
		pnlConsole.setSize(690, 170);
		pnlConsole.setLocation(10, 250);
		pnlConsole.setLayout(null);
		pnlConsole.setBorder(titledBorder);
		pnlConsole.setBackground(MAINFRAME_BG_COLOR);
		
		getContentPane().add(pnlConsole);			
	}
	
	private void startComposition() throws InvalidSeriesException, InvalidIntervalException, CloneNotSupportedException {
		PropertiesManager manager = new PropertiesManager(new File(CONFIGURATION_FILE));
		manager.properties.setProperty(PROPERTY_POPULATION_SIZE, txtPopulationSize.getText());
		manager.properties.setProperty(PROPERTY_MAX_GENERATIONS,txtIterations.getText());
		manager.properties.setProperty(PROPERTY_TRANSFORMATION_NUMBER,txtTransformations.getText());
		
		String series = "";
		for(int i = 1; i < serieNotes.size(); i++) {
			int diff = Math.abs(serieNotes.elementAt(i-1) - serieNotes.elementAt(i));
			if(i == 1)
				series += diff;
			else
				series += "-" + diff;
		}
		manager.properties.setProperty(PROPERTY_REFERENCE_SERIES, series);
		manager.properties.setProperty(PROPERTY_SERIES_STARTING_NOTE, serieNotes.elementAt(0).toString());
		manager.properties.setProperty(PROPERTY_RYTHM_COUNT, "3");
		manager.properties.setProperty(PROPERTY_RYTHM_UNIT, "4");
		manager.properties.setProperty(PROPERTY_MELODIC_LINE_NUMBER, txtMelodicLines.getText());
		try {
			manager.properties.store(new FileOutputStream("conf/configuration.properties"), null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EvolutionaryTwelveNote etn = new EvolutionaryTwelveNote();
		etn.evolve();
	}
	
	private void resetSeedSeries() {
		txtSeriesNotes.setText("");
		seedSeries = new Hashtable<Integer, String>();
	}
	

	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
	}
	
	private static final long serialVersionUID = 2971575511981372926L;
	
	/* Seed series panel */
	private JPanel pnlSeedSeries          = null;
	/* Algorithm parameters panel */
	private JPanel pnlAlgorithmParameters = null;
	/* Algorithm control panel */
	private JPanel pnlAlgorithmControl    = null;
	/* Keyboard */
	private Keyboard keyboard             = null;
	
	private JLabel lblSeriesNotes = null;
	
	private JTextField txtSeriesNotes = null;
	
	/* Console panel */
	private JPanel pnlConsole             = null;
	
	/* Start button */
	private JButton btnStart = null;
	/* Stop button */
	private JButton btnStop = null;
	/* Reset button */
	private JButton btnReset = null;
	
	private JTextField txtPopulationSize;
	private JTextField txtIterations;
	private JTextField txtTransformations;
	private JTextField txtMelodicLines;
	
	 
	private final Hashtable<Integer, String> NOTES = new Hashtable<Integer, String>() {  
		{
			 put(0, "C");
			 put(1, "C#");
			 put(2, "D");
			 put(3, "D#");
			 put(4, "E");
			 put(5, "F");
			 put(6, "F#");
			 put(7, "G");
			 put(8, "G#");
			 put(9, "A");
			 put(10, "A#");
			 put(11, "B");
		 }
	};
	
	private Hashtable<Integer, String> seedSeries = new Hashtable<Integer, String>();
	private Vector<Integer> serieNotes = new Vector<Integer>(); 
}
