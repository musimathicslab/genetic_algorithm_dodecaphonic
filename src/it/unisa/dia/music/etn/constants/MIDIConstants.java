package it.unisa.dia.music.etn.constants;

public abstract class MIDIConstants {
	// costanti relative ai canali
	public static int CHANNEL_1 =  0x00;
	public static int CHANNEL_2 =  0x01;
	public static int CHANNEL_3 =  0x02;
	public static int CHANNEL_4 =  0x03;
	public static int CHANNEL_5 =  0x04;
	public static int CHANNEL_6 =  0x05;
	public static int CHANNEL_7 =  0x06;
	public static int CHANNEL_8 =  0x07;
	public static int CHANNEL_9 =  0x08;
	public static int CHANNEL_10 = 0x09;
	public static int CHANNEL_11 = 0x0A;
	public static int CHANNEL_12 = 0x0B;
	public static int CHANNEL_13 = 0x0C;
	public static int CHANNEL_14 = 0x0D;
	public static int CHANNEL_15 = 0x0E;
	public static int CHANNEL_16 = 0x0F;
	
	public static int NOTE_OFF = 0x80;
	public static int NOTE_ON = 0x90;
	
	public static int COPYRIGHT = 0x02;
	public static int TEXT = 0x03;
	
	public static int TIME_SIGNATURE = 0x58;
	
	public static int KEY_SIGNATURE = 0x59;
	
	public static int END_OF_TRACK = 0x2F;

	public static int PROGRAM_CHANGE = 0xC0;
	
	public static int TEMPO = 0x51;
	
	public static final int SYSEX_START = 0xF0;
	public static final int SYSEX_END = 0xF7;
		
	// Universal SysEx Message
	public static final byte REALTIME_ID = 0x7F;
	public static final byte NONREALTIME_ID = 0x7E;
	// - GM System
	public static final byte GM_SYSTEM = 0x09;
	public static final byte GM_SYSTEM_ENABLE = 0x01;
	public static final byte GM_SYSTEM_DISABLE = 0x00;
	
	// - SysEx Channel
	public static final byte DISREGARD_CHANNEL = 0x7F;
	
    public static final int MTrk_MAGIC = 0x4d54726b;  // 'MTrk' 
    public static final int MThd_MAGIC = 0x4d546864;  // 'MThd'
    
	public static final String[] INSTRUMENT_CATEGORIES = {"Piano", "Chromatic Percussion", "Organ", "Guitar", "Bass", "Strings", "Ensemble", "Brass", "Reed", "Pipe", 
														  "Synth lead", "Synth pad", "Synth effects", "Ethnic", "Percussive", "Sound Effects"};
	
    public static final String[][] INSTRUMENTS = { // Piano
    	                                          new String[] {"Acoustic_Grand", "Bright Acoustic", "Electric Grand", "Honky-Tonk", "Electric Piano 1", "Electric Piano 2", "Harpsichord", "Clavinet"}, 
    	                                          // Chromatic Percussion
    	                                          new String[] {"Celesta", "Glockenspiel", "Music Box", "Vibraphone", "Marimba", "Xylophone", "Tubular Bells", "Dulcimer"}, 
    	                                          // Organ
    	                                          new String[] {"Drawbar Organ", "Percussive Organ", "Rock Organ", "Church Organ", "Reed Organ", "Accordian", "Harmonica", "Tango Accordian"}, 
    	                                          // Guitar 
    	                                          new String[] {"Nylon String Guitar", "Steel String Guitar ", "Electric Jazz Guitar", "Electric Clean Guitar", "Electric Muted Guitar", "Overdriven Guitar", "Distortion Guitar", "Guitar Harmonics"}, 
    	                                          // Bass
    	                                          new String[] {"Acoustic Bass", "Electric Bass (finger)", "Electric Bass (pick)", "Fretless Bass", "Slap Bass 1", "Slap Bass 2", "Synth Bass 1", "Synth Bass 2"}, 
    	                                          // Strings
    	                                          new String[] {"Violin", "Viola", "Cello", "Contrabass", "Tremolo Strings", "Pizzicato Strings", "Orchestral Strings", "Timpani"}, 
    	                                          // Ensemble
    	                                          new String[] {"String Ensemble 1", "String Ensemble 2", "SynthStrings 1", "SynthStrings 2", "Choir Aahs", "Voice Oohs", "Synth Voice", "Orchestra Hit"}, 
    	                                          // Brass
    	                                          new String[] {"Trumpet", "Trombone", "Tuba", "Muted Trumpet", "French Horn", "Brass Section", "SynthBrass 1", "SynthBrass 2"}, 
    	                                          // Reed
    	                                          new String[] {"Soprano Sax", "Alto Sax", "Tenor Sax", "Baritone Sax", "Oboe", "English Horn", "Bassoon", "Clarinet"}, 
    	                                          // Pipe
    	                                          new String[] {"Piccolo", "Flute", "Recorder", "Pan Flute", "Blown Bottle", "Skakuhachi", "Whistle", "Ocarina"}, 
    	                                          // Synth Lead
    	                                          new String[] {"Square", "Sawtooth", "Calliope", "Chiff", "Charang", "Voice", "Fifths", "Basslead"}, 
    	                                          // Synth Pad
    	                                          new String[] {"New age", "Warm", "Polysynth", "Choir", "Bowed", "Metallic", "Halo", "Sweep"}, 
    	                                          // Synth Effects
    	                                          new String[] {"Rain", "Soundtrack", "Crystal", "Atmosphere", "Brightness", "Goblins", "Echoes", "Sci-fi"},               
    	                                          // Ethnic
    	                                          new String[] {"Sitar", "Banjo", "Shamisen", "Koto", "Kalimba", "Bagpipe", "Fiddle", "Shanai"}, 
    	                                          // Percussive
    	                                          new String[] {"Tinkle Bell", "Agogo", "Steel Drums", "Woodblock", "Taiko Drum", "Melodic Tom", "Synth Drum", "Reverse Cymbal"}, 
    	                                          // Sound Effects
    	                                          new String[] {"Guitar Fret Noise", "Breath Noise", "Seashore", "Bird Tweet", "Telephone Ring", "Helicopter", "Applause", "Gunshot"}
    	                                        };   
}