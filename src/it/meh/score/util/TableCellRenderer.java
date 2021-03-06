package it.meh.score.util;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;


public class TableCellRenderer extends DefaultTableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focus, int row, int col) {
		super.getTableCellRendererComponent(table, value, selected, focus, row, col);
		
		JLabel testLabel = null;
		
		if(value instanceof String)
			testLabel = new JLabel((String) value);
				
		testLabel.setOpaque(true);
	      
		Color bgcolor = null;
		Color fgcolor = null;
		
		Font f = null;
		
		if(!selected) {
			bgcolor = (row % 2 == 0 ? ALTERNATE_COLOR : Color.white);
			fgcolor = Color.black;
			f = CELL_FONT;
		} else {
			bgcolor = SELECTED_COLOR;
			fgcolor = Color.white;
			f = SELECTED_CELL_FONT;
		}
	     
		testLabel.setBackground(bgcolor);
		testLabel.setForeground(fgcolor);
	    testLabel.setFont(f);  
		
		return testLabel;   
	}
	   
	private static final long serialVersionUID = -3580103442160216792L;
	
	private static final Color SELECTED_COLOR = new Color(61, 128, 223);
	private static final Color ALTERNATE_COLOR = new Color(241 ,245, 250);
	
	private static final Font CELL_FONT = new Font("Verdana", Font.PLAIN, 10);
	private static final Font SELECTED_CELL_FONT = new Font("Verdana", Font.BOLD, 10);
}


