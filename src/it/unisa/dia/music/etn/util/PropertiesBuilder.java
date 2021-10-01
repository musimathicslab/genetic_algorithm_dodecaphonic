package it.unisa.dia.music.etn.util;

import it.unisa.dia.music.etn.constants.data.PropertiesBuilderConstants;

import java.io.*;
import java.util.*;

public class PropertiesBuilder implements PropertiesBuilderConstants {
	private PropertiesBuilder(String propertiesFilepath) {
		this.propertiesFilepath = propertiesFilepath;
		
		properties = new Properties();
		
		loadProperties();
	}
		
	public void loadProperties() {	
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(propertiesFilepath));
		} catch(IOException e) {
			System.out.println("Impossibile caricare il file di properties");
			System.exit(1);
		}
	}
		
	public String getProperty(String propertyKey) {
		return properties.getProperty(propertyKey);
	}
		
	public static PropertiesBuilder getInstance() {
		if(instance == null)
			instance = new PropertiesBuilder(PROPERTIES_FILE);
		
		return instance;
	}
	
		
	private static PropertiesBuilder instance = null;
	
	private String propertiesFilepath = null;
	
	private Properties properties = null;
}
