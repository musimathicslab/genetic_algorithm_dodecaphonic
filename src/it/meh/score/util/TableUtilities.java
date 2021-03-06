package it.meh.score.util;

import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class TableUtilities {
	public static void fillTable(JTable table, String[] header, int[] columnSize, Vector valoriTabella) {
		TableModel tableModel = new TableModel(valoriTabella, header);
	    ((AbstractTableModel) tableModel).fireTableDataChanged();
	        
	    table.setModel(tableModel);
	    resizeTableColumns(table, columnSize);
		   	
	    table.setVisible(true);
	    table.setEnabled(true);
	}
	
	private static void resizeTableColumns(JTable table, int[] columnSize) {
		 String[] columnNames = ((TableModel) table.getModel()).getColumnNames();
		 
		 for(int i = 0; i < columnNames.length; i++) {
			 TableColumn tableColumn = table.getColumn(columnNames[i]);
			 tableColumn.setPreferredWidth(columnSize[i]);
		 }
		 
		 table.setShowVerticalLines(false);
		 table.setRowHeight(20); 
	}
}
