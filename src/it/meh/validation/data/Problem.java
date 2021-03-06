package it.meh.validation.data;

import java.util.*;

public interface Problem {
	public String getType();
	
	public int getCategory();
	
	public String getDescription();
	
	public String getLocation();
	
	public Vector getMeasures();
	
	public Vector getNotes();
}
