package it.unisa.dia.music.etn.manager;

import java.io.*;
import java.util.*;

public class PropertiesManager {
	public PropertiesManager(File propertiesFile) {
		this.propertiesFile = propertiesFile;
	}
	
	public void saveProperties(String propertyName, String propertyValue) {
		properties = new Properties();
		
		try {
	        properties.setProperty(propertyName, propertyValue);
	        properties.store(new FileOutputStream(propertiesFile), null);
	    } catch (IOException e) {
	    	System.out.println(e);
	    }
	}
	
	public String loadProperty(String propertyName) {
		String propertyValue = null;
		
		Properties properties = new Properties();
		
		try {
	        properties.load(new FileInputStream(propertiesFile));
	        propertyValue = properties.getProperty(propertyName);
	        
	    } catch (IOException e) {
	    	System.out.println(e);
	    }
	    
	    return propertyValue;
	}
	
	
	/* Properties file */
	private File propertiesFile = null;
	public static Properties properties = new Properties();
}
