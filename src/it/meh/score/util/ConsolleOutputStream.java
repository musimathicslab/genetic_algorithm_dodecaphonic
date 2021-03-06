package it.meh.score.util;

import java.io.*;
import javax.swing.*;

public class ConsolleOutputStream extends OutputStream {
	public ConsolleOutputStream(JTextArea txtAreaConsolle) {
		this.txtAreaConsolle = txtAreaConsolle;
	}
	
	public void write(int b) throws IOException {
		char c = (char) b;
		
		txtAreaConsolle.append(String.valueOf(c));
	
		if(c == '\n')
			txtAreaConsolle.setCaretPosition(txtAreaConsolle.getDocument().getLength());
	}
	
	private JTextArea txtAreaConsolle;
}
