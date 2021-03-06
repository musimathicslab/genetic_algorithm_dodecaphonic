package it.meh.score.util;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{
	private static final long serialVersionUID = 5707068043948727388L;
	
	private String[] header;
	private Object[][] data;
	
	private int numRows; 
	private int numCols;

	public TableModel(Vector data, String[] header)	{
		int len = header.length;
		numCols = len;
		
		this.header = header;

		// Caricamento dei valori della tabella
		if (data.size() > 0) {
			numRows = data.size();
			this.data = new Object[numRows][numCols];
			
			for(int i = 0; i < data.size(); i++) {
				Vector row = (Vector) data.elementAt(i);
				for(int j = 0; j < row.size(); j++)
					this.data[i][j] = row.elementAt(j);
				
			}
		}
	}

	public Vector getVectorData() {
		Vector vctData = new Vector();

		for (int i = 0; i < numRows; i++) {
			Vector row = new Vector();

			for (int j = 0; j < 3; j++) 
				row.add(data[i][j]);	

			vctData.add(row);
		}

		return vctData;
	}
	
    public int getRowCount() {
		if(data != null) 
			return data.length;
		else 
    	 		return 0;
    }

    public int getColumnCount() {
    		return header.length;
    }

    public Object getValueAt(int row, int column) {
    		return data[row][column];
    }

    public String[] getColumnNames() {
		return header;
	}
    
    public String getColumnName(int column) {
    		return header[column];
    }

    public Class getColumnClass(int column) {
    		return data[0][column].getClass();
    }

    public boolean isCellEditable(int row, int col) {
    		return false;
    }

    public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
    }

}    
