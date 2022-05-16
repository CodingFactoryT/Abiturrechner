package main.java;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicComboBoxUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class MarkSelectComboBox<E> extends JComboBox<E>{
	public static final int WIDTH = 45;
	public static final int HEIGHT = 30;
	
	private final int POPUPMENU_WIDTH = 60;
	
	public MarkSelectComboBox() {
		//super();
		this.addItem((E)" --- ");
		for(int i = 15; i >= 0; i--) {
			String entry = " ";
			if(i < 10) entry += "0";
			entry += String.valueOf(i) + " ";
			this.addItem((E) entry);
		}

		this.setFocusable(false);
		this.setFont(new Font("Arial", Font.BOLD,25));
		this.setEditable(false);
		this.setBackground(Color.white);
		this.setMaximumRowCount(4);
		this.setSize(new Dimension(WIDTH,HEIGHT));
	}
	@Override 
	public void updateUI() {	//removes the arrow button and the border of the JComboBox
	    super.updateUI();
	    setUI(new BasicComboBoxUI() {
	      @Override 
	      protected JButton createArrowButton() {
	        return new JButton() {
	          @Override public int getWidth() {
	            return 0;
	          }
	        };
	      }
	    });
	    setBorder(null);
	  }
	
	@Override public Dimension getSize() {	//sets width of the popup menu, but not of the actual component
		return new Dimension(POPUPMENU_WIDTH,0);
	}
}
